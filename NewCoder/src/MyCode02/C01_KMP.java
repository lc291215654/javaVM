package MyCode02;

public class C01_KMP {

	public static int getIndexOf(String s, String m) {
		if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
			return -1;
		}

		char[] ss = s.toCharArray();
		char[] mm = m.toCharArray();
		for(int i=0;i<=ss.length-mm.length;i++){
			for(int j=0;j<mm.length;j++){
				if(ss[i+j] != mm[j]){
					break;
				}
				if(j == mm.length -1){
					return i;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));
	}

}
