package com.gbase.dsAlgo.sort;

import com.gbase.dsAlgo.util.SortUtil;

public class SelectionSort {

	public static void main(String[] args) {
		Integer[] arr = SortUtil.generateRandomArray(10, 3, 30);
		
		SortUtil.testSort(SelectionSort.class, "selectionSort", arr, arr.length);
		SortUtil.printArray(arr);
	}
	
	/**
	 * 选择排序， 从小到大排序
	 * 对数组arr的前n个元素排序
	 * @param arr
	 * @param n
	 * @return
	 */
	public static <T extends Comparable<T>> T[] selectionSort(T[] arr, int n) {
		for(int i = 0; i < n - 1; i++) {
			// 寻找 [i,n) 区间里的最小值
			int minIndex = i;
			for(int j = i+1; j < n; j++) {
				if(((Comparable<T>) arr[minIndex]).compareTo(arr[j]) > 0) {
					minIndex = j;
				}
			}
			//内层循环结束后，进行一次排序
			T tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

}
