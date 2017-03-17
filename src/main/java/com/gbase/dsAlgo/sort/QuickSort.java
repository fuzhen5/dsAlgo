package com.gbase.dsAlgo.sort;

import java.util.Random;

import com.gbase.dsAlgo.util.SortUtil;

public class QuickSort {
	
	public static void main(String[] args) {
		int n = 1000000;
		System.out.println("Test for Random Array, size = " + n + ", random range [0, " + n*10 + "]");
		Integer[] arr = SortUtil.generateRandomArray(n, 0, n*10);
		Integer[] arr1 = arr.clone();
		SortUtil.testSort(QuickSort.class, "quickSort", arr, arr.length);
		SortUtil.testSort(MergeSort.class, "mergeSort", arr1, arr1.length);
		
		System.out.println("Test for Nearly Sorted Array, size = " + n + ", random range [0, " + n*10 + "]");
		Integer[] narr = SortUtil.generateNearlyOrderedArray(n, 50);
		Integer[] narr1 = narr.clone();
		SortUtil.testSort(QuickSort.class, "quickSort", narr1, narr1.length);
		
	}
	
	public static<T extends Comparable<T>> void quickSort(T[] arr, int n) {
		quickSort(arr, 0, n-1);
	}

	/**
	 * 对数组 arr[l...r] 进行排序
	 * @param arr  数组
	 * @param l    数组左边界
	 * @param r	       数组右边界
	 */
	private static<T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {
//		if(l >= r) {
//			return;
//		}
		//当数组元素较少时，采用插入排序优化
		if(r-l <= 15) {
			InsertionSort.optimizedInsertionSort(arr, l, r);
			return;
		}
		
		int p = partition(arr, l, r);
		quickSort(arr, l, p-1);
		quickSort(arr, p+1, r);
	}

	/**
	 * 对arr[l...r]进行partition操作
	 * 返回p,使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private static<T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		
		int ran = new Random().nextInt(r - l + 1) + l;
		T t = arr[ran];
		arr[ran] = arr[l];
		arr[l] = t;
		
		T v = arr[l];
		// arr[l+1...j] < v ; arr[j+1...i) > v;
		int j = l;
		for(int i = l+1; i <= r; i++) {
			if(arr[i].compareTo(v) < 0) {
				T tmp = arr[j+1];
				arr[j+1] = arr[i];
				arr[i] = tmp;
				
				
				
				
				
				
				
				
				j++;
			} 
		}
		T tmp = arr[j];
		arr[j] = arr[l];
		arr[l] = tmp;
		return j;
	}

}
