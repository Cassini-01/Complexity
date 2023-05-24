package C004;

import java.util.Objects;

public class Cell {

    private final int cellID;
    private Cell N,NE,E,SE,S,SW,W,NW;
    public Cell[] directionList;

    public Cell(int id) {
        this.cellID = id;
        this.directionList = new Cell[8];
    }

    // print cell neighbour details
    public void printNeighbours() {
        String[] labels = {"N","NE","E","SE","S","SW","W","NW"};
        System.out.println("=== " + this.cellID + " " + this + " ===");
        for (int i = 0; i < directionList.length; i++) {
            if (Objects.isNull(directionList[i])) {
                System.out.println(labels[i] + " " + "null " + "null");
            } else {
                System.out.println(labels[i] + " " + directionList[i].getCellID() + " " + directionList[i]);
            }
        }
        System.out.println();
    }

    public void fillDirectionList() {
        directionList[0] = N;
        directionList[1] = NE;
        directionList[2] = E;
        directionList[3] = SE;
        directionList[4] = S;
        directionList[5] = SW;
        directionList[6] = W;
        directionList[7] = NW;
    }

    // getters
    public int getCellID() {return cellID;}
    public Cell getN() {return N;}
    public Cell getNE() {return NE;}
    public Cell getE() {return E;}
    public Cell getSE() {return SE;}
    public Cell getS() {return S;}
    public Cell getSW() {return SW;}
    public Cell getW() {return W;}
    public Cell getNW() {return NW;}

    // setters
    public void setN(Cell cell) {N = cell;}
    public void setNE(Cell cell) {NE = cell;}
    public void setE(Cell cell) {E = cell;}
    public void setSE(Cell cell) {SE = cell;}
    public void setS(Cell cell) {S = cell;}
    public void setSW(Cell cell) {SW = cell;}
    public void setW(Cell cell) {W = cell;}
    public void setNW(Cell cell) {NW = cell;}
}
