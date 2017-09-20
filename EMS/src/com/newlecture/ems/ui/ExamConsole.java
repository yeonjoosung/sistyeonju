package com.newlecture.ems.ui;

import java.util.Scanner;

import com.newlecture.ems.entity.Exam;

public abstract class ExamConsole {
	/*
	 * has a composition (����)-��ü�� (class ��ü�� ������ ����) association (����)-������..��������
	 * (�ٸ�Ŭ������ ��������) aggregation (����) DI(dependency Injection):������ ����-> ��ǰ ������ �ǹ�
	 */
	private Exam exam = newExam();// compostion

	public abstract Exam newExam();

//	public void setExam(Exam exam) {
//		this.exam = exam;
//	}

	public void input() {

		int kor;
		int eng;
		int math;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.printf("���� ���� ���� ������ �Է����ּ��� :");
			kor = scan.nextInt();
			eng = scan.nextInt();
			math = scan.nextInt();

			if ((kor > 100 || kor < 0) || (eng > 100 || eng < 0) || (math > 100 || math < 0)) {
				System.out.println("��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
			}

			exam.setKor(kor);
			exam.setEng(eng);
			exam.setMath(math);

		} while ((kor > 100 || kor < 0) || (eng > 100 || eng < 0) || (math > 100 || math < 0));
//		onInput(exam);
	}

//	protected abstract void onInput(Exam exam);

	public void print() {
		int kor = exam.getKor();
		int eng = exam.getEng();
		int math = exam.getMath();

		int total;
		float avg;
		System.out.printf("����: %3d,  ", kor);
		System.out.printf("����: %3d, ", eng);
		System.out.printf("����: %3d\n", math);
		onPrint(exam);
		total = exam.total();
		avg = exam.avg();
		System.out.printf("����: %3d\n", total);
		System.out.printf("���: %3.2f\n", avg);

	}// static �Լ��� this�� ����Ҽ�����

	protected abstract void onPrint(Exam exam);

}
