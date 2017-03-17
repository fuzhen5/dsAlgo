package com.gbase.dsAlgo.util;

import java.util.Random;

public class SortExtUtil {
	
	public static void main(String[] args) {
		Integer[] arr = {1,3,100,299};
		getMaxAndMin(arr);
		Integer e = getN(arr, 1);
		System.out.println(e);
	}
	
	/**
	 * 获得数组的最大值和最小值
	 * @param arr
	 */
	public static<T extends Comparable<T>> void getMaxAndMin(T[] arr) {
		int maxIndex = 0;
		int minIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].compareTo(arr[maxIndex]) > 0) {
				maxIndex = i;
			}
			if(arr[i].compareTo(arr[minIndex]) < 0) {
				minIndex = i;
			}
		}
		System.out.println("arr min elements: " + arr[minIndex] + " index: " + minIndex + "\narr max elements: " + arr[maxIndex] + " index: " + maxIndex);
	}
	
	/**
	 * 获取数组中第n大的元素
	 * @param arr
	 * @return
	 */
	public static<T extends Comparable<T>> T getN(T[] arr, int k) {
		
		return getN(arr, 0, arr.length-1, k);
		
	}

	/**
	 * 获取数组 arr[l...r]中第k个最大的数      l <=k <= r
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private static<T extends Comparable<T>> T getN(T[] arr, int l, int r, int k) {
		if(l > r) {
			return null;
		}
		int p = partition(arr, l, r);
		int index = r - k + 1;
		if(p < index) {
			getN(arr,p+1, r, k);
		} if(p > index) {
			getN(arr, l, p-1, p-index);
		}
		return arr[index];
	}

	private static<T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		int index = new Random().nextInt(r - l + 1) + l;
		SortUtil.swap(arr, l, index);
		
		T v = arr[l];
		int i = l+1, j = r;
		while(i < j) {
			while(arr[i].compareTo(v) < 0) {
				i++;
			}
			while(arr[j].compareTo(v) > 0) {
				j--;
			}
			SortUtil.swap(arr, i, j);
			i++;
			j--;
		}
		SortUtil.swap(arr, l, j);
		
		return j;
	}

}
