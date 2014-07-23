package com.josenaves.algorithms.sorting;

/**
 * Selection sort Java implementation.
 * The basic idea is to divide the list in two portions - an unsorted portion and a sorted portion.
 * At each step of the algorithm, a number is moved from the unsorted portion to the sorted portion of the list
 * until it eventualy the entire list is sorted.
 * Based on CS50 video http://youtu.be/f8hXR_Hvybo
 * 
 * Algorithm Analysis: running time for worst case =  O(nö2)
 * 
 * @author josenaves
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] list = {23, 42, 4, 16, 8, 15};

		SelectionSort.printList(list);

		for (int i = 0; i < list.length-1; i++) {
			// find the minimum element
			// minimum is the index of the minimum element
			int minimum = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[j] < list[minimum]) minimum = j;
			}
			if (minimum != i) SelectionSort.swap(list, i, minimum);
		}
		SelectionSort.printList(list);
	}
	
	public static void swap(int[] list, int a, int b) {
		int aux = list[a];
		list[a] = list[b];
		list[b] = aux;
	}

	public static void printList(int[] list) {
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
