package C004;

public class Agent {
    private final int agentID;
    private char displayChar;

    public Agent(int id) {
        this.agentID = id;
        // temp
        this.displayChar = 'x';
    }

    public int getAgentID() {return this.agentID;}
    public char getDisplayChar() {return this.displayChar;}

    public void setDisplayChar(char display) {this.displayChar = display;}
}
