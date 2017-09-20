package com.newlecture.ems.ui;

import java.util.Scanner;

import com.newlecture.ems.entity.Exam;

public abstract class ExamConsole {
	/*
	 * has a composition (구성)-일체형 (class 전체가 완전히 종속) association (연관)-조립형..결합유연
	 * (다른클래스와 연관관계) aggregation (집합) DI(dependency Injection):의존성 주입-> 부품 결합의 의미
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
			System.out.printf("국어 영어 수학 성적을 입력해주세요 :");
			kor = scan.nextInt();
			eng = scan.nextInt();
			math = scan.nextInt();

			if ((kor > 100 || kor < 0) || (eng > 100 || eng < 0) || (math > 100 || math < 0)) {
				System.out.println("유효하지 않은 성적의 범위(0~100)입니다.");
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
		System.out.printf("국어: %3d,  ", kor);
		System.out.printf("영어: %3d, ", eng);
		System.out.printf("수학: %3d\n", math);
		onPrint(exam);
		total = exam.total();
		avg = exam.avg();
		System.out.printf("총합: %3d\n", total);
		System.out.printf("평균: %3.2f\n", avg);

	}// static 함수는 this를 사용할수없음

	protected abstract void onPrint(Exam exam);

}
