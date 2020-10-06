import java.io.*;
import java.util.*;

class MaxTruckSize {

	public static void main(String[] args) throws IOException {

		int num = 5;
		int[] boxes = {1,2,3,1,1};
		int unitSize = 5;
		int[] unitsPerBox = {2,3,1,6,4};
		int truckSize = 3;

		System.out.println(findMaxSize(num, boxes, unitSize, unitsPerBox, truckSize));
	}

	public static int findMaxSize(int num, int[] boxes, int unitSize, int[] unitsPerBox, int truckSize) {

		List<int[]> boxesUnits = new ArrayList<>();
		
		for(int i = 0; i < num; ++i) {
		    
		    boxesUnits.add(new int[]{boxes[i], unitsPerBox[i]});
		}
		
		Collections.sort(boxesUnits, (a, b) -> b[1] - a[1]);
		long maxUnits = 0;
		
		for(int[] a : boxesUnits) {
		    
		    int numBoxes = a[0];
		    int units = a[1];
		    
		    if(truckSize > numBoxes) {
			    
		        truckSize -= numBoxes;
		        maxUnits += (numBoxes * units);
		    }
		    else {
		        
		        maxUnits += (truckSize * units);
		        break;
		    }
		}
		
		System.out.println(maxUnits);
	}
}
