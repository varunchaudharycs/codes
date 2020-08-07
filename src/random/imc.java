import java.io.*;
import java.util.*;

class imc {

	public static void main(String args[]) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			StringTokenizer st;
			String inp;

			System.out.println("Enter N");
			int n = Integer.parseInt(buf.readLine());

			System.out.println("Enter artifacts coordinates");
			inp = buf.readLine();

			String[] artifacts = inp.split(",");

			System.out.println("Enter search coordinates");
			inp = buf.readLine();

			String[] search = inp.split(" ");

			System.out.println(findArtifacts(n, artifacts, search));
		}
	}

	public static int[] decode(String code) {

		int len = code.length();

		int y = code.charAt(len - 1) - 'A';
		int x = Integer.parseInt(code.substring(0, len - 1)) - 1;

		//System.out.println("in - " + code + ", out - " + x + "," + y);
		return new int[]{x, y};
	}

	public static String findArtifacts(int n, String[] artifacts, String[] search) {


		int[][] matrix = new int[n][n];
		HashMap<Integer, HashSet<String>> hm = new HashMap<>();
		HashMap<Integer, Integer> count = new HashMap<>();

		int partial = 0, full = 0;

		for(int idx = 0; idx < artifacts.length; ++idx) {

			String topLeft = artifacts[idx].split(" ")[0];
			String bottomRight = artifacts[idx].split(" ")[1];

			int[] coordinates = decode(topLeft);

			int x1 = coordinates[0];
			int y1 = coordinates[1];

			coordinates = decode(bottomRight);

			int x2 = coordinates[0];
			int y2 = coordinates[1];

			for(int i = x1; i <= x2; ++i)
				for(int j = y1; j <= y2; ++j) {

					matrix[i][j] = idx + 1;
					hm.computeIfAbsent(idx + 1, k -> new HashSet<String>()).add(i + "," + j);
					count.put(idx + 1, count.getOrDefault(idx + 1, 0) + 1);
				}
		}

		for(String coordinate : search) {

			int[] coordinates = decode(coordinate);

			int x = coordinates[0];
			int y = coordinates[1];

			System.out.println("searching @ (" + x + "," + y + ")");

			if(hm.containsKey(matrix[x][y])) {

				System.out.println("removing artifact - " + matrix[x][y]);
				hm.get(matrix[x][y]).remove(x + "," + y);
			}
		}

		for(Map.Entry<Integer, HashSet<String>> e : hm.entrySet()) {

			if(hm.get(e.getKey()).isEmpty()) full++;
			else if(hm.get(e.getKey()).size() < count.get(e.getKey())) partial++;
		}

		return full + "," + partial;
	}
}

// Enter N
// 4
// Enter artifacts coordinates
// 1B 2C,2D 4D
// Enter search coordinates
// 2B 2D 3D 4D 4A
// searching @ (1,1)
// removing artifact - 1
// searching @ (1,3)
// removing artifact - 2
// searching @ (2,3)
// removing artifact - 2
// searching @ (3,3)
// removing artifact - 2
// searching @ (3,0)
// 1,1
// Enter N
// 3
// Enter artifacts coordinates
// 1A 1B,2C 2C
// Enter search coordinates
// 1B
// searching @ (0,1)
// removing artifact - 1
// 0,1

