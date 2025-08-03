package com.hcl.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {

	public static void main(String[] args) {
		int[] array = { 1, 3, 15, 11, 2 };
		int[] array1 = { 23, 127, 235, 19, 8 };
		int length = array.length;
		int number = 6;
		char[] ch = { 'a', 'b', 'c', 'd' };
		String str = "mathematics";

		// System.out.println(findAllPossibleCombination(ch));
		// System.out.println(findMissingNumber(array));
		// System.out.println(findZeroOcuranceInGivenNumber(number));
		// System.out.println(bubleSort(array));
		// System.out.println(mergeSort(array, length));
		// System.out.println(findMinDifference(array));
		// System.out.println(findMaxDifference(array));
		// System.out.println(findMaxDifferenceBySorting(array));
		// System.out.println(findMaxDifferenceByBubleSort(array));
		// System.out.println(findMaxDifferenceMaxValAfterMinValMath(array));
		// System.out.println(findMaxDifferenceMaxValAfterMinVal(array));
		// System.out.println(countPairWithGivenSum(array, number));
		// System.out.println(countPairWithGivenSumMap(array, number));
		// System.out.println(countPairWithGivenSumMapReverse(array, number));
		// System.out.println(countCharFromStrByMap(str));
		// System.out.println(countCharFromStrWithoutMap(str));
		// System.out.println(smallestDiffFromTwoArray(array, array1));
		// System.out.println(smallestDiffFromTwoArray1(array, array1));
		System.out.println(findSmallestNumberWhichIsNotInArr(array));

	}

	// array = [1, 3, 5, 18, 19, 25]
	// array1 = [8, 19, 23, 127, 235]
	private static int smallestDiffFromTwoArray1(int[] array, int[] array1) {
		Arrays.sort(array);
		Arrays.sort(array1);
		int a = 0, b = 0;
		int minDiff = Integer.MAX_VALUE;
		while (a < array.length && b < array1.length) {
			if (Math.abs(array[a] - array1[b]) < minDiff)
				minDiff = Math.abs(array[a] - array1[b]);
			if (array[a] < array1[b])
				a++;
			else
				b++;
		}
		return minDiff;
	}

	// int[] array = { 1, 3, 15, 11, 2 };
	// int[] array1 = { 23, 127, 235, 19, 8 };
	private static int smallestDiffFromTwoArray(int[] array, int[] array1) {
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array1.length; j++) {
				if ((Math.abs(array[i] - array1[j]) < minDiff)) {
					minDiff = Math.abs(array[i] - array1[j]);
				}
			}
		}
		return minDiff;
	}

	// found = true/false for 1st repeating & non-repeating char
	private static char countCharFromStrWithoutMap(String str) {
		for (int i = 0; i < str.length(); ++i) {
			boolean found = false;
			for (int j = 0; j < str.length(); ++j) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					found = true;
					break;
				}
			}
			if (found == true) {
				return str.charAt(i);
			}
		}
		return '$';
	}

	private static Map<Character, Integer> countCharFromStrByMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		return map;
	}

	private static int countPairWithGivenSumMapReverse(int[] array, int number) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > number) {
				continue;
			}
			int secValue = number - array[i];
			count += map.getOrDefault(secValue, 0);
			map.put(array[i], map.getOrDefault(array[i], 0) + 1);
		}
		return count;
	}

	private static int countPairWithGivenSumMap(int[] array, int number) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], map.getOrDefault(array[i], 0) + 1);
		}
		// System.out.println(map);
		for (int j = 0; j < array.length; j++) {
			if (array[j] > number) {
				continue;
			}
			int secValue = number - array[j];
			if (map.getOrDefault(map.get(secValue), 0) > 0) {
				count += map.get(secValue);
				map.put(array[j], map.get(array[j]) - 1);
				if (array[j] == secValue) {
					count -= 1;
				}
			}
		}
		return count;
	}

	private static int countPairWithGivenSum(int[] array, int number) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (!(array[i] >= number || array[j] >= number)) {
					if (array[i] + array[j] == number) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private static int findMaxDifferenceMaxValAfterMinVal(int[] array) {
		int maxDiff = array[1] - array[0];
		int minDiff = array[0];
		for (int i = 0; i < array.length; i++) {
			if ((array[i] - minDiff) > maxDiff) {
				maxDiff = array[i] - minDiff;
			}
			if (array[i] < minDiff) {
				minDiff = array[i];
			}
		}
		return maxDiff;
	}

	private static int findMaxDifferenceMaxValAfterMinValMath(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					max = Math.max(max, array[j] - array[i]);
				}
			}
		}
		return max;
	}

	private static int findMaxDifferenceByBubleSort(int[] array) {
		bubleSort(array);
		return division(array[array.length - 1], array[0]);
	}

	private static int findMaxDifferenceBySorting(int[] array) {
		Arrays.sort(array);
		return division(array[array.length - 1], array[0]);
	}

	private static int findMaxDifference(int[] array) {
		int maxDiff = array[0];
		int minDiff = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxDiff) {
				maxDiff = array[i];
			}
		}
		for (int j = 0; j < array.length; j++) {
			if (array[j] < minDiff) {
				minDiff = array[j];
			}
		}
		return division(maxDiff, minDiff);
	}

	private static int findMinDifference(int[] array) {
		Arrays.sort(array);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] < minDiff) {
				minDiff = array[i + 1] - array[i];
			}
		}
		return minDiff;
	}

	private static int division(int maxVal, int minVal) {
		return maxVal - minVal;
	}

	public static <T> List<List<T>> combination(List<T> values, int size) {

		if (0 == size) {
			return Collections.singletonList(Collections.<T>emptyList());
		}

		if (values.isEmpty()) {
			return Collections.emptyList();
		}

		List<List<T>> combination = new LinkedList<List<T>>();

		T actual = values.iterator().next();

		List<T> subSet = new LinkedList<T>(values);
		subSet.remove(actual);

		List<List<T>> subSetCombination = combination(subSet, size - 1);

		for (List<T> set : subSetCombination) {
			List<T> newSet = new LinkedList<T>(set);
			newSet.add(0, actual);
			combination.add(newSet);
		}

		combination.addAll(combination(subSet, size));

		return combination;
	}

	private static List<String> findAllPossibleCombination(char[] ch) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				list.add("" + ch[i] + ch[j]);
				list.add("" + ch[j] + ch[i]);
			}
		}
		return list;
	}

	private static String mergeSort(int[] array, int length) {
		if (length < 2) {
			return null;
		}
		int midElement = length / 2;
		int[] leftArray = new int[midElement];
		int[] rightArray = new int[length - midElement];

		for (int i = 0; i < midElement; i++) {
			leftArray[i] = array[i];
		}

		for (int j = midElement; j < length; j++) {
			rightArray[j - midElement] = array[j];
		}

		mergeSort(leftArray, midElement);
		mergeSort(rightArray, length - midElement);
		return Arrays.toString(merge(array, leftArray, rightArray, midElement, length - midElement));
	}

	private static int[] merge(int[] array, int[] leftArray, int[] rightArray, int midElementL, int midElementR) {
		int i = 0, j = 0, k = 0;

		while (i < midElementL && j < midElementR) {
			if (leftArray[i] <= rightArray[j]) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}

		while (i < midElementL) {
			array[k++] = leftArray[i++];
		}

		while (j < midElementR) {
			array[k++] = rightArray[j++];
		}
		return array;

	}

	private static String bubleSort(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return Arrays.toString(array);
	}

	// if number = 5 then Array would be = 0,1,2,3,4,5
	private static int findZeroOcuranceInGivenNumber(int number) {
		int count = 0;
		List<String> list2Digit = new ArrayList<>();
		for (int i = 0; i <= number; i++) {
			list2Digit.add(i + "");
		}
		if (list2Digit.size() == 10) {
			return 1;
		} else {
			for (String sz : list2Digit) {
				if (sz.length() > 2) {
					char[] ch = sz.toCharArray();
					for (int i = 0; i < ch.length; i++) {
						if (ch[i] == '0') {
							count++;
						}
					}
				} else {
					if (sz.contains("0")) {
						count++;
					}
				}
			}
		}
		return count;
	}

	// { 1, 3, 15, 11, 2 }
	// { 1, 2, 3, 11, 15 }
	private static String findMissingNumber(int[] array) {
		Arrays.sort(array);
		int firstElement = array[0];
		int lastElement = array[array.length - 1];
		int[] newAllElement = new int[lastElement];
		int[] missElements = new int[newAllElement.length - array.length];
		int k = 0;
		boolean missiEle = false;

		for (int i = 0; i < lastElement; i++) {
			newAllElement[i] = firstElement + i;
		}
		// example below
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		// [1, 2, 3, 11, 15]
		for (int i = 0; i < newAllElement.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (newAllElement[i] == array[j]) {
					break;
				} else {
					if (j == array.length - 1) {
						missiEle = true;
					}
				}
			}
			if (missiEle) {
				missElements[k] = newAllElement[i];
				missiEle = false;
				k++;
			}
		}
		return Arrays.toString(missElements);
	}

	private static int findSmallestNumberWhichIsNotInArr(int[] arr) {
		Arrays.sort(arr);
		int minValue = arr[1];
		int maxValue = arr[arr.length - 1];
		int length = arr.length;
		Set<Integer> set = new HashSet<>();

		if (minValue == 0 || minValue == 1) {
			return minValue;
		}
		// after insert complete range {1, 2, 3, 4, 5, 6, 7, 8, 9}
		for (int j = minValue; j <= maxValue; j++) {
			set.add(j);
		}
		for (int i = 0; i < length; i++) {
			if (set.contains(arr[i])) {
				set.remove(arr[i]);
			}
		}
		return new TreeSet<>(set).getFirst();

	}

}
