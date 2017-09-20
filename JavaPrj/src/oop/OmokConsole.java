package oop;

import java.util.Scanner;

public class OmokConsole {

	private Omok omok= new Omok();

	public void input() {
		int x;
		int y;
		Scanner scan = new Scanner(System.in);

		System.out.print("x space y : ");

		x = scan.nextInt();
		y = scan.nextInt();

		omok.setX(x);
		omok.setY(y);

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
				if (x == (omok.getX() ) && y == (omok.getY() ))
					System.out.print("¡Û");
				else
					System.out.print("¦«");

			System.out.println();
		}

	}

}
