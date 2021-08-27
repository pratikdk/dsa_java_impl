public class P10_StringRotation {

    private static boolean isStringRotated(String s1, String s2) {
        if (s1.length() > 0 && s1.length() == s2.length()) {
            String concatedString = s1 + s1;
            return concatedString.indexOf(s2) != -1;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[][] probs = {
            {"waterbottle", "erbottlewat"},
            {"pratik", "atikpr"},
            {"random", "string"}
        };

        for (String[] prob: probs) {
            System.out.println(isStringRotated(prob[0], prob[1]));
        }
    }
}
