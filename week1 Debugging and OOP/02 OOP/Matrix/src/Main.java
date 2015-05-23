
public class Main {
    public static void main(String[] args) {
        Pixel[][] exampleValues = {{new Pixel(1, 1, 1), new Pixel(2, 2, 2)}, 
                                   {new Pixel(3, 3, 3), new Pixel(4, 4, 4)}};
        Matrix exampleMatrix = new Matrix(exampleValues);
        System.out.println(exampleMatrix.toString());
        exampleMatrix.operate(MatrixOperation.brightness(1));
    }
}
