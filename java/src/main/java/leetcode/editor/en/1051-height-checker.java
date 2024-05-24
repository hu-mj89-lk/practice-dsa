package leetcode.editor.en;

/**
 * Problem : 1051
 * Title : Height Checker
 */
class Driver_1051 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int heightChecker(int[] heights) {
            int[] expected = new int[heights.length];

            System.arraycopy(heights, 0, expected, 0, heights.length);

            // selectionSort(expected, 0, expected.length - 1);
            // bubbleSort(expected, 0, expected.length - 1);
            insertionSort(expected, 0, expected.length - 1);

            int k = 0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] != expected[i])
                    k++;
            }

            return k;
        }

        // selection sort
        private void selectionSort(int[] arr, int start, int end) {
            for (int i = start; i <= end; i++) {
                int min = i;
                // find minimum in rest
                for (int j = i; j <= end; j++) {
                    if (arr[j] < arr[min])
                        min = j;
                }

                // swap
                if (min != i) {
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }
            }
        }

        // bubble sort
        private void bubbleSort(int[] arr, int start, int end) {
            boolean hasSwapped = true;
            while (hasSwapped) {
                hasSwapped = false;
                for (int i = end; i > 0; i--) {
                    if (arr[i] < arr[i - 1]) {
                        // swap
                        int temp = arr[i - 1];
                        arr[i - 1] = arr[i];
                        arr[i] = temp;
                        hasSwapped = true;
                    }
                }
            }
        }

        // insertion sort
        private void insertionSort(int[] arr, int start, int end) {
            for (int i = 1; i < arr.length; i++) {

                // find suitable position
                int current = i;
                while (current > 0 && arr[current - 1] > arr[current]) {
                    // swap
                    int temp = arr[current - 1];
                    arr[current - 1] = arr[current];
                    arr[current] = temp;
                    current--;
                }

            }

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
