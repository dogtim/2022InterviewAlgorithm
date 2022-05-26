package com.example.algorithm.exam;

public class MakePalindromeString {

    //"_a_", "aaee_a", "bb_bb" -> You should return "bab", "aaeeaa", "bbcbb"

    //Therefore, if the impossible string to be palindromic, you should return "NO"
    //such as "a_e", "ef_fb", "_dfdfe"
    public String result(String inputS) {
        StringBuilder stringBuilder = new StringBuilder(inputS);

        for (int left = 0, right = inputS.length() - 1; left < right; left++, right--) {
            char leftChar = inputS.charAt(left);
            char rightChar = inputS.charAt(right);
            if(leftChar != rightChar) {
                if (leftChar == '_') {
                    stringBuilder.setCharAt(left, rightChar);
                } else if (rightChar == '_') {
                    stringBuilder.setCharAt(right, leftChar);
                } else {
                    return "NO";
                }
            } else if (leftChar == '_') {
                stringBuilder.setCharAt(left, 'a');
                stringBuilder.setCharAt(right, 'a');
            }
        }

        if(inputS.length() % 2 == 1)  { // odd
            if (inputS.charAt(inputS.length()/2) == '_') {
                stringBuilder.setCharAt(inputS.length()/2, 'a');
            }
        }

        return stringBuilder.toString();
    }

}
