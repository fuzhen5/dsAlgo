package com.gbase.dsAlgo.search;

/**
 * 二分查找 对有序数组、列表进行二分查找 时间复杂度o(logn)
 * 
 * @author wangf
 *
 */
public class BinarySerach {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7};
		System.out.println(binarySerach(arr, arr.length, 7));
		System.out.println(binarySerach2(arr, arr.length, 0));
	}

	/**
	 * 从数组arr的前n个数中查找target
	 * 
	 * @param arr
	 * @param n
	 * @param target
	 * @return 若找到，则返回其index，否则，返回-1
	 */
	public static <T extends Comparable<T>> int binarySerach(T[] arr, int n, T target) {
		// 从数组arr[l,r]中查找target
		int l = 0, r = n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid].compareTo(target) == 0) {
				return mid;
			} else if (arr[mid].compareTo(target) > 0) {
				// arr[l...mid...r], arr[mid] > target, 搜索范围缩小至arr[l...mid-1]
				r = mid - 1;
			} else {
				// arr[l...mid...r], arr[mid] < target, 搜索范围缩小至arr[mid+1,r]
				l = mid + 1;
			}
		}
		return -1;
	}

	public static <T extends Comparable<T>> int binarySerach2(T[] arr, int n, T target) {
		// 从arr[l...r]中搜索target
		return bs(arr, 0, n - 1, target);
	}

	private static <T extends Comparable<T>> int bs(T[] arr, int l, int r, T target) {

		if (l > r) {
			return -1;
		}
		int mid = l + (r - l) / 2;
		if (target.compareTo(arr[mid]) == 0) {
			return mid;
		} else if (target.compareTo(arr[mid]) > 0) {
			return bs(arr, mid + 1, r, target);
		} else {
			return bs(arr, l, mid - 1, target);
		}
	}

}
