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

    public void agentAction() {

    }

    public void coreDirectionHandler(Direction direction) {
        switch(direction) {
            case North:
                coreMoveHandler(this.currentCell.getN());
                break;
            case NorthEast:
                coreMoveHandler(this.currentCell.getNE());
                break;
            case East:
                coreMoveHandler(this.currentCell.getE());
                break;
            case SouthEast:
                coreMoveHandler(this.currentCell.getSE());
                break;
            case South:
                coreMoveHandler(this.currentCell.getS());
                break;
            case SouthWest:
                coreMoveHandler(this.currentCell.getSW());
                break;
            case West:
                coreMoveHandler(this.currentCell.getW());
                break;
            case NorthWest:
                coreMoveHandler(this.currentCell.getNW());
                break;
        }
    }

    private void coreMoveHandler(Cell nextCell) {
        nextCell.setCurrentAgent(this);
        this.currentCell.removeCurrentAgent();
        this.setCurrentCell(nextCell);

    }

    public void borderDirectionHandler(Direction direction) {
        // identify the current cell
        Cell currentCell = this.currentCell;
    }

    public Cell getCurrentCell() {return this.currentCell;}
    public int getAgentID() {return this.agentID;}
    public char getDisplayChar() {return this.displayChar;}

    public void setDisplayChar(char display) {this.displayChar = display;}
    public void setCurrentCell(Cell cell) {this.currentCell = cell;}
}
