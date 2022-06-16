package com.example.algorithm.exam;

// Only have a and b in a String, and a/b can not appear three consecutive together

// Input: aaabb, return Output 1
// because aaabb -> ababb, need one time change `a` to `b`

// Input: aaabbb, return Output 2
// because aaabb -> ababba

public class TheNumOfChangingCharacter {

    public int number(String S) {
        int result = 0;
        StringBuilder sb = new StringBuilder(S);

        if (S.length() <= 2) {
            return result;
        }

        for(int i = 2; i < S.length(); i++) {
            if (isConsecutive(sb, i, 'a')) {
                changeChar(sb, i, 'b');
                result++;
            } else if (isConsecutive(sb, i, 'b')) {
                changeChar(sb, i, 'a');
                result++;
            }
        }

        return result;
    }
    private void changeChar(StringBuilder sb, int i, char c) {
        // bbaaabb
        if (i > 4 && sb.charAt(i-4) == c && sb.charAt(i-3) == c && i < sb.length() - 2 && sb.charAt(i+1) == c && sb.charAt(i+2) == c) {
            sb.setCharAt(i-1, c);
            // bbaaaba
        } else if (i < sb.length() - 2 && sb.charAt(i+1) == c && sb.charAt(i+2) == c) {
            sb.setCharAt(i-2, c);
        } else { // bbaaaaa
            sb.setCharAt(i, c);
        }
    }
    private boolean isConsecutive(StringBuilder sb, int i, char c) {
        return sb.charAt(i) == c && sb.charAt(i - 1) == c && sb.charAt(i - 2) == c;
    }


}
