package com.example.algorithm.exam;

import java.util.LinkedList;
import java.util.Queue;

public class GetMaxArea {
    private int rowLength;
    private int columnLength;
    // You must return the max area which the space contains 1 value with a number of nodes
    // for example:
    /*
       [
        [0, 1, 0, 1],
        [1, 1, 0, 1],
        [1, 1, 0, 0],
        [0, 1, 0, 0],
       ]

       the output is 6, array[0][1], array[1][0], array[1][1], array[2][0], array[2][1], array[3][1]
    * */
    public int getMaxArea(int[][] area) {
        rowLength = area.length;
        columnLength = area[0].length;
        int result = 0;
        Queue<int[]> queue = new LinkedList();
        final int VALID = 1;
        final int VISITED = 2;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (area[row][column] == VALID) {
                    System.out.println("Node["+row+"]["+column+"] " + area[row][column]);
                    int[] node = {row, column};
                    queue.add(node);
                    int localMax = 0;
                    while (!queue.isEmpty()) {
                        int[] _node = queue.poll();
                        area[row][column] = VISITED;

                        for (int[] direction: DIRECTIONS) {
                            if (getValue(direction, area, _node[0], _node[1]) == VALID) {
                                int[] newNode = {_node[0] + direction[0], _node[1] + direction[1]};
                                area[_node[0] + direction[0]][_node[1] + direction[1]] = VISITED;
                                queue.add(newNode);
                            }
                        }
                        localMax++;
                    }
                    result = Math.max(result, localMax);
                }
            }
        }

        return result;
    }

    private int getValue(int[] direction, int[][] area, int row, int column) {
        int result = -1;

        if (row + direction[0] < 0 || row + direction[0] >= rowLength || column + direction[1] < 0 || column + direction[1] >= columnLength) {
            return result;
        }

        return area[row + direction[0]][column + direction[1]];
    }

    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
}
