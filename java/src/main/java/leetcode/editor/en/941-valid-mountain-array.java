package leetcode.editor.en;

/**
 * Problem : 941
 * Title : Valid Mountain Array
 */
class Driver_941 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3)
                return false;

            int peak = 0;
            boolean flipped = false;
            for (int curr = 1; curr < arr.length; curr++) {
                int previous = arr[curr - 1];

                if (arr[curr] == previous)
                    return false;
                else {
                    if (flipped) {
                        if (arr[curr] > previous)
                            return false;
                    } else {
                        if (arr[curr] < previous) {
                            if (!flipped) {
                                flipped = true;
                                peak = curr - 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }

            return flipped && (0 < peak && peak < arr.length - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
