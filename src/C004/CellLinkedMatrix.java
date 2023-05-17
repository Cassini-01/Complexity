package C004;

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

        // link up all the cells
        for (int i = 1; i <= cellAmount; i++) {
            int tempCellID = cellList[i].getCellID();
            // N
            int tempVal = tempCellID - rowSize - 1;
            if (boundCheck(tempVal, colSize, rowSize)) {

            }
            // NE
            // E
            // SE
            // S
            // SW
            // W
            // NW
        }

    }

    private boolean boundCheck(int tempVal, int col, int row) {
        if ( tempVal > 0 || tempVal < row || tempVal < col) {
            return true;
        } else {
            return false;
        }
    }

}
