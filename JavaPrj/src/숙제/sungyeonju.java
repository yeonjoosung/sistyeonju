package 숙제;
import java.util.Scanner;

public class sungyeonju {

	public static void main(String[] args) {

		int total = 0;
		float avg = 0;

		Scanner scan = new Scanner(System.in);

		int grade = 0;
		int con = 1;
		float num = 0;
		System.out.println("┌───────────────────────────────────────────┐");
		System.out.println("│                *사용자 성적입력                                           │");
		System.out.println("└───────────────────────────────────────────┘");

		while (con == 1) {
			do {
				System.out.print("점수입력 :");
				grade = scan.nextInt();
				if (grade < 0 || grade > 100) {
					System.out.println("점수의 범위(0~100)가 잘못되었습니다.");
				}
			} while (grade > 100 || grade < 0);

			total += grade;
			num++;
			do {
				if (con > 1 || con < 0)
					System.out.println("잘못된 숫자를 입력하였습니다. 0이나 1을 입력해주세요.");
				System.out.print("계속하시겠습니까? 0(아니오)or 1(예): ");
				con = scan.nextInt();
			} while (con > 1 || con < 0);

		}

		avg = (float) (total / num);

		System.out.println("\n────────────────────");
		System.out.println("입력한 성적은 ");
		System.out.printf("총점은 %10d\n", total);
		System.out.printf("평균은 %10.2f\n", avg);
		System.out.println("입니다.");
		System.out.println("────────────────────");

	}

}
