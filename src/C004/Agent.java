package C004;

public class Agent {
    private final int agentID;
    private char displayChar;
    private Cell currentCell;
    private static int moveCount;

    public Agent(int id) {
        this.agentID = id;
        // temp
        this.displayChar = 'x';
        this.moveCount = 0;
    }

    public void directionHandler(Direction direction, int steps) {
        switch(direction) {
            case North:
                moveHandler(this.currentCell.getN(), steps);
                break;
            case NorthEast:
                moveHandler(this.currentCell.getNE(), steps);
                break;
            case East:
                moveHandler(this.currentCell.getE(), steps);
                break;
            case SouthEast:
                moveHandler(this.currentCell.getSE(), steps);
                break;
            case South:
                moveHandler(this.currentCell.getS(), steps);
                break;
            case SouthWest:
                moveHandler(this.currentCell.getSW(), steps);
                break;
            case West:
                moveHandler(this.currentCell.getW(), steps);
                break;
            case NorthWest:
                moveHandler(this.currentCell.getNW(), steps);
                break;
        }
    }

    private void moveHandler(Cell nextCell, int steps) {
        nextCell.setCurrentAgent(this);
        this.currentCell.removeCurrentAgent();
        this.setCurrentCell(nextCell);
        //directionHandler(direction, nextCell,);

    }

    public Cell getCurrentCell() {return this.currentCell;}
    public int getAgentID() {return this.agentID;}
    public char getDisplayChar() {return this.displayChar;}

    public void setDisplayChar(char display) {this.displayChar = display;}
    public void setCurrentCell(Cell cell) {this.currentCell = cell;}
}
