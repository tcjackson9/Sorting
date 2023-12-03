/*
 * Author: Tanner Jackson
 * Class: CSc 345
 * File: SortGrid.java
 * Purpose: This class enables sorting of a grid by converting
 * it into a 1D array, performing a merge sort on the array.
 * And then putting the elements back into the grid structure.
 */
public class SortGrid {
	/*
	 * sort(g) -- takes an input grid g and sorts it
	 * in ascending order.
	 */
    public static void sort(Grid g) {
        int gridSize = g.size();
        int[][] sortedArray = new int[gridSize][gridSize];
        int[] elements = new int[gridSize * gridSize];
        // Extract elements from grid and store into 
        // 1D array for sorting.
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                elements[row * gridSize + col] = g.getIntVal(row, col);
            }
        }
        mergeSort(elements, 0, elements.length - 1);
        // Place sorted elements back into grid structure.
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                sortedArray[i][j] = elements[i * gridSize + j];
                g.setIntVal(i, j, sortedArray[i][j]);
            }
        }
    }
    /*
     * mergeSort(arr, left, right) -- performs a merge sort for a given
     * integer array from left to right.
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    /*
     * merge(arr, left, mid, right) -- merges two sorted integer arrays.
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        // Copy elements to temp arrays.
        for (int i = 0; i < leftSize; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        // Merge two sub-arrays back into original array.
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } 
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements from leftArr and rightArr
        // to original array.
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}