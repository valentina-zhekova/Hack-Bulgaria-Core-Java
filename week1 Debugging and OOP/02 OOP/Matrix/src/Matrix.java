public class Matrix {
    private Pixel[][] matrix;

    public Matrix(Pixel[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.matrix = new Pixel[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public void operate(MatrixOperation op) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                MatrixOperation.withPixel(i, j, matrix).op;
            }
        }
    }

    public String toString() {
        String result = "";
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result += " " + matrix[i][j].toString();
            }
            result += "\n";
        }
        return result;
    }
}
