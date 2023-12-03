/*
 * Author: Tanner Jackson
 * Class: CSc 345
 * File: LocSort.java
 * Purpose: Intitializes sorting algorithms that are designed
 * to optimize memory access by considering restricted range when
 * performing sorting operations.
 */
public class LocSort {
	/*
	 * selectionSort(array, dValue) -- sorts an array using selection
	 * sort. Limits number of elements examined.
	 */
	public static void selectionSort(int[] array, int dValue) {
        for (int index = 0; index < array.length - 1; index++) {
            int minIndex = index;
            for (int j = index + 1; j < Math.min(array.length, index + dValue + 1); j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = temp;
        }
    }
	/*
	 * insertionSort(array, dValue) -- sorts an array using insertion sort, examines
	 * a limited range of elements for each item to determine correct position 
	 * in sorted sequence.
	 */
    public static void insertionSort(int[] array, int dValue) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    /*
     * heapSort(array, dValue) -- sorts an array using heap sort. Adapts heapify process
     * to consider a specified range for each element in the heap.
     */
    public static void heapSort(int[] array, int dValue) {
        int size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i, dValue);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0, dValue);
        }
    }
    /*
     * heapify(array, size, index, dValue) -- rearranges heap given the index and 
     * considering a specified range.
     */
    private static void heapify(int arr[], int size, int index, int dValue) {
        int largest = index;
        for (int j = 1; j <= dValue; j++) {
            int child = index * dValue + j;
            if (child < size && arr[child] > arr[largest]) {
                largest = child;
            }
        }
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest, dValue);
        }
    }
}