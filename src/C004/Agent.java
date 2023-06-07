package C004;

import java.util.Objects;

public class Agent {
    private final int agentID;
    private char displayChar;
    private Cell currentCell;
    private Direction currentDirection;
    int NW, NE, SE, SW;
    int[] N, E, S ,W;

    public Agent(int id) {
        this.agentID = id;
        this.displayChar = 'x';
        this.currentDirection = Direction.SouthEast; // testing, likely be random
    }

    public void agentAction() {
        coreDirectionHandler();
    }

    private void coreDirectionHandler() {
        switch(currentDirection) {
            case North:
                if (Objects.isNull(this.currentCell.getN())) {
                    this.currentDirection = Direction.South;
                    coreMoveHandler(this.currentCell.getS());
                } else {
                    coreMoveHandler(this.currentCell.getN());
                }
                break;
            case NorthEast:
                if (Objects.isNull(this.currentCell.getNE())) {
                    this.currentDirection = Direction.SouthWest;
                    coreMoveHandler(this.currentCell.getSW());
                } else {
                    coreMoveHandler(this.currentCell.getN());
                }
                break;
            case East:
                if (Objects.isNull(this.currentCell.getE())) {
                    this.currentDirection = Direction.West;
                    coreMoveHandler(this.currentCell.getW());
                } else {
                    coreMoveHandler(this.currentCell.getE());
                }
                break;
            case SouthEast:
                if (Objects.isNull(this.currentCell.getSE())) {
                    this.currentDirection = Direction.NorthWest;
                    coreMoveHandler(this.currentCell.getNW());
                } else {
                    coreMoveHandler(this.currentCell.getSE());
                }
                break;
            case South:
                if (Objects.isNull(this.currentCell.getS())) {
                    this.currentDirection = Direction.North;
                    coreMoveHandler(this.currentCell.getN());
                } else {
                    coreMoveHandler(this.currentCell.getS());
                }
                break;
            case SouthWest:
                if (Objects.isNull(this.currentCell.getSW())) {
                    this.currentDirection = Direction.NorthEast;
                    coreMoveHandler(this.currentCell.getNE());
                } else {
                    coreMoveHandler(this.currentCell.getSW());
                }
                break;
            case West:
                if (Objects.isNull(this.currentCell.getW())) {
                    this.currentDirection = Direction.East;
                    coreMoveHandler(this.currentCell.getE());
                } else {
                    coreMoveHandler(this.currentCell.getW());
                }
                break;
            case NorthWest:
                if (Objects.isNull(this.currentCell.getNW())) {
                    this.currentDirection = Direction.SouthEast;
                    coreMoveHandler(this.currentCell.getSE());
                } else {
                    coreMoveHandler(this.currentCell.getNW());
                }
                break;
        }
    }

    private void coreMoveHandler(Cell nextCell) {
        nextCell.setCurrentAgent(this);
        this.currentCell.removeCurrentAgent();
        this.setCurrentCell(nextCell);

    }

    private boolean isIn(int[] cellIDList, Cell cell) {
        for (int ID : cellIDList) {
            if (cell.getCellID() == ID) {
                return true;
            }
        }
        return false;
    }

    public Cell getCurrentCell() {return this.currentCell;}
    public int getAgentID() {return this.agentID;}
    public char getDisplayChar() {return this.displayChar;}

    public void setDisplayChar(char display) {this.displayChar = display;}
    public void setCurrentCell(Cell cell) {this.currentCell = cell;}
    //public void setNW(int cellID) {this.NW = cellID;}
}
