import java.util.Scanner;

public class main {
   public static int calculate(int n, int a, int b) {
      if(n<=1)
         return 0;
      
      int result = a + b;
      a = b;
      System.out.print((result) + " ");
      
      if(n==2)
         System.out.println("\nThe fibonacci is: " + result);
         
      return calculate(n-1, a, b=result);
   }
   
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter a Fibonacci number: ");
      int n = obj.nextInt();
      int a = 0, b = 1;
      
      System.out.print(a + " " + b + " ");

      calculate(n, a, b);
   }
}