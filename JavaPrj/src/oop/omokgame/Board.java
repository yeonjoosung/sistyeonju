package oop.omokgame;

public class Board {

	private Omok omok = new Omok();

	public void create() {
		System.out.println("Omok start...");
	}

	public void print() {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				System.out.print("¦«");

			System.out.println();
		}
	}

	public void put(Omok omok) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++)
				if (x == (omok.getOx()) && y == (omok.getOy()))
					System.out.print("¡Û");
				else
					System.out.print("¦«");

			System.out.println();
		}

	}

}
