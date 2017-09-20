package oop;

import java.util.Scanner;

public class Exam {

	private int kor;
	private int eng;
	private int math;

	public Exam() {
//		kor = 1;
//		eng = 1;
//		math = 1;
		this(1, 1, 1);

	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.printf("���� ���� ���� ������ �Է����ּ��� :");
			kor = scan.nextInt();
			eng = scan.nextInt();
			math = scan.nextInt();
			if ((kor > 100 || kor < 0) || (eng > 100 || eng < 0) || (math > 100 || math < 0)) {
				System.out.println("��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
			}
		} while ((kor > 100 || kor < 0) || (eng > 100 || eng < 0) || (math > 100 || math < 0));

	}

	public void print() {

		System.out.printf("����: %3d,  ", kor);
		System.out.printf("����: %3d, ", eng);
		System.out.printf("����: %3d\n", math);
		int total = kor + eng + math;
		System.out.printf("����: %3d\n", total);
		System.out.printf("���: %3.2f\n", (float) total / 3.0);

	}// static �Լ��� this�� ����Ҽ�����

}
