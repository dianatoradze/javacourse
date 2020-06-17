public class Main {
    public static void main(String[] args) {
        int n = 7;

        String[][] array = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = " ";
                array[i][n - i-1] = "x";
                if (i == j  ) {
                    array[i][j] = "x";
                    array[i][n - i-1] = "x";
                }
                   System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}

