import java.util.Scanner;

public class SumTwoNum {
   public static boolean getBool(int[] arr, int size, int sum) {
      boolean bool = false;
      for(int a = 0; a<size; a++) {
         for(int b = 1; b<size; b++) {
            if((arr[a]+arr[b])==sum) 
               bool = true;
         }
      }
      return bool;
   }
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      System.out.print("Enter size of an array: ");
      int size = obj.nextInt();
      int[] input = new int[size];
      
      for(int i = 0; i<size; i++) {
         System.out.print("Enter an integer: ");
         input[i] = obj.nextInt();
      }
      
      System.out.print("Enter targeted sum: ");
      int target = obj.nextInt();
      
       if(getBool(input, size, target)) 
          System.out.println("The array has two numbers, which sum is equal to the targeted sum."); 
       else
          System.out.println("The array has no two numbers, which sum is equal to the targeted sum.");
   }
}