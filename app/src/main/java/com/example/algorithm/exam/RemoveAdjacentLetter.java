package com.example.algorithm.exam;

public class RemoveAdjacentLetter {

    // inputS length should be equal to inputWeight length
    // inputS: eedcc -> edc, keep the most sum of remaining array

    // eedcc along with [1, 2, 5, 3, 2], you should return the maximum of remaining
    // 2 + 5 + 3
    public int minimumValue(String inputS, int[] inputWeight) {
        int result = inputWeight[0];
        int previousMax = inputWeight[0];

        for (int i = 1; i < inputS.length(); i ++) {
            if (inputS.charAt(i) == inputS.charAt(i - 1)) {
                result -= previousMax;
                previousMax = Math.max(previousMax, inputWeight[i]);
                result += previousMax;

            } else {
                result += inputWeight[i];
                previousMax = inputWeight[i];
            }
        }

        return result;
    }

}
