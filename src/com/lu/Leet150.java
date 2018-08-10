package com.lu;

import java.util.Stack;

public class Leet150 {
    private int operate(String operator, int num1, int num2){
        if(operator == "+")
            return num1 + num2;
        if(operator == "-")
            return num1 - num2;
        if(operator == "*")
            return num1 * num2;
        if(operator == "/")
            return num1 / num2;
        return 0;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        String[] operators = new String[]{"+", "-", "*", "/"};
        for(String token:tokens){
            if(token == "+" || token == "-" || token == "*" || token == "/"){
                stack.push(operate(token, stack.pop(), stack.pop()));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        Leet150 l150 = new Leet150();
        System.out.println(l150.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
