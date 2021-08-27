
public class P05_PalindromePermutation {

    public static boolean isPalindromePermutation(String txt) {
        int oddCount = 0;

        int[] alphaSet = new int[((int) 'z') - ((int) 'a') + 1];

        for (int i = 0; i < txt.length(); i++) {
            int alphaOrd = getAsciiAlphaValue(txt.charAt(i));

            if (alphaOrd != -1) {
                alphaSet[alphaOrd] += 1;
                if (alphaSet[alphaOrd] % 2 == 0) {
                    oddCount -= 1;
                } else {
                    oddCount += 1;
                }
            }
        }

        return oddCount <= 1; 
    }

    private static int getAsciiAlphaValue(char chr) {
        int A = (int) 'A';
        int Z = (int) 'Z';
        int a = (int) 'a';
        int z = (int) 'z';

        int chrOrd = (int) chr;

        if (A <= chrOrd && chrOrd <= Z) {
            return (chrOrd-A);
        } else if (a <= chrOrd && chrOrd <= z) {
            return (chrOrd-a);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] probs = {
            "Tact Coa",
            "Pratik kitarp",
            "azAZ",
            "random string"
        };

        for (String prob: probs) {
            System.out.println(isPalindromePermutation(prob));
        }
    }
}