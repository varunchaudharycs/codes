import java.io.*;
import java.util.*;

class MaxTruckSize {

	public static void main(String[] args) throws IOException {

		int num = 3;
		List<Integer> boxes = List.of(3, 2, 1);
		int unitSize = 3;
		List<Integer> unitsPerBox = List.of(1, 2, 3);
		int truckSize = 3;

		System.out.println(findMaxSize(num, boxes, unitSize, unitsPerBox, truckSize));
	}

	public static int findMaxSize(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {

		int size = 0;

		List<List<Integer>> boxesAndUnitsPerBox = new ArrayList<>();

		for(int i = 0; i < num; ++i) { boxesAndUnitsPerBox.add(List.of(boxes.get(i), unitsPerBox.get(i))); }

		Collections.sort(boxesAndUnitsPerBox, (a, b) -> b.get(1) - a.get(1));

		for(int i = 0; i < num; ++i) {

			int b = boxesAndUnitsPerBox.get(i).get(0);
			int u = boxesAndUnitsPerBox.get(i).get(1);

			if(truckSize >= b) {

				size += (b * u);
				truckSize -= b;
			}
			else {

				size += (truckSize * u);
				break;
			}
		}

		return size;
	}
}