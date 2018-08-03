package com.lu;

import java.util.Stack;

public class Leet20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if(stack.size() == 0)
                    return false;
                char prev = stack.pop();
                if (ch == ')') {
                    if (prev != '(')
                        return false;
                }
                if (ch == '}') {
                    if (prev != '{')
                        return false;
                }
                if (ch == ']') {
                    if (prev != '[')
                        return false;
                }
            }
        }

        return stack.size() == 0;
    }


    public static void main(String[] args) {
        Leet20 l20 = new Leet20();
        System.out.println(l20.isValid("{[]}"));
    }
}
