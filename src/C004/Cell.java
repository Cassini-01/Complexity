package C004;

import java.util.Objects;

public class Cell {

    private final int cellID;
    private Cell N,NE,E,SE,S,SW,W,NW;
    private Cell[] directionList;
    private Agent currentAgent;

    public Cell(int id) {
        this.cellID = id;
        this.directionList = new Cell[8];
        this.currentAgent = null;
    }

    // print currentAgent
    // if empty print '.'
    public void printCurrentAgent() {
        if (Objects.isNull(currentAgent)) {
            System.out.print('.');
            System.out.print('\t');
        } else {
            System.out.print(currentAgent.getDisplayChar());
            System.out.print('\t');
        }
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
    public Agent getCurrentAgent() {return currentAgent;}
    public Cell getN() {return N;}
    public Cell getNE() {return NE;}
    public Cell getE() {return E;}
    public Cell getSE() {return SE;}
    public Cell getS() {return S;}
    public Cell getSW() {return SW;}
    public Cell getW() {return W;}
    public Cell getNW() {return NW;}

    // setters
    public void setCurrentAgent(Agent agent) {this.currentAgent = agent;}
    public void removeCurrentAgent() {this.currentAgent = null;}
    public void setN(Cell cell) {N = cell;}
    public void setNE(Cell cell) {NE = cell;}
    public void setE(Cell cell) {E = cell;}
    public void setSE(Cell cell) {SE = cell;}
    public void setS(Cell cell) {S = cell;}
    public void setSW(Cell cell) {SW = cell;}
    public void setW(Cell cell) {W = cell;}
    public void setNW(Cell cell) {NW = cell;}
}
