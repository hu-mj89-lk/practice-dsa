package leetcode.editor.en;

/**
 * Problem : 346
 * Title : Moving Average from Data Stream
 */
class Driver_346 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        int[] data;
        int data_length;

        int window_size;

        public MovingAverage(int size) {
            this.data = new int[size];
            this.data_length = 0;
            this.window_size = size;
        }

        public double next(int val) {
            // 1. insert in data
            // case : data has space left
            if (data_length < window_size) {
                data[data_length] = val;
                data_length++;
            }
            // case : data is full
            else {
                // shift elements left
                for (int i = 1; i < data.length; i++) {
                    data[i - 1] = data[i];
                }

                // insert val at last of data
                data[data.length - 1] = val;
            }

            // calculate sum of all elements in data
            double total = 0;
            for (int i = 0; i < data.length; i++)
                total += data[i];

            // calculate average = sum of elements in data / length of data
            return (total / data_length);
        }
    }
    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
