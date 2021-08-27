import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P05_227_BasicCalculator {
    private static final Map<String, Integer> opPriority = new HashMap<>();
    static {
        opPriority.put("+", 0);
        opPriority.put("-", 0);
        opPriority.put("*", 1);
        opPriority.put("/", 1);
        opPriority.put("%", 1);
        opPriority.put("**", 1);
        opPriority.put("(", 2);
        opPriority.put(")", 2);
    }

    static class ProgramStack<T> {
        private List<T> stack;
        private int stackPointer;

        ProgramStack() {
            stack = new ArrayList<>(); 
            stackPointer = -1;
        }

        public void push(T t) {
            stack.add(t);
            stackPointer += 1;
        }

        public T pop() {
            if (stackPointer >= 0) {
                T t = stack.get(stackPointer);
                stack.remove(stackPointer);
                stackPointer -= 1;
                return t;
            } else {
                return null;
            }
            
        }

        public T peek() {
            if (stackPointer >= 0) {
                return stack.get(stackPointer);
            }
            return null;
        }

        public int size() {
            return stackPointer+1;
        }

        public String toString() {
            return stack.toString();
        }
    } 

    private static Double evaluateOperation(String op, Double x, Double y) {
        Double result = 0d;

        switch (op) {
            case "+":
                result = add(x, y);
                break;
            case "-":
                result = subtract(x, y);
                break;
            case "*":
                result = multiply(x, y);
                break;
            case "/":
                result = divide(x, y);
                break;
            case "%":
                result = modulo(x, y);
                break;
            case "**":
                result = power(x, y);
                break;
        }
        return result;
    }

    private static Double add(Double x, Double y) {
        return x + y;
    }

    private static Double subtract(Double x, Double y) {
        return x - y;
    }

    private static Double multiply(Double x, Double y) {
        return x * y;
    }

    private static Double divide(Double x, Double y) {
        return x / y;
    }

    private static Double modulo(Double x, Double y) {
        return x % y;
    }

    private static Double power(Double x, Double y) {
        return Math.pow(x, y);
    }

    private static void printStacks(String eq) {
        ProgramStack<String> operatorStack = new ProgramStack<>();
        ProgramStack<Double> operandStack = new ProgramStack<>();

        int i = 0;
        while (i < eq.length()) {
            if (Character.isDigit(eq.charAt(i))) {
                Double leftD = 0d + (eq.charAt(i) - '0');
                Double rightD = 0d;
                while (i < eq.length()-1 && Character.isDigit(eq.charAt(i+1))) {
                    i += 1;
                    leftD = (leftD*10) + (eq.charAt(i)-'0');
                }
                if (i < eq.length()-1 && eq.charAt(i+1) == '.') {
                    i += 1;
                    int rightDSize = 0;
                    while (i < eq.length()-1 && Character.isDigit(eq.charAt(i+1))) {
                        i += 1;
                        rightDSize += 1;
                        rightD = rightD + ((eq.charAt(i)-'0') * (1/Math.pow(10, rightDSize)));
                    }
                }
                operandStack.push(leftD+rightD);
            } else if (!Character.isWhitespace(eq.charAt(i))) {
                String operator = "" + eq.charAt(i); 
                if (eq.charAt(i) == '*') {
                    if (i < eq.length()-1 && eq.charAt(i+1) == '*') {
                        i += 1;
                        operator += eq.charAt(i);
                    }
                }
                operatorStack.push(operator);
            }
            i += 1;
        }
        System.out.println(operatorStack.toString());
        System.out.println(operandStack.toString());
    }

    private static Double calculate(String eq) {
        ProgramStack<String> operatorStack = new ProgramStack<>();
        ProgramStack<Double> operandStack = new ProgramStack<>();

        Double x, y, currEval;
        // this hurts code quality,
        // keep it simple to stack operations like peek(), instead of maintaning a state
        String prevOp = null; 

        int i = 0;
        while (i < eq.length()) {
            if (Character.isDigit(eq.charAt(i))) { // Scans a complete integer
                Double leftD = 0d + (eq.charAt(i) - '0');
                Double rightD = 0d;
                while (i < eq.length()-1 && Character.isDigit(eq.charAt(i+1))) {
                    i += 1;
                    leftD = (leftD*10) + (eq.charAt(i)-'0');
                }
                if (i < eq.length()-1 && eq.charAt(i+1) == '.') {
                    i += 1;
                    int rightDSize = 0;
                    while (i < eq.length()-1 && Character.isDigit(eq.charAt(i+1))) {
                        i += 1;
                        rightDSize += 1;
                        rightD = rightD + ((eq.charAt(i)-'0') * (1/Math.pow(10, rightDSize)));
                    }
                }
                operandStack.push(leftD+rightD);
            } else if (!Character.isWhitespace(eq.charAt(i))) { // Scans anything that's not a numeral and whitespace
                String operator = "" + eq.charAt(i); 
                if (eq.charAt(i) == '*') {
                    if (i < eq.length()-1 && eq.charAt(i+1) == '*') {
                        i += 1;
                        operator += eq.charAt(i);
                    }
                }

                if (prevOp != null) { // if previous op is not null
                    if (operator.equals(")")) { // if its end of Parathesis, process its internals (<->)
                        while (!prevOp.equals("(")) {
                            y = operandStack.pop();
                            x = operandStack.pop();
                            currEval = evaluateOperation(prevOp, x, y);
                            operatorStack.pop();
                            operandStack.push(currEval);
                            prevOp = operatorStack.peek();
                        }
                        while (prevOp != null && prevOp.equals("(")) {
                            operatorStack.pop();
                            prevOp = operatorStack.peek();
                        }
                        i += 1;
                        continue;
                    } else { // Process the non parathesized portions using plain old left->right and priority principles.
                        // get priorities for current OP and previous OP
                        Integer currOpPriority = opPriority.get(operator);
                        Integer prevOpPriority = opPriority.get(prevOp);

                        while (prevOpPriority >= currOpPriority) {
                            y = operandStack.pop();
                            x = operandStack.pop();
                            currEval = evaluateOperation(prevOp, x, y);
                            operatorStack.pop();
                            operandStack.push(currEval);

                            if (operatorStack.size() > 0) {
                                prevOp = operatorStack.peek();
                                if (prevOp.equals("(")) { // break off if ( is reached.
                                    break;
                                }
                                prevOpPriority = opPriority.get(prevOp);
                            } else {
                                break;
                            }
                        }
                    }
                }
                operatorStack.push(operator);
                prevOp = operator;
                if (prevOp.equals("(")) {
                    prevOp = null;
                }
            }
            i += 1;
        }
        
        // Compute leftoves
        while (operatorStack.size() > 0) {
            y = operandStack.pop();
            x = operandStack.pop();
            currEval = evaluateOperation(operatorStack.pop(), x, y);
            operandStack.push(currEval);
        }

        return operandStack.pop();
    }

    public static void main(String[] args) {
        String[] probs = {
            "(3+2)*5",
            "3+2*5",
            " 3/2 ",
            " 3+5 / 2 ",
            "2 + 2+2 * 2* 2+2 / 2",
            "100 * 2 /100-2",
            "2 + ( 3 / 100) * 2",
            "3 * (2 + 2 * (5 - 2 * 2 / (3-2)) * 2)",
            "(3 + 2)",
            "2 + 8 - ( 3 / 100)",
            "(1 + 3 - 2)",
            "2 + 4 * (4 / 2 - (2 + 2 / 2 + (4**2))) * (2 - 9)"
        };

        for (String prob: probs) {
            printStacks(prob);
            System.out.println(calculate(prob));
            
        }
    }
}