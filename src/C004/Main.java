package C004;

public class Main {
    public static void main(String[] args) {
        int colSize = 100;
        int rowSize = 100;
        CellLinkedMatrix matrix = new CellLinkedMatrix(colSize, rowSize);

        matrix.generateAgent();

        matrix.printAgentList();

        matrix.printMatrix();

        matrix.spawnAgent(1);

        matrix.switchActivation();

        matrix.cycleAgents();





    }
}
