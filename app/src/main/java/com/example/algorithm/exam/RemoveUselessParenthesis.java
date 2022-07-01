package com.example.algorithm.exam;

import java.util.Stack;

/*
Example 1:
Input: (A)B)(CAAA
Output: (A)BCAAA // remove ')(' in index 4 and 5

Example 2:
Input: (((
Output: "" // because there are no ')' can make valid parenthesis string

Example 3:
Input: )))(A)
Output: (A) // remove ')))' in index 0,1,2
* */
public class RemoveUselessParenthesis {

    public String filterString(String input) {
        StringBuilder result = new StringBuilder();
        Stack<Data> stack = new Stack();

        // Store the indexes that are invalid parenthesis
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '(') {
                Data data = new Data(i, c);
                stack.push(data);
            } else if (c == ')') {
                if(!stack.isEmpty() && stack.peek().ch == '(') {
                    stack.pop();
                } else {
                    Data data = new Data(i, c);
                    stack.push(data);
                }
            }
        }

        for(int i = input.length() - 1; i >= 0; i--) {
            if(!stack.isEmpty() && stack.peek().index == i) {
                stack.pop();
            } else {
                result.insert(0, input.charAt(i));
            }
        }
        return result.toString();
    }
}

class Data {
    int index;
    char ch;
    public Data(int index, char ch) {
        this.index = index;
        this.ch = ch;
    }
}