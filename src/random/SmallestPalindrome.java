class SmallPalindrome {  
  public static void main(String args[]) { 
    String str = "slejfldsjlfe";
    char[] s = str.toCharArray();
    int n = s.length;
    int i = n - 1;
    boolean inc = false;

    while (i >= n / 2) {
      if (s[i] != s[n-i-1]) {
        if (s[i] > s[n-i-1]) {
          inc = true;
        }
        else {
          inc = false;
        }
        s[i] = s[n-i-1];
      }
      i--;
    }

    if (inc) {
      i = n / 2;

      if ((n & 1) == 1 && s[n/2] != 'z') {
        s[n/2]++;
      } 
      else {
        if ((n & 1) == 1) {
          s[i] = 'a';
          i = (n / 2) + 1;
        }

        while (i < n && s[i] == 'z') {
          s[i] = 'a';
          s[n-i-1] = 'a';
          i++;
        }
        s[i]++;
        s[n-i-1]++;
      }
    }

    StringBuilder res = new StringBuilder();

    for (char c : s) {
      res.append(c);
    }

    System.out.println(res.toString());
  } 
}
