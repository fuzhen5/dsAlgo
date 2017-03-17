package com.gbase.dsAlgo.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import com.gbase.dsAlgo.sort.InsertionSort;

public class SortUtil {
	
	/**
	 * 生成具有 n 个元素的随机整形数组，每个元素的范围为[rangeL,rangeR]
	 * @param n
	 * @param rangeL
	 * @param rangeR
	 * @return
	 */
	public static  Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
		assert(rangeR >= rangeL);
		Integer[] arr = new Integer[n];
		Random random = new Random();
		for(int i = 0; i < n; i++) {
			arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
		}
		return arr;
	}
	
	/**
	 * 生产具有n个元素的近乎有序的数组（从小到大有序）
	 * @param n
	 * @param swapTimes
	 * @return
	 */
	public static  Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i;
		}
		Random random = new Random();
		for(int i = 0; i < swapTimes; i++) {
			int indexX = random.nextInt(n);
			int indexY = random.nextInt(n);
			Integer tmp = arr[indexX];
			arr[indexX] = arr[indexY];
			arr[indexY] = tmp;
		}
		return arr;
	}
	
	/**
	 * 打印数组
	 * @param arr
	 */
	public static <T> void printArray(T[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 检验数组是否已经排序
	 * 所有排序算法的默认实现，都是按照从小到大的顺序进行排序的
	 * 这里检验数组的前一个元素是否都不比后一个元素大
	 * @param arr
	 * @param n
	 * @return
	 */
	public static<T extends Comparable<T>> boolean isSorted(T[] arr, int n) {
		for(int i = 0; i < n-1; i++) {
			if(((Comparable<T>) arr[i+1]).compareTo(arr[i]) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static<T extends Comparable<T>> boolean isSorted(T[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			if(((Comparable<T>) arr[i+1]).compareTo(arr[i]) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static<T> void testSort(Class<T> cls, String methodName, Integer[] arr, int n) {
		try {
			Method[] methods = cls.getDeclaredMethods();
			for(Method method : methods) {
				if(method.getName().equals(methodName)  && method.getParameterTypes().length == 2) {
					Long start = System.currentTimeMillis();
					method.invoke(cls, new Object[]{arr,n});
					Long end = System.currentTimeMillis();
					assert(isSorted(arr,n));
					System.out.println(methodName + " : " + (end-start)/1000.0 + " s");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		Integer[] arr = generateRandomArray(100, 3, 400);
		System.out.println("before sort ...");
		System.out.println(Arrays.toString(arr));
		InsertionSort.insertionSort(arr,arr.length);
		System.out.println("after sort ...");
		printArray(arr);
	}
}
