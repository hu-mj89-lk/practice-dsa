package interview.unsolved;

/**
 * Problem : Activate Fountain
 * <p>
 * There is a linear garden from 1 to n. At each point there is a fountain.
 * Given array a[n] tells info about fountain such that its range is
 * max(i-a[i],1) to the left of fountain to min(i+a[i],n) to the right of fountain.
 * <p>
 * Find minimum no. of fountains needed to be activated so that whole garden is covered.
 * <p>
 * e.g.if n=3 and a={1,2,1} then second fountain has range 1 to 3. So only 1 fountain needed.
 * Here fountain at 1 has range of 1 to 2, fountain at 2 has range of 1 to 3 and fountain at 3 has range of 2 to 3
 * So only fountain 2 is enough to be activated to cover the whole garden.
 */
public class BNY_Mellon {
    public static void main(String[] args) {
        test(new int[]{0, 0, 0, 3, 0, 0, 2, 0, 0}, 2);
        test(new int[]{0, 0, 0, 3, 0, 0, 2, 0, 0}, 2);
        test(new int[]{3, 0, 2, 0, 1, 0}, 2);
        test(new int[]{3, 0, 1, 0, 1, 0}, 2);
        test(new int[]{3, 0, 1, 0, 0, 1}, 2);
        test(new int[]{2, 0, 2, 0, 1, 0}, 2);
        test(new int[]{2, 0, 0, 0, 0}, 3);
        test(new int[]{0, 0, 0, 0, 0}, 5);
        test(new int[]{1, 2, 1}, 1);
        test(new int[]{0, 1, 0}, 1);
        test(new int[]{2, 1, 2, 1, 2, 4}, 2);
        test(new int[]{0, 0, 0, 0, 2, 0, 2, 3}, 4);
    }

    private static void test(int[] fountains, int expected) {
        System.out.printf("answer : " + fountainActivation(fountains) + "expected :" + expected);
    }

    private static int fountainActivation(int[] locations) {
        return 0;
    }
}