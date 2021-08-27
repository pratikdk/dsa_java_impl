public class P01_IsUniqueString {

    public static boolean isUnique(String txt) {
        int[] charset = new int[128];
        for (int i = 0; i < txt.length(); i++) {
            int ord = (int) txt.charAt(i);
            if ((charset[ord] & 1) == 1) {
                return false;
            }
            charset[ord] += 1;
        }
        return true;
    }

    
    public static void main(String[] args) {
        System.out.println(isUnique("pratt"));
    }
}