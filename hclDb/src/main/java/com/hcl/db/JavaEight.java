package com.hcl.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaEight {

	private static Integer counter = 1;

	public static void main(String[] args) {

		int[] array = { 2, 24, 6, 8, 21, 10, };
		int element = 0;
		int number = 100;
		String str = "counteachcharater";
		String[] longString = { "Spring", "Microservies", "MVC", "java" };

		// System.out.println(countDuplChar(str));
		// System.out.println(getAllDuplChar(str));
		// System.out.println(getAllUniqueChar(str));
		// System.out.println(getFirstNonRepetiveChar(str));
		// System.out.println(getFirstRepetiveChar(str));
		// System.out.println(findSecondHighestNumber(array));
		// System.out.println(findLongestString(longString));
		// System.out.println(findGivenElementStartWith(array, element));
		// System.out.println(findOccuranceOfElement(number, element));
		System.out.println(findMaxElement(array));
		// System.out.println(calculateSumOfAllNum(array));
		// System.out.println(calculateAvgOfAllNum(array));
		// System.out.println(converStringToUpperCase(longString));
		// System.out.println(getAllEvenNum(array));
		// System.out.println(getOnlyDistinctNum(array));
		// System.out.println(getOddEvenNumBoth(array));
		// System.out.println(sumerizingIntArray(array));
		// System.out.println(mapStrWithStrLength(longString));
		// System.out.println(mapStrWithIncrementValue(longString));
		// System.out.println(addAllStrLength(longString));

	}

	private static Integer addAllStrLength(String[] longString) {
		Integer sum = Arrays.stream(longString)
				.collect(Collectors.mapping(String::length, Collectors.summingInt(Integer::intValue)));
		return sum;
	}

	private static Map<Integer, String> mapStrWithIncrementValue(String[] longString) {
		Map<Integer, String> map = Arrays.stream(longString)
				.collect(Collectors.toMap(m -> counter++, String::toString));
		return map;
	}

	private static List<Integer> mapStrWithStrLength(String[] longString) {
		List<Integer> list = Arrays.stream(longString).collect(Collectors.mapping(String::length, Collectors.toList()));
		return list;
	}

	// summerizingInt method in java, Stream is a collector that generate the
	// summary statistics for the element of stream, including count, sum, minimum,
	// average and maximum. Return type is IntSummaryStatistics.
	private static IntSummaryStatistics sumerizingIntArray(int[] array) {
		IntSummaryStatistics iSs = Arrays.stream(array).boxed().collect(Collectors.summarizingInt(Integer::intValue));
		return iSs;
	}
	// Question: Partition a list of integer into odd & even number.
	// the partitioningBy method in java, stream is use to partition the element of
	// stream into two groups based on a specific predicate. It return a Map where
	// key is Boolean and the values are list of elements that satisfy (do or do not
	// satisfy) the predicate.

	// Return type = Map<Boolean, List<T>>
	// Key = true => contain element that satisfy the predicate.
	// Key = false => contain element that not satisfy the predicate.
	private static Map<Boolean, List<Integer>> getOddEvenNumBoth(int[] array) {
		Map<Boolean, List<Integer>> oddEven = Arrays.stream(array).boxed()
				.collect(Collectors.partitioningBy(p -> p.intValue() % 2 == 0));
		return oddEven;
	}

	private static List<Integer> getOnlyDistinctNum(int[] array) {
		List<Integer> distinct = Arrays.stream(array).boxed().distinct().collect(Collectors.toList());
		return distinct;
	}

	private static OptionalDouble calculateAvgOfAllNum(int[] array) {
		OptionalDouble avg = Arrays.stream(array).boxed().mapToInt(Integer::intValue).average();
		return avg;
	}

	private static List<Integer> getAllEvenNum(int[] array) {
		List<Integer> evenNum = Arrays.stream(array).boxed().filter(f -> f.intValue() % 2 == 0)
				.collect(Collectors.toList());
		return evenNum;
	}

	private static List<String> converStringToUpperCase(String[] longString) {
		List<String> upCase = Arrays.stream(longString).map(String::toUpperCase).collect(Collectors.toList());
		return upCase;
	}

	// max & min both can be use
	private static int findMaxElement(int[] array) {
		int max = Arrays.stream(array).boxed().min(Comparator.naturalOrder()).get();
		return max;
	}

	private static int calculateSumOfAllNum(int[] array) {
		int sum = Arrays.stream(array).boxed().mapToInt(Integer::intValue).sum();
		return sum;
	}

	private static int findOccuranceOfElement(int number, int element) {
		List<Long> zCount = new ArrayList<>();
		List<String> count = IntStream.rangeClosed(0, number).boxed().map(x -> x.toString())
				.filter(e -> e.contains(String.valueOf(element))).collect(Collectors.toList());

		System.out.println(count);

		count.forEach(c -> {
			long lg = 0;
			if (c.length() > 2) {
				// PANGA
				lg = Arrays.asList(c.toCharArray()).stream().filter(f -> f.equals(String.valueOf(element))).count();
				zCount.add(lg);
			} else {
				if (c.contains("0"))
					zCount.add(0L);
			}
		});
		System.out.println("*****findOccuranceOfElement****");
		return zCount.size();
	}

	private static List<String> findGivenElementStartWith(int[] array, int element) {
		List<String> list = Arrays.stream(array).boxed().map(s -> s.toString())
				.filter(e -> e.startsWith(String.valueOf(element))).collect(Collectors.toList());
		System.out.println("*****findGivenElementStartWith****");
		return list;
	}

	private static String findLongestString(String[] longString) {
		String string = Arrays.stream(longString).reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
				.get();
		System.out.println("*****findLongestString****");
		return string;
	}

	private static Integer findSecondHighestNumber(int[] array) {
		Integer integer = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).skip(1).limit(array.length - 1)
				.findAny().get();
		System.out.println("*****findSecondHighestNumber****");
		return integer;
	}

	// [c]
	private static String getFirstRepetiveChar(String str) {
		String string = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList())).entrySet()
				.stream().filter(mv -> mv.getValue().size() > 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println("*****getFirstRepetiveChar****");
		return string;
	}

	// [o]
	private static String getFirstNonRepetiveChar(String str) {
		String string = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList())).entrySet()
				.stream().filter(mv -> mv.getValue().size() == 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println("*****getFirstNonRepetiveChar****");
		return string;
	}

	// [u, n, o]
	private static List<String> getAllUniqueChar(String str) {
		List<String> list = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity())).entrySet()
				.stream().filter(mv -> mv.getValue().size() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("*****getAllUniqueChar****");
		return list;
	}

	// [a, r, c, t, e, h]
	private static List<String> getAllDuplChar(String str) {
		List<String> list = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity())).entrySet()
				.stream().filter(mv -> mv.getValue().size() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("*****getAllDuplChar****");
		return list;
	}

	// {a=3, r=2, c=3, t=2, e=2, u=1, h=2, n=1, o=1}
	private static Map<Object, Long> countDuplChar(String str) {
		Map<Object, Long> map = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("*****countDuplChar****");
		return map;
	}

}
