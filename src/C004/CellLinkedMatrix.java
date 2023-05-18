package C004;

import java.util.ArrayList;

public class CellLinkedMatrix {

    int colSize;
    int rowSize;
    int cellAmount;

    public CellLinkedMatrix(int col, int row) {
        // defines size of matrix
        this.colSize = col;
        this.rowSize = row;

        // calculate number of cells
        cellAmount = colSize * rowSize;

        // create cells and add to an array
        Cell[] cellList = new Cell[cellAmount+1];
        for (int i = 1; i <= cellAmount; i++) {
            cellList[i] = new Cell(i);
        }

        // identify the corners
        int NW = 1;
        int NE = col;
        int SE = col * row;
        int SW = (col * row) - col + 1;

        // identify the north border
        int[] N = new int[col];
        for (int i = 1; i < col; i++) {
            N[i] = i;
        }
        // remove the corners
        N[0] = -1;
        N[col-1] = -1;

        // identify the east border
        int[] E = new int[row];
        E[0] = col;
        for (int i = 1; i < row; i++) {
            E[i] = E[i-1] + col;
        }
        // remove the corners
        E[0] = -1;
        E[row-1] = -1;

        // identify the south border
        int[] S = new int[col];
        S[0] = ((col*row)-col+1);
        for (int i = 1; i < col; i++) {
            S[i] = S[i-1] + 1;
        }
        // remove corners
        S[0] = -1;
        S[col-1] = -1;


        for (int i = 0; i < row; i++) {
            System.out.println(S[i]);
        }
    }

}
