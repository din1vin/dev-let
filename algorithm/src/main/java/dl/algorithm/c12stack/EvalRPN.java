package dl.algorithm.c12stack;


import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                int a = nums.pop();
                int b = nums.pop();
                int c;
                switch (s) {
                    case "+":
                        c = b + a;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "*":
                        c = b * a;
                        break;
                    case "/":
                        c = b / a;
                        break;
                    default:
                        throw new RuntimeException();
                }
                nums.push(c);
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }
}
