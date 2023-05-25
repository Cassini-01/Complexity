package C004;

public class CellLinkedMatrix {

    int colSize, rowSize, cellAmount;
    Cell[] cellList;

    public CellLinkedMatrix(int col, int row) {
        // declare corner and borders
        int NW, NE, SE, SW;
        int[] N, E, S ,W;

        // defines size of matrix
        this.colSize = col;
        this.rowSize = row;

        // calculate number of cells
        this.cellAmount = colSize * rowSize;

        // create cells and add to an array
        cellList = new Cell[cellAmount+1];
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
        for (int i = 1; i <= col; i++) {
            N[i-1] = i;
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
        for (int i = 1; i < cellAmount; i++) {
            Cell cell = cellList[i];
            if (cell.equals(null)) {continue;}
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

        // link border cells
        for (int i = 1; i <= cellAmount; i++) {
            Cell cell = cellList[i];
            if (isIn(N, cell)) {
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
            }
            if (isIn(E, cell)) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }
            if (isIn(S, cell)) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }
            if (isIn(W, cell)) {
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
            }
            if (cell.getCellID() == NW) {
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc SE direction
                cell.setSE(cellList[cell.getCellID() + row + 1]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
            }
            if (cell.getCellID() == NE) {
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
            }
            if (cell.getCellID() == SE) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }
            if (cell.getCellID() == SW) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
            }
        }

        // fill in the direction arrays of each cell
        for (int i = 1; i < cellList.length; i++) {
            cellList[i].fillDirectionList();
        }
    }

    public void printAllNeighbours() {
        for (int i = 1; i < cellList.length; i++) {
            cellList[i].printNeighbours();
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

    public Cell[] getCellList() {return cellList;}
    public Cell getCell(int ID) {
        for (int i = 1; i < cellAmount; i++) {
            if (ID == cellList[i].getCellID()) {
                return cellList[i];
            }
        }
        return null;
    }
    public Cell getCell(Cell cell) {
        for (int i = 1; i < cellAmount; i++) {
            if (cell.equals(cellList[i])) {
                return cellList[i];
            }
        }
        return null;
    }
}
