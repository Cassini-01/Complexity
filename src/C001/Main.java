package C001;

public class Main {

    public static void main(String[] args) {

        Environment envi1 = new Environment(25, 25);

        envi1.createObject1(5,5);

        clock(envi1);
    }

    public static void clock(Environment envi) {
        while (true) {
            for (Cell obs : envi.objects) {
                obs.action();
                envi.print();
                wait(100);
            }
        }
    }

    public static void wait(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}