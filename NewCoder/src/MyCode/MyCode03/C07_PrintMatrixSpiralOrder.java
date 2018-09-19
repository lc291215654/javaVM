package MyCode.MyCode03;

public class C07_PrintMatrixSpiralOrder {

    /**
     * 按顺序打印二维数组中所有的边框
     *
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        for (int i = 0, j = 0; i <= row && j <= col; i++, j++, row--, col--) {
            printEdge(matrix, i, j, row, col);
        }
    }

    /**
     * 按顺序打印某两个点组成的边框上的值
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR){
            for (int i = tC; i <= dC; i++) {
                System.out.println(m[tR][i]);
            }
        }else if(tC == dC){
            for (int i = tR; i <= dR; i++) {
                System.out.println(m[i][tC]);
            }
        }else {
            for (int i = tC; i <= dC; i++) {
                System.out.println(m[tR][i]);
            }
            for (int i = tR+1; i <= dR; i++) {
                System.out.println(m[i][dC]);
            }
            for (int i = dC-1; i >= tC; i--) {
                System.out.println(m[dR][i]);
            }
            for (int i = dR-1; i > tR ; i--) {
                System.out.println(m[i][tC]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {{1, 2, 3},
                        {5, 6, 7},
                        {9, 10, 11}};
        spiralOrderPrint(matrix);
    }

}
