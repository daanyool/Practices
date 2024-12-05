import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.ArrayList;

public class InfixToPostfix {   
   public static void main(String[] args) {
      boolean bool = true;
      
      while(bool==true) {
         byte choice = 1;
         
            while(choice==1) {
               Stack<Character> operator = new Stack<>();
               ArrayList<String> output = new ArrayList<>();
               Scanner obj = new Scanner(System.in);
             
              // try {
                  System.out.print("Enter expression: ");
                  String exp = obj.nextLine().replaceAll(" ", "");
                  bool = false;
                
                  for(int i = 0; i < exp.length(); i++) {
                     char ch = exp.charAt(i);
         
                     if(Character.isDigit(ch)) 
                        output.add(String.valueOf(ch));
                     
                     else if(ch=='-') {
                        if(i==0 || isOperator(exp.charAt(--i)) || exp.charAt(--i)=='(' && Character.isDigit(exp.charAt(++i))) {
                           StringBuilder num = new StringBuilder();
                           num.append(ch);
                           
                           i++;
                           while(i<exp.length() && (Character.isDigit(i) || exp.charAt(i)=='.')) {
                              num.append(exp.charAt(i));
                              i++;
                           }
                           output.add(String.valueOf(num));
                        }
                     }
            
                     else if(isOperator(ch)) {    
                        while(!operator.isEmpty() && precedence(ch) <= precedence(operator.peek()))
                           output.add(String.valueOf(operator.pop()));
                        operator.push(ch);
                     } 
                  
                     else if(ch == '(') 
                        operator.push(ch);
            
                     else if(ch == ')') {
                        while(!operator.isEmpty() && operator.peek()!='(') {
                           output.add(String.valueOf(operator.pop()));
                        }
                        operator.pop();
                     }
                  }
      
                  if(output.size() < exp.length()) {
                     while(output.size() < exp.length() && !operator.isEmpty()) 
                        output.add(String.valueOf(operator.pop()));
                  }
                  
                  for(String s: output)
                     System.out.print(s + " ");
            
                  calculate(output);
            
               do {           
                  System.out.println("Do you want to enter another expression?\n[1] yes\n[0] no");
                  choice = obj.nextByte();
               } while(choice!=1 && choice!=0);   
               bool = false;
           // }
           // catch(Exception e) {
           //    bool = true;
           //    System.out.println("Invalid");
          //  } 
         }
      }
      System.out.println("Exit");                       
   }
   
   public static void calculate(ArrayList<String> expression) {
      LinkedList<String> val = new LinkedList<String>();
      
      for(int i = 0; i < expression.size(); i++) {
         val.addLast(expression.get(i));
      }
         
      while (val.size() > 1) {
         System.out.print("\nPostfix: ");
        
         for (String x : val)
            System.out.print(x + " ");
        
            System.out.println();
            
            int index = 0;
   
            for (int x = val.size()-1; x >= 0; x--) {
               if (val.get(x).length() == 1 && isOperator(val.get(x).charAt(0)))  
                      index = x; 
            }
            
            double fOperand = Double.parseDouble(val.get(index-2));             
            double sOperand = Double.parseDouble(val.get(index-1));            
            char op = val.get(index).charAt(0);
            
            for(int x = 0; x <= 1; x++) {
               val.remove(index-x);
               val.set(index-2, "");
            }
      
            val.set(index-2, String.valueOf(applyOperator(fOperand, sOperand, op)));         
         }
         System.out.println("\nFinal result: " + val.get(0));
         System.out.println();
   }

   public static boolean isOperator(char ch) {
      return ch == '*' || ch == '/' || ch == '+' || ch == '-';
   }
   
   public static int precedence(char ch) {
      if(ch=='*' || ch=='/') 
         return 2;
      if(ch=='-' || ch=='+')
         return 1;
      else
         return 0;
   }
   
    public static double applyOperator(double oper1, double oper2, char op) {
      switch (op) {
         case '+':
            return oper1 + oper2;
         case '-':
            return oper1 - oper2;
         case '*':
            return oper1 * oper2;
         case '/':
            if (oper2 == 0) throw new ArithmeticException("Division by zero");
            return oper1 / oper2;
         default: 
            throw new IllegalArgumentException("Invalid operator: " + op);
      }
   }
}