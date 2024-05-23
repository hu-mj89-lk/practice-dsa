package interview.solved;

public class Tsys_R2_2 {

    public static void main(String[] args) {
        problem1();
        System.out.println("----------");
        problem2();
        System.out.println("----------");
    }

    /**
     * Given a matrix, print alternate rows in zig-zag order
     * <p>
     * Input =
     * <p>
     * 1   2   3
     * 4   5   6
     * 7   8   9
     * <p>
     * Output = 1,2,3,6,5,4,7,8,9
     */
    public static void problem1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };

        int j = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            boolean isEven = i % 2 == 0;
            while (j >= 0 && j < row.length) {
                System.out.print(row[j] + " ");
                if (isEven) {
                    j++;
                } else {
                    j--;
                }
            }
            if (isEven) {
                j--;
            } else {
                j++;
            }
        }
        System.out.println();
    }

    /**
     * Print a character as many times as mentioned in the frequency against it.
     * <p>
     * Input = "a2b3c2d2a3b2c3e2f2";
     * Output = "aabbbccddaaabbccceeff";
     * <p>
     * 2nd Example:
     * Input = "a11b3c2d2a3b2c3e2f2";
     * Output = "aaaaaaaaaaabbbccddaaabbccceeff";
     */
    public static void problem2() {
        String input = "a11b3c2d2a3b2c3e2f2";
        char[] chars = input.toCharArray();

        char prev = chars[0];
        StringBuilder frequency = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                for (int k = 0; k < Integer.parseInt(frequency.toString()); k++) {
                    System.out.print(prev + "");
                }

                // update
                prev = c;
                frequency = new StringBuilder();
            } else {
                frequency.append(c);
            }
        }

        //left overs
        for (int k = 0; k < Integer.parseInt(frequency.toString()); k++) {
            System.out.print(prev + "");
        }
        System.out.println();
    }
}
