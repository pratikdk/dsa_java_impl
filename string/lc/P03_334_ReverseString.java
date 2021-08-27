public class P03_334_ReverseString {
    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder(s);
        char tempChar;
        int oppositeIndex;
        for (int i = 0; i < builder.length()/2; i++) {
            tempChar = builder.charAt(i);
            oppositeIndex = builder.length()-(i+1);
            builder.setCharAt(i, builder.charAt(oppositeIndex));
            builder.setCharAt(oppositeIndex, tempChar);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String[] probs = {
            "Pratik",
            "acer"
        };
         
        for (String prob: probs) {
            System.out.println(reverse(prob));
        }
    }
}
