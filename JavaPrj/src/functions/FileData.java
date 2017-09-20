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

		FileOutputStream 용주 = new FileOutputStream("res/data.txt");
		PrintStream 은녕 = new PrintStream(용주);

		for (int i = 0; i < 7; i++) {
			용주.write(nums[i]);
			// 은녕.printf("%d ", nums[i]);
		}
		은녕.close(); // b부터 닫아야함
		용주.close();

		FileInputStream 형주 = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(형주);

		int num;
		while (true) {
			num = 형주.read();		//read()는 1byte만 불러옴
			if (num == -1)
				break;
			System.out.print(num + " ");

		}
		scan.close();
		형주.close();
		
		System.out.println("\n프로그램종료");
	}

}
