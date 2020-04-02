package com.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuanFa {

	public static List<Integer> arrayList = new ArrayList<Integer>();

	public static void main(String[] args) {
		for (int j = 1; j <= 8; j++) {
			//arrayList.add((int) (Math.random() * 20));
			arrayList.add(10-j);
		}
		printArrayList();
		//partition(0, arrayList.size()-1);
		QuickSort(0, arrayList.size()-1);
		printArrayList();
		// printArrayList();

		// maopao_01();

		// maopao_02();

		// xuanze();

		// charu();

		// xier();
		// System.out.println(lt(7));

	}

	public static void xier() {
		int len = arrayList.size();
		int temp, gap = len / 2;
		while (gap > 0) {
			for (int i = gap; i < len; i++) {
				temp = arrayList.get(i);
				int preIndex = i - gap;
				while (preIndex >= 0 && arrayList.get(preIndex) > temp) {
					arrayList.set(preIndex + gap, arrayList.get(preIndex));
					preIndex -= gap;
				}
				arrayList.set(preIndex + gap, temp);
			}
			gap /= 2;
		}
		printArrayList();
	}

	/**
	 * 从第一个元素开始，该元素可以认为已经被排序；
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
	 * 将新元素插入到该位置后；
	 * 重复步骤2~5。
	 * */
	public static void charu() {
		System.out.println("插入排序");
		for (int i = 1; i < arrayList.size(); i++) {
			// 当前要插入的值
			int newValue = arrayList.get(i);
			int j = i - 1;
			// 把新的值插入到已经排序好的队列中
			while (j >= 0 && arrayList.get(j) > newValue) {
				arrayList.set(j + 1, arrayList.get(j));
				j--;
			}
			arrayList.set(j + 1, newValue);
		}
		printArrayList();

	}

	/**
	 * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
	 * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
	 * 以此类推，直到所有元素均排序完毕。
	 * */
	public static void xuanze() {
		System.out.println("选择排序");
		for (int i = 0; i < arrayList.size(); i++) {
			int index = i;
			//找到最小的元素，与第i位置元素替换
			for (int j = i + 1; j < arrayList.size(); j++) {
				if (arrayList.get(j) < arrayList.get(index)) {
					index = j;
				}
			}
			swapArrayList(i, index);
		}
		printArrayList();

	}

	/**
	 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
	 * 针对所有的元素重复以上的步骤，除了最后一个；
	 * 重复步骤1~3，直到排序完成。
	 * */
	public static void maopao_01() {
		System.out.println("冒泡排序-01");
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = 0; j < arrayList.size() - i - 1; j++) {
				if (arrayList.get(j + 1) < arrayList.get(j)) {
					swapArrayList(j, j + 1);
				}
			}
		}
		printArrayList();
	}

	/**
	 * 设置一标志性变量index,用于记录每趟排序中最后一次进行交换的位置。
	 * 由于index位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到index位置即可。
	 */
	public static void maopao_02() {
		System.out.println("冒泡排序-02");
		int i = arrayList.size() - 1;
		while (i > 0) {
			int index = 0;
			for (int j = 0; j < i; j++) {
				if (arrayList.get(j + 1) < arrayList.get(j)) {
					index = j;
					swapArrayList(j, j + 1);
				}
			}
			System.out.println("-----------------");
			i = index;
		}
		printArrayList();
	}

	/**
	 * 归并排序
	 *
	 * @param array
	 * @return
	 */
	public static int[] MergeSort(int[] array) {
		if (array.length < 2){
			return array;
		}
		int mid = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		return merge(MergeSort(left), MergeSort(right));
	}
	/**
	 * 归并排序——将两段排序好的数组结合成一个排序数组
	 *
	 * @param left
	 * @param right
	 * @return
	 */
	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		for (int index = 0, i = 0, j = 0; index < result.length; index++) {
			if (i >= left.length){
				result[index] = right[j++];
			}
			else if (j >= right.length){
				result[index] = left[i++];
			}
			else if (left[i] > right[j]){
				result[index] = right[j++];
			}
			else{
				result[index] = left[i++];
			}
		}
		return result;
	}

	
	//快速排序
	public static void QuickSort( int start, int end) {
        int smallIndex = partition(start, end);
        if (smallIndex > start){
			QuickSort(start, smallIndex - 1);
		}
        if (smallIndex < end){
			QuickSort(smallIndex + 1, end);
		}
    }
	
	//找出smallIndex位置 value，smallIndex左侧的值都比value小 右侧都比value大
	public static int partition(int start, int end) {
		//int pivot = (int) (start + Math.random() * (end - start + 1));
		//System.out.println(pivot);
		int smallIndex = start - 1;
		//swapArrayList(pivot, end);
		System.out.println("开始循环交换");
		for (int i = start; i <= end; i++){
			if (arrayList.get(i) <= arrayList.get(end)) {
				smallIndex++;
				if (i > smallIndex){
					swapArrayList(i, smallIndex);
				}
			}
		}
		System.out.println("smallIndex:"+smallIndex);
		return smallIndex;
	}

	public static void swapArrayList(int i, int j) {
		int temp = 0;
		temp = arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, temp);
		System.out.print("交换标志位:" + i + "-" + j + ",更新List:");
		printArrayList();
	}

	public static void printArrayList() {
		for (int value : arrayList){
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static int lt(int n) {
		if (n == 1){
			return 1;
		}
		if (n == 2){
			return 2;
		}
		return lt(n - 1) + lt(n - 2);
	}

}
