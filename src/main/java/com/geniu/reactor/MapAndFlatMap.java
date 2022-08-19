package com.geniu.reactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * map() vs flatMap()
 * https://www.geeksforgeeks.org/difference-between-map-and-flatmap-in-java-stream/
 *
 * @Author: zhongshibo
 * @Date: 2022/8/18 14:32
 */
public class MapAndFlatMap {

	public static void main(String[] args) {
		testMap();
		System.out.println("================");
		testFlatMap();
	}

	/**
	 * 测试 map()
	 * 返回 List<String> 的长度数组
	 */
	public static void testMap() {
		// making the array list object
		ArrayList<String> fruit = new ArrayList<>();
		fruit.add("Apple");
		fruit.add("mango");
		fruit.add("pineapple");
		fruit.add("kiwi");
		System.out.println("List of fruit-" + fruit);

		// lets use map() to convert list of fruit
		List list = fruit.stream()
				.map(s -> s.length())
				.collect(Collectors.toList());
		System.out.println("List generated by map-" + list);
	}

	/**
	 * 测试 flatMap
	 *
	 */
	public static void testFlatMap() {
		// making the arraylist object of List of Integer
		List<List<Integer>> number = new ArrayList<>();

		// adding the elements to number arraylist
		number.add(Arrays.asList(1, 2));
		number.add(Arrays.asList(3, 4));
		number.add(Arrays.asList(5, 6));
		number.add(Arrays.asList(7, 8));

		System.out.println("List of list-" + number);
		System.out.println("List of list stream - " + number.stream());
		System.out.println("threadName = " + Thread.currentThread().getName());
		// using flatmap() to flatten this list
		List<Integer> flatList
				= number.stream()
				.flatMap(list -> {
					System.out.println("flatMap threadName = " + Thread.currentThread().getName());
					return list.stream();
				})
				.collect(Collectors.toList());

		// printing the list
		System.out.println("List generate by flatMap-"
				+ flatList);
	}
}
