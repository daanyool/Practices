import java.util.Scanner;

public class CalcPower {
   private static int calculateExp(int base, int exp) {
      int result = 1;
      for(int i = 0; i<exp; i++) {
         result *= base;
      }
      return result;
   }
   
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter a number: ");
      int b = obj.nextInt();
      
      System.out.print("Enter the exponent: ");
      int e = obj.nextInt();
      
      System.out.println(b + "^" + e + " = " + calculateExp(b, e));
   }
}