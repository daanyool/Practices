import java.util.Scanner;

public class CountVowels {
   private static int count(String s) {
      int counter = 0;
      
      for(int i = 0; i<s.length(); i++) {
         char ch = s.charAt(i);
         
         if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            counter++;
         }
      }
      return counter;
   }
   
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter a string: ");
      String str = obj.nextLine();
      
      System.out.println(count(str) + " vowel/s found in the string.");
   }
}