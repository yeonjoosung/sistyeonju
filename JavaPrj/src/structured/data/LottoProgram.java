package structured.data;

import java.util.Random;

public class LottoProgram {
	public static void main(String[] args) {

		Lotto lotto = new Lotto();

		gen(lotto);
		print(lotto);
		sort(lotto);
		print(lotto);

	}

	private static void sort(Lotto lotto) {

		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				int temp;
				if (lotto.nums[i] > lotto.nums[j]) {
					temp = lotto.nums[i];
					lotto.nums[i] = lotto.nums[j];
					lotto.nums[j] = temp;
				}
			}
		}
		System.out.println();
	}

	private static void print(Lotto lotto) {
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto.nums[i]);
	}

	private static void gen(Lotto lotto) {
		Random rand = new Random();
		for (int i = 0; i < lotto.nums.length; i++) {
			lotto.nums[i] = rand.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto.nums[i] == lotto.nums[j]) {
					i--;
					break;
				}
			}
		}

	}

}