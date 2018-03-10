package b3.basic_class_07;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 */

public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}

	public static void printAllSubsquence2(String str) {
		char[] chs = str.toCharArray();
		process2(chs, 0,"");
	}

	public static void process2(char[] chs, int index,String pre) {
		if(index == chs.length){
			if(!pre.equals("")){
				System.out.println(pre);
			}
			return;
		}
		process2(chs,index+1,pre+String.valueOf(chs[index]));
		process2(chs,index+1,pre);

	}

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
		char[] tcch = new char[5];
		tcch[0]='a';
		tcch[1]=0;
		tcch[2]='b';
		tcch[3]=0;
		tcch[4]=0;

		System.out.println(String.valueOf(tcch));
	}

}
