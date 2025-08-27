package leetcode.editor.en;

/**
 * Problem : 167
 * Title : Two Sum II - Input Array Is Sorted
 */
class Driver_167 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // return solutionMy(numbers, target);
            return solution1(numbers, target);
        }

        /**
         * approach : two pointer
         * <p>
         * time complexity : O(n)
         * space complexity : O(1)
         */
        private int[] solution1(int[] numbers, int target) {
            int start = 0, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[start] + numbers[end];

                if (sum == target) {
                    return new int[]{start + 1, end + 1};
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }

            return null;
        }

        /**
         * approach : iterate over the array and, for every element Binary Search its compliment
         * <p>
         * time complexity : O(nLog(n))
         * space complexity : O(1)
         */
        private int[] solutionMy(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int compliment = target - numbers[i];

                /*
                 * Binary Search (Iterative)
                 *
                 * time complexity : O(log(n))
                 * space complexity : O(1)
                 */
                int complimentIdx = -1, start = i + 1, end = numbers.length - 1;
                while (start <= end) {
                    int mid = (start + end) >> 1;
                    if (compliment == numbers[mid]) {
                        complimentIdx = mid;
                    } else if (compliment < numbers[mid]) {
                        end = mid - 1;
                    } else if (compliment > numbers[mid]) {
                        start = mid + 1;
                    }
                }

                if (complimentIdx < 0) {
                    continue;
                }

                return new int[]{i + 1, complimentIdx + 1};
            }

            return null;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
