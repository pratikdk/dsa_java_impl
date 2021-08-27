public class P02_05_LongestPalindromeSubstring {

    private static String find(String s) {
        int start = 0;
        int end = 0;
        int leftLen = 0, rightLen = 0, currMaxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            leftLen = getPalindromeLength(s, i, i);
            rightLen = getPalindromeLength(s, i, i+1);

            currMaxLen = Math.max(leftLen, rightLen);

            if (currMaxLen > end-start) {
                start = i - ((currMaxLen-1)/2);
                end = i + currMaxLen/2 + 1;
            }
        }
        return s.substring(start, end);

    }

    private static int getPalindromeLength(String s, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex -= 1;
            rightIndex += 1;
        }
        return rightIndex - leftIndex - 1; 
    }
    public static void main(String[] args) {
        String[] probs = {"fabbac", "abcdd", "hellonitinfaaabbaaafa"};

        for (String prob: probs) {
            System.out.println(find(prob));
        }
    }
}

