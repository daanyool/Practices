import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
   public static int findIndex(int[] arr, int size, int num) {
      int index = 0;
      for(int i = 0; i<size; i++) {
         if(arr[i] == num)
            index = i;
      }
      return index;
   }
   
   public static boolean hasIndex(int[] arr,int size, int num) {
      boolean bool = false;
      for(int i = 0; i<size; i++) {
         if(arr[i] == num)
            bool = true;
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
      
      for(int a: input) 
         System.out.print(a + " ");
         
      Arrays.sort(input);
      System.out.println("\n");
      
      System.out.print("Sorted Array: ");
      for(int b: input) 
         System.out.print(b + " ");
      
      System.out.print("\nSearch an element: ");
      int element = obj.nextInt();
      
      if(hasIndex(input, size, element))
         System.out.println(element + " is in the index " + findIndex(input, size, element));
      else
         System.out.println("No element found.");
   }
}