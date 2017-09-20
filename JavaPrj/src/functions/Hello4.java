package functions;

import java.util.Scanner;

public class Hello4 {

	public static void main(String[] args) {
		
		int[] kors = new int[3];
		int[] engs = new int[3];
		int[] maths = new int[3];
		int menu;
		
		
		EXIT:
		while(true) {
		menu = inputMenu();
		
		switch(menu) {
		case 1:
			inputExam(kors,engs,maths);
			break;
		case 2:
			printExam(kors,engs,maths);
		case 3:
			break EXIT;
		}
		
		
		}
		

	}

	private static void printExam(int[] kors, int[] engs, int[] maths) {
		
	}

	private static void inputExam(int[] kors, int[] engs, int[] maths) {
		
	}

	private static int inputMenu() {
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
