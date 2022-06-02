package com.example.algorithm.exam;

import java.util.HashMap;

 /* Example:
input: [0, 1, 2]  -> "01211210" (3 carry) -> (10 carry) = 84
output: [0-9a-z] ->

To define the encode & decode by yourself.
Create two HashMap to keep the mapping values

Three char
input: 001, output: z1
input: 002, output: z2
input: 010, output: 3
...
input: 222, output: q

Two char
input: 00, output: r
input: 01, output: s
....
input: 22, output: z

Two char
input: 0, output: 0
input: 1, output: 1
input: 2, output: 2

Combination Input:  001002
Combination Output: z1z2
  */

public class EncodingStringMapping {

    public HashMap<String, String> table1 = new HashMap<>();
    public HashMap<String, String> table2 = new HashMap<>();

    public EncodingStringMapping() {
        // Build the table1 & table2 for decoding and encoding use
        buildThreeChar();
        buildTwoChar();
        buildOneChar();
    }

    private void buildOneChar() {
        // 0, 1, 2
        for (int i = 0; i < 2; i++) {
            String key = String.valueOf(i);
            String value = String.valueOf(i);
            table1.put(key, value);
            table2.put(value, key);
        }
    }

    private void buildTwoChar() {
        // 00
        char[] doubleData = ("rstuvwxyz").toCharArray();

        // 00, 01, 02, ... 22
        for (int i = 0; i < doubleData.length; i++) {
            String key = decimalToTernary(i);
            String value = String.valueOf(doubleData[i]);
            if (key.length() == 1) {
                key = "0" + key;
            }
            table1.put(key, value);
            table2.put(value, key);
        }
    }

    private void buildThreeChar() {
        // 000, 001
        char[] triple = ("0123456789abcdefghijklmnopq").toCharArray();
        // 000, 001, 002, ...222
        for (int i = 0; i < triple.length; i++) {
            String key = decimalToTernary(i);
            String value = String.valueOf(triple[i]);
            if (key.length() == 1) {
                key = "00" + key;
                value = "zz" + value;
            } else if (key.length() == 2) {
                key = "0" + key;
            }
            System.out.println("key : " + key + ", value: " + value);

            // (001, z1), (002, z2), ... (222, p)

            table1.put(key, value);
            table2.put(value, key);
        }
    }

    public String encode(String input) {
        if (input.length() <= 3) { // 0, 0
            return table1.get(input);
        } else {
            String prefix = input.substring(0, 3);
            return table1.get(prefix) + encode(input.substring(3));
        }
    }

    public String decode(String input) {
        if (input.length() == 0) {
            return "";
        }

        if (input.length() >= 3 && input.charAt(0) == 'z' && input.charAt(1) == 'z') {
            String prefix = input.substring(0, 3);;
            System.out.println("prefix : " + prefix);
            return table2.get(prefix) + decode(input.substring(3));
        } else {
            String key = String.valueOf(input.charAt(0));
            return table2.get(key) + decode(input.substring(1));
        }
    }

    private String decimalToAny(char[] map, int number) {
        if (number == 0) {
            return String.valueOf(map[0]);
        }
        String result = "";
        while (number != 0) {
            int x = number % map.length;
            result = map[x] + result;
            number = number / map.length;
        }
        return result;
    }

    private String decimalToTernary(int number) {
        char[] map = "012".toCharArray();
        return decimalToAny(map, number);
    }

}
