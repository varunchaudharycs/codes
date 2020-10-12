package random;

import java.io.*;
import java.util.*;

class CriticalConnections {

    public static void main(String[] args) {

        // int n = 6;
        // List<List<Integer>> connections = new ArrayList<>() {{

        //     add(List.of(1, 2));
        //     add(List.of(1, 3));
        //     add(List.of(2, 3));
        //     add(List.of(2, 4));
        //     add(List.of(2, 5));
        //     add(List.of(4, 6));
        //     add(List.of(5, 6));
        // }};
        // OUTPUT - []

        int n = 9;
        List<List<Integer>> connections = new ArrayList<List<Integer>>() {{

            add(Arrays.asList(1, 2));
            add(Arrays.asList(1, 3));
            add(Arrays.asList(2, 3));
            add(Arrays.asList(3, 4));
            add(Arrays.asList(3, 6));
            add(Arrays.asList(4, 5));
            add(Arrays.asList(6, 7));
            add(Arrays.asList(6, 9));
            add(Arrays.asList(7, 8));
            add(Arrays.asList(8, 9));
        }};

        Set<Integer> servers = new HashSet<>();
        for(List<Integer> connection : connections)
            for(int server : connection)
                servers.add(server);

        int totalServers = servers.size();

        System.out.println(new CriticalConnections().findCriticalConnections(totalServers, n, connections));
    }

    private void DFS(Map<Integer, HashSet<Integer>> adj, int u){

        visited.put(u, true);

        if(adj.get(u).size()!=0){

            for(int v : adj.get(u)){

                if(visited.getOrDefault(v, false)== false) { DFS(adj,v); }
            }
        }
    }

    List<List<Integer>> list;
    Map<Integer, Boolean> visited;

    private List<List<Integer>> findCriticalConnections(int numOfServers, int numOfConnections,
                                      List<List<Integer>> connections) {

        Map<Integer, HashSet<Integer>> adj = new HashMap<>();

        for(List<Integer> connection : connections){ // create adjacency map

            int u = connection.get(0);
            int v = connection.get(1);

            adj.computeIfAbsent(u, k -> new HashSet<Integer>()).add(v);
            adj.computeIfAbsent(v, k -> new HashSet<Integer>()).add(u);
        }
       
        list = new ArrayList<>();

        for(int i = 0; i < numOfConnections; ++i){

            visited = new HashMap<>();
            List<Integer> connection = connections.get(i);

            int x = connection.get(0);
            int y = connection.get(1);

            adj.get(x).remove(y);
            adj.get(y).remove(x);

            DFS(adj,1);

            if(visited.size() != numOfServers){

                    if(x > y) { list.add(new ArrayList<>(Arrays.asList(x, y))); }
                    else { list.add(connection); }
            }

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        return list;
    }
}