package functions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileData {

	public static void main(String[] args) throws IOException {

		int[] nums = new int[] { 23, 34, 65,23, 2, 34, 4 };

		FileOutputStream ���� = new FileOutputStream("res/data.txt");
		PrintStream ���� = new PrintStream(����);

		for (int i = 0; i < 7; i++) {
			����.write(nums[i]);
			// ����.printf("%d ", nums[i]);
		}
		����.close(); // b���� �ݾƾ���
		����.close();

		FileInputStream ���� = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(����);

		int num;
		while (true) {
			num = ����.read();		//read()�� 1byte�� �ҷ���
			if (num == -1)
				break;
			System.out.print(num + " ");

		}
		scan.close();
		����.close();
		
		System.out.println("\n���α׷�����");
	}

}
