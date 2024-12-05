import java.util.Scanner;

public class StringReverse {
   public static String reverse(String str) {
      char[] ch = str.toCharArray();
      String newStr = "";
      
      for(int i = str.length(); i>0; i--) {
         newStr += String.valueOf(ch[i-1]);
      }
      return newStr;
   }
   
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter a string: ");
      String s = obj.nextLine();
      
      System.out.println("Reversed String: " + reverse(s));
   }
}