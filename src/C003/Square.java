package C003;

public class Square {
    private final int squareID;
    private Square next;

    public Square(int id) {
        this.squareID = id;
    }

    public int getSquareID() {return squareID;}
    public Square getNext() {return next;}
    public void setNext(Square square) {next = square;}

}
