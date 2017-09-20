package capsule;

import java.util.Scanner;

public class Exam {

	int kor;
	int eng;
	int math;

	public static void printExam(Exam[] exams) {

		int subtotal;
		int total = 0;
		for (int i = 0; i < exams.length; i++) {
			System.out.printf("����%2d: %3d ", i + 1, exams[i].kor);
			System.out.printf("����%2d: %3d ", i + 1, exams[i].eng);
			System.out.printf("����%2d: %3d\n", i + 1, exams[i].math);
			subtotal = exams[i].kor + exams[i].eng + exams[i].math;
			total += subtotal;
			System.out.printf("%2d ��° ���� ����: %3d, ��� %3.2f\n", i + 1, subtotal, (float) subtotal / 3.0);
		}
		System.out.printf("��ü ��: %3d\n", total);
		System.out.printf("��ü���: %3.2f\n", (float) total / 9.0);

	}

	public static void inputExam(Exam[] exams) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < exams.length; i++) {
			do {
				System.out.printf("%2d��° ���� ���� ���� ������ �Է����ּ��� :", i + 1);
				int kor = exams[i].kor = scan.nextInt();
				int eng = exams[i].eng = scan.nextInt();
				int math = exams[i].math = scan.nextInt();
				if ((kor > 100 || kor < 0) || (eng > 100 || eng < 0) || (math > 100 || math < 0)) {
					System.out.println("��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
				}

			} while ((exams[i].kor > 100 || exams[i].kor < 0) || (exams[i].eng > 100 || exams[i].eng < 0)
					|| (exams[i].math > 100 || exams[i].math < 0));

		}
	}

}
