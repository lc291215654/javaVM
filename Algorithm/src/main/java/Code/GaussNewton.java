package Code;

public class GaussNewton {
    double[] xData = new double[]{0.038, 0.194, 0.425, 0.626, 1.253, 2.500, 3.740};
    double[] yData = new double[]{0.050, 0.127, 0.094, 0.2122, 0.2729, 0.2665, 0.3317};

    double[][] bMatrix = new double[2][1];//ϵ���¾���
    int m = xData.length;
    int n = bMatrix.length;
    int iterations = 7;//��������

    //������ʽ��⣬��1�й�ʽ��
    private void magic(){
    	//��1,��2������ֵ
    	bMatrix[0][0] = 0.9;
    	bMatrix[1][0] = 0.2;
    	
    	//��J����
        for(int k = 0; k < iterations; k++) { 
        	double[][] J = new double[m][n];
        	double[][] JT = new double[n][m];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++) {
                    J[i][j] = secondDerivative(xData[i], bMatrix[0][0], bMatrix[1][0], j);
                }
            }

            JT = MatrixMath.invert(J);//��ת�þ���JT
            double[][] invertedPart = MatrixMath.mult(JT, J);//����JT��J���
            
            //����invertedPart����ʽ��ֵ��|JT*J|
            double result = MatrixMath.mathDeterminantCalculation(invertedPart);
            
            //�����invertedPart�������:(JT*J)^-1
            double[][] reversedPart = MatrixMath.getInverseMatrix(invertedPart, result);

            //�󷽲�r(��)����: ri = yi - f(xi, b)
            double[][] residuals = new double[m][1];
            for(int i = 0; i < m; i++) {
                residuals[i][0] = yData[i] - (bMatrix[0][0] * xData[i]) / (bMatrix[1][0] + xData[i]);
            }
            
            //������reversedPart*JT*residuals: (JT*J)^-1*JT*r
            double[][] product = MatrixMath.mult(MatrixMath.mult(reversedPart, JT), residuals);
            
            //������ʽ, ����ʽ��
            double[][] newB = MatrixMath.plus(bMatrix, product);
            bMatrix = newB;        
        }        
        //��ʾϵ��ֵ
        System.out.println("b1: " + bMatrix[0][0] + "\nb2: " + bMatrix[1][0]);        
    }

    //2�й�ʽ��
    private static double secondDerivative(double x, double b1, double b2, int index){
        switch(index) {
            case 0: return x / (b2 + x);//��ϵ��bi��
            case 1: return -1 * (b1 * x) / Math.pow((b2+x), 2);//��ϵ��b2��
        }
        return 0;
    }
    
    public static void main(String[] args) {
        GaussNewton app = new GaussNewton();
        app.magic();        
    }
}
