package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem : 752
 * Title : Open the Lock
 */
class Driver_752 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            return new SolutionMy().openLock(deadends, target);
        }

        private static class SolutionMy {
            private int openLock(String[] deadends, String target) {
                Set<String> deadEnds = Stream.of(deadends)
                        .collect(Collectors.toSet());

                int level = 0;
                Queue<String> queue = new LinkedList<>();
                queue.offer("0000");

                while (!queue.isEmpty()) {
                    int queueSize = queue.size();
                    for (int i = 0; i < queueSize; i++) {
                        String curr;
                        if (target.equals((curr = queue.poll()))) {
                            return level;
                        } else if (!deadEnds.add(curr)) {
                            continue;
                        }

                        queue.addAll(nextLevel(curr, deadEnds));
                    }
                    level++;
                }

                return -1;
            }

            private List<String> nextLevel(String current, Set<String> deadEnds) {
                List<String> result = new LinkedList<>();
                for (int wheel = 0; wheel < 4; wheel++) {
                    int digit = Character.getNumericValue(current.charAt(wheel));
                    StringBuilder stringBuilder = new StringBuilder(current);

                    stringBuilder.setCharAt(wheel, (char) (((digit + 1 + 10) % 10) + 48));
                    result.add(stringBuilder.toString());

                    stringBuilder.setCharAt(wheel, (char) (((digit - 1 + 10) % 10) + 48));
                    result.add(stringBuilder.toString());
                }

                return result;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
