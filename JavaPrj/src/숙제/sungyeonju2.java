package ¼÷Á¦;

public class sungyeonju2 {
	public static void main(String[] args) {
		int a = 0;
		for (int i = 0; i < 50; i++) {
			if (i > 25)
				a = i % 26;
			else
				a = i;
			System.out.print((char) (65 + a) + " ");
		}

	}
}
