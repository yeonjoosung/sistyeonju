
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
			System.out.println("��������������������������������������������������������");
			System.out.println("��                         *�����Է�                                           ��");
			System.out.println("��������������������������������������������������������");
			System.out.println("\t\t1. ���� �Է�");
			System.out.println("\t\t2. ���� ���");
			System.out.println("\t\t3. ����");
			System.out.print("���� > ");
			menu = scan.nextInt();
			switch (menu) {

			case 1: {
				int kor = 0;
				int math = 0;
				int eng = 0;

				System.out.println("��������������������������������������������������������");
				System.out.println("��                         *�����Է�                                           ��");
				System.out.println("��������������������������������������������������������");

				for (int i = 0; i < 3; i++) {
					do {
						if ((kor < 0 || kor > 100) || (math < 0 || math > 100) || (eng < 0 || eng > 100))
							System.out.println("\t��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
						System.out.printf("\t%d��° ���� ���� ���� ������ �Է��ϼ��� : ", i + 1);
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

				System.out.println("��������������������������������������������������������");
				System.out.println("��                         *�������                                           ��");
				System.out.println("��������������������������������������������������������");

				for (int i = 0; i < 3; i++) {
					total = kors[i] + maths[i] + engs[i];
					avg = (float) (total / (float) 3);

					System.out.printf(" ����%d: %10d\n", i + 1, kors[i]);
					System.out.printf(" ����%d: %10d\n", i + 1, maths[i]);
					System.out.printf(" ����%d: %10d\n", i + 1, engs[i]);
					System.out.printf(" ����%d : %10d\n", i + 1, total);
					System.out.printf(" ���%d : %10.2f\n", i + 1, avg);
					System.out.println("����������������������������������������������������");
				}
				break;
			}
			case 3:
				System.out.println("���α׷� ����");
				break start;

			default:
				System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�. ��ȣ 1~3���� �Է����ּ���.");
			}
		}
	}
}