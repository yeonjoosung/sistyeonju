package functions;

import java.util.Scanner;

public class Omok3 {
	public static void main(String[] args) {

		int xy[][] = new int[20][15];

		printOmok();
		xy = inputOmok(xy);
		ouputOmok(xy);

	}

	private static void ouputOmok(int[][] xy) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (xy[x][y] == 1)
					System.out.print("¡Û");
				else
					System.out.print("¦«");

			System.out.println();
		}
	}

	private static int[][] inputOmok(int[][] xy) {
		System.out.print("x space y : ");
		Scanner scan = new Scanner(System.in);
		int ox, oy;
		ox = scan.nextInt();
		oy = scan.nextInt();
		xy[ox][oy] = 1;

		return xy;
	}

	private static void printOmok() {

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("¦«");

			System.out.println();
		}

	}

}
