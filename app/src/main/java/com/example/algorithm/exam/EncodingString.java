package com.example.algorithm.exam;

public class EncodingString {

    // input: [0, 1, 2]  -> "01211210" (3 carry) -> (10 carry) = 84
    // output: [0-9a-z] ->

    public String encode(String input) {
        return decimalTo36Carry(toDecimalWithPow(input, 3));
    }

    public String decode(String input) {
        return decimalToTernary(toDecimalWithPow(input, 36));
    }

    private int toDecimalWithPow(String inputString, int pow) {
        int carry = 0;
        int result = 0;
        for (int i = inputString.length() - 1; i >= 0; i--) {
            boolean flag = Character.isDigit(inputString.charAt(i));
            int number = 0;
            if(flag) {
                number = Integer.parseInt(String.valueOf(inputString.charAt(i)));
            }
            else {
                number = inputString.charAt(i) - 'a' + 10;
            }
            if (number != 0) {
                if (carry >= 1) {
                    result += number * (int) Math.pow(pow, carry);
                } else {
                    result += number;
                }
            }
            carry++;
        }
        System.out.println("result " + result);
        return result;
    }

    private String decimalToAny(char[] map, int number) {
        if(number == 0) {
            return String.valueOf(map[0]);
        }
        String result = "";
        while(number != 0) {
            int x = number % map.length;
            result = map[x] + result;
            number = number / map.length;
        }
        return result;
    }

    private String decimalTo36Carry(int number) {
        char[] map = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
        return decimalToAny(map, number);
    }

    private String decimalToTernary(int number) {
        char[] map = "012".toCharArray();
        return decimalToAny(map, number);
    }

}
