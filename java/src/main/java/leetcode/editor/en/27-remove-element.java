package leetcode.editor.en;

/**
 * Problem : 27
 * Title : Remove Element
 */
class Driver_27 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int k = 0;
            int last = nums.length - 1;

            for (int i = 0; i <= last; i++) {
                if (nums[i] == val) {
                    while (last > i) {
                        if (nums[last] == val)
                            last--;
                        else {
                            nums[i] = nums[last--];
                            k++;
                            break;
                        }
                    }
                } else {
                    k++;
                }
            }

            return k;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
