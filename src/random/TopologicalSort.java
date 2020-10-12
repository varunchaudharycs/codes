package random;

import java.io.*;
import java.util.*;

public class TopologicalSort {

	public static void main(String[] args)throws IOException {

		List<int[]> adj = new ArrayList<int[]>() {{

			add(new int[] {});
			add(new int[] {3});
			add(new int[] {3});
			add(new int[] {});
			add(new int[] {0, 1});
			add(new int[] {0, 2});
			add(new int[] {});
		}};
		int n = 7;

		List<int[]> adj2 = new ArrayList<int[]>() {{ // CYCLE

			add(new int[] {1});
			add(new int[] {0});
		}};
		int n2 = 2;
		
		//sortUsingStack(adj, n);

		sortUsingEdgeRemoval(adj2, n2);
	}

	

	// MODDED DFS = EDGE REMOVAL
	public static void sortUsingEdgeRemoval(List<int[]> adj, int n) {

		int totalEdges = 0;
		int[] inDegree = new int[n];
		Map<Integer, List<Integer>> adjMap = new HashMap<>();

		for(int u = 0; u < n; ++u) { // CREATE ADJACENCY MAP
			for(int v : adj.get(u)) {
				adjMap.computeIfAbsent(u, k -> new ArrayList<Integer>()).add(v);
				inDegree[v]++; // FIND IN DEGREE OF VERTICES
				totalEdges++; 
			}
		}

		// System.out.println("totalEdges - " + totalEdges);
		// for(int i : inDegree) { System.out.print(i + ", "); }

		Queue<Integer> starts = new LinkedList<>(); // IDENTIFY STARTS || ISOLATED || NO DEP VERTICES
		for(int i = 0; i < n; ++i) { if(inDegree[i] == 0) { starts.add(i); } }
		// System.out.println("starts - " + starts);

		List<Integer> sorted = new ArrayList<>(); // STORE SORTED ORDER

		while(!starts.isEmpty()) {

			int start = starts.poll(); // PICK START

			sorted.add(start); // ADD TO SORTED LIST

			if(adjMap.containsKey(start)) { // ITERATE CHILDREN

				for(int v : adjMap.get(start)) {

					inDegree[v]--; // DELETE EDGE
					totalEdges--;
					if(inDegree[v] == 0) { starts.add(v); } // IF CHILD HAS NO OTHER IN EDGE -> PUT IN STARTS
					
				}	
			}		
		}

		if(totalEdges != 0) { System.out.println("IMPOSSIBLE"); } // CYCLE
		else { System.out.println(sorted); }	
	}

	public static int getStart(Set<Integer> starts) {

		if(starts.size() == 0) { return -1; }
		else {

			int start = starts.iterator().next();
			starts.remove(start);
			return start;
		}
	}

	// MODDED DFS - STACK
	public static void sortUsingStack(List<int[]> adj, int n) {

		Set<Integer> starts = new HashSet<>();
		for(int i = 0; i < n; ++i) { starts.add(i); }

		for(int[] outgoing : adj) { // IDENTIFY STARTS & ISOLATED VERTICES

			for(int vertex : outgoing) { starts.remove(vertex); } 
		}

		//System.out.println("starts - " + starts);

		Set<Integer> visited = new HashSet<>();

		Stack<Integer> sorted = new Stack<>(); // STORE TOP SORT

		Stack<Integer> dfs = new Stack<>(); // DFS stack

		dfs.push(getStart(starts));

		while(visited.size() != n) {

			if(dfs.isEmpty()) {

				if(starts.isEmpty()) { break; }
				else { dfs.push(getStart(starts)); continue; }
			}

			int curr = dfs.peek();

			//System.out.println("curr - " + curr);

			visited.add(curr);
			boolean ready = true;
			for(int child : adj.get(curr)) {

				if(!visited.contains(child)) { dfs.push(child); ready = false; }
			}

			if(ready) { sorted.push(dfs.pop()); }

			//System.out.println("dfs - " + dfs);
			//System.out.println("visited - " + visited);
		}

		if(visited.size() != n) { System.out.println("IMPOSSIBLE"); }
		else {
			while(!sorted.isEmpty()) { System.out.print(sorted.pop() + ", "); }
		}
	}
}