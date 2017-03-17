package com.gbase.dsAlgo.sort;

import com.gbase.dsAlgo.util.SortUtil;

public class MergeSort {
	
	
	public static void main(String[] args) {
		int n = 1000000;
		Integer[] arr1 = SortUtil.generateRandomArray(n, 0, 50000000);
		Integer[] arr2 = arr1.clone();
//		SortUtil.testSort(InsertionSort.class, "optimizedInsertionSort", arr1, n);
//		mergeSort(arr2,n);
		SortUtil.testSort(MergeSort.class, "mergeSort", arr2, n);
//		SortUtil.testSort(MergeSort.class, "mergeSortBU", arr1, n);
		
	}
	
	/**
	 * 自底向上构建归并排序
	 * @param arr
	 * @param n
	 */
	public static<T extends Comparable<T>> void mergeSortBU(T[] arr, int n) {
		for(int sz = 1; sz <= n; sz += sz) {
			for(int i = 0; i+sz < n; i += sz + sz) {
				//对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
				if(arr[i+sz-1].compareTo(arr[i+sz]) > 0) {
					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));
				}
			}
		}
	}
	
	/**
	 * 自顶向下构建归并排序算法
	 * @param arr
	 * @param n
	 */
	public static<T extends Comparable<T>> void mergeSort(T[] arr, int n) {
		mergeSort(arr, 0 , n-1);
	}
	
	/**
	 * 递归使用归并排序，对arr[l...r]的范围进行排序
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
		//处理递归的终止条件
//		if(l >= r) {
//			return ;
//		}
		//当数组元素较少时，采用插入排序优化
		if(r-l <= 15) {
			InsertionSort.optimizedInsertionSort(arr, l, r);
			return;
		}
		int mid = l + (r-l) / 2; 
		mergeSort(arr,l,mid);
		mergeSort(arr, mid+1,r);
		if(arr[mid].compareTo(arr[mid+1]) > 0) {
			merge(arr,l,mid,r);
		}
	}
	

	/**
	 * 将arr[l,mid]和arr[mid+1,r]两部分进行归并
	 * @param arr
	 * @param l
	 * @param mid
	 * @param r
	 * @return
	 */
	private static<T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
		T[] aux =  arr.clone();
		
		int i = l;
		int j = mid + 1;
		for(int k = l; k <= r; k++) {
			if(i > mid) {
				arr[k] = aux[j-l];
				j++;
			} else if(j > r) {
				arr[k] = aux[i-l];
				i++;
			}else if(aux[i-l].compareTo(aux[j-l]) < 0) {
				arr[k] = aux[i-l];
				i++;
			} else {
				arr[k] = aux[j-l];
				j++;
			}
		}
	}

}
