package structured.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataAnalysis {

	public static void main(String[] args) throws IOException {

		double total = 0;
		int count = 0;
		double avg;
		FileInputStream fis = new FileInputStream("src/structured/data/data.txt");

		Scanner data = new Scanner(fis);
		while (data.hasNextDouble()) {

			total += data.nextDouble();
			count++;
		}
		avg = total / count;
		System.out.printf("ÃÑÇÕ: %2.2f\n", total);
		System.out.printf("Æò±Õ: %2.2f", avg);
		
	}

}
