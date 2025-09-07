package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem : 39
 * Title : Combination Sum
 */
class Driver_39 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Driver_39().new Solution()
                .combinationSum(
                        new int[]{2, 3, 5},
                        8
                );
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return new Solution1().combinationSum(candidates, target);
        }

        private static class Solution1 {
            private List<List<Integer>> combinationSum(int[] candidates, int target) {
                // sort candidates
                // time complexity : O(nLog(n)) , space complexity : O(1)
                Arrays.sort(candidates);

                return solutionInternal(candidates, 0, candidates.length - 1, target);
            }

            private List<List<Integer>> solutionInternal(int[] candidates, int start, int end, int target) {
                if (start > end) {
                    return new ArrayList<>();
                }

                List<List<Integer>> result = new ArrayList<>();
                int i = start, current;
                do {
                    current = candidates[i];
                    int count = maxPossibleCounts(current, target);

                    while (count > 0) {
                        int newCurrent = current * count;
                        int newTarget = target - newCurrent;
                        if (newCurrent == target) {
                            List<Integer> combination = new ArrayList<>();
                            for (int j = count; j > 0; j--) {
                                combination.add(current);
                            }
                            result.add(combination);
                        } else {
                            List<List<Integer>> intermediateResult = solutionInternal(
                                    candidates,
                                    i + 1,
                                    candidates.length - 1,
                                    newTarget
                            );

                            for (List<Integer> combination : intermediateResult) {
                                for (int j = count; j > 0; j--) {
                                    combination.add(current);
                                }
                                result.add(combination);
                            }
                        }
                        count--;
                    }
                    i++;
                } while (i <= end && current <= target);

                return result;
            }

            private int maxPossibleCounts(int current, int target) {
                int count = 0;
                while (target >= current) {
                    target -= current;
                    count++;
                }
                return count;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}