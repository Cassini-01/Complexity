package C000;

public class test {

    public static void main(String[] args) {

        boolean increment = true;
        int rows = 3;
        int columns = 3;

        while (true) {

            // increment
            if (increment) {

                int columnIndex = 0;
                int rowIndex = 0;
                while (true) {

                    if (columnIndex == columns-1 && rowIndex == rows-1) {
                        increment = false;
                        break;
                    }

                    wait(100);
                    int[][] temp = new int[columns][rows];
                    temp[columnIndex][rowIndex] = 1;
                    printPlane(temp, rows, columns);
                    for (int i = 0; i < 3; i++) {
                        System.out.println();
                    }

                    columnIndex = columnIndex + 1;
                    if (columnIndex == columns) {
                        rowIndex++;
                        columnIndex = 0;
                    }


                }
            }
            // decrement
            else {
                int columnIndex = columns - 1;
                int rowIndex = rows - 1;
                while (true) {

                    if (columnIndex == 0 && rowIndex == 0) {
                        increment = true;
                        break;
                    }

                    wait(100);
                    int[][] temp = new int[columns][rows];
                    temp[columnIndex][rowIndex] = 1;
                    printPlane(temp, rows, columns);
                    for (int i = 0; i < 3; i++) {
                        System.out.println();
                    }

                    if (columnIndex == 0) {
                        rowIndex--;
                        columnIndex = columns - 1;
                        continue;
                    }
                    columnIndex = columnIndex - 1;
                }
            }
        }
    }

    public static void main2(String[] args) {

        int rows = 10;
        int columns = 5;

        int columnIndex = 0;
        int rowIndex = 0;

        while (true) {

            wait(500);
            int[][] temp = new int[columns][rows];

            temp[columnIndex][rowIndex] = 1;

            printPlane(temp, rows, columns);

            columnIndex = columnIndex + 1;

            if (columnIndex == columns) {
                rowIndex++;
                columnIndex = 0;
            }

            if (rowIndex == rows) {

            }

            for (int i = 0; i < 3; i++) {
                System.out.println();
            }
        }

    }

    public static void printPlane(int[][] plane, int rows, int columns) {
        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(plane[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main1(String[] args) {

        int arrLength = 50;

        int index = 0;
        int change = 1;
        while (true) {

            wait(100);
            int[] temp = new int[arrLength];

            temp[index] = 1;

            printArr(temp);

            index = index + change;

            if (index == arrLength-1)
                change = -1;
            if (index == 0)
                change = +1;
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void wait(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


