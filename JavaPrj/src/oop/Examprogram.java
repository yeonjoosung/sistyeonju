package oop;

import java.util.Scanner;

public class Examprogram {

	public static void main(String[] args) {

		Exam exam = new Exam();

		EXIT: while (true) {
			int menu = inputMenu();

			switch (menu) {
			case 1:
				exam.input();
				break;
			case 2:
				exam.print();
				break;
			case 3:
				break EXIT;
			}

		}

	}

	public static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		int menu;
		System.out.println("┌──────────────────────────┐");
		System.out.println("│                              *메인메뉴                                      │");
		System.out.println("└──────────────────────────┘");
		System.out.println("\t\t1. 성적 입력");
		System.out.println("\t\t2. 성적 출력");
		System.out.println("\t\t3. 종료");
		System.out.print("선택 > ");
		menu = scan.nextInt();
		return menu;
	}

}
