
import java.io.IOException;
import java.util.Scanner;

public class Hello2 {
	public static void main(String[] args) throws IOException {
		int n = 3;
		int[] kors = new int[n];
		int[] engs = new int[n];
		int[] maths = new int[n];

		Scanner scan = new Scanner(System.in);
		start: while (true) {

			int menu;
			System.out.println("┌──────────────────────────┐");
			System.out.println("│                         *성적입력                                           │");
			System.out.println("└──────────────────────────┘");
			System.out.println("\t\t1. 성적 입력");
			System.out.println("\t\t2. 성적 출력");
			System.out.println("\t\t3. 종료");
			System.out.print("선택 > ");
			menu = scan.nextInt();
			switch (menu) {

			case 1: {
				int kor = 0;
				int math = 0;
				int eng = 0;

				System.out.println("┌──────────────────────────┐");
				System.out.println("│                         *성적입력                                           │");
				System.out.println("└──────────────────────────┘");

				for (int i = 0; i < 3; i++) {
					do {
						if ((kor < 0 || kor > 100) || (math < 0 || math > 100) || (eng < 0 || eng > 100))
							System.out.println("\t유효하지 않은 성적의 범위(0~100)입니다.");
						System.out.printf("\t%d번째 국어 영어 수학 성적을 입력하세요 : ", i + 1);
						kor = scan.nextInt();
						math = scan.nextInt();
						eng = scan.nextInt();

					} while ((kor < 0 || kor > 100) || (math < 0 || math > 100) || (eng < 0 || eng > 100));

					kors[i] = kor;
					engs[i] = eng;
					maths[i] = math;
				}
				break;
			}
			case 2: {

			/*	int kor = 0;
				int math = 0;
				int eng = 0;*/

				int total;
				float avg;

				System.out.println("┌──────────────────────────┐");
				System.out.println("│                         *성적출력                                           │");
				System.out.println("└──────────────────────────┘");

				for (int i = 0; i < 3; i++) {
					total = kors[i] + maths[i] + engs[i];
					avg = (float) (total / (float) 3);

					System.out.printf(" 국어%d: %10d\n", i + 1, kors[i]);
					System.out.printf(" 수학%d: %10d\n", i + 1, maths[i]);
					System.out.printf(" 영어%d: %10d\n", i + 1, engs[i]);
					System.out.printf(" 총점%d : %10d\n", i + 1, total);
					System.out.printf(" 평균%d : %10.2f\n", i + 1, avg);
					System.out.println("──────────────────────────");
				}
				break;
			}
			case 3:
				System.out.println("프로그램 종료");
				break start;

			default:
				System.out.println("잘못된 번호를 입력하였습니다. 번호 1~3번을 입력해주세요.");
			}
		}
	}
}