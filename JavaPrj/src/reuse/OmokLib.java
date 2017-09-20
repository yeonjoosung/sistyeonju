package reuse;

import java.util.Scanner;

public class OmokLib {

	public static void printBoard(Omok omok) {

		int ox = omok.x;
		int oy = omok.y;

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (x == ox && y == oy)
					System.out.print("¡Û");
				else
					System.out.print("¦«");

			System.out.println();
		}
	}

	public static void input(Omok omok) {
		Scanner scan = new Scanner(System.in);

		System.out.print("x space y : ");

		omok.x = scan.nextInt();
		omok.y = scan.nextInt();
	}

	public static void printBoard() {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("¦«");

			System.out.println();
		}
	}
}
