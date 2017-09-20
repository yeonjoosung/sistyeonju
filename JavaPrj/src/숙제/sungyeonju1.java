package 熨薯;

public class sungyeonju1 {
	public static void main(String[] args) {

		for (int i = 25; i >= 0; i--) // 65-90
			System.out.print((char) (65 + i) + " ");
		
		System.out.println();
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		int size = 'Z' - 'A' + 1;
		for (int i = 0; i < size; i++)
			System.out.printf("%c ", 'Z' - i);

	}
}
