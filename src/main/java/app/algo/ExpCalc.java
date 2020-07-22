package app.algo;

import java.util.Queue;

public class ExpCalc {

    public  int eval(String exp) {
        Queue<Integer> numbers = new java.util.LinkedList<>();
        Queue<String> operator = new java.util.LinkedList<>();
        breakUpOps(exp, numbers, operator);
        return calculate(numbers, operator);
    }

    private  int calculate(Queue<Integer> numbers, Queue<String> operator) {
        int result = 0;
        for (Integer n : numbers) {
            if (result == 0) {
                result = n;
            } else {
                result = operator(result, n, operator.poll());
            }
        }
        return result;
    }

    private  int operator(int result, Integer n, String op) {
        switch (op) {
            case "+":
                result = result + n;
                break;
            case "-":
                result = result - n;
                break;
            case "/":
                result = result / n;
                break;
            case "*":
                result = result * n;
                break;
            default:
                throw new IllegalArgumentException("invalid expreson");
        }
        return result;
    }

    private  void breakUpOps(String exp, Queue<Integer> numbers, Queue<String> operator) {
        char[] chars = exp.toCharArray();
        int tVal = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                tVal = tVal * 10 + Character.getNumericValue(c);
            } else {
                numbers.add(tVal);
                operator.add(Character.toString(c));
                tVal = 0;
            }
        }
        if (tVal > 0) {
            numbers.add(tVal);
        }
    }
}
