package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
class Calculator {
    int prevRes;
    int currentRes;
    public int calculate(char op, int a, int b) {
        if (op != '<') prevRes = currentRes;
        switch (op) {
            case '-':
                currentRes = a - b;
                break;
            case '+':
                currentRes = a + b;
                break;
            case '*':
                currentRes = a * b;
                break;
            case '/':
                currentRes = a / b;
                break;
            case '<':
                return prevRes;
        }
        return currentRes;
    }
}
public class Main {

    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;
        a = 3;
        op = '+';
        b = 7;
        c = 4;
        op2 = '+';
        d = 7;
        undo = '<';
        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}