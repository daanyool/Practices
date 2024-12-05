import java.util.Scanner;

public class PracticeException {
   public static void main(String[] args) { 
      Scanner obj = new Scanner(System.in);
      int num, den, result;
      
      do {
         System.out.print("Enter numerator: ");
         num = obj.nextInt();
      
         System.out.print("Enter denominator: ");
         den = obj.nextInt();
         
         try {
            result = num / den;
            System.out.println(num + " / " + den + " = " + result);
         }
         catch(ArithmeticException mistake) {
            System.out.println(mistake.getMessage());
         }
         System.out.println();
      } while(den==0);
   }
}