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
		System.out.println("��������������������������������������������������������");
		System.out.println("��                              *���θ޴�                                      ��");
		System.out.println("��������������������������������������������������������");
		System.out.println("\t\t1. ���� �Է�");
		System.out.println("\t\t2. ���� ���");
		System.out.println("\t\t3. ����");
		System.out.print("���� > ");
		menu = scan.nextInt();
		return menu;
	}

}
