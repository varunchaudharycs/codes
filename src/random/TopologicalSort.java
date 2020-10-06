import java.io.*;
import java.util.*;

public class TopologicalSort {

	public static void main(String[] args)throws IOException {

		List<int[]> adj = new ArrayList<>() {{

			add(new int[] {});
			add(new int[] {3});
			add(new int[] {3});
			add(new int[] {});
			add(new int[] {0, 1});
			add(new int[] {0, 2});
			add(new int[] {});
		}};

		sort(adj);
	}

	public static int getStart(Set<Integer> starts) {

		if(starts.size() == 0) { return -1; }
		else {

			int start = starts.iterator().next();
			starts.remove(start);
			return start;
		}
	}

	public static void sort(List<int[]> adj) {

		int n = adj.size();

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