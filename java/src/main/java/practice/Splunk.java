package practice;

/**
 * You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice question disguised as a random note.
 * <p>
 * Your task is to write a function that, given a list of words and a note, finds and returns the word in the list that is scrambled inside the note, if any exists. If none exist, it returns the result "-" as a string. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.
 * <p>
 * Example:
 * words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"]
 * <p>
 * note1 = "ctay"
 * find(words, note1) => "cat"   (the letters do not have to be in order)
 * <p>
 * note2 = "bcanihjsrrrferet"
 * find(words, note2) => "cat"   (the letters do not have to be together)
 * <p>
 * note3 = "tbaykkjlga"
 * find(words, note3) => "-"     (the letters cannot be reused)
 * <p>
 * note4 = "bbbblkkjbaby"
 * find(words, note4) => "baby"
 * <p>
 * note5 = "dad"
 * find(words, note5) => "-"
 * <p>
 * note6 = "breadmaking"
 * find(words, note6) => "bird"
 * <p>
 * note7 = "dadaa"
 * find(words, note7) => "dada"
 * <p>
 * All Test Cases:
 * <p>
 * find(words, note1) -> "cat"
 * <br/>
 * find(words, note2) -> "cat"
 * <br/>
 * find(words, note3) -> "-"
 * <br/>
 * find(words, note4) -> "baby"
 * <br/>
 * find(words, note5) -> "-"
 * <br/>
 * find(words, note6) -> "bird"
 * <br/>
 * find(words, note7) -> "dada"
 * <p>
 * Complexity analysis variables:
 * <p>
 * W = number of words in `words`
 * <br/>
 * S = maximal length of each word or of the note
 */
public class Splunk {

    public static void main(String[] argv) {
        String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
        String note1 = "ctay";
        String note2 = "bcanihjsrrrferet";
        String note3 = "tbaykkjlga";
        String note4 = "bbbblkkjbaby";
        String note5 = "dad";
        String note6 = "breadmaking";
        String note7 = "dadaa";

        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "cat", find(words, note1));
        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "cat", find(words, note2));
        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "-", find(words, note3));
        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "baby", find(words, note4));
        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "-", find(words, note5));
        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "bird", find(words, note6));
        System.out.printf("EXPECTED : %s , ACTUAL : %s\n", "dada", find(words, note7));
    }

    private static String find(String[] words, String note) {
        // build frequency table for note
        int[] noteFT = createFT(note);

        int index = -1;
        for (int k = 0; k < words.length; k++) {
            // build frequency table for current word
            int[] currWordFT = createFT(words[k]);

            boolean found = true;
            for (int j = 0; j < 26; j++) {
                if (currWordFT[j] > 0
                        && currWordFT[j] > noteFT[j]) {
                    found = false;
                    break;
                }
            }

            if (found) {
                index = k;
                break;
            }
        }

        return index < 0 ? "-" : words[index];
    }

    private static int[] createFT(String word) {
        int[] ft = new int[26];
        word.chars()
                .forEach(ascii -> ft[ascii - 97] += 1);
        return ft;
    }
}
