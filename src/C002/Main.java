package C002;

import C001.Cell;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int col = 5;
        int row = 5;

        int[][] matrix = new int[col][row];

        Random rand = new Random();
        int upperbound = 10;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[c][r] = rand.nextInt(upperbound);
            }
        }

        while (true) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (matrix[c][r] > 5) {
                        matrix[c][r]--;
                    }
                    else if (matrix[c][r] < 5) {
                        matrix[c][r]++;
                    }
                }
            }
            //print
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            for (int i = 0 ; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(matrix[j][i] + "\t");

                }
                System.out.println();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
