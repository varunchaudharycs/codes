import logging
import os
import sys
from pathlib import Path
import json
import configparser
import pandas as pd
import numpy as np
import uuid
from sqlalchemy import create_engine

CONFIG_PATH = os.path.join(os.path.dirname(__file__), '..' + os.sep + '..', 'config.ini')
LOG_PATH = os.path.join(os.path.dirname(__file__), '..' + os.sep + '..', 'log.txt')


class DataWarehousing:

    def __init__(self):
        logging.info('Created NestedToFlatJSON class object.')

    # Takes user input for file paths
    def user_inputs(self):
        input_path = input('Enter the input data sample file path:')
        if not Path(input_path).is_file():
            logging.warning('Invalid file path- File does not exist. Please enter again.')
            self.user_inputs()
        return input_path

    # Reads data
    def read_file(self, input_path):
        logging.info('Reading data...')
        data = []
        try:
            with open(input_path) as f:
                for line in f:
                    data.append(json.loads(line))
        except Exception as e:
            print('An exception occurred while reading file- ', input_path)
            self.safe_exit(e)
        # Converting to pandas dataframe
        data_frame = pd.DataFrame.from_records(data)
        logging.info('Reading data... DONE.')
        return data_frame

    # Flattens nested JSON
    @staticmethod
    def process(data_frame):
        logging.info('Processing data...')
        # Converting column names to lower case
        data_frame.columns = map(str.lower, data_frame.columns)
        # Validate records- filter rows with NaN user ID, vehicle ID or event name
        data_frame = data_frame[data_frame['userid'].notna()]
        data_frame = data_frame[data_frame['vehicleid'].notna()]
        data_frame = data_frame[data_frame['eventname'].notna()]
        # Convert 'automatic_transmission' column, 1 -> True, 0 -> False
        data_frame['automatic_transmission'] = data_frame['automatic_transmission'].astype('bool')
        # Adds row number
        data_frame['row_no'] = np.arange(len(data_frame))
        # Adds datasourceid
        data_frame['datasourceid'] = str(uuid.uuid4())
        logging.info('Processing data... DONE.')
        return data_frame

    # Saves results
    def write_to_db(self, data_frame, config):
        logging.info('Writing to DB...')
        # TODO: store respective columns in user, vehicle, event, raw. Update insert query
        sql_connector = create_engine('mysql+pymysql://root:0404@localhost/carvana')
        try:
            # Filtering columns according to schema
            cols_raw = ["datasourceid","row_no","eventname","eventdate","userid","firstname","lastname","email","dob","creditscore","annualincome","vehicleid","make","model","year","automatic_transmission"]
            cols_user = ["userid","firstname","lastname","email","dob","creditscore","annualincome"]
            cols_vehicle = ["vehicleid","make","model","year","automatic_transmission"]
            cols_events = ["datasourceid","row_no","eventname","userid","vehicleid","eventdate"]
            data_frame = data_frame.reindex(columns=cols_raw)
            user_info = data_frame.reindex(columns=cols_user)
            # Removing duplicates
            user_info = user_info.drop_duplicates('userid')
            vehicle_info = data_frame.reindex(columns=cols_vehicle)
            # Removing duplicates
            vehicle_info = vehicle_info.drop_duplicates('vehicleid')
            event_info = data_frame.reindex(columns=cols_events)
            # Inserting data into tables
            data_frame.to_sql('data_raw', con=sql_connector, if_exists='append', chunksize=1000, index=False)
            user_info.to_sql('user_info', con = sql_connector, if_exists = 'append', chunksize = 1000, index = False)
            vehicle_info.to_sql('vehicle_info', con = sql_connector, if_exists = 'append', chunksize = 1000, index = False)
            event_info.to_sql('event_info', con = sql_connector, if_exists = 'append', chunksize = 1000, index = False)
        except Exception as e:
            logging.error('An exception occurred while writing to db')
            self.safe_exit(e)
        logging.info('Writing to DB... DONE.')

    @staticmethod
    def safe_exit(e):
        logging.error('Exception-\n{}\nExiting application.'.format(e))
        sys.exit(1)


# Executes task 1
def run_task1():
    """
The Analytics team would like to be able the query the information inside these messages with sql.
The department head has asked you to capture and warehouse this data for easy querying.
The JSON messages are in the file “data_sample.txt“.
Warehouse this data in a set of sql tables that you feel best represents the data.
Feel free to use any relevant packages for your answer.
    """
    config = configparser.ConfigParser()
    # Reading config and logs
    try:
        config.read(CONFIG_PATH)
        logging.basicConfig(
            filename=LOG_PATH,
            filemode=config['LOGGING']['filemode'],
            format='%(asctime)s - %(message)s',
            level=logging.INFO)
    except Exception as e:
        print('Error reading config/log file- {}.\n'
              'Exception-\n{}\n'
              'Exiting application.'.format(CONFIG_PATH, e))
        sys.exit(1)
    logging.info('------------------ TASK 1... ------------------')
    obj = DataWarehousing()
    # Checking file paths in config file
    if 'TASK_1' not in config:
        input_path = obj.user_inputs()
    else:
        input_path = config['TASK_1']['InputFilePath']
    dataframe_raw = obj.read_file(input_path)
    dataframe_processed = obj.process(dataframe_raw)
    obj.write_to_db(dataframe_processed, config)
    logging.info('------------------ TASK 1... DONE. ------------------')


if __name__ == "__main__":
    run_task1()
