import java.util.Random;

public class StringRandom {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCTUATION = ".!?…";

    public static String generateWord(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
            sb.append(c);
        }
        return sb.toString();
    }

    public static String generateSentence(int wordCount) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < wordCount; i++) {
            String word = generateWord(random.nextInt(6) + 1); // generate word with length 1 to 6
            sb.append(word);
            if (i < wordCount - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String generateText(int sentenceCount) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < sentenceCount; i++) {
            String sentence = generateSentence(random.nextInt(10) + 1); // generate sentence with word count 1 to 10
            sb.append(sentence);
            if (i < sentenceCount - 1) {
                sb.append(getRandomPunctuation());
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static char getRandomPunctuation() {
        Random random = new Random();
        return PUNCTUATION.charAt(random.nextInt(PUNCTUATION.length()));
    }

    public static void main(String[] args) {
        String text = generateText(1000);
        System.out.println(text);
    }
}
