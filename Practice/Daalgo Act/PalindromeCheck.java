import java.util.Scanner;

public class PalindromeCheck {
   public static String reverse(String str) {
      char[] ch = str.toCharArray();
      String newStr = "";
      
      for(int i = str.length(); i>0; i--) {
         newStr += String.valueOf(ch[i-1]);
      }
      return newStr;
   }
   
   public static boolean check(String str) {
      String rev = reverse(str);
      str = str.toLowerCase().replaceAll("\\s", "").trim();
      rev = rev.toLowerCase().replaceAll("\\s", "").trim();
      
      if(rev.equals(str)) 
         return true;
      else
         return false;
   }
   
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter a string: ");
      String s = obj.nextLine();
      
      if(check(s))
         System.out.println("The string is a palindrome.");
      else 
         System.out.println("The string is not a palindrome.");
   }
}