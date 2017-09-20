package structured.data;

import java.util.Scanner;

public class OmokProgram2 {

	public static void main(String[] args) {

		// int ox = 0, oy = 0;
		Omok omok = new Omok();

		Omok[] omoks = new Omok[10];// 동적메모리할당 -참조형식(주소저장)
		omoks[0] = new Omok();// 공간을 만듬-사용할때 만드는게 바람직함

		printBoard();
		input(omoks);
		printBoard(omoks);

	}

	private static void printBoard(Omok[] omok) {

//		int ox = omok.x;
//		int oy = omok.y;

		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (x == omok[0].x && y == omok[0].y)
					System.out.print("○");
				else
					System.out.print("┼");

			System.out.println();
		}
	}

	private static void input(Omok[] omoks) {
		Scanner scan = new Scanner(System.in);

		Omok omok = new Omok();
		System.out.print("x space y : ");

		omok.x = scan.nextInt();
		omok.y = scan.nextInt();
		
		omoks[0] = omok;
		
	}

	private static void printBoard() {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("┼");

			System.out.println();
		}
	}

}
