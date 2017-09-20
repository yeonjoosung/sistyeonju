

public class Omok {
	public static void main(String[] args) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++) {
				if ((x + y <= 15 && x <= y)) { // y=x, y=-x+15
					// if문기본값이 아닌것
					System.out.printf("○");
				} else {
					// else는기본값
					System.out.printf("┼");
				}
			}
			System.out.println();
		}
	}
}
