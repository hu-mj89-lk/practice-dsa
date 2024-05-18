package practice.algorithm.sorting;

public class MergeSort_Inplace {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};

        mergeSort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.printf("%d ", a);
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start == end || arr == null || arr.length < 2)
            return;

        int mid = (start + end) >> 1;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, mid + 1, end);
    }

    private static void merge(int[] arr, int s1, int e1, int s2, int e2) {
        // TODO : implement
    }

}
