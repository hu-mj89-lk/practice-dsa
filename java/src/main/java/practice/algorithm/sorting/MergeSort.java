package practice.algorithm.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, 6, 8, 3, 5, 0, 4};

        int[] sortedArr = mergeSort(arr, 0, arr.length - 1);

        for (int a : sortedArr) {
            System.out.printf("%d ", a);
        }
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end)
            return new int[]{arr[start]};

        int mid = (start + end) >> 1;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid + 1, end);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int l = 0, r = 0, k = 0; k < result.length; k++) {
            if (l >= left.length) {
                result[k] = right[r++];
            } else if (r >= right.length) {
                result[k] = left[l++];
            } else {
                if (left[l] < right[r]) {
                    result[k] = left[l++];
                } else {
                    result[k] = right[r++];
                }
            }
        }

        return result;
    }

}
