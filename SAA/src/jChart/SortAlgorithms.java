package jChart;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SortAlgorithms {

	public static ArrayList<Integer> sortNumbers = new ArrayList<Integer>();
	public static int temp;

	private static int N;

	public static int[] array;
	public static int[] helper;

	public static void init(ArrayList<Integer> ar) {
		array = new int[ar.size()];
		for (int i = 0; i < ar.size(); i++) {
			array[i] = ar.get(i);
		}
	}

	protected static void list() {
		for (int i = 0; i < array.length; i++) {
			sortNumbers.add(array[i]);
			if (i == 0)
				Display.sortNum.setText(array[i] + "");
			else
				Display.sortNum.setText(Display.sortNum.getText() + ", " + array[i]);
		}
		Engine.draw(sortNumbers);
	}

	public static void clear(ArrayList<Integer> ar) {
		ar.clear();
		sortNumbers.clear();
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}

	/*
	 * 
	 * Bubble Sort Algorithm
	 * 
	 */

	public static void bubbleSorting(ArrayList<Integer> ar) {
		init(ar);
		long now = System.nanoTime();
		for (int i = 0; i < (array.length - 1); i++) {
			for (int j = 0; j < (array.length - i - 1); j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		long time = System.nanoTime() - now;
		Statistic.bubbleSort.setText(time + " nano sec");
		list();
	}

	/*
	 * 
	 * QuickSort Algorithm
	 * 
	 */

	public static void quickSorting(ArrayList<Integer> ar) {
		init(ar);
		long now = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		long time = System.nanoTime() - now;
		Statistic.quicSorting.setText(time + " nano sec");
		list();
	}

	public static void quickSort(int array[], int start, int end) {
		int i = start;
		int k = end;

		if (end - start >= 1) {
			int pivot = array[start];

			while (k > i) {
				while (array[i] <= pivot && i <= end && k > i)
					i++;
				while (array[k] > pivot && k >= start && k >= i)
					k--;
				if (k > i)
					swap(array, i, k);
			}
			swap(array, start, k);

			quickSort(array, start, k - 1);
			quickSort(array, k + 1, end);
		} else
			return;
	}

	/*
	 * 
	 * Swap
	 * 
	 */

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/*
	 * 
	 * Heap Sort Algorithm
	 * 
	 */

	public static void heapSorting(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		heapify(array);
		for (int i = N; i > 0; i--) {
			swap(array, 0, i);
			N--;
			maxHeap(array, 0);
		}

		long time = System.nanoTime() - now;
		Statistic.heapSort.setText(time + " nano sec");

		list();
	}

	private static void heapify(int[] array) {

		N = array.length - 1;

		for (int i = N / 2; i >= 0; i--)
			maxHeap(array, i);

	}

	private static void maxHeap(int[] array, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && array[left] > array[i])
			max = left;
		if (right <= N && array[right] > array[max])
			max = right;

		if (max != i) {
			swap(array, i, max);
			maxHeap(array, max);
		}
	}

	/*
	 * 
	 * Merge Sort Algorithm
	 * 
	 */

	public static void mergeSorting(ArrayList<Integer> ar) {
		init(ar);
		int size = array.length;
		helper = new int[size];

		long now = System.nanoTime();

		mergeSort(0, size - 1);

		long time = System.nanoTime() - now;
		Statistic.mergeSort.setText(time + " nano sec");

		list();
	}

	private static void mergeSort(int start, int end) {
		if (start < end) {
			int middle = start + (end - start) / 2;

			mergeSort(start, middle);
			mergeSort(middle + 1, end);

			merge(start, middle, end);
		}
	}

	private static void merge(int start, int middle, int end) {
		for (int i = start; i <= end; i++) {
			helper[i] = array[i];
		}

		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = helper[i];
			k++;
			i++;
		}
	}

	/*
	 * 
	 * Insertion Sort Algorithm
	 * 
	 */
	public static void insertionSorting(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;

			for (j = i - 1; j >= 0 && temp < array[j]; j--)
				array[j + 1] = array[j];
			array[j + 1] = temp;
		}

		long time = System.nanoTime() - now;
		Statistic.insertionSort.setText(time + " nano sec");

		list();
	}

	/*
	 * 
	 * Selection Sort Algorithm
	 * 
	 */

	public static void selectionSort(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}

		long time = System.nanoTime() - now;
		Statistic.selectionSort.setText(time + " nano sec");

		list();
	}

	/*
	 * 
	 * Odd-even Sorting Algorithm
	 * 
	 */

	public static void oddEvenSorting(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		int n = array.length;
		int temp;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 2; j < n; j += 2) {
					if (array[j] < array[j - 1]) {
						temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
					}
				}
			} else {
				for (int j = 1; j < n; j += 2) {
					if (array[j] < array[j - 1]) {
						temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;

					}
				}
			}
		}

		long time = System.nanoTime() - now;
		Statistic.oddevenSort.setText(time + " nano sec");
		list();
	}

	/*
	 * 
	 * Cocktail Sorting Algorithm
	 * 
	 */

	public static void cocktailSorting(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i <= array.length - 2; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
			swapped = false;
			for (int i = array.length - 2; i >= 0; i--) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);

		long time = System.nanoTime() - now;
		Statistic.cocktailSort.setText(time + " nano sec");

		list();
	}

	/*
	 * 
	 * Cycle Sorting Algorithm
	 * 
	 */

	public static void cycleSorting(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		int writes = 0;

		for (int cycleStart = 0; cycleStart < array.length - 1; cycleStart++) {
			int val = array[cycleStart];

			int pos = cycleStart;
			for (int i = cycleStart + 1; i < array.length; i++)
				if (array[i] < val)
					pos++;

			if (pos == cycleStart)
				continue;

			while (val == array[pos])
				pos++;

			int tmp = array[pos];
			array[pos] = val;
			val = tmp;
			writes++;

			while (pos != cycleStart) {
				pos = cycleStart;
				for (int i = cycleStart + 1; i < array.length; i++)
					if (array[i] < val)
						pos++;

				while (val == array[pos])
					pos++;

				tmp = array[pos];
				array[pos] = val;
				val = tmp;
				writes++;
			}
		}

		long time = System.nanoTime() - now;
		Statistic.cycleSort.setText(time + " nano sec");

		list();
	}

	/*
	 * 
	 * Shell Sorting Algorithm
	 * 
	 */

	public static void shellSorting(ArrayList<Integer> ar) {
		init(ar);

		long now = System.nanoTime();

		int j;
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				Comparable<Integer> tmp = array[i];
				for (j = i; j >= gap && tmp.compareTo(array[j - gap]) < 0; j -= gap) {
					array[j] = array[j - gap];
				}
				array[j] = (int) tmp;
			}
		}

		long time = System.nanoTime() - now;
		Statistic.shellSort.setText(time + " nano sec");

		list();
	}
}
