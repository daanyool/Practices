import java.util.Scanner;

public class MyBinaryTree {
   private TreeNode root;
   
   private class TreeNode {
      private int data;
      private TreeNode left;
      private TreeNode right;
      
      public TreeNode(int data) {
         this.data = data;
      }
   }
   
   public void insert(int value) {
      root = insert(root, value);
   }
   
   public TreeNode insert(TreeNode root, int value) {
      if(root == null) {
         root = new TreeNode(value);
         return root;
      }
      
      if(value < root.data) 
         root.left = insert(root.left, value);
      else
         root.right = insert(root.right, value);
      
      return root;
   }
   
   public void inOrder() {
      inOrder(root);
   }
   
   public void inOrder(TreeNode root) {
      if(root == null) 
         return;
      
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
   }
   
   public void postOrder() {
      postOrder(root);
   }
   
   public void postOrder(TreeNode root) {
      if(root == null)
         return;
      
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data + " ");
   }
   
   public void preOrder() {
      preOrder(root);
   }
   
   public void preOrder(TreeNode root) {
      if(root == null)
         return;
      
      System.out.print(root.data + " ");
      postOrder(root.left);
      postOrder(root.right);
   }
   
   public boolean search(int key) {
      return search(root, key);
   }
   
   public boolean search(TreeNode root, int key) {
      if(root != null && root.data == key) {
         return true;
      }
      else if(root == null) {
         return false;
      }
       
      if(key < root.data)
         return search(root.left, key);
      else
        return search(root.right, key);
    }
    
    public void delete(int value){
      root = delete(root, value);
    }
    
    public TreeNode delete(TreeNode root, int value) {
        if (root == null) {
             root = new TreeNode(value);
             return root;
        }
        if (value < root.data) {
            root.left = delete(root.left, value);
        } else if (value > root.data) {
            root.right = delete(root.right, value);
        } else{
            if(root.left == null)
               return root.right;            
            else if(root.right == null)
               return root.left;  
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        
        return root;
    }
    
    static int minValue(TreeNode root){
      int minVal = root.data;
      while(root.left != null){
         minVal = root.left.data;
         root = root.left;
      }
      return minVal;
    }
   
   public static void main(String[] args) {
      MyBinaryTree bt = new MyBinaryTree();
      Scanner obj = new Scanner(System.in);
      boolean bool = true;
      
      System.out.println("----- B I N A R Y  T R E E -----");
      
      while(bool==true) {
         int num = 0;
         byte choice = 0;
         try {
            do {
               System.out.print("Enter a number: ");
               num = obj.nextInt();
               
               if(bt.search(num) == true) 
                  System.out.println("Already added.");
               else
                  bt.insert(num);
               do {
                  System.out.println("Do you want to enter more numbers?\n[1] yes  [2] no");
                  choice = obj.nextByte();
               } while(choice!=1 && choice!=2);
            } while(choice==1);
            bool = false;
         } 
         catch(Exception e) {
            System.out.println("Invalid Input. Please try again.");
            obj.next();
         } 
      } 
      
      byte choice2 = 0;
      do {
         choice2 = 0;
         int enterNum = 0;
         bool = true;
         while(bool==true) {
            try {
               System.out.println("[1] insert\n[2] delete\n[3] Traverse\n[4] search\n[5] exit");
               choice2 = obj.nextByte();
               bool = false;
            }
            catch(Exception e) {
               System.out.println("Invalid. Please enter again.");
               obj.next();
            }
         }
         
         switch(choice2) {
            case 1: 
               bool = true;
               while(bool==true) {
                  try {
                     System.out.print("Enter a number you want to insert: ");
                     enterNum = obj.nextInt();
                     
                     if(bt.search(enterNum) == true) 
                        System.out.println("Already added.");
                     else
                        bt.insert(enterNum);
                     bool = false;
                  }
                  catch(Exception e) {
                     System.out.println("Invalid. Please try again.");
                     obj.next();
                  }
               }
               break;
            case 2:
               bool = true;
               while(bool==true) {
                  try {
                     System.out.print("Enter a number you want to delete: ");
                     enterNum = obj.nextInt();
                     
                     if(bt.search(enterNum) == false) 
                        System.out.println("Number not found.");
                     else 
                        bt.delete(enterNum);
                     bool = false;
                  }
                  catch(Exception e) {
                     System.out.println("Invalid. Please enter again.");
                     obj.next();
                  }
               }
               break;
            case 3:
               bool = true;
               while(bool==true) {
                  byte choice3 = 0;
                  try {
                     System.out.println("[1] In-Order\n[2] Post-Order\n[3] Pre-Order");
                     choice3 = obj.nextByte();
                     
                     switch(choice3) {
                        case 1: bt.inOrder(); System.out.println(); break;
                        case 2: bt.postOrder(); System.out.println(); break;
                        case 3: bt.preOrder(); System.out.println();
                     }
                     bool = false;
                  }
                  catch(Exception e) {
                     System.out.println("Invalid. Please enter again.");
                     obj.next();
                  }
               }
               break;
            case 4:
               bool = true;
               while(bool==true) {
                  try {
                     System.out.print("Enter number you want to search");
                     enterNum = obj.nextByte();
                     
                     if(bt.search(enterNum) == true) 
                        System.out.println(enterNum + " is found");
                     else
                        System.out.println(enterNum + " is not found");
                     bool = false;
                  }
                  catch(Exception e) {
                     System.out.println("Invalid. Please try again.");
                     obj.next();
                  }
               }
               break;
            case 5: System.out.println("Thank You!"); break;
            default: System.out.println("Invalid Input.");
         }
      } while(choice2!=5);
   }
}