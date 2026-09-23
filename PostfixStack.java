
import java.util.Scanner;
public class PostfixStack {

    // ---- Custom Stack implementation (array-based) ----
    private double[] data;
    private int top;

    public PostfixStack(int capacity) {
        data = new double[capacity];
        top = -1;
    }

    public void push(double value) {
        if (top == data.length - 1) {
            throw new RuntimeException("Stack is full");
        }
        data[++top] = value;
    }

    public double pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data[top--];
    }

    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void displayStack() {
        System.out.print("Stack (bottom -> top): [");
        for (int i = 0; i <= top; i++) {
            System.out.print(data[i]);
            if (i < top) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ---- Postfix evaluation ----
    public static double evaluatePostfix(String expression) {
        String[] pieces = expression.trim().split("\\s+");
        PostfixStack stack = new PostfixStack(pieces.length);

        for (String token : pieces) {
            if (isOperator(token)) {
                double right = stack.pop();
                double left = stack.pop();
                double result = applyOperator(left, right, token.charAt(0));
                stack.push(result);
                System.out.println("Applied '" + token + "' on " + left + " and " + right
                        + " -> pushed " + result);
            } else {
                double value = Double.parseDouble(token);
                stack.push(value);
                System.out.println("Pushed " + value);
            }
            stack.displayStack();  // show stack after every major operation
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }

    private static double applyOperator(double left, double right, char op) {
        switch (op) {
            case '+': return left + right;
            case '-': return left - right;
            case '*': return left * right;
            case '/':
                if (right == 0) throw new ArithmeticException("Division by zero");
                return left / right;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    // ---- Demo: now takes live input ----
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression (numbers and operators separated by spaces):");
        String expression = scanner.nextLine();

        System.out.println("Evaluating postfix expression: " + expression);
        double result = evaluatePostfix(expression);
        System.out.println("Final Result: " + result);

        scanner.close();
    }
}