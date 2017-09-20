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
	// System.out.println("컴퓨터 성적을 입력해주세요");
	// com = scan.nextInt();
	// ((NewlecExam) exam).setCom(com);
	// if (com > 100 || com < 0) {
	// System.out.println("유효하지 않은 성적의 범위(0~100)입니다.");
	// }
	// } while (com > 100 || com < 0);
	//
	// }

	public void input() {
		super.input();
		 int com;
		 Scanner scan = new Scanner(System.in);
		 do {
		 System.out.print("컴퓨터 성적을 입력해주세요: ");
		 com = scan.nextInt();
		 exam.setCom(com);
		 if (com > 100 || com < 0) {
		 System.out.println("유효하지 않은 성적의 범위(0~100)입니다.");
		 }
		 } while (com > 100 || com < 0);

	}

	@Override
	protected void onPrint(Exam exam) {
		System.out.println("컴퓨터: " + this.exam.getCom());

	}

}
