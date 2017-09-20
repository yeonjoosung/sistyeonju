package functions;

import java.util.Random;

public class Lotto {
	private static void sortLotto(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				int temp;
				if (nums[i] > nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	private static void printLotto(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", nums[i]);
	}

	private static void genLotto(int[] nums) {
		// TODO Auto-generated method stub
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

	}

	public static void main(String[] args) {

		int[] nums = new int[6];

		Random rand = new Random();

		genLotto(nums);
		printLotto(nums);
		sortLotto(nums);
		System.out.println();
		printLotto(nums);

	}

}
/*
  		for (int j = 0; j < 5; j++) {

			for (int i = 0; i < 5 - j; i++) {
				int temp;
				if (nums[i] > nums[i + 1]) {
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;

				}

			}
		}

  */
 