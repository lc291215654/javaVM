package Code;

public class MatrixMath {
	
    /**
     * ����������㣺�ӡ������ˡ�ת��
     */
	    public final static int OPERATION_ADD = 1;  
	    public final static int OPERATION_SUB = 2;  
	    public final static int OPERATION_MUL = 4;		  
	    
	    /**
	     * ����ӷ�
	     * @param a ����
	     * @param b ������
	     * @return ��
	     */
		public static double[][] plus(double[][] a, double[][] b){
			if(legalOperation(a, b, OPERATION_ADD)) { 
				for(int i=0; i<a.length; i++) {  		
		            for(int j=0; j<a[0].length; j++) {  
		            	a[i][j] = a[i][j] + b[i][j];  
		            }
				}	
			}
			return a;
		}
		
		/**
		 * �������
		 * @param a ����
		 * @param b ������
		 * @return ��
		 */
		public static double[][] substract(double[][] a, double[][] b){
			if(legalOperation(a, b, OPERATION_SUB)) { 
				for(int i=0; i<a.length; i++) {  
		            for(int j=0; j<a[0].length; j++) {  
		            	a[i][j] = a[i][j] - b[i][j];  
		            }
				}		
			}
			return a;
		}		

		/**
		 * �жϾ��������Ƿ��������
		 * @param a ��������ľ���
		 * @param b ��������ľ���
		 * @param type ��������
		 * @return ����/����������
		 */
		private static boolean legalOperation(double[][] a, double[][] b, int type) {  
	        boolean legal = true;  
	        if(type == OPERATION_ADD || type == OPERATION_SUB)  
	        {  
	            if(a.length != b.length || a[0].length != b[0].length) {  
	                legal = false;  
	            }  
	        }   
	        else if(type == OPERATION_MUL)  
	        {  
	            if(a[0].length != b.length) {  
	                legal = false;  
	            }  
	        }  
	        return legal;  
	    } 
		
		/**
		 * ����˷�
		 * @param a ����
		 * @param b ������
		 * @return ��
		 */
		public static double[][] mult(double[][] a, double[][] b){
			if(legalOperation(a, b, OPERATION_MUL)) {
				double[][] result = new double[a.length][b[0].length];
				for(int i=0; i< a.length; i++) {  
		            for(int j=0; j< b[0].length; j++) {  
		            	result[i][j] = calculateSingleResult(a, b, i, j);  
		            }
				}
				return result;
			}
			else
			{
				return null;
			}		
		}
		
		/**
		 * ����˷�
		 * @param a ����
		 * @param b ������
		 * @return ��
		 */
		public static double[][] mult(double[][] a, int b) {  
	        for(int i=0; i<a.length; i++) {  
	            for(int j=0; j<a[0].length; j++) {  
	                a[i][j] = a[i][j] * b;  
	            }  
	        }  
	        return a;  
	    }
		
		/**
		 * �����������Ԫ���뱻����������Ԫ�ػ��ĺ�
		 * @param a ��������
		 * @param b ����������
		 * @param row ��
		 * @param column ��
		 * @return ֵ
		 */
		private static double calculateSingleResult(double[][] a, double[][] b, int row, int column) {  
			double result = 0.0;  
	        for(int k = 0; k< a[0].length; k++) {  
	            result += a[row][k] * b[k][column];  
	        }  
	        return result;  
	    }  
		
		/**
		 * �����ת��
		 * @param a Ҫת�õľ���
		 * @return ת�ú�ľ���
		 */
		public static double[][] invert(double[][] a){
			double[][] result = new double[a[0].length][a.length];
			for(int i=0;i<a.length;i++){
				for(int j=0;j<a[0].length;j++){  
			    	  result[j][i]=a[i][j];  
			      }  
			  }  
			return result;
		}	
		
		
		/**
		 * �������
		 * @param a ����������
		 * @param b ��������
		 * @return �˻�
		 */
	    public static double dot(double[] a, double[] b) {
	        double ret = 0;
	        
	        if(a.length != b.length) {
	            return Double.NaN;
	        }
	        
	        for(int i = 0; i < a.length; i++) {
	            ret += a[i] * b[i];
	        }
	        return ret;
	    }
	    
	    /**
	     * ���������֮��
	     * @param a ����
	     * @param b ����
	     * @return �˻�
	     */
	    public static double[] mult(double[][] a,double[] b) {
	        int la = a.length;
	        int ra = 0;
	        
	        if(la != 0) {
	            ra= a[0].length;
	        }
	        
	        double[] ret = new double[la];
	        
	        for(int i = 0; i < la; i++) {
	            for(int j = 0;j < ra; j++) {
	                ret[i] += a[i][j] * b[j];
	            }
	        }
	        return ret;
	    }
	    
	    /**
	     * �����;���֮��
	     * @param a ����
	     * @param b ����
	     * @return �˻�
	     */
	    public static double[] mult(double[] a,double[][] b) {
	        int la = b.length;
	        int ra = 0;
	        
	        if(la != 0) {
	            ra = b[0].length;
	        }
	        double[] ret = new double[ra];
	        
	        for(int i = 0; i < ra; i++) {
	            for(int j = 0;j < la; j++) {
	                ret[i] += a[j] * b[j][i];
	            }
	        }
	        return ret;
	    }

	/** 
	 *  �������󣺰�������������ʽֵ����������ִ�������ʽ��á� 
	 */   
	    /** 
	     * ����ľ��������� 
	     * @param value ��Ҫת���ľ��� 
	     * @return ����� 
	     */  
	    public static double[][] getInverseMatrix(double[][] value,double result){  
	        double[][] transferMatrix = new double[value.length][value[0].length];  

	        for (int i = 0; i < value.length; i++) {  
	            for (int j = 0; j < value[i].length; j++) {  
	                transferMatrix[j][i] =  mathDeterminantCalculation(getNewMatrix(i, j, value));  
	                if ((i+j)%2!=0) {  
	                    transferMatrix[j][i] = -transferMatrix[j][i];  
	                }  
	                transferMatrix[j][i] /= result;   
	            }  
	        }  
	        return transferMatrix;  
	    }  
	    
	    /*** 
	     * ת��Ϊ�����Ǿ���������ʽ��ֵ
	     * @param value ��Ҫ�������ʽ 
	     * @return ����Ľ�� 
	     */  
	    public static double mathDeterminantCalculation(double[][] value){  
	        if (value.length == 1) {  
	            //������ʽΪ1�׵�ʱ���ֱ�ӷ��ر���  
	            return value[0][0];  
	        }
	        
	        if (value.length == 2) {  
	            //�������ʽΪ���׵�ʱ��ֱ�ӽ��м���  
	            return value[0][0]*value[1][1]-value[0][1]*value[1][0];  
	        }  
	        
	        //������ʽ�Ľ�������2ʱ  
	        double result = 1;  
	        for (int i = 0; i < value.length; i++) {         
	            //�������Խ���λ�õ���ֵ�Ƿ���0�����������Ը�������е��������ҵ�һ�в�Ϊ0�Ľ��е���  
	            if (value[i][i] == 0) {  
	                value = changeDeterminantNoZero(value,i,i);  
	                result*=-1;  
	            }  
	            
	            for (int j = 0; j <i; j++) {  
	                //�ÿ�ʼ������е���λΪ0����Ϊ������ʽ  
	                //���Ҫ�������Ϊ0����Լ�����һ��λ�ã�������ʡȥ�˼���  
	                if (value[i][j] == 0) {  
	                    continue;  
	                }  
	                //���Ҫ��Ҫ���������0��������һ�н��е���  
	                if (value[j][j]==0) {  
	                    double[] temp = value[i];  
	                    value[i] = value[i-1];  
	                    value[i-1] = temp;  
	                    result*=-1;  
	                    continue;  
	                }  
	                //������ת��Ϊ�����Ǿ���
	                double  ratio = -(value[i][j]/value[j][j]);  
	                value[i] = addValue(value[i],value[j],ratio);  
	            }  
	        }  	        
	        return mathValue(value,result);
	    }  
	      
	    /** 
	     * ���������Ǿ�������ʽ�Ľ�� 
	     * @param value 
	     * @return 
	     */  
	    private static double mathValue(double[][] value,double result){  
	        for (int i = 0; i < value.length; i++) {  
	            //����Խ�������һ��ֵΪ0��ȫ��Ϊ0��ֱ�ӷ��ؽ��  
	            if (value[i][i]==0) {  
	                return 0;  
	            }  
	            result *= value[i][i];  
	        }  
	        return result;  
	    }  
	      
	    /*** 
	     * ��i��֮ǰ��ÿһ�г���һ��ϵ����ʹ�ô�i�еĵ�i��֮ǰ�������û�Ϊ0 
	     * @param currentRow ��ǰҪ������� 
	     * @param frontRow i��֮ǰ�ı������� 
	     * @param ratio Ҫ���Ե�ϵ�� 
	     * @return ��i��i��֮ǰ�����û�Ϊ0����µ��� 
	     */  
	    private static double[] addValue(double[] currentRow,double[] frontRow, double ratio){  
	        for (int i = 0; i < currentRow.length; i++) {  
	            currentRow[i] += frontRow[i]*ratio;  
	        }  
	        return currentRow;  
	    }  
	      
	    /** 
	     * ָ���е�λ���Ƿ�Ϊ0�����ҵ�һ����Ϊ0��λ�õ��н���λ�õ��������û���򷵻�ԭ����ֵ 
	     * @param determinant ��Ҫ���������ʽ 
	     * @param line Ҫ�������� 
	     * @param row Ҫ�жϵ��� 
	     */  
	    private static double[][] changeDeterminantNoZero(double[][] determinant,int line,int column){  
	        for (int i = line; i < determinant.length; i++) {  
	            //�����е���  
	            if (determinant[i][column] != 0) {  
	                double[] temp = determinant[line];  
	                determinant[line] = determinant[i];  
	                determinant[i] = temp;  
	                return determinant;  
	            }  
	        }  
	        return determinant;  
	    }  	      

	    /** 
	     * ת��Ϊ��������ʽ 
	     * @param row �� 
	     * @param line �� 
	     * @param matrix Ҫת���ľ��� 
	     * @return ת���Ĵ�������ʽ 
	     */  
	    private static double[][] getNewMatrix(int row,int line,double[][] matrix){  
	        double[][] newMatrix = new double[matrix.length-1][matrix[0].length-1];  
	        int rowNum = 0,lineNum = 0;  
	        for (int i = 0; i < matrix.length; i++) {  
	            if (i == row){  
	                continue;  
	            }  
	            for (int j = 0; j < matrix[i].length; j++) {  
	                if (j == line) {  
	                    continue;  
	                }  
	                newMatrix[rowNum][lineNum++%(matrix[0].length-1)] = matrix[i][j];  
	            }  
	            rowNum++;  
	        }  
	        return newMatrix;  
	    }  
	      
	    public static void main(String[] args) {  
//	        double[][] test = {{0,0,0,1,2},{0,0,0,2,3},{1,1,0,0,0},{0,1,1,0,0},{0,0,1,0,0}};  
//	        double[][] test2 = 
//	                { 
//	                    { 0, 0, 0, 1, 2 }, 
//	                    { 0, 0, 0, 4, 3 }, 
//	                    { 1, 1, 0, 0, 0 }, 
//	                    { 0, 1, 1, 0, 0 }, 
//	                    { 0, 0, 1, 0, 0 } 
//	                };
	        double[][] test = {
		            {3.8067488033632655, -2.894113667134647},  
		            {-2.894113667134647, 3.6978894069779504}
		        };
	        double result;  
	        try {  
	            double[][] temp = new double[test.length][test[0].length];  
	            for (int i = 0; i < test.length; i++) {  
	                for (int j = 0; j < test[i].length; j++) {  
	                    temp[i][j] = test[i][j];  
	                }  
	            }  
	            //�ȼ�����������ʽ��ֵ�Ƿ����0�����������0��þ����ǿ����  
	            result = mathDeterminantCalculation(temp);  
	            if (result == 0) {  
	                System.out.println("���󲻿���");  
	            }else {  
	                System.out.println("�������");  
	                //��������  
	                double[][] result11 = getInverseMatrix(test,result);  
	                //��ӡ�����  
	                for (int i = 0; i < result11.length; i++) {  
	                    for (int j = 0; j < result11[i].length; j++) {  
	                        System.out.print(result11[i][j]+"   ");                       
	                    }  
	                    System.out.println();  
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            System.out.println("������ȷ������ʽ����");  
	        }  
	    }  	
}
