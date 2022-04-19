package globallogic;

import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    private static final String HEADER = "Counted letters:\n";

    public static void main(String[] args) {
        countLettersInArgWordAndPrintResult(args[0]);
    }

    static void countLettersInArgWordAndPrintResult(final String arg) {
        TreeMap<Character, Integer> resultMap = createResultMap(arg.toLowerCase());
        String resultString = buildResult(resultMap);
        printResult(resultString);
    }

    private static void printResult(final String resultString) {
        System.out.println(resultString);
    }

    private static String buildResult(final TreeMap<Character, Integer> result) {
        StringBuilder sb = new StringBuilder("");
        addHeader(sb);
        result.forEach((e,f)-> sb.append(e).append(" = ").append(f).append("\n"));
        return sb.toString();
    }

    private static void addHeader(final StringBuilder sb) {
        sb.append(HEADER);
    }

    private static TreeMap<Character, Integer> createResultMap(final String toLowerCase) {
        TreeMap<Character, Integer> result = new TreeMap<>();
        String[] split = toLowerCase.split("");
        for (int i = 0; i < split.length; i++) {
            int count = countLettersInGivenWord(split[i], split);
            addLetterToMap(result, count, toLowerCase.charAt(i));
        }
        return result;
    }

    private static void addLetterToMap(final TreeMap<Character, Integer> result, final int count, final char letter) {
        if (count > 0)
            result.put(letter,count);
    }

    private static int countLettersInGivenWord(final String letter, final String[] split) {
        return (int) Arrays.stream(split)
                .filter(e -> e.equals(letter))
                .count();
    }
}
