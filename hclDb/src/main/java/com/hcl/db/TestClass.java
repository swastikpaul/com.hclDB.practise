package com.hcl.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		int[] array = { 3, 1, 5, 9 };
		int length = array.length;
		int number = 1000;

		System.out.println(findMissingNumber(array));
		// System.out.println(findZeroOcuranceInGivenNumber(number));
		// System.out.println(bubleSort(array));
		// System.out.println(mergeSort(array, length));

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
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		// [1, 3, 5, 9]
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

}
