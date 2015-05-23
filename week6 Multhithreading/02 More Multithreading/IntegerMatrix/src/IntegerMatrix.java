import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IntegerMatrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public IntegerMatrix(int[][] values) {
        rows = values.length;
        cols = values[0].length;
        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = values[i][j];
            }
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < rows; i++) {
            output += "| ";
            for (int j = 0; j < cols; j++) {
                output += matrix[i][j] + " ";
            }
            output += "|\n";
        }
        return output;
    }

    public IntegerMatrix multiplyRightBy(IntegerMatrix other) throws InterruptedException {
        assert this.cols == other.rows;
        Collection<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tasks.add(new Task(matrix[i], other.getColumn(j)));
            }
        }
        int numThreads = tasks.size() > 4 ? 4 : tasks.size(); // max 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> results = executor.invokeAll(tasks);
        //for (Future<Integer> result : results) {
        //    PingResult pingResult = result.get();
        //    log(pingResult);
        //}
        executor.shutdown(); // always reclaim resources
    }

    private final class Task implements Callable<Integer> {
        Task(int[] row, int[] col) {
            rowL = new int[row.length];
            colL = new int[col.length];
            for (int i = 0; i < row.length; i++) {
                rowL[i] = row[i];
            }
            for (int j = 0; j < col.length; j++) {
                colL[j] = col[j];
            }
        }

        @Override
        public Integer call() throws Exception {
            return scalarProduct(rowL, colL);
        }

        private final int[] rowL;
        private final int[] colL;
    }

    // // not exactly...
    // public IntegerMatrix multiplyRightBy(IntegerMatrix other) throws
    // InterruptedException {
    // assert this.cols == other.rows;
    // int[][] result = new int[this.rows][other.cols];
    // for (int i = 0; i < this.rows; i++) {
    // final int localCopyI = i;
    // for (int j = 0; j < other.cols; j++) {
    // final int localCopyJ = j;
    //
    // Thread setElement = new Thread(new Runnable() {
    // public void run() {
    // result[localCopyI][localCopyJ] = scalarProduct(matrix[localCopyI],
    // other.getColumn(localCopyJ));
    // }
    // });
    // setElement.start();
    // setElement.join();
    // }
    // }
    // return new IntegerMatrix(result);
    // }

    // // not parallel solution; 1 milisecond...
    // public IntegerMatrix multiplyRightBy(IntegerMatrix other) {
    // assert this.cols == other.rows;
    // int[][] result = new int[this.rows][other.cols];
    // for (int i = 0; i < this.rows; i++) {
    // for (int j = 0; j < other.cols; j++) {
    // result[i][j] = scalarProduct(this.matrix[i], other.getColumn(j));
    // }
    // }
    // return new IntegerMatrix(result);
    // }

    private int scalarProduct(int[] row, int[] col) {
        int scalarProduct = 0;
        for (int i = 0; i < row.length; i++) {
            scalarProduct += row[i] * col[i];
        }
        return scalarProduct;
    }

    private int[] getColumn(int index) {
        int[] column = new int[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }
}
