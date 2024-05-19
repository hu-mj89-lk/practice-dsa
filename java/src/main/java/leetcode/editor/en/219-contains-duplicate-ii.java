package leetcode.editor.en;

import java.util.*;

/**
 * Problem : 219
 * Title : Contains Duplicate II
 */
class Driver_219 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            // return solutionMy(nums, k);
            // return solution1(nums, k);
            // return solution2(nums, k);
            return solution3(nums, k);
        }

        /**
         * approach : Optimization of solution1 using Hash Map
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private boolean solutionMy(int[] nums, int k) {
            Map<Integer, Integer> lastIndex = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!lastIndex.containsKey(nums[i])) {
                    lastIndex.put(nums[i], i);
                    continue;
                }

                if (i - lastIndex.get(nums[i]) <= k) {
                    return true;
                } else {
                    lastIndex.put(nums[i], i);
                }
            }
            return false;
        }

        /**
         * approach : maintain a sliding window of previous k elements and search current element in it
         * search : Constant time search, using Hash Table for sliding window
         * time complexity : O(n)
         * space complexity : O(k)
         */
        private boolean solution3(int[] nums, int k) {
            // using Hash Table for sliding window
            Set<Integer> slidingWindow = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (slidingWindow.contains(nums[i]))
                    return true;

                slidingWindow.add(nums[i]);
                if (slidingWindow.size() > k) {
                    slidingWindow.remove(nums[i - k]);
                }
            }
            return false;
        }

        /**
         * approach : maintain a sliding window of previous k elements and search current element in it
         * search : Binary search, using BST for sliding window
         * time complexity : O(nlog(k))
         * space complexity : O(k)
         */
        private boolean solution2(int[] nums, int k) {
            // using BST for sliding window; both TreeSet and TreeMap will work
            Map<Integer, Integer> slidingWindow = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (slidingWindow.containsKey(nums[i])) {
                    return true;
                }

                slidingWindow.put(nums[i], null);
                if (slidingWindow.size() > k) {
                    slidingWindow.remove(nums[i - k]);
                }
            }
            return false;
        }

        /**
         * approach : maintain a sliding window of previous k elements and search current element in it
         * search : Linear search, in-place
         * time complexity : O(n*min(n,k)) ~ O(n^2)
         * space complexity : O(1)
         */
        private boolean solution1(int[] nums, int k) {
            for (int i = 0; i < nums.length; i++) {
                int lowerBound = Math.max(i - k, 0);
                for (int j = i - 1; j >= lowerBound; j--) {
                    if (nums[i] == nums[j])
                        return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
