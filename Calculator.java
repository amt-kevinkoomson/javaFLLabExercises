import java.util.Stack;

public class Calculator {
    private Stack<Integer> stack;

    public Calculator() {
        stack = new Stack<>();
    }

    public void pushOperand(int operand) {
        stack.push(operand);
    }

    public void pushOperator(char operator) {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
        }
        stack.push(result);
    }

    public int getResult() {
        return stack.peek();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.pushOperand(5);
        calculator.pushOperand(3);
        calculator.pushOperator('+');
        calculator.pushOperand(2);
        calculator.pushOperator('*');
        calculator.pushOperand(4);
        calculator.pushOperator('-');
        calculator.pushOperand(10);
        calculator.pushOperator('/');

        System.out.println("Result: " + calculator.getResult());
    }
}
