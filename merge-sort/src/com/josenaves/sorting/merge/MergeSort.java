package com.josenaves.sorting.merge;

/**
 * Classical MergeSort - divide and conquer from John von Neumann.
 * It needs extra memory for recursion and new arrays allocation.
 * In a worst case cenario, it is O(n log n)
 * @author @josenaves
 */
public class MergeSort {
	
	public static final int arr[] = {72, 10, 6, 19, 20, 5, 97, 27, 18, 55};

	public static void main(String[] args) {
		printArray(arr);
		int[] sortedArr = mergeSort(arr);
		printArray(sortedArr);
	}
	
	/**
	 * Makes a merge sorting
	 * @param a array of integers to sort
	 * @return
	 */
	public static int[] mergeSort(int[] a) {
		int n = a.length;
		
		// array is already sorted
		if (n < 2) return a;

		// find the middle position
		int mid = n/2;
		
		// create 2 arrays
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		// fill them all
		for (int i = 0; i < mid; i++)  left[i] = a[i];
		for (int i = mid; i < n; i++)  right[i-mid] = a[i];

		// slice it again until there's only one element
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}

	/**
	 * Merge elements of two arrays and keep them sorted.
	 * @param a array
	 * @param p index
	 * @param q index
	 * @param r index
	 * @return
	 */
	private static int[] merge(int[] leftArr, int[] rightArr) {
		int[] mergedArr = new int[leftArr.length + rightArr.length];
		
		int lengthLeft = leftArr.length;
		int lengthRight = rightArr.length;
		
		int i = 0; // index on left array
		int j = 0; // index on right array
		
		// index in merged array
		int k = 0;
		
		while (i < lengthLeft && j < lengthRight) {
			if (leftArr[i] <= rightArr[j]) 
				mergedArr[k++] = leftArr[i++];
			else 
				mergedArr[k++] = rightArr[j++];
		}
		
		while (i < lengthLeft) {
			mergedArr[k++] = leftArr[i++];
		}
		
		while (j < lengthRight) {
			mergedArr[k++] = rightArr[j++];
		}
		
		return mergedArr;
	}
	
	static void printArray(int a[]) {
		for (int e: a) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
