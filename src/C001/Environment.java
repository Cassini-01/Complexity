package C001;

import java.util.ArrayList;

public class Environment {
    public int colSize;
    public int rowSize;
    public Cell[][] matrix;
    public ArrayList<Cell> objects;
    public Environment(int cSize, int rSize) {
        this.colSize = cSize;
        this.rowSize = rSize;
        matrix = new Cell[colSize][rowSize];
        fill();
    }

    public void createObject1(int colIndex, int rowIndex) {
        Object1 temp = new Object1(colIndex, rowIndex);
        matrix[colIndex][rowIndex] = temp;
        objects.add(temp);
    }

    public void print() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (int r = 0 ; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                System.out.print(matrix[c][r].getDisplay() + "\t");

            }
            System.out.println();
        }
    }
    public void fill() {
        for (int r = 0 ; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                Cell temp = new Cell();
                matrix[c][r] = temp;
            }
        }
    }
}
