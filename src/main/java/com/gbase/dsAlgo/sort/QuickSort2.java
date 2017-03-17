package com.gbase.dsAlgo.sort;

import java.util.Random;

import com.gbase.dsAlgo.util.SortUtil;

/**
 * 二路快速排序
 * @author wangf
 *
 */
public class QuickSort2 {

	public static void main(String[] args) {
		// 产生100w个随机数，区间较小
		int n = 1000000;
		Integer[] arr = SortUtil.generateRandomArray(n, 0, 10);
		Integer[] arr1 = arr.clone();
		SortUtil.testSort(QuickSort.class, "quickSort", arr, arr.length);
		SortUtil.testSort(QuickSort2.class, "quickSort2", arr1, arr1.length);
	}

	/**
	 * 对数组 arr 按照升序进行排序
	 * 
	 * @param arr
	 * @param n
	 */
	public static <T extends Comparable<T>> void quickSort2(T[] arr, int n) {
		quickSort2(arr, 0, n - 1);
	}

	/**
	 * 对数组 arr[l...r]进行快速排序
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static <T extends Comparable<T>> void quickSort2(T[] arr, int l, int r) {
		// 当数组元素较少时，采用插入排序优化
		if (r - l <= 15) {
			InsertionSort.optimizedInsertionSort(arr, l, r);
			return;
		}

		int p = partition2(arr, l, r);
		quickSort2(arr, l, p - 1);
		quickSort2(arr, p + 1, r);

	}

	/**
	 * 对数据 arr[l...r]部分进行partition操作 返回p,使得arr[l...p-1] < arr[p] ; arr[p+1...r]
	 * > arr[p]
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private static <T extends Comparable<T>> int partition2(T[] arr, int l, int r) {
		int index = new Random().nextInt(r - l + 1) + l;
		swap(arr, l, index);

		T v = arr[l];
		// arr[l+1...i) <= v; arr(j...r) >= v
		int i = l + 1;
		int j = r;
		while (true) {
			while (i <= r && arr[i].compareTo(v) < 0) {
				i++;
			}
			while (j >= l + 1 && arr[j].compareTo(v) > 0) {
				j--;
			}
			if (i > j) {
				break;
			}
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, l, j);

		return j;
	}

	private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
