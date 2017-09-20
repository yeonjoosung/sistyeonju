package oop.omokgame;

import java.util.Scanner;

public class Omok {

	private int ox;
	private int oy;

	public Omok() {
		this(0, 0);
	}

	public Omok(int ox, int oy) {
		this.setOx(ox);
		this.setOy(oy);
	}

	public int getOx() {
		return ox;
	}

	public void setOx(int ox) {
		this.ox = ox;
	}

	public int getOy() {
		return oy;
	}

	public void setOy(int oy) {
		this.oy = oy;
	}

	public void input() {
		int ox;
		int oy;
		Scanner scan = new Scanner(System.in);
		ox = scan.nextInt();
		oy = scan.nextInt();
		setOx(ox);
		setOy(oy);

	}

}
