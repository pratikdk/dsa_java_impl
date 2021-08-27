public class P02_IsUniqueStringBinary {

    public static boolean isUnqiue(String txt) {
        int state = 0;
    
        for (int i = 0; i < txt.length(); i++) {
            int ord = (int) txt.charAt(i);
            System.out.println(ord +" "+ state );
            if ((state & (1 << ord)) > 0) {
                System.out.println("enter");
                return false;
            }
            state = state | (1 << ord);
        }
        return true;
    }

    public static void main(String[] args){ 
        System.out.println(isUnqiue("Pratt"));
    }
}
