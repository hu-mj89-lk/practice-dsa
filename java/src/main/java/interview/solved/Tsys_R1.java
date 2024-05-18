package interview.solved;

import java.util.concurrent.atomic.AtomicInteger;

public class Tsys_R1 {

    public static void main(String[] args) {
        problem1();
        System.out.println("----------");
        problem2();
        System.out.println("----------");
        problem3();
        System.out.println("----------");
    }

    /**
     * Find the pivotal index from an int array,
     * such that left-sum (sum of all elements to the left) and right-sum((sum of all elements to the right))
     * around that index are same.
     * Input : 1, 4, 5, 2, 3
     * Output : 2
     */
    public static void problem1() {
        int[] arr = new int[]{1, 4, 5, 2, 3};

        // create prefix sums
        int[] sums = createPrefixSums(arr);
        int result = -1;

        for (int i = 1; i < sums.length; i++) {
            int sumLeft = sums[i] - sums[0] - arr[i - 1];
            int sumRight = sums[sums.length - 1] - sums[i];
            if (sumLeft == sumRight) {
                result = i;
                break;
            }
        }

        if (result > -1)
            System.out.println("RESULT :: " + (result - 1));
        else
            System.out.println("NOT FOUND");
    }

    private static int[] createPrefixSums(int[] arr) {
        int[] sums = new int[arr.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + arr[i - 1];
        }
        return sums;
    }

    /**
     * Print character and its continuous frequency.
     * Input : aabbbccddaaabbccceeff
     * output : a2b3c2d2a3b2c3e2f2
     */
    public static void problem2() {
        String input = "aabbbccddaaabbccceeff";

        AtomicInteger arPrev = new AtomicInteger(-1);
        AtomicInteger arPrevCount = new AtomicInteger(0);
        input.chars()
                .forEach(curr -> {
                    if (arPrev.get() == -1) {// default
                        arPrev.set(curr);
                        arPrevCount.getAndIncrement();
                    } else {
                        if (curr == arPrev.get()) {
                            arPrevCount.incrementAndGet();
                        } else {
                            System.out.printf("%s%d", (char) arPrev.get(), arPrevCount.get());
                            arPrev.set(curr);
                            arPrevCount.set(1);

                        }
                    }
                });
        System.out.printf("%s%d%n", (char) arPrev.get(), arPrevCount.get());
    }

    /**
     * An array containing 0's and 1's, arrange all 1's on the left hand side and
     * all 0's on the right hand side, provided you can traverse the array only once
     * Input : 0,1,1,0,1
     * Output : 1,1,1,0,0
     */
    public static void problem3() {
        int[] arr = new int[]{1, 0, 1};

        for (int left = 0, right = arr.length - 1, i = 0; left < right && i < arr.length; i++) {
            int temp = -1;
            if (arr[i] == 1) {// seeing 1
                temp = arr[left];
                arr[left++] = arr[i];
                arr[i] = temp;
            } else {// seeing 0
                temp = arr[right];
                arr[right--] = arr[i];
                arr[i] = temp;
            }
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
