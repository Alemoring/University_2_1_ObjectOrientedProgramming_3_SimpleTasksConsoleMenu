public class Matrix {
    private int[][] matrix;
    private int len;
    private int rank = 0;

    public Matrix() {
        matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (int) (((Math.random() * 100) % 10) + 1);
            }
        }
        len = 16;
        rank = 4;
    }

    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
        len = rows * columns;
        rank = rows;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (((Math.random() * 100) % 10) + 1);
            }
        }
    }
 
    public Matrix(int[][] m) {
        matrix = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            len += m[i].length;
            rank += 1;
            for (int j = 0; j < m[i].length; j++) {
                matrix[i][j] = m[i][j];
            }
        }
    }
    public Matrix(Matrix m) {
        len = m.len;
        rank = m.rank;
        matrix = new int[m.matrix.length][m.matrix[0].length];
        for (int i = 0; i < m.matrix.length; i++) {
            for (int j = 0; j < m.matrix[i].length; j++) {
                matrix[i][j] = m.matrix[i][j];
            }
        }
    }

    public float findFrequency() {
        return findFrequency(5);
    }

    public float findFrequency(int x) {
        int kol = 0; // Количество заданного числа в массиве
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == x)
                    kol += 1;
            }
        }
        return ((float) kol / len) * 100;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] getMatrix(){
        return matrix;
    }
    public int getNumberMatrix(int i, int j){
        return matrix[i][j];
    }
    public int getLen(){
        return len;
    }
    public int getRank(){
        return rank;
    }
}
