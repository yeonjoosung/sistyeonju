package ����;
import java.util.Scanner;

public class sungyeonju {

	public static void main(String[] args) {

		int total = 0;
		float avg = 0;

		Scanner scan = new Scanner(System.in);

		int grade = 0;
		int con = 1;
		float num = 0;
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("��                *����� �����Է�                                           ��");
		System.out.println("������������������������������������������������������������������������������������������");

		while (con == 1) {
			do {
				System.out.print("�����Է� :");
				grade = scan.nextInt();
				if (grade < 0 || grade > 100) {
					System.out.println("������ ����(0~100)�� �߸��Ǿ����ϴ�.");
				}
			} while (grade > 100 || grade < 0);

			total += grade;
			num++;
			do {
				if (con > 1 || con < 0)
					System.out.println("�߸��� ���ڸ� �Է��Ͽ����ϴ�. 0�̳� 1�� �Է����ּ���.");
				System.out.print("����Ͻðڽ��ϱ�? 0(�ƴϿ�)or 1(��): ");
				con = scan.nextInt();
			} while (con > 1 || con < 0);

		}

		avg = (float) (total / num);

		System.out.println("\n����������������������������������������");
		System.out.println("�Է��� ������ ");
		System.out.printf("������ %10d\n", total);
		System.out.printf("����� %10.2f\n", avg);
		System.out.println("�Դϴ�.");
		System.out.println("����������������������������������������");

	}

}
