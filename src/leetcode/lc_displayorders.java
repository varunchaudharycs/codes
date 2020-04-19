// https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_displayorders {
    // NESTED MAP -> (tableNo -> (Dish -> Qty))
    public List<List<String>> displayTable(List<List<String>> orders) {
        int len = orders.size();

        List<List<String>> summary = new ArrayList<>();

        List<String> dishes = new ArrayList<>();
        List<Integer> tables = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> tableOrders = new HashMap<>();

        for(List<String> order: orders) {

            String tableNo = order.get(1);
            String dish = order.get(2);
            int tableNum = Integer.parseInt(tableNo);
            if(!dishes.contains(dish)) dishes.add(dish);
            if(!tables.contains(tableNum)) tables.add(tableNum);


            HashMap<String, Integer> hm = tableOrders.getOrDefault(tableNo, new HashMap<String, Integer>());
            hm.put(dish, hm.getOrDefault(dish, 0)+1);
            tableOrders.put(tableNo, hm);
        }
        Collections.sort(dishes); // ORDERED
        Collections.sort(tables); // ORDERED
        dishes.add(0, "Table");
        summary.add(dishes);
     
        for(Integer tableNum : tables) {
            String table = tableNum.toString();
            List<String> tableOrder = new ArrayList<>(){{
                add(table);
            }};

            for(String dish : dishes)
                if(!dish.equals("Table"))
                    if(tableOrders.get(table).containsKey(dish))
                        tableOrder.add(String.valueOf(tableOrders.get(table).get(dish)));
                    else
                        tableOrder.add("0");
            summary.add(tableOrder);
        }

        return summary;
    }
}
