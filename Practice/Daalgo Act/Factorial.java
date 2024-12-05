import java.util.Scanner;

public class Factorial {
   public static int getFactorial(int n) {
      if(n == 1 || n == 0) 
         return 1;
         
      return n*getFactorial(n-1);
   }
   
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter a number to get its factorial: ");
      int num = obj.nextInt();
      
      System.out.println("Factorial of " + num + " is " + getFactorial(num));
   }
}