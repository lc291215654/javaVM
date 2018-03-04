package MyCode07;

public class C02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	public static void func(int n, String from, String help, String to) {
		if (n == 1) {
			System.out.println("move from " + from + " to " + to);
		} else {
			func(n - 1, from, to, help);
			func(1, from, help, to);
			func(n - 1, help, from, to);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
