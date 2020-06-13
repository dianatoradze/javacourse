public class Main {
    public static void main(String[] args) {
        int sizeX = 7;
        int sizeY = 7;
        String[][] array = new String[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                array[i][j] = " ";
                array[i][sizeY - 1-j] = "x";
                if (i == j  ) {
                    array[i][j] = "x";
                    array[i][sizeY - 1-j] = "x";
                }
                 System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}

