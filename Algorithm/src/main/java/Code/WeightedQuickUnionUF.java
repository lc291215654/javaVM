package Code;

import java.util.Scanner;

public class WeightedQuickUnionUF {
    private int[] id; // ����id���Դ�����Ϊ������      
    
    private int[] sz; // ���ɴ��������ģ��������ڵ�����Ӧ�ķ����Ĵ�С
    
    private int count; // ��������  
    
    public WeightedQuickUnionUF(int N)  
    {  
        // ��ʼ������id����.  
        count = N;  
        id = new int[N]; 
        sz = new int[N];
        for (int i = 0; i < N; i++)  {
            id[i] = i;  
            sz[i] = 1;
        }              
    }  
    
    public int count()  { 
    	return count; 
    }  
    public boolean connected(int p, int q)  { 
    	return find(p) == find(q); 
    }  
    
    public int find(int p)   { 
    	// Ѱ��p�ڵ�������ĸ��ڵ㣬���ڵ��������id[root] = root  
        while (p != id[p]) p = id[p];  
        return p; 
    }
    
    public void union(int p, int q)  {   
    	int i = find(p);  
        int j = find(q);  
        if (i == j) return;  
        // ��С����Ϊ����������  
        if (sz[i] < sz[j]) { 
        	id[i] = j; 
        	sz[j] += sz[i]; 
        }  
        else { 
        	id[j] = i; 
        	sz[i] += sz[j]; 
        }  
        count--; 
    }  
    
    public static void main(String[] args) {
    	String data = "4 3 3 8 6 5 9 4 2 1 5 0 7 2 6 1";
	    Scanner sc = new Scanner(data);
	    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
	    while (sc.hasNext()) {
	    	int p = sc.nextInt();
			int q = sc.nextInt();
			if(uf.connected(p, q) ) {
				continue;
			}
			uf.union(p, q);
			System.out.println(p+ " " + q);
	    }
	    sc.close();
		System.out.println(uf.count() + " ����");
    }
}
