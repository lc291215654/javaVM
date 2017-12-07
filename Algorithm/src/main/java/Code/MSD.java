package Code;

//��λ���ȵ��ַ�������
public class MSD {
	private static int R = 256;		//����
	private static final int M = 3;//С������л���ֵ
	private static String[] aux;	//���ݷ���ĸ�������
	
	private static int charAt(String s, int d)
	{
		if(d < s.length())
		{
			return s.charAt(d);
		}
		else
		{
			return -1;
		}
	}
	
	public static void sort(String[] a)
	{
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d)
	{//�Ե�d���ַ�Ϊ����a[lo]��a[hi]����
		if(hi <= lo + M)
		{//��������
			InsertionSort(a, lo, hi, d);
			return;
		}
		
		int[] count = new int[R+2]; //����Ƶ��
		for(int i = lo; i <= hi; i++)
		{
			count[charAt(a[i], d) + 2]++;
		}
		
		for(int r = 0; r < R+1; r++) //��Ƶ��ת��Ϊ����
		{
			count[r+1] +=count[r];
		}
		
		for(int i = lo; i <= hi; i++) //���ݷ���
		{
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		
		for(int i = lo; i <= hi; i++) //��д
		{
			a[i] = aux[i-lo];
		}
		
		//�ݹ����ÿ���ַ�Ϊ����������
		for(int r = 0; r < R; r++)
		{
			sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
		}
	}
	
	//��������
	private static void InsertionSort(String[] a, int lo, int hi, int d) 
	{   
	    for( int i = lo; i < hi; i++) 
	    { 
	        for( int j=i+1; j>lo; j--) 
	        {	        	
	            if( a[j-1].compareTo(a[j]) <= 0)
	            {
	                break;
	            }
	            String temp = a[j];
	            a[j] = a[j-1];
	            a[j-1] = temp;	        	
	        }
	    }  
	}
	
	public static void main(String[] args) 
	 {
		String[] a= {"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she",
   			"sells", "are", "surely", "seashells"};
   	
		MSD.sort(a);
	   	for(int i = 0; i < a.length; i++)
	   	{
	   		System.out.println(a[i]);
	   	} 
	 }

}
