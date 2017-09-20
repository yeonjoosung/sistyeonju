
import java.io.IOException;
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) throws IOException {
		int kor = 0;
		int math = 0;
		int eng = 0;
		int total;
		float avg;

		Scanner scan = new Scanner(System.in);
		나돌아갈래: while (true) { // break지정위치

			int menu;
			System.out.println("┌───────────────────────────────────────────┐");
			System.out.println("│                   메인메뉴                                                │");
			System.out.println("└───────────────────────────────────────────┘");
			System.out.println("\t\t1. 성적 입력");
			System.out.println("\t\t2. 성적 출력");
			System.out.println("\t\t3. 종료");
			System.out.print("선택 > ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("┌───────────────────────────────────────────┐");
				System.out.println("│                   성적입력                                                │");
				System.out.println("└───────────────────────────────────────────┘");
				do {
					if (kor < 0 || kor > 100)
						System.out.println("\t유효하지 않은 성적의 범위(0~100)입니다.");
					System.out.print("\t\t국어 : ");
					kor = scan.nextInt();

					// kor = System.in.read(); // throws IOException -오류 처리안함
					// System.out.println(kor);
				} while (kor < 0 || kor > 100);

				do {
					if (math < 0 || math > 100)
						System.out.println("\t유효하지 않은 성적의 범위(0~100)입니다.");

					System.out.print("\t\t수학 : ");
					math = scan.nextInt();
				} while (math < 0 || math > 100);

				do {
					if (eng < 0 || eng > 100)
						System.out.println("\t유효하지 않은 성적의 범위(0~100)입니다.");
					System.out.print("\t\t영어 : ");
					eng = scan.nextInt();

				} while (eng < 0 || eng > 100);

				break;

			case 2:
				System.out.println("┌───────────────────────────────────────────┐");
				System.out.println("│                   성적출력                                                │");
				System.out.println("└───────────────────────────────────────────┘");
				for(int i=0;i<3;i++) {
				total = kor + math + eng;
				avg = (float) (total / 3.0);
				System.out.printf(" 국어: %10d\n",kor);
				System.out.printf(" 수학: %10d\n",math);
				System.out.printf(" 영어: %10d\n",eng);
				System.out.printf(" 총점 : %10d\n", total);
				System.out.printf(" 평균 : %10.2f\n", avg); // %f : 실수, %e: 지수형실수,,,%c :문자, %s:문자열
				System.out.println("─────────────────────────────────────────────");// \n, \t
				
				}
				
				
				
				break;
			case 3:
				System.out.println("프로그램 종료");
				break 나돌아갈래;// break의 나가는 위치지정

			default:
				System.out.println("잘못된 번호를 입력하였습니다. 번호 1~3번을 입력해주세요.");

				
			}

		}

	}
}

//System.out.printf(" 영어 : %5d \n", eng);
// 1$ - 첫번째 값을 프린트, %숫자.숫자f ->자리수 맞춰줌: %1$5d
// System.out.printf(" 수학 : %5d\n", math); // %d: 10진수, %x: 16진수, %o :8진수

// System.out.write('3');
// System.out.write('3'+1);
// System.out.write(51); //버퍼에 넣음
// System.out.write(52);
// System.out.flush();//출력시킴

/*
 * for, while, if , do~while, switch
 * */
 