

public class Omok {
	public static void main(String[] args) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 20; x++) {
				if ((x + y <= 15 && x <= y)) { // y=x, y=-x+15
					// if���⺻���� �ƴѰ�
					System.out.printf("��");
				} else {
					// else�±⺻��
					System.out.printf("��");
				}
			}
			System.out.println();
		}
	}
}
