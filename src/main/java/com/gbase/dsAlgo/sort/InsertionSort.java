package com.gbase.dsAlgo.sort;

import java.util.Arrays;

import com.gbase.dsAlgo.util.SortUtil;

/**
 * 插入排序
 *  8 6  2  3  1  5  7  4
 *  保持第一个元素不动，把它后面的元素与前面已经排好序的元素进行比较，确定其插入位置。然后再继续排序
 * @author wangf
 *
 * @param <T>
 */
public class InsertionSort {
	
	public static void main(String[] args) {
		
		Integer[] arr = {8,6,2,3,1,5,7,4};
		
//		System.out.println(Arrays.toString(insertionSort(arr, 4)));
		System.out.println(Arrays.toString(optimizedInsertionSort(arr, 0,7)));
		
		int n = 50000;
		Integer[] arr1 = SortUtil.generateRandomArray(n, 3, 300000);
		optimizedInsertionSort(arr1,0, arr1.length-1);
		SortUtil.isSorted(arr);
		
	}
	
	/**
	 * 对数组前n个数据进行插入排序
	 * @param arr
	 * @param n
	 */
	public static <T extends Comparable<T>> T[] insertionSort(T[] arr, int n) {
		for(int i=1; i< n; i++) {
			// 寻找元素arr[i]合适的插入位置，能够提前结束内层循环
			for(int j=i; j>0 && ((Comparable<T>) arr[j]).compareTo(arr[j-1]) < 0; j--) {
				//遍历的同时不断进行交换
				T tmp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = tmp;
			}
		}
		return arr;
	}
	
	
	/**
	 * 对数组前n个数据进行排序，优化后版本
	 * @param arr
	 * @param n
	 */
	public static <T extends Comparable<T>> T[] optimizedInsertionSort(T[] arr, int n) {
		for(int i=1; i< n; i++) {
			// 寻找元素arr[i]合适的插入位置，能够提前结束内层循环
			T e = arr[i];
			int j;
			for(j = i; j > 0 && ((Comparable<T>) e).compareTo(arr[j-1]) < 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = e;
		}
		return arr;
	}
	
	/**
	 * 对数组arr[l,r]进行排序，优化后版本
	 * @param arr
	 * @param n
	 */
	public static <T extends Comparable<T>> T[] optimizedInsertionSort(T[] arr, int l, int r) {
		for(int i=l+1; i<= r; i++) {
			// 寻找元素arr[i]合适的插入位置，能够提前结束内层循环
			T e = arr[i];
			int j;
			for(j = i; j > l && ((Comparable<T>) e).compareTo(arr[j-1]) <= 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = e;
		}
		return arr;
	}
	
}
