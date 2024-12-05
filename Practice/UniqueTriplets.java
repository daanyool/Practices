import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class UniqueTriplets {
   public static List<List<Integer>> findUniqueTriplets(int[] arr, int sum) {
      Arrays.sort(arr);
      
      List<List<Integer>> triplets = new ArrayList<>();
      List<Integer> pair = new ArrayList<>();
      
      for(int a = 0; a<arr.length-2; a++) {
         int left = a + 1;
         int right = arr.length-1;
         
         while(left < right) {
            if(arr[a] + arr[left] + arr[right] == sum) {
               pair.add(arr[a]);
               pair.add(arr[left]);
               pair.add(arr[right]);
               triplets.add(pair);
               pair = new ArrayList<>();
              
               left++;
               right--;
            }
            
            else if(arr[a] + arr[left] + arr[right] < sum)
               left++;
            else
               right--;
         }
      }
      return triplets;
   }
                           
   public static void main(String[] args) {
      Scanner obj = new Scanner(System.in);
      
      System.out.print("Enter the size of an array: ");
      int size = obj.nextInt();
      int[] arr = new int[size];
      
      int element = 0;
      for(int i = 0; i<size; i++) {
         System.out.print("Enter an element: ");
         element = obj.nextInt();
         arr[i] = element;
      }
      
      System.out.print("Enter desired sum: ");
      int sum = obj.nextInt();
      
      List<List<Integer>> triplets = findUniqueTriplets(arr, sum);
      
      if(!triplets.isEmpty())
         System.out.println(triplets);
      else
          System.out.println("No triplets found");
   }
}