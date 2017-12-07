package Code;

//��λ���ȵ��ַ�������
public class LSD 
{
	public static void sort(String[] a, int W)
	{//ͨ��ǰW���ַ���a[]����
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = W - 1; d >= 0; d--)
		{//���ݵ�d���ַ��ü��������㷨����
			int[] count = new int[R+1];	//������ֵ�Ƶ��
			for(int i = 0; i < N; i++)
			{
				count[a[i].charAt(d) + 1]++;
			}
			
			for(int r = 0; r < R; r++)	//��Ƶ��ת��Ϊ����
			{
				count[r + 1] += count[r];
			}
			
			for(int i = 0; i < N; i++)	//��Ԫ�ط���
			{
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			
			for(int i = 0; i < N; i++)	//��д
			{
				a[i] = aux[i];
			}
		}
	}
	
	public static void main(String[] args) 
	 {
		String[] a= {"4PGC938", "2IYE230", "3CI0720", "1ICK750", "1OHV845", "4JZY524", "1ICK750",
    			"3CI0720", "1OHV845", "1OHV845", "2RLA629", "2RLA629", "3ATW723"};
    	
    		LSD.sort(a, 7);
    		for(int i = 0; i < a.length; i++)
    		{
    		    System.out.println(a[i]);
    		} 
	 }
}
