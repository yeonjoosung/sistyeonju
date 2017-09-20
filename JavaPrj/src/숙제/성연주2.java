package 熨薯;

public class 撩翱輿2 {
	public static void main(String[] args) {
		int a = 0;
		for (int i = 0; i < 50; i++) {
			if (i > 25)
				a = i % 26;
			else
				a = i;
			System.out.print((char) (65 + a) + " ");
		}
		
		System.out.println("\n式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		
		
		for (int i = 0; i < 50; i++) {
			System.out.print((char)(65+(i%26))+" ");
		}

		System.out.println("\n式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		for (int i = 0; i < 50; i++) {
			System.out.printf("%c ", 'A' + i % 26);
		}

	}
}
