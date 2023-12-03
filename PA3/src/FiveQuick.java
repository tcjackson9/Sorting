/*
 * Author: Tanner Jackson
 * Class: CSc 345
 * File: FiveQuick.java
 * Purpose: Improved version of traditional quick sort, it
 * uses two pivot elements to partition array into three 
 * sections. Reduces number of comparisons and improve efficieny
 * of the sorting process.
 */
public class FiveQuick {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        fiveWayQuickSort(arr, 0, arr.length - 1);
    }
    /*
     * fiveWayQuickSort(arr, lowIdx, highIdx) -- performs the sorting
     * algorithm, uses pivots to partition and then recursively sort.
     */
    private static void fiveWayQuickSort(int[] arr, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) {
            return;
        }
        if (arr[lowIdx] > arr[highIdx]) {
            swap(arr, lowIdx, highIdx);
        }
        // Set pivot elements.
        int pivot1 = arr[lowIdx];
        int pivot2 = arr[highIdx];
        // Set pointers for partitioning.
        int left = lowIdx + 1;
        int right = highIdx - 1;
        int i = left;
        // Partitioning array based on pivot elements.
        while (i <= right) {
            if (arr[i] < pivot1) {
                swap(arr, i, left);
                i++;
                left++;
            } 
            else if (arr[i] > pivot2) {
                while (i <= right && arr[right] > pivot2) {
                    right--;
                }
                if (i < right) {
                    swap(arr, i, right);
                    right--;
                }
                if (arr[i] < pivot1) {
                    swap(arr, i, left);
                    left++;
                }
                i++;
            } 
            else {
                i++;
            }
        }
        swap(arr, lowIdx, --left);
        swap(arr, highIdx, ++right);
        // Recursively sort partitions.
        fiveWayQuickSort(arr, lowIdx, left - 1);
        fiveWayQuickSort(arr, left + 1, right - 1);
        fiveWayQuickSort(arr, right + 1, highIdx);
    }
    /*
     * swap(arr, a, b) -- helper method to swap elements
     * in the array.
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}