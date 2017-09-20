package reuse;

import java.util.Scanner;

public class Instance_Omok {
	private int x;
	private int y;

	public Instance_Omok() {
		this(1, 1);
	}

	public Instance_Omok(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void input() {
		Scanner scan = new Scanner(System.in);

		System.out.print("x space y : ");

		x = scan.nextInt();
		y = scan.nextInt();
	}

	public void printBoard() {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("¦«");

			System.out.println();
		}
	}

	public void checkBoard() {

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (x == this.x && y == this.y)
					System.out.print("¡Û");
				else
					System.out.print("¦«");

			System.out.println();
		}

	}

}
