package Code;

public class CurveFitting {
    ///<summary>
    ///��С���˷���϶�Ԫ�������
    ///����y=ax+b
    ///����MultiLine������a��b����������
    ///a��ӦMultiLine[1]
    ///b��ӦMultiLine[0]
    ///</summary>
    ///<param name="arrX">��֪���x���꼯��</param>
    ///<param name="arrY">��֪���y���꼯��</param>
    ///<param name="length">��֪��ĸ���</param>
    ///<param name="dimension">���̵���ߴ���</param>
    public static double[] MultiLine(double[] arrX, double[] arrY, int length, int dimension) {
    	int n = dimension + 1;                 //dimension�η�����Ҫ�� dimension+1�� ϵ��    	      
        double[][] Guass = new double[n][n + 1];      
        for (int i = 0; i < n; i++){ //�����ʽ��
        	int j;
            for (j = 0; j < n; j++){
            	Guass[i][j] = SumArr(arrX, j + i, length);//��ʽ�ٵȺ���ߵ�һ�����󣬼�Ax=b�е�A
            }
            Guass[i][j] = SumArr(arrX, i, arrY, 1, length);//��ʽ�ٵȺ��ұߵľ��󣬼�Ax=b�е�b
        }        
        
        return ComputGauss(Guass, n);//��˹��Ԫ��
    }
    
    //�������Ԫ�ص�n�η��ĺͣ�������A�е�Ԫ��
    private static double SumArr(double[] arr, int n, int length) {
    	double s = 0;
        for (int i = 0; i < length; i++){
        	if (arr[i] != 0 || n != 0){
                s = s + Math.pow(arr[i], n);
        	}
            else{
                s = s + 1;
            }
        }
        return s;
    }
    
    //�������Ԫ�ص�n�η��ĺͣ�������b�е�Ԫ��
    private static double SumArr(double[] arr1, int n1, double[] arr2, int n2, int length) {
    	double s = 0;
        for (int i = 0; i < length; i++)
        {
            if ((arr1[i] != 0 || n1 != 0) && (arr2[i] != 0 || n2 != 0))
                s = s + Math.pow(arr1[i], n1) * Math.pow(arr2[i], n2);
            else
                s = s + 1;
        }
        return s;        
    }
    
    //��˹��Ԫ�������Է�����
    private static double[] ComputGauss(double[][] Guass, int n) {
        int i, j;
        int k, m;
        double temp;
        double max;
        double s;
        double[] x = new double[n];

        for (i = 0; i < n; i++) {
        	x[i] = 0.0;//��ʼ��
        }

        for (j = 0; j < n; j++) {
            max = 0;
            k = j;
            
            // �ӵ�i�п�ʼ���ҳ���j���е����ֵ��i��jֵӦ���ֲ��䣩  
            for (i = j; i < n; i++) {
                if (Math.abs(Guass[i][j]) > max){
                    max = Guass[i][j];// ʹ�ý������ҳ����ֵ������ֵ���
                    k = i;
                }
            }

            if (k != j) {
            	//����j�����ҵ������ֵ������������������iֵ���䣨jֵ��¼�˱��β�������ʼ�У�
                for (m = j; m < n + 1; m++) {
                    temp = Guass[j][m];
                    Guass[j][m] = Guass[k][m];
                    Guass[k][m] = temp;
                }
            }

            if (max == 0) {
                // "�����Է���Ϊ�������Է���" 
                return x;
            }

            // ��m���У���(j+1)�����£�������(j+1)�У�����Ԫ�ض���ȥGuass[j][m] * s / (Guass[j][j])
            //ֱ����m�е�i+1������Ԫ�ؾ�Ϊ��
            for (i = j + 1; i < n; i++) {
                s = Guass[i][j];                
                for (m = j; m < n + 1; m++) {
                    Guass[i][m] = Guass[i][m] - Guass[j][m] * s / (Guass[j][j]);                 
                }
            }
        }//����for (j=0;j<n;j++)

        //�ش����̣�����ʽ4.1.5��
        for (i = n - 1; i >= 0; i--) {
            s = 0;
            for (j = i + 1; j < n; j++) {
                s = s + Guass[i][j] * x[j];
            }
            x[i] = (Guass[i][n] - s) / Guass[i][i];
        }

        return x;
    }//����ֵ�Ǻ�����ϵ��
    
    public static void main(String[] args)  {
        double[] x = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] y = {0, 1, 4, 9, 16, 25, 36, 49};
        double[] a = MultiLine(x, y, 8, 2);
		
        for(int i =0; i <a.length;i++){
            System.out.println(a[i]);
            }
    }  
}
