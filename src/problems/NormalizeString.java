package problems;

/**
 * You are given a string -> normalize it
 */
public class NormalizeString {
    public static void main(String[] args) {
        System.out.println(normWithRegex("good       string                   "));
    }

    public static String norm(String s) {
        boolean first = true;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (first) {
                    res += c;
                    first = false;
                }
            } else {
                res += c;
                first = true;
            }
        }

        return res.trim();
    }
    public static String normWithRegex(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }
}
