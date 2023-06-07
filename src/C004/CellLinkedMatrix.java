package C004;

import java.util.ArrayList;

public class CellLinkedMatrix {

    private int colSize, rowSize, cellAmount;
    private Cell[] cellList;
    private ArrayList<Agent> agentList;
    private final Cell origin;
    private static int nextAssignableID = 1;
    int NW, NE, SE, SW;
    int[] N, E, S ,W;
    private boolean activated;

    public CellLinkedMatrix(int col, int row) {
        this.activated = false;

        // set agentList to null
        this.agentList = new ArrayList<Agent>();

        // defines size of matrix
        this.colSize = col;
        this.rowSize = row;

        // calculate number of cells
        this.cellAmount = colSize * rowSize;

        // create cells and add to an array
        cellList = new Cell[cellAmount+1];
        for (int i = 1; i <= cellAmount; i++) {
            cellList[i] = new Cell(i);
        }

        // identify the corners
        NW = 1;
        NE = col;
        SE = col * row;
        SW = (col * row) - col + 1;

        // identify the north border
        N = new int[col];
        for (int i = 1; i <= col; i++) {
            N[i-1] = i;
        }
        // remove the corners
        N[0] = -1;
        N[col-1] = -1;

        // identify the east border
        E = new int[row];
        E[0] = col;
        for (int i = 1; i < row; i++) {
            E[i] = E[i-1] + col;
        }
        // remove the corners
        E[0] = -1;
        E[row-1] = -1;

        // identify the south border
        S = new int[col];
        S[0] = ((col*row)-col+1);
        for (int i = 1; i < col; i++) {
            S[i] = S[i-1] + 1;
        }
        // remove corners
        S[0] = -1;
        S[col-1] = -1;

        // identify the west border
        W = new int[row];
        W[0] = 1;
        for (int i = 1; i < row; i++) {
            W[i] = W[i-1] + col;
        }
        // remove the corners
        W[0] = -1;
        W[row-1] = -1;

        // link core cells
        for (int i = 1; i < cellAmount; i++) {
            Cell cell = cellList[i];
            if (cell.equals(null)) {continue;}
            if (cell.getCellID() == NW || cell.getCellID() == NE ||
            cell.getCellID() == SE || cell.getCellID() == SW) {
                continue;
            }
            if (isIn(N, cell) || isIn(E, cell) || isIn(S, cell)
                    || isIn(W, cell)) {
                continue;
            } else {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc SE direction
                cell.setSE(cellList[cell.getCellID() + row + 1]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }

        }

        // link border cells
        for (int i = 1; i <= cellAmount; i++) {
            Cell cell = cellList[i];
            if (isIn(N, cell)) {
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc SE direction
                cell.setSE(cellList[cell.getCellID() + row + 1]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
            }
            if (isIn(E, cell)) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }
            if (isIn(S, cell)) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }
            if (isIn(W, cell)) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc SE direction
                cell.setSE(cellList[cell.getCellID() + row + 1]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
            }
            if (cell.getCellID() == NW) {
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
                // calc SE direction
                cell.setSE(cellList[cell.getCellID() + row + 1]);
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
            }
            if (cell.getCellID() == NE) {
                // calc S direction
                cell.setS(cellList[cell.getCellID() + row]);
                // calc SW direction
                cell.setSW(cellList[cell.getCellID() + row - 1]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
            }
            if (cell.getCellID() == SE) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc W direction
                cell.setW(cellList[cell.getCellID() - 1]);
                // calc NW direction
                cell.setNW(cellList[cell.getCellID() - row - 1]);
            }
            if (cell.getCellID() == SW) {
                // calc N direction
                cell.setN(cellList[cell.getCellID() - row]);
                // calc NE direction
                cell.setNE(cellList[cell.getCellID() - row + 1]);
                // calc E direction
                cell.setE(cellList[cell.getCellID() + 1]);
            }
        }

        // fill in the direction arrays of each cell
        for (int i = 1; i < cellList.length; i++) {
            cellList[i].fillDirectionList();
        }

        // set cell origin to first cell
        this.origin = cellList[NW];

    }

    public void cycleAgents() {
        while (activated) {
            for (Agent agent : agentList) {
                agent.agentAction();
                this.printMatrix();
                wait(1000);

            }
        }
    }

    public void switchActivation() {
        if (this.activated == false)
            this.activated = true;
        else
            this.activated = false;
    }

    public Cell getOrigin() {return this.origin;}

    public Agent getAgent(int id) {
        for (Agent agent : agentList) {
            if (agent.getAgentID() == id) {
                return agent;
            }
        }
        return null;
    }

    // generates a new Agent with a unique ID and adds it to list
    public void generateAgent() {
        Agent newAgent = new Agent(nextAssignableID);
        newAgent.setCurrentCell(origin);
        agentList.add(newAgent);
        nextAssignableID++;
    }

    // assumes there can only be one agent
    public void spawnAgent(int id) {
        origin.setCurrentAgent(getAgent(id));
    }

    // removes agents from list using specified id
    // TODO remove agent from matrix as well as list
    public void removeAgent(int id) {
        for (Agent agent : agentList) {
            if (agent.getAgentID() == id) {
                agentList.remove(agent);
            }
        }
    }


    // ### tools ############################################################################################


    public void printMatrix() {
        int count = 0;
        for (int i = 1; i < cellList.length; i++) {
            if (count == colSize){
                System.out.println();
                count = 0;
            }
            cellList[i].printCurrentAgent();
            count++;
        }

        System.out.println();
        System.out.println();
    }

    public void printAllNeighbours() {
        for (int i = 1; i < cellList.length; i++) {
            cellList[i].printNeighbours();
        }
    }

    public void printAgentList() {
        for (Agent agent : agentList) {
            System.out.println(agent.getAgentID());
        }
        System.out.println();
        System.out.println();
    }

    private boolean isIn(int[] cellIDList, Cell cell) {
        for (int ID : cellIDList) {
            if (cell.getCellID() == ID) {
                return true;
            }
        }
        return false;
    }

    private void wait(int milli) {
        try {
            Thread.sleep(milli);
        } catch (Exception e) {

        }
    }

}
