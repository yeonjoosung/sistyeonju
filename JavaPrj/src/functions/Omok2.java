package functions;

import java.util.Scanner;

public class Omok2 {
	public static void main(String[] args) {
		
		
		
		
		
		Scanner scan = new Scanner(System.in);
		int ox, oy;

		printOmok();
		System.out.print("x space y : ");
		ox = scan.nextInt();
		oy = scan.nextInt();



		ouputOmok(ox, oy);

	}

//	private static int inputOmok() {
//		Scanner scan = new Scanner(System.in);
//		int ox = scan.nextInt();
//	}

	private static void ouputOmok(int ox, int oy) {

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (x == ox && y == oy)
					System.out.print("¡Û");
				else
					System.out.print("¦«");

			System.out.println();
		}

	}

	private static void printOmok() {

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("¦«");

			System.out.println();
		}

	}

//	ox=inputOmok();

}
