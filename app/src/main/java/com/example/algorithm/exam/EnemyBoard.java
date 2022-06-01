package com.example.algorithm.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EnemyBoard {
/*
    Let’s pretend we are creating a game. Write an algorithm that randomly populates a M x N board with exactly X enemies.
    width: 3
    height: 4
    enemies: 2

    Output should be as below
    0, 0, 0,
    0, 0, 1,
    0, 1, 0,
    0, 0, 0,
*/

    public void random(int width, int height, int enemies) {
        if (enemies > width * height) {
            return;
        }

        ArrayList<Integer> array = new ArrayList<>();
        int originalLength = width * height;
        Set<Integer> outputArray = new HashSet<>();

        for (int i = 0; i < originalLength; i ++) {
            array.add(i);
        }

        for(int i = 0; i < enemies; i++) {
            int size = array.size();
            // creating an object of Random class
            Random random = new Random();
            int selectIndex = random.nextInt(size);
            outputArray.add(array.get(selectIndex));
            // remove the selectIndex of item in this array
            array.remove(selectIndex);
        }

        for (int i = 0; i < originalLength; i++) {
            if (i % width == 0 && i != 0) {
                System.out.print("\n");
            }
            if (outputArray.contains(i)) {
                System.out.print("1,");
            } else {
                System.out.print("0,");
            }
        }
    }
}
