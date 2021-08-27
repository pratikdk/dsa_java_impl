public class P03_IsPermutation {

    public static boolean isPermutation(String left, String right) {
        int[] charset = new int[128]; 

        for (int i = 0; i < left.length(); i++) {
            int ord = (int) left.charAt(i);
            charset[ord] += 1;
        }

        for (int i = 0; i < right.length(); i++) {
            int ord = (int) right.charAt(i);
            charset[ord] -= 1;
            if (charset[ord] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] probs = {{"abcd", "dcba"},
                             {"1235", "3521"},
                             {"!=()", "(!=)"}, 
                             {"ab ", "abcd"},
                             {"1234", "42133"}};

        for (String[] prob: probs) {
            System.out.println(isPermutation(prob[0], prob[1]));
        }
        
    }
}