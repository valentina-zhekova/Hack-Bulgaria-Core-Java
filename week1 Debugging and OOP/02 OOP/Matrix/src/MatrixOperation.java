public interface MatrixOperation {
    default public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        return matrix[x][y];
    }
    
    public Pixel brightness(int offset) {
        this.setR(this.getR() + offset);
        this.setG(this.getG() + offset);
        this.setB(this.getB() + offset);
    }
    
    public Pixel grayscale() {
        int average = (int) (this.getR() + this.getG() + this.getB()) / 3;
        this.setR(average);
        this.setG(average);
        this.setB(average);
    }
}
