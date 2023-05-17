package C003;

public class SquareLinkedList {
    private final Square head;
    public SquareLinkedList() {
        Square s1 = new Square(1);
        Square s2 = new Square(2);
        Square s3 = new Square(3);
        Square s4 = new Square(4);

        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);
        s4.setNext(s1);

        this.head = s1;
    }

    private Square getHead() {
        return head;
    }

    public Square getSquare(int id) {
        Square temp;
        temp = head;
        while(true) {
            if (temp.getSquareID() == id) {return temp;}
            else {temp = temp.getNext();}
        }
    }

}
