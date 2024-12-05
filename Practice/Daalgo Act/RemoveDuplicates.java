import java.util.Scanner;
import java.util.Arrays;

public class RemoveDuplicates {
   public static int[] removeDuplicate(int[] arr, int size) {     
      if (size <= 1) 
         return arr;
          
      int index = 1; 
      for (int a = 1; a < size; a++) {
         int b;
         for (b = 0; b < index; b++) {
            if (arr[a] == arr[b]) {
               break;
            }
         }
         if (b == index) {
            arr[index] = arr[a];
            index++;
         }
      }
       
      int[] result = Arrays.copyOf(arr, index);
      return result;
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
      
      int[] output = removeDuplicate(input, size);
      
      for(int s: output) 
         System.out.print(s + " ");
   }
}  