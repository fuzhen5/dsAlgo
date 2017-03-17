package com.gbase.dsAlgo.sort;

import java.util.Random;

import com.gbase.dsAlgo.util.SortUtil;

/**
 * 三路快速排序
 * @author wangf
 *
 */
public class QuickSort3Ways {
	
	public static void main(String[] args) {
		int n = 1000000;
		Integer[] arr = SortUtil.generateRandomArray(n, 0, 100);
		Integer[] arr1 = arr.clone();
		SortUtil.testSort(QuickSort3Ways.class, "quickSort3Ways", arr, arr.length);
		SortUtil.testSort(QuickSort2.class, "quickSort2", arr1, arr1.length);
	}
	
	public static<T extends Comparable<T>> void quickSort3Ways(T[] arr, int n) {
		quickSort3Ways(arr, 0, n-1);
	}

	/**
	 * 对数组 arr[l...r] 进行3路快速排序
	 *  将 arr[l...r]分为 <v ; ==v; >v 三部分
	 *  之后递归对 <v ; >v 两部分继续进行三路快速排序
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static<T extends Comparable<T>> void quickSort3Ways(T[] arr, int l, int r) {
		if (r - l <= 15) {
			InsertionSort.optimizedInsertionSort(arr, l, r);
			return;
		}
		
		// partition
		int index = new Random().nextInt(r - l + 1) + l;
		SortUtil.swap(arr, l, index);

		T v = arr[l];
		
		int lt = l; // arr[l+1...lt] < v
		int gt = r+1; // arr[gt,r] > v
		int i = l + 1;// arr[lt+1,i) == v
		while( i < gt) {
			if(arr[i].compareTo(v) < 0) {
				SortUtil.swap(arr, i, lt+1);
				lt++;
				i++;
			} else if(arr[i].compareTo(v) == 0) {
				i++;
			} else {
				SortUtil.swap(arr,gt-1,i);
				gt--;
			}
		}
		
		SortUtil.swap(arr, l, lt);
		lt --;
		quickSort3Ways(arr, l, lt);
		quickSort3Ways(arr, gt, r);
	}
	
}
