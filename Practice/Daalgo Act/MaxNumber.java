import java.util.Scanner;

public class MaxNumber {
   public static int findMax(int[] arr, int size) {
      int max = 0;
      if(size==1)
         max = arr[0];
      else {
         for(int a = 0; a<size; a++) {
            if(max<arr[a])
               max = arr[a];
         }
      }
         return max;
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
      
      for(int i : input) 
         System.out.print(i + " ");
         System.out.println();
         
      System.out.println("Maximum Number: " + findMax(input, size));
   }
}