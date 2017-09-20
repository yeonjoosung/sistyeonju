package structured.data;

import java.util.Scanner;

public class OmokProgram {

	public static void main(String[] args) {

		// int ox = 0, oy = 0;
		Omok omok = new Omok();// null- 공간이없다고 에러가 남 *

		printBoard();
		input(omok);
		printBoard(omok);

	}

	private static void printBoard(Omok omok) {

		int ox = omok.x;
		int oy = omok.y;

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (x == ox && y == oy)
					System.out.print("○");
				else
					System.out.print("┼");

			System.out.println();
		}
	}

	private static void input(Omok omok) {
		Scanner scan = new Scanner(System.in);

		System.out.print("x space y : ");

		omok.x = scan.nextInt();
		omok.y = scan.nextInt();
	}

	private static void printBoard() {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("┼");

			System.out.println();
		}
	}

}
