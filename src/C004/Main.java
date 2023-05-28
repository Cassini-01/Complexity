package C004;

public class Main {
    public static void main(String[] args) {
        int colSize = 10;
        int rowSize = 10;
        CellLinkedMatrix matrix = new CellLinkedMatrix(colSize, rowSize);

        matrix.generateAgent();

        matrix.printAgentList();

        matrix.printMatrix();

        matrix.spawnAgent(1);

        matrix.printMatrix();

        matrix.moveAgent(1, Direction.SouthEast, 1);

        matrix.moveAgent(1, Direction.SouthEast, 1);

        matrix.printMatrix();





    }
}
