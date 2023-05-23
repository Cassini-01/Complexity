package C004;

public class CellLinkedMatrix {

    int colSize;
    int rowSize;
    int cellAmount;

    public CellLinkedMatrix(int col, int row) {
        // declare corner and borders
        int NW;
        int NE;
        int SE;
        int SW;
        int[] N;
        int[] E;
        int[] S;
        int[] W;

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
        NW = 1;
        NE = col;
        SE = col * row;
        SW = (col * row) - col + 1;

        // identify the north border
        N = new int[col];
        for (int i = 1; i < col; i++) {
            N[i] = i;
        }
        // remove the corners
        N[0] = -1;
        N[col-1] = -1;

        // identify the east border
        E = new int[row];
        E[0] = col;
        for (int i = 1; i < row; i++) {
            E[i] = E[i-1] + col;
        }
        // remove the corners
        E[0] = -1;
        E[row-1] = -1;

        // identify the south border
        S = new int[col];
        S[0] = ((col*row)-col+1);
        for (int i = 1; i < col; i++) {
            S[i] = S[i-1] + 1;
        }
        // remove corners
        S[0] = -1;
        S[col-1] = -1;

        // identify the west border
        W = new int[row];
        W[0] = 1;
        for (int i = 1; i < row; i++) {
            W[i] = W[i-1] + col;
        }
        // remove the corners
        W[0] = -1;
        W[row-1] = -1;



        // link core cells
        for (Cell cell : cellList) {
            if (cell.getCellID() == NW || cell.getCellID() == NE ||
            cell.getCellID() == SE || cell.getCellID() == SW) {
                continue;
            }
            if (isIn(N, cell) || isIn(E, cell) || isIn(S, cell)
                    || isIn(W, cell)) {
                continue;
            } else {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc SE direction
                cell.setSE(cellList[cell.getCellID() + row + 1]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }

        }

    }

    private boolean isIn(int[] cellIDList, Cell cell) {
        for (int ID : cellIDList) {
            if (cell.getCellID() == ID) {
                return true;
            }
        }
        return false;
    }

}
