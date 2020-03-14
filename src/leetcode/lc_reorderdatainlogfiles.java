package leetcode;
import java.io.*;
import java.util.*;

//https://leetcode.com/problems/reorder-data-in-log-files/

// TIME - O(nlogn)
// SPACE - O(n) 


class lc_reorderdatainlogfiles {

  public String[] reorderLogFiles(String[] logs) {

          int len = logs.length;
          String log, text;
          long num;
          ArrayList<String> logs_l = new ArrayList<>();
          ArrayList<String> logs_d = new ArrayList<>();

          for(int i = 0; i < logs.length; ++i) {

              log = logs[i];
              text = log.split(" ")[1];
              if(text.charAt(0) < 'a')
                  logs_d.add(log);
              else
                  logs_l.add(log);
          }

          Collections.sort(logs_l, new Comparator<String>() {

              public int compare(String log1, String log2) {

              if(log1.split(" ", 2)[1].compareTo(log2.split(" ", 2)[1]) == 0)
                  return log1.split(" ", 2)[0].compareTo(log2.split(" ", 2)[0]);
              else
                  return log1.split(" ", 2)[1].compareTo(log2.split(" ", 2)[1]);
                                                         }
          });

          logs_l.addAll(logs_d);       

          return logs_l.toArray(new String[] {});

    }
}
