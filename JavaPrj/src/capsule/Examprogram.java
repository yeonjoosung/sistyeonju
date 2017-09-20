package capsule;

import java.util.Scanner;

public class Examprogram {

	public static void main(String[] args) {

		int menu;

		Exam[] exams = new Exam[3];

		for (int i = 0; i < exams.length; i++)
			exams[i] = new Exam();

		EXIT: while (true) {
			menu = inputMenu();

			switch (menu) {
			case 1:
				Exam.inputExam(exams);
				break;
			case 2:
				Exam.printExam(exams);
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
