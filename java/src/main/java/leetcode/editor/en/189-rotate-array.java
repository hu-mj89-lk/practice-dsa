package leetcode.editor.en;

/**
 * Problem : 189
 * Title : Rotate Array
 */
class Driver_189 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;

            int start = 0, count = 0;
            while (count < nums.length) {
                int current = start, prevVal = nums[start];
                do {
                    int next = (current + k) % nums.length;

                    int temp = nums[next];
                    nums[next] = prevVal;
                    prevVal = temp;
                    current = next;
                    count++;
                } while (start != current);
                start++;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
