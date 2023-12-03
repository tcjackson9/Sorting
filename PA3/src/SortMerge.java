/*
 * Author: Tanner Jackson
 * Class: CSc 345
 * File: SortMerge.java
 * Purpose: This class is an implementation of Merge Sort,
 * that takes sorts an array into ascending order by recursively
 * dividing it into smaller parts, sorting the parts, and merging
 * them back together.
 */

public class SortMerge {
    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /*
     * mergeSort(array, leftIdx, rightIdx) -- recursive function
     * for the algorithm.
     */
    private static void mergeSort(int[] array, int leftIdx, int rightIdx) {
        if (leftIdx < rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            mergeSort(array, leftIdx, midIdx);
            mergeSort(array, midIdx + 1, rightIdx);
            merge(array, leftIdx, midIdx, rightIdx);
        }
    }

    /*
     * merge(array, leftIdx, midIdx, rightIdx) -- performs merging
     * process of the algorithm.
     */
    private static void merge(int[] array, int leftIdx, int midIdx, int rightIdx) {
        int sizeLeft = midIdx - leftIdx + 1;
        int sizeRight = rightIdx - midIdx;
        // Create temp arrays to hold subarrays
        int[] leftArr = new int[sizeLeft];
        int[] rightArr = new int[sizeRight];
        System.arraycopy(array, leftIdx, leftArr, 0, sizeLeft);
        System.arraycopy(array, midIdx + 1, rightArr, 0, sizeRight);
        // Merge temp arrays
        int i = 0, j = 0;
        int k = leftIdx;
        // Compare elements from left and right subarrays and merge into
        // main array.
        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                i++;
            } 
            else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArr
        while (i < sizeLeft) {
            array[k] = leftArr[i];
            i++;
            k++;
        }
        // Copy remaining elements of rightArr
        while (j < sizeRight) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }
}