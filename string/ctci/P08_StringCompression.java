public class P08_StringCompression {

    private static String compressString(String text) {
        String result = "";
        int textLen = text.length();
        int charCounter = 0;
        char currentChar;

        for (int i = 0; i < text.length(); i++) {
            charCounter += 1;
            currentChar = text.charAt(i);
            
            if (i+1 == textLen || currentChar != text.charAt(i+1)) {
                result += currentChar;
                if (charCounter > 1) {
                    result += charCounter;
                }
                charCounter = 0;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String[] probs = {"aabbcccddddefzzzz","aabbccdd","abcd"};

        for (String prob: probs) {
            System.out.println(compressString(prob));
        }
    }
}
