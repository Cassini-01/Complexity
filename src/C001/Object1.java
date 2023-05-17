package C001;

public class Object1 extends Cell {
    int col, row;
    public Object1(int colIndex, int rowIndex) {
        col = colIndex;
        row = rowIndex;
    }
    @Override
    public void action() {

    }
    @Override public String getDisplay() {return "X";}
    public int getCol() {return col;}
    public int getRow() {return row;}

}
