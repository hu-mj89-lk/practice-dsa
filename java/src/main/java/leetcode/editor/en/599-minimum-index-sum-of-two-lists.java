package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem : 599
 * Title : Minimum Index Sum of Two Lists
 */
class Driver_599 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> currentResults = null;

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }

            int leastIdx = Integer.MAX_VALUE;
            for (int i = 0; i < list2.length; i++) {
                int newLeastIdx;
                if (!map.containsKey(list2[i]) ||
                        (newLeastIdx = i + map.get(list2[i])) > leastIdx)
                    continue;

                if (newLeastIdx < leastIdx) {
                    currentResults = new ArrayList<>();
                }
                currentResults.add(list2[i]);
                leastIdx = newLeastIdx;
            }

            String[] results = new String[currentResults.size()];
            for (int i = 0; i < currentResults.size(); i++) {
                results[i] = currentResults.get(i);
            }
            return results;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
