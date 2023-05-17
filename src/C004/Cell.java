package C004;

public class Cell {

    private final int cellID;
    private Cell N,NE,E,SE,S,SW,W,NW;

    public Cell(int id) {
        this.cellID = id;
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
