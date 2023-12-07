import java.util.Arrays;

public class GenericSortingAlgorithms<T extends Comparable<T>> {

    public T[] insertionSort(T[] arr) {
        int n = arr.length;
        T[] sortedArray = Arrays.copyOf(arr, n);

        for (int i = 1; i < n; ++i) {
            T key = sortedArray[i];
            int j = i - 1;
            while (j >= 0 && sortedArray[j].compareTo(key) > 0) {
                sortedArray[j + 1] = sortedArray[j];
                j = j - 1;
            }
            sortedArray[j + 1] = key;
        }

        return sortedArray;
    }

    public T[] bubbleSort(T[] arr) {
        int n = arr.length;
        T[] sortedArray = Arrays.copyOf(arr, n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j].compareTo(sortedArray[j + 1]) > 0) {
                    T temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    public T[] mergeSort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr; // Already sorted
        }

        int n = arr.length;
        int mid = n / 2;

        T[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        T[] rightArray = Arrays.copyOfRange(arr, mid, n);

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        return merge(leftArray, rightArray);
    }

    private T[] merge(T[] left, T[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        T[] mergedArray = Arrays.copyOf(left, leftLength + rightLength);

        while (i < leftLength && j < rightLength) {
            if (left[i].compareTo(right[j]) <= 0) {
                mergedArray[k++] = left[i++];
            } else {
                mergedArray[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            mergedArray[k++] = left[i++];
        }

        while (j < rightLength) {
            mergedArray[k++] = right[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        Integer[] intArray = { 9, 5, 2, 3, 8, 2, 9, 4, 1 };
        String[] stringArray = { "peach", "apple", "papaya", "orange" };

        GenericSortingAlgorithms<Integer> intSorter = new GenericSortingAlgorithms<>();
        GenericSortingAlgorithms<String> stringSorter = new GenericSortingAlgorithms<>();

        System.out.println("Original intArray: " + Arrays.toString(intArray));
        Integer[] intInsertionSorted = intSorter.insertionSort(intArray.clone());
        System.out.println("Insertion Sorted intArray: " + Arrays.toString(intInsertionSorted));

        System.out.println("Original stringArray: " + Arrays.toString(stringArray));
        String[] stringBubbleSorted = stringSorter.bubbleSort(stringArray.clone());
        System.out.println("Bubble Sorted stringArray: " + Arrays.toString(stringBubbleSorted));

        Integer[] intArrayForMergeSort = { 4, 2, 7, 1, 3, 9, 2 };
        String[] stringArrayForMergeSort = { "peach", "apple", "papaya", "orange" };

        System.out.println("Original intArray for Merge Sort: " + Arrays.toString(intArrayForMergeSort));
        Integer[] intMergeSorted = intSorter.mergeSort(intArrayForMergeSort.clone());
        System.out.println("Merge Sorted intArray: " + Arrays.toString(intMergeSorted));

        System.out.println("Original stringArray for Merge Sort: " + Arrays.toString(stringArrayForMergeSort));
        String[] stringMergeSorted = stringSorter.mergeSort(stringArrayForMergeSort.clone());
        System.out.println("Merge Sorted stringArray: " + Arrays.toString(stringMergeSorted));
    }
}
