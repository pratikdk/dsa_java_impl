public class P06_IsOneEditAway {

    public static int countEdits(String left, String right) {
        int editCount = 0;

        int leftLen = left.length(), rightLen = right.length();
        
        int l = 0, r = 0;

        while (l < leftLen && r < rightLen) {
            if (left.charAt(l) != right.charAt(r)) {
                if (leftLen < rightLen) {
                    r++;
                } else if (leftLen > rightLen) {
                    l++;
                } else {
                    l++;
                    r++;
                }
                editCount++;
            } else {
                l++;
                r++;
            }
        }
        
        editCount += leftLen-l;
        editCount += rightLen-r;

        return editCount;
    }

    public static void main(String[] args) {
        String[][] probs = new String[][] {
            {"plea", "plea"},
            {"padle", "plea"},
            {"pdorale", "ple"},
            {"paddor", "pddore"},
            {"paledor", "ple"},
        };

        for (String[] prob: probs) {
            System.out.println(countEdits(prob[0], prob[1]));
        }
    }
}
