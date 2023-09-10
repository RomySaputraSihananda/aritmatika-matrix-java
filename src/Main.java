public class Main {
    public static void main(String[] args) {
        int[][] data1 = {
                { 10, 192 },
                { 32, 344 },
        };

        int[][] data2 = {
                { 7, 6 },
                { 7, 8 },
        };

        print(data1);
        print(data2);

        int[][][] hasil = {
                tambahKurang(data1, data2, '+'),
                tambahKurang(data1, data2, '-'),
                kali(data1, data2)
        };

        print(hasil[0]);
        print(hasil[1]);
        print(hasil[2]);
    }

    private static int[][] tambahKurang(int[][] array1, int[][] array2, char operation) {
        boolean valid = validRomCol(array1, array2, '+');
        int[][] hasil = new int[array1.length][array1[0].length];

        if (!valid)
            return hasil;

        switch (operation) {
            case '+':
                for (int i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array1[0].length; j++) {
                        hasil[i][j] = array1[i][j] + array2[i][j];
                    }
                }
                break;
            case '-':
                for (int i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array1[0].length; j++) {
                        hasil[i][j] = array1[i][j] - array2[i][j];
                    }
                }
                break;
            default:
                break;
        }

        return hasil;
    }

    private static int[][] kali(int[][] array1, int[][] array2) {
        int[][] hasil = new int[array1.length][array2[0].length];
        boolean valid = validRomCol(array1, array2, '*');
        int buffer;

        if (!valid)
            return hasil;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                buffer = 0;
                for (int k = 0; k < array1[0].length; k++) {
                    buffer += (array1[i][k] * array2[k][j]);
                }
                hasil[i][j] = buffer;
            }
        }
        return hasil;
    }

    private static boolean validRomCol(int[][] array1, int[][] array2, char operation) {
        int[] row = { array1.length, array2.length };
        int[] col = { array1[0].length, array2[0].length };
        switch (operation) {
            case '+':
                if (!(row[0] == row[1] && col[0] == col[1])) {
                    return false;
                }
                break;
            case '*':
                if (!(row[0] == col[1])) {
                    return false;
                }
                break;
        }

        return true;
    }

    private static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
}