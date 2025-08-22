package leetcode.editor.en;

/**
 * Problem : 303
 * Title : Range Sum Query - Immutable
 */
class Driver_303 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] nums;
        int[] prefixSum;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefixSum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                this.prefixSum[i] = nums[i] + (i > 0 ? this.prefixSum[i - 1] : 0);
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right] - prefixSum[left] + this.nums[left];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}