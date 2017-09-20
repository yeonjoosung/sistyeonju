package oop.omokgame;

public class OmokProgram {
	public static void main(String[] args) {

		Omok omok = new Omok();
		Board board = new Board();
		OmokForm form = new OmokForm();

		board.create();
		board.print();

		form.print();
		
		
		omok.input();
		board.put(omok);

		board.print();

	}

}
