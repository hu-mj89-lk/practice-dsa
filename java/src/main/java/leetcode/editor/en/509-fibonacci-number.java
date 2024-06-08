package leetcode.editor.en;

import java.util.Map;

/**
 * Problem : 509
 * Title : Fibonacci Number
 */
class Driver_509 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            // return solution1(n);
            // return solution2(n);
            // return solution3(n, new HashMap<>(Map.of(0, 0, 1, 1)));
            return solution4(n);
        }

        /**
         * approach : bottom-up
         * <p>
         * time complexity : O(n)
         * space complexity : O(1)
         */
        private int solution4(int n) {
            if (n < 2) {
                return n;
            }
            int n_2 = 0, n_1 = 1;
            for (int i = 2; i <= n; i++) {
                int fib = n_1 + n_2;
                n_2 = n_1;
                n_1 = fib;
            }

            return n_1;
        }

        /**
         * approach : top-down using memoization
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private int solution3(int n, Map<Integer, Integer> cache) {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }

            cache.put(n, solution3(n - 2, cache) + solution3(n - 1, cache));

            return cache.get(n);
        }

        /**
         * approach : bottom-up w/ tabulation
         * <p>
         * time complexity : O(n)
         * space complexity : O(n)
         */
        private int solution2(int n) {
            if (n < 2) {
                return n;
            }

            int[] cache = new int[n];
            cache[1] = 1;

            for (int i = 2; i < n; i++) {
                cache[i] = cache[i - 1] + cache[i - 2];
            }

            return cache[n - 1] + cache[n - 2];
        }

        /**
         * approach : recursion
         * <p>
         * time complexity : O(2^n)
         * space complexity : O(n)
         */
        private int solution1(int n) {
            if (n < 2) {
                return n;
            }

            return solution1(n - 1) + solution1(n - 2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
