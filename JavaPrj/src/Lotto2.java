
import java.util.Random;

public class Lotto2 {
	public static void main(String[] args) {

		int[] nums = new int[6];

		Random rand = new Random();

		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] == nums[j]) {
					i--;
					break;
				}
			}
		}

		// 초기 상태
		for (int i = 0; i < nums.length; i++)
			System.out.printf("%d ", nums[i]);

		// for (int i = 0; i < 5; i++) {
		// for (int j = i + 1; j < 6; j++) {
		// int temp;
		// if (nums[i] > nums[j]) {
		// temp = nums[i];
		// nums[i] = nums[j];
		// nums[j] = temp;
		// }
		// }
		// }

		for (int j = 0; j < nums.length - 1; j++) {

			for (int i = 0; i < nums.length - 1 - j; i++) {
				int temp;
				if (nums[i] > nums[i + 1]) {
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}
		}

		System.out.println("\n------------------");

		// 최종 상태의 로또
		for (int i = 0; i < nums.length; i++)
			System.out.printf("%d ", nums[i]);

	}
}
