import java.util.Stack;
import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter infix expression:");
        String infix = console.nextLine();
        String postfix = convertToPostfix(infix);
        System.out.println(infix + " = " + postfix);
        int result = evaluatePostfix(postfix);
        if (result != Integer.MIN_VALUE) {
            System.out.println(postfix + " = " + result);
        } else {
            System.out.println("Invalid infix expression");
        }
    }

    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int inStackPrecedence, incomingPrecedence;

        for (char c : infix.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue;
            } else if (Character.isDigit(c)) {
                postfix.append(c).append(' ');
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else {

                switch (c) {
                    case '+':
                    case '-':
                        incomingPrecedence = 1;
                        break;
                    case '*':
                    case '/':
                        incomingPrecedence = 2;
                        break;
                    default:
                        incomingPrecedence = 0;
                        break;
                }

                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.peek();
                    if (top == '+' || top == '-') {
                        inStackPrecedence = 1;
                    } else {
                        inStackPrecedence = 2;
                    }

                    if (inStackPrecedence >= incomingPrecedence) {
                        postfix.append(stack.pop()).append(' ');
                    } else {
                        break;
                    }
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                return "Invalid infix expression";
            }
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    return Integer.MIN_VALUE; 
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            return Integer.MIN_VALUE; 
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        return Integer.MIN_VALUE; 
                }
            }
        }

        if (stack.size() == 1) {
            return stack.peek();
        } else {
            return Integer.MIN_VALUE; 
        }
    }
}