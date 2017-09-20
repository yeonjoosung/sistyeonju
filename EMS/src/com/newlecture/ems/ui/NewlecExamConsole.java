package com.newlecture.ems.ui;

import java.util.Scanner;

import com.newlecture.ems.entity.Exam;

public class NewlecExamConsole extends ExamConsole {

	private NewlecExam exam;

	@Override
	public Exam newExam() {
		exam = new NewlecExam();
		return exam;
	}

	// protected void onInput(Exam exam) {
	// int com;
	// Scanner scan = new Scanner(System.in);
	// do {
	// System.out.println("��ǻ�� ������ �Է����ּ���");
	// com = scan.nextInt();
	// ((NewlecExam) exam).setCom(com);
	// if (com > 100 || com < 0) {
	// System.out.println("��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
	// }
	// } while (com > 100 || com < 0);
	//
	// }

	public void input() {
		super.input();
		 int com;
		 Scanner scan = new Scanner(System.in);
		 do {
		 System.out.print("��ǻ�� ������ �Է����ּ���: ");
		 com = scan.nextInt();
		 exam.setCom(com);
		 if (com > 100 || com < 0) {
		 System.out.println("��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
		 }
		 } while (com > 100 || com < 0);

	}

	@Override
	protected void onPrint(Exam exam) {
		System.out.println("��ǻ��: " + this.exam.getCom());

	}

}
