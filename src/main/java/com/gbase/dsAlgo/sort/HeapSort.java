package com.gbase.dsAlgo.sort;

import com.gbase.dsAlgo.util.SortUtil;

public class HeapSort {
	
	/**
	 * 对数组arr前n个元素进行排序（堆排序）
	 * @param arr
	 * @param n
	 */
	public static<T extends Comparable<T>> void heapSort(T[] arr, int n) {
		//heapify操作，构造一个堆
		for(int i = (n-1)/2; i >= 0; i--) {
			shiftDown(arr, n, i);
		}
		
		for(int i = n-1; i > 0; i--) {
			SortUtil.swap(arr, 0, i);
			shiftDown(arr, i, 0);
		}
	}

	private static<T extends Comparable<T>> void shiftDown(T[] arr, int n, int k) {
		T tmp = arr[k];
		//只有该索引为k位置的元素不是叶子节点时，才继续
		while(2*k+1 <= n-1) {
			int j = 2*k+1;
			if(j+1 <= n-1 && arr[j+1].compareTo(arr[j]) > 0) {
				j++;
			}
			//data[j]是 data[2*k]和data[2*k+1]中的最大值
			if(tmp.compareTo(arr[j])  >= 0) {
				break;
			}
			arr[k] = arr[j];
			k = j;
		}
		arr[k] = tmp;
	} 
	
	public static void main(String[] args) {
		int n = 1000000;
		// 测试1 一般性测试
		System.out.println("Test for Random Array, size = " + n + " random range[0, " + n + "]");
		Integer[] arr = SortUtil.generateRandomArray(n, 0, n);
		Integer[] arr1 = arr.clone();
		
		SortUtil.testSort(HeapSort.class, "heapSort", arr, n);
		SortUtil.testSort(QuickSort.class, "quickSort", arr1, n);
	}

}
