package Code;

//����R�򵥴ʲ������ķ��ű�
public class TrieST<Value> {
	private static int R = 256; //����
	private Node root;
	private static class Node
	{
		private Object val;
		private Node[] next = new Node[R];
	}
	 
	@SuppressWarnings("unchecked")
	public Value get(String key)
	{
		Node x = get(root, key, 0);
		if(x == null)
		{
			return null;
		}
		return (Value)x.val;
	}
	
	private Node get(Node x, String key, int d)
	{
		//������x��Ϊ�������ֵ��ʲ���������key�������ֵ
		if(x == null)
		{
			return null;
		}
		if(d == key.length())
		{
			return x;
		}
		char c = key.charAt(d);//�ҵ���d���ַ�����Ӧ���ֵ��ʲ�����
		return get(x.next[c], key, d + 1);
	}
	
	public void put(String key, Value val)
	{
		root = put(root, key, val, 0);			
	}
	
	private Node put(Node x, String key, Value val, int d)
	{
		//���key��������xΪ�������ӵ��ʲ�����������������������ֵ
		if(x == null)
		{
			x = new Node();			
		}
		if(d == key.length())
		{
			x.val = val;
			return x;
		}
		char c = key.charAt(d);//�ҵ���d���ַ�����Ӧ���ֵ��ʲ�����
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
	
	public void delete(String key)
	{  
	    	root = delete(root, key, 0); 
	}  
	  
	private Node delete(Node x, String key, int d)
	{  
	    	if(x == null) 
	    	{
	    		return null;  
	    	}
	    	if(d == key.length())
	    	{
	        		x.val = null;  
	   	 }
	    	else
	    	{  
	       	 	char c= key.charAt(d);  
	       	 	x.next[c] = delete(x.next[c], key, d+1);  
	    	}  
	   	 	if(x.val != null) 
	   	 {
	    		return x;  
	    	}
	      
	    	for(char c = 0; c < R; c++) 
	    	{
	        	if(x.next[c] != null) 
	        	{
	            		return x; 
	        	}
	    	}
	    	return null;  
	}  
	
	public static void main(String[] args) 
	 {
		TrieST<Integer> newST = new TrieST<Integer>();
    		String[] keys= {"Nicholas", "Nate", "Jenny", "Penny", "Cynthina", "Michael"};
    		for(int i = 0; i < keys.length; i++)
    		{
    			newST.put(keys[i], i);
    		}	    	
    			newST.delete("Penny");
    		for(int i = 0; i < keys.length; i++)
    		{
    			Object val = newST.get(keys[i]);
    			System.out.println(keys[i] + " " + val);
    		} 
	 }

}
