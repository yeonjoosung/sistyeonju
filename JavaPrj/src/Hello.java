
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
		�����ư���: while (true) { // break������ġ

			int menu;
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("��                   ���θ޴�                                                ��");
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("\t\t1. ���� �Է�");
			System.out.println("\t\t2. ���� ���");
			System.out.println("\t\t3. ����");
			System.out.print("���� > ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("������������������������������������������������������������������������������������������");
				System.out.println("��                   �����Է�                                                ��");
				System.out.println("������������������������������������������������������������������������������������������");
				do {
					if (kor < 0 || kor > 100)
						System.out.println("\t��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
					System.out.print("\t\t���� : ");
					kor = scan.nextInt();

					// kor = System.in.read(); // throws IOException -���� ó������
					// System.out.println(kor);
				} while (kor < 0 || kor > 100);

				do {
					if (math < 0 || math > 100)
						System.out.println("\t��ȿ���� ���� ������ ����(0~100)�Դϴ�.");

					System.out.print("\t\t���� : ");
					math = scan.nextInt();
				} while (math < 0 || math > 100);

				do {
					if (eng < 0 || eng > 100)
						System.out.println("\t��ȿ���� ���� ������ ����(0~100)�Դϴ�.");
					System.out.print("\t\t���� : ");
					eng = scan.nextInt();

				} while (eng < 0 || eng > 100);

				break;

			case 2:
				System.out.println("������������������������������������������������������������������������������������������");
				System.out.println("��                   �������                                                ��");
				System.out.println("������������������������������������������������������������������������������������������");
				for(int i=0;i<3;i++) {
				total = kor + math + eng;
				avg = (float) (total / 3.0);
				System.out.printf(" ����: %10d\n",kor);
				System.out.printf(" ����: %10d\n",math);
				System.out.printf(" ����: %10d\n",eng);
				System.out.printf(" ���� : %10d\n", total);
				System.out.printf(" ��� : %10.2f\n", avg); // %f : �Ǽ�, %e: �������Ǽ�,,,%c :����, %s:���ڿ�
				System.out.println("������������������������������������������������������������������������������������������");// \n, \t
				
				}
				
				
				
				break;
			case 3:
				System.out.println("���α׷� ����");
				break �����ư���;// break�� ������ ��ġ����

			default:
				System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�. ��ȣ 1~3���� �Է����ּ���.");

				
			}

		}

	}
}

//System.out.printf(" ���� : %5d \n", eng);
// 1$ - ù��° ���� ����Ʈ, %����.����f ->�ڸ��� ������: %1$5d
// System.out.printf(" ���� : %5d\n", math); // %d: 10����, %x: 16����, %o :8����

// System.out.write('3');
// System.out.write('3'+1);
// System.out.write(51); //���ۿ� ����
// System.out.write(52);
// System.out.flush();//��½�Ŵ

/*
 * for, while, if , do~while, switch
 * */
 