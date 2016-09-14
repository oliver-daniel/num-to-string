import java.text.*;
import java.util.Arrays;
import java.util.ArrayList;
public class NumToString {

  public static String numToString(String sh, boolean original){
    int n = 0;
    String s = null;
    try{
      n = Integer.parseInt(sh);
      s = n + "";
    }catch(NumberFormatException e) {}

    if (n == 0 && !original)
      return "";

    String delimited = NumberFormat.getInstance().format(n);
    String[] split = delimited.split(",");

    if (n < 20) {
      String[] zeroNineteen = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE",
                               "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
                               "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN",
                               "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
      return zeroNineteen[n];
    }else if (n < 100) {
      String[] twentyNinety = {"TWENTY", "THIRTY", "FORTY", "FIFTY",
                               "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
      if (s.substring(1).equals("0"))
        return twentyNinety[n / 10 - 2];
      return twentyNinety[n / 10 - 2] + " " + numToString(s.substring(1),false);
    }else if (n < 1000) {
      if (s.substring(1).equals("00"))
        return numToString(s.charAt(0) + "",false) + " " + "HUNDRED";
      return numToString(s.charAt(0) + "",false) + " " + "HUNDRED" + numToString(s.substring(1),false);
    }else{
      String[] powers = {"THOUSAND", "MILLION", "BILLION",
                         "TRILLION", "QUADRILLION", "QUINTILLION"};

      return numToString(split[0],false) + " " + powers[split.length - 2] + " " + numToString(String.join(",",Arrays.copyOfRange(split,1,split.length)),false);
    }
  }

  public static int search(int sh, ArrayList<String> visited,int depth){
    String s = String.join("",numToString(sh + "",true).split(" "));
    if (visited.contains(s))
      return depth;
    visited.add(s);
    int n = s.length();
    return search(n,visited,depth + 1);
  }

  public static void main(String[] args) {
    int m = 0;
    int mx = 0;

    for (int x = 0; x < 100000; x++) {
      int n = search(x,new ArrayList<String>(),0);
      if (n > m) {
        m = n;
        mx = x;
      }
    }
    System.out.println(mx + "->" + m);
  }
}