// https://leetcode.com/contest/weekly-contest-182/problems/design-underground-system/
// TIME - O(n)

import java.io.*;
import java.util.*;

class lc_undergroundsystem {
    
    private HashMap<Integer, String> id_checkinStation;
    private HashMap<Integer, Integer> id_checkinTime;
    private HashMap<String, Double> stations_avgTime; // st1-st2 => avgTime
    private HashMap<String, Integer> stations_visits; // st1-st2 => #visits

    public UndergroundSystem() {
        id_checkinStation = new HashMap<Integer, String>();
        id_checkinTime = new HashMap<Integer, Integer>();
        stations_avgTime = new HashMap<String, Double>();
        stations_visits = new HashMap<String, Integer>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
        id_checkinStation.put(id, stationName);
        id_checkinTime.put(id, t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        int checkinTime = id_checkinTime.get(id);
        String checkinStation = id_checkinStation.get(id);
        id_checkinTime.remove(id);
        id_checkinStation.remove(id);
        
        String k = checkinStation + "-" + stationName;
        double duration = t - checkinTime;
        
        if(stations_avgTime.containsKey(k)) {
            double avgTime = (stations_avgTime.get(k) * stations_visits.get(k) + duration) / (stations_visits.get(k) + 1);
            stations_visits.put(k, stations_visits.get(k) + 1);
            stations_avgTime.put(k, avgTime);
        }
        else {
            stations_visits.put(k, 1);
            stations_avgTime.put(k, duration);
        }
        
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String k = startStation + "-" +  endStation;
        return stations_avgTime.get(k);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
