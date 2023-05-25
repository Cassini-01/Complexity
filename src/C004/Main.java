package C004;

public class Main {
    public static void main(String[] args) {
        int colSize = 5;
        int rowSize = 5;
        CellLinkedMatrix matrix = new CellLinkedMatrix(colSize, rowSize);

        matrix.printMatrix();
        matrix.cellList[5].setCurrentAgent(new Agent(1));
        System.out.println();
        System.out.println();
        matrix.printMatrix();
        matrix.cellList[5].getCurrentAgent().setDisplayChar('Z');
        System.out.println();
        System.out.println();
        matrix.printMatrix();
    }
}
