package com.hcl.db;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DsaJava {

	public static void main(String[] args) {
		int number = 20;
		int[] array1 = { 1, 2, 3, 4 };
		int[] array2 = { 5, 6, 4 };
		/*
		 * dsa1: Given a number n, print all primes smaller than or equal to n. Example:
		 * Input : n =10 Output : 2 3 5 7
		 */
		// System.out.println(dsa1(number));
		// ==========================================================================
		/*
		 * TWO SUM: Given an array of integers nums and an integer target, return
		 * indices of the two numbers such that they add up to target Input: nums =
		 * [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1]
		 * == 9, we return [0, 1]
		 */
		// System.out.println(dsa2(array1, number));
		// System.out.println(dsa2_1(array1, number));
		// System.out.println(dsa2_2(array1, number));
		// System.out.println(dsa2_3(array1, number));
		// ==========================================================================
		/*
		 * 121) Best Time to Buy and Sell Stock. You want to maximize your profit by
		 * choosing a single day to buy one stock and choosing a different day in the
		 * future to sell that stock. Input: prices = [7,1,5,3,6,4] Output: 5
		 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
		 * 6-1 = 5.
		 */
		// System.out.println(dsa3(array1));
		// ==========================================================================
		/*
		 * Find if given array is contain any duplicate Element. Example: input array =
		 * [1, 2, 3, 1] output will be true if not then false. we can solve this problem
		 * by brute force approach like comparing each element by each-other it will
		 * give time complexity O(n2) another approach by sorting array first then
		 * comparing one element with next element it will give time complexity
		 * O(n)|log(n), another approach is using HashSet.
		 */
		// ==========================================================================
		/*
		 * Product of array it self. Input array [1, 2, 3, 1] and output Array [6, 3, 2,
		 * 6]. Explanation: while inserting elements in new array except that all will
		 * be multiple of elements. video 36min
		 */
		// System.out.println(dsa4(array1));
		// System.out.println(dsa4_1(array1));
		System.out.println(dsa4_2(array1));
	}

	private static String dsa1(int number) {
		String priNum = "";
		int x, y, flg;
		for (x = 2; x <= number; x++) {
			flg = 1;
			for (y = 2; y * y <= x; y++) {
				if (x % y == 0) {
					flg = 0;
					break;
				}
			}
			if (flg == 1)
				priNum += x + ", ";
		}
		return priNum;
	}

	private static String dsa2(int[] array1, int number) {
		String index = "";
		for (int i = 0; i < array1.length; i++) {
			for (int j = i + 1; j < array1.length; j++) {
				if (array1[i] + array1[j] == number) {
					return index + "[" + i + "]" + " " + "[" + j + "]";
				}
			}
		}
		return "no index found!";
	}

	private static String dsa2_1(int[] array1, int number) {
		String index = "";
		Arrays.sort(array1);
		int leftIndex = 0;
		int rigthIndex = array1.length - 1;

		while (leftIndex < rigthIndex) {
			int sum = array1[leftIndex] + array1[rigthIndex];
			if (sum == number) {
				return index + "[" + leftIndex + "]" + " " + "[" + rigthIndex + "]";
			} else if (sum < number) {
				leftIndex++;
			} else {
				rigthIndex--;
			}
		}
		return "no index found!";
	}

	private static String dsa2_2(int[] array1, int number) {
		String index = "";
		Arrays.sort(array1);
		for (int i = 0; i < array1.length; i++) {
			int sum = number - array1[i];
			for (int j = 0; j < array1.length; j++) {
				if (!(array1[j] > number) && array1[j] == sum) {
					return index + "[" + i + "]" + " " + "[" + j + "]";
				}
			}
		}
		return "no index found!";
	}

	private static String dsa2_3(int[] array1, int number) {
		String index = "";
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array1.length; i++) {
			int diff = number - array1[i];
			if (!map.containsKey(diff)) {
				map.put(array1[i], i);
			} else {
				return index + "[" + map.get(diff) + "]" + " " + "[" + i + "]";
			}
		}
		return "no index found!";
	}

	private static int dsa3(int[] array1) {
		int buy = array1[0];
		int profit = 0;

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] < buy) {
				buy = array1[i];
			}
			profit = Math.max(profit, array1[i] - buy);
		}
		return profit;
	}

	private static String dsa4(int[] array1) {

		int compositeVal = 1;
		int[] ansArray = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			compositeVal *= array1[i];
		}
		for (int j = 0; j < array1.length; j++) {
			ansArray[j] = compositeVal / array1[j];
		}
		return Arrays.toString(ansArray);
	}

	private static String dsa4_1(int[] array1) {

		int[] preFixArr = new int[array1.length];
		int[] postFixArr = new int[array1.length];
		int[] ansArray = new int[array1.length];
		int pre = 0;
		int preLastVal = 0;
		int pos = array1.length - 1;
		int posLastVal = 0;

		for (int i = 0; i < array1.length; i++) {
			if (!(pre >= 1)) {
				preFixArr[pre] = 1;
				preLastVal = 1;
				pre++;
			} else {
				preFixArr[pre] = preLastVal * array1[pre - 1];
				preLastVal = preLastVal * array1[pre - 1];
				pre++;
			}
		}

		for (int j = array1.length; j > 0; j--) {
			if ((pos == array1.length - 1)) {
				postFixArr[pos] = 1;
				posLastVal = 1;
				pos--;
			} else {
				postFixArr[pos] = posLastVal * array1[pos + 1];
				posLastVal = posLastVal * array1[pos + 1];
				pos--;
			}
		}

		for (int k = 0; k < array1.length; k++) {
			ansArray[k] = preFixArr[k] * postFixArr[k];
		}
		return Arrays.toString(ansArray);
	}

	// { 1, 2, 3, 4 }
	private static String dsa4_2(int[] array1) {

		int[] ansArray = new int[array1.length];
		Arrays.fill(ansArray, 1);
		int pre = 1, post = 1;

		for (int i = 0; i < array1.length; i++) {
			ansArray[i] = pre;
			pre *= array1[i];
		}

		for (int j = array1.length - 1; j >= 0; j--) {
			ansArray[j] = ansArray[j] * post;
			post = post * array1[j];
		}
		return Arrays.toString(ansArray);
	}

}
