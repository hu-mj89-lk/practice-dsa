package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : 359
 * Title : Logger Rate Limiter
 */
class Driver_359 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Logger {

        private final Map<String, Integer> messageTimestampMap;

        public Logger() {
            this.messageTimestampMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!messageTimestampMap.containsKey(message) ||
                    timestamp - messageTimestampMap.get(message) >= 10) {
                messageTimestampMap.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
