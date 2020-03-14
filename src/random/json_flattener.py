import logging
import os
import sys
from pathlib import Path
import json
import configparser

CONFIG_PATH = os.path.join(os.path.dirname(__file__), '..' + os.sep + '..', 'config.ini')
LOG_PATH = os.path.join(os.path.dirname(__file__), '..' + os.sep + '..', 'log.txt')
CURRENT_DIR = os.path.dirname(__file__)


class NestedToFlatJSON:

    def __init__(self):
        logging.info('Created NestedToFlatJSON class object.')

    # Takes user input for file paths
    def user_inputs(self):
        input_path = input('Enter the input JSON file path:')
        if not Path(input_path).is_file():
            logging.warning('Invalid file path- File does not exist. Please enter again.')
            self.user_inputs()
        output_path = input('Enter output file path to store results:')
        return input_path, output_path

    # Reads JSON
    def read_json(self, input_path):
        logging.info('Reading JSON...')
        try:
            with open(input_path) as f:
                json_raw = json.load(f)
        except Exception as e:
            print('An exception occurred while reading file- ', input_path)
            self.safe_exit(e)
        logging.info('Reading JSON... DONE.')
        return json_raw

    # Flattens nested JSON
    @staticmethod
    def flatten_json(json_input):
        logging.info('Flattening JSON...')
        json_updated = {}

        def flatten(values, key = ''):
            if type(values) is dict:
                for value in values:
                    flatten(values[value], key + value + '_')
            elif type(values) is list:
                i = 0
                for value in values:
                    flatten(value, key + str(i) + '_')
                    i += 1
            else:
                json_updated[key[:-1]] = values

        flatten(json_input)
        logging.info('Flattening JSON... DONE.')
        return json.dumps(json_updated)

    # Saves results
    def write_to_file(self, json_flat, output_path):
        logging.info('Writing results to file...')
        try:
            f = open(output_path, "w")
            f.write(json_flat)
        except Exception as e:
            logging.error('An exception occurred while writing to file- ', output_path)
            self.safe_exit(e)
        finally:
            f.close()
        logging.info('Results stored in: %s', output_path)
        logging.info('Writing results to file... DONE.')

    @staticmethod
    def safe_exit(e):
        logging.error('Exception-\n{}\nExiting application.'.format(e))
        sys.exit(1)


# Executes task 3
def run_task3():
    """
write a function to parse a nested JSON file into a flat JSON. For example,
Before parsing: {"a": {"value": 0}, "b": {"number": 0, "value": 5}, "c": {"d": {"value": 8}}}
After parsing: {"a_value": 0, "b_number": 0, "b_value": 5, "c_d_value": 8}
This function should be able to handle any level of nesting and be robust to the name of they key. You can assume all associated values are numeric.
A sample JSON message to test your function is in trades_sample.json
You may use any relevant packages to assist your function, but do not use any pre-existing functions that automatically accomplishes the assigned task (i.e. your answer shouldn't be just one line of code!).
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
    logging.info('------------------ TASK 3... ------------------')
    obj = NestedToFlatJSON()
    # Checking file paths in config file
    if 'TASK_3' not in config:
        input_path, output_path = obj.user_inputs()
    else:
        input_path = os.path.join(CURRENT_DIR, config['TASK_3']['InputFilePath'])
        output_path = config['TASK_3']['OutputFilePath']
    json_raw = obj.read_json(input_path)
    json_flat = obj.flatten_json(json_raw)
    obj.write_to_file(json_flat, output_path)
    logging.info('Flattened JSON:\n%s', json_flat)
    logging.info('------------------ TASK 3... DONE. ------------------')


if __name__ == "__main__":
    run_task3()
