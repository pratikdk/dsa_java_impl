public class P04_Urlify {

    public static String urlify(String txt) {
        int spaceCount = 0;
        int negativeSpace = 0;

        boolean extraSpaceFlag = false;
        for (int i = 0; i < txt.length(); i++) {
            char chr = txt.charAt(i);
            if (chr == ' ') {
                if (extraSpaceFlag == false) {
                    spaceCount += 1;
                    extraSpaceFlag = true;
                } else {
                    negativeSpace += 1;
                }
            } else {
                extraSpaceFlag = false;
            }
        }

        char[] urlArr = new char[(txt.length() - negativeSpace - spaceCount) + (spaceCount * 3)];
        int j = 0;

        extraSpaceFlag = false;
        for (int i = 0; i < txt.length(); i++) {
            char chr = txt.charAt(i);
            if (chr == ' ') {
                if (extraSpaceFlag == false) {
                    urlArr[j] = '%';
                    urlArr[j+1] = '2';
                    urlArr[j+2] = '0';
                    j += 3;
                    extraSpaceFlag = true;
                }
            } else {
                urlArr[j] = chr;
                j += 1;
                extraSpaceFlag = false;
            }
        }

        String url = String.valueOf(urlArr);

        return url; //"" + spaceCount + " " + negativeSpace;

    }

    public static void main(String[] args) {
        String[] probs = {
            "A random string  to test.",
            "Mr John Smith."
        };

        for (String prob: probs) {
            System.out.println(urlify(prob));
        }
    }
}
