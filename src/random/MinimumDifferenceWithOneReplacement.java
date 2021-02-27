import java.io.*;
import java.util.*;


class MinimumDifferenceWithOneReplacement {

  public static void main(String[] args)throws IOException {
    int[] a = {6, 13, 19, 48, 74, 75, 85, 86, 88, 98};
    int[] b = {1012, 1024, 1160, 1518, 1525, 1539, 1682, 1717, 1762, 1947};

    TreeSet<Integer>  A = new TreeSet<>();
    for (int e : a) {
      A.add(e);
    }

    int minDiff = Integer.MAX_VALUE;
    int toBeSubtracted = 0;
    int[] abDiff = new int[a.length];
    for (int i = 0; i < a.length; ++i) {
      abDiff[i] = Math.abs(a[i] - b[i]);
      Integer floorA = A.floor(b[i]);
      Integer ceilA = A.ceiling(b[i]);

      int optA = (floorA != null) ? Math.abs(floorA - b[i]) : Integer.MAX_VALUE;
      int optB = (ceilA != null) ? Math.abs(ceilA - b[i]) : Integer.MAX_VALUE;
      
      if (optA < abDiff[i] || optB < abDiff[i]) {
        minDiff = Math.min(optA, optB);
        toBeSubtracted = Math.max(toBeSubtracted, abDiff[i] - minDiff);
      }
    }

    int res = Arrays.stream(abDiff).sum() - toBeSubtracted;

    System.out.println(res);
  }
}
