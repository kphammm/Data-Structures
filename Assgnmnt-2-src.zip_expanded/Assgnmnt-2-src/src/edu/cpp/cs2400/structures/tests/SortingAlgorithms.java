/**
 * This file pedagogical material for the course
 * CS 2400: Data Structures and Algorithms
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 * 
 * Copyright (c) 2022 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs2400.structures.tests;
import edu.cpp.cs2400.structures.stacksandqueues.ArrayHeap;

import java.util.Random;

/**
 * @author Edwin Rodr&iacute;guez
 * 
 */
public class SortingAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] list = new int[100000];
		Random rand = new Random();

		for (int i = 0; i < list.length; ++i) {
//			list[i] = 42;
			list[i] = rand.nextInt(1000000);
		}

		long initTime = System.currentTimeMillis();
		radixSort(list,6);
		long finalTime = System.currentTimeMillis();

		System.out.println(finalTime - initTime);
		System.out.println("fuckk");

	}

	public static int[] countingSort(int[] numbers) {
		int[] counter = new int[100000];
		int[] result = new int[numbers.length];

		for (int i = 0; i < numbers.length; ++i) {
			++counter[numbers[i]];
		}

		for (int i = 1; i < counter.length; ++i) {
			counter[i] += counter[i - 1];
		}

		for (int i = 0; i < result.length; ++i) {
			result[--counter[numbers[i]]] = numbers[i];
		}

		return result;
	}

	
	public static int[] radixSort(int[] numbers, int radix) {
		int[] result = numbers;
		
		for (int pos = 1; pos <= radix; ++pos) {
			result = modCountingSort(result, pos);
		}
		
		return result;
	}
	
	private static int getDigit(int number, int pos) {
		int pow = (int)Math.pow(10, pos);
		int rem = number % pow;
		return rem / (pow / 10);
	}

	public static int[] modCountingSort(int[] numbers, int pos) {
		int[] counter = new int[10];
		int[] result = new int[numbers.length];

		for (int i = 0; i < numbers.length; ++i) {
			++counter[getDigit(numbers[i], pos)];
		}

		for (int i = 1; i < counter.length; ++i) {
			counter[i] += counter[i - 1];
		}

		for (int i = result.length-1; i >= 0; --i) {
			result[--counter[getDigit(numbers[i], pos)]] = numbers[i];
		}

		return result;
	}
	
	public static int[] heapSort(int[] numbers) {
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>();
		heap.fromArray(boxingHelper(numbers));
		return unboxingHelper(heap.getSortedContents());
	}

	@SuppressWarnings("unused")
	private static int[] unboxingHelper(Integer[] oNumbers) {
		int[] result = new int[oNumbers.length];
		
		for (int i = 0; i < result.length; ++i)
			result[i] = oNumbers[i].intValue();
		
		return result;
	}

	@SuppressWarnings("removal")
	private static Integer[] boxingHelper(int[] numbers) {
		Integer[] result = new Integer[numbers.length];
		
		for (int i = 0; i < result.length; ++i)
			result[i] = new Integer(numbers[i]);
		
		return result;
	}

	public static int[] quickSort(int[] numbers) {

		quickSortHelper(numbers, 0, numbers.length - 1);

		return numbers;
	}

	private static void quickSortHelper(int[] numbers, int init, int last) {

		if ((last - init) < 1 || (last < 0)) {
			return;
		}

		int pivotIndex = partitionList(numbers, init, last);

		quickSortHelper(numbers, init, pivotIndex - 1);
		quickSortHelper(numbers, pivotIndex + 1, last);

	}

	private static int partitionList(int[] numbers, int init, int last) {
		int lastAssignedPos = init;

		for (int i = init; i < last; ++i) {
			if (numbers[i] < numbers[last]) {
				swap(numbers, lastAssignedPos, i);
				++lastAssignedPos;
			}
		}

		swap(numbers, last, lastAssignedPos);
		return lastAssignedPos;
	}

	public static int[] mergeSort(int[] numbers) {

		return mergeSortHelper(numbers, 0, numbers.length - 1);
	}

	private static int[] mergeSortHelper(int[] numbers, int init, int last) {
		if ((last - init) == 0) {
			return new int[] { numbers[last] };
		}

		int mid = (last + init) / 2;

		int[] subList1 = mergeSortHelper(numbers, init, mid);
		int[] subList2 = mergeSortHelper(numbers, mid + 1, last);

		return merge(subList1, subList2);
	}

	private static int[] merge(int[] subList1, int[] subList2) {
		int[] result = new int[subList1.length + subList2.length];
		int sub1First = 0;
		int sub2First = 0;

		for (int i = 0; i < result.length; ++i) {
			if (sub1First == subList1.length) {
				result[i] = subList2[sub2First++];
			} else if (sub2First == subList2.length) {
				result[i] = subList1[sub1First++];
			} else if (subList1[sub1First] <= subList2[sub2First]) {
				result[i] = subList1[sub1First++];
			} else {
				result[i] = subList2[sub2First++];
			}
		}

		return result;
	}

	public static int[] bubbleSort(int[] numbers) {
		boolean swapped = false;

		do {
			swapped = false;

			for (int i = 0; i < (numbers.length - 1); ++i) {
				if (numbers[i] > numbers[i + 1]) {
					swap(numbers, i, i + 1);
					swapped = true;
				}
			}

		} while (swapped);

		return numbers;
	}

	public static int[] selectionSort(int[] numbers) {

		for (int i = 0; i < numbers.length - 1; ++i) {
			int minIndex = i;

			for (int j = i + 1; j < numbers.length; ++j) {
				if (numbers[j] < numbers[minIndex])
					minIndex = j;
			}

			swap(numbers, minIndex, i);
		}

		return numbers;
	}

	public static int[] insertionSort(int[] numbers) {
		for (int i = 1; i < numbers.length; ++i) {
			for (int j = i; j > 0; --j) {
				if (numbers[j] < numbers[j - 1]) {
					swap(numbers, j, j - 1);
				} else {
					break;
				}
			}
		}

		return numbers;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static int[] recInsertSort(int[] list) {
		return recSortHelper(0, list);
	}

	private static int[] insert(int init, int[] list) {
		for (int i = init; i < list.length - 1; ++i) {
			if (list[i] > list[i + 1]) {
				swap(list, i, i + 1);
			} else {
				break;
			}
		}

		return list;
	}

	private static int[] recSortHelper(int init, int[] list) {
		if (init == (list.length - 1)) {
			return list;
		} else {
			return insert(init, recSortHelper(init + 1, list));
		}
	}

}
