package oop.collec.sizeup;

import java.util.Scanner;

public class ExamConsole {

	private Exam[] exams;
	private int index;
	private int capa;

	public ExamConsole() {
		exams = new Exam[3];
		exams[0] = new Exam();
		exams[1] = new Exam();
		exams[2] = new Exam();
		index = 0;
		capa =3;
	}

	public void input() {

		int kor = 0;
		int eng = 0;
		int math = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("������������������������������������������");
		System.out.println("��     �����Է�                       ��");
		System.out.println("������������������������������������������");
		do {

			if (kor < 0 || kor > 100)
				System.out.println("������ ����(0~100)�� ������ϴ�. �ٽ� �Է��ϼ���.");
			System.out.println("����: ");
			kor = scan.nextInt();
		} while (kor < 0 || kor > 100);

		do {
			if (eng < 0 || eng > 100)
				System.out.println("������ ����(0~100)�� ������ϴ�. �ٽ� �Է��ϼ���.");
			System.out.println("����: ");
			eng = scan.nextInt();
		} while (eng < 0 || eng > 100);

		do {
			if (math < 0 || math > 100)
				System.out.println("������ ����(0~100)�� ������ϴ�. �ٽ� �Է��ϼ���.");
			System.out.println("����: ");
			math = scan.nextInt();
		} while (math < 0 || math > 100);

		Exam exam = new Exam();
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
		if (index >= capa) {
			Exam[] temp = new Exam[capa + 2];
			for (int i = 0; i < exams.length; i++) {
				temp[i] = exams[i];
			}
			exams = temp;

			capa += 2;
			

		}
		exams[index++] = exam;

	}

	public void print() {

		for (int i = 0; i < index; i++) {
			Exam exam = exams[i];

			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();

			int total = 0;
			float avg;

			total = exam.total();
			avg = exam.avg();

			System.out.println("������������������������������������������");
			System.out.println("��                     �������                       ��");
			System.out.println("������������������������������������������");

			System.out.printf("����%d: %d��\n", i + 1, kor);
			System.out.printf("����%d: %d��\n", i + 1, eng);
			System.out.printf("����%d: %d��\n", i + 1, math);
			System.out.printf("����%d: %d��\n", i + 1, total);
			System.out.printf("���%d: %.2f��\n", i + 1, avg);
		}

	}

}
