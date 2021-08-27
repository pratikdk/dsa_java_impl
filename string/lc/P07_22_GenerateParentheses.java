import java.util.ArrayList;
import java.util.List;

public class P07_22_GenerateParentheses {

    private static List<String> generate(int n) {
        if (n == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        // 0 1 2
        // 2 1 0

        List<String> res = new ArrayList<>();

        for (int c = 0; c < n; c++) {
            for (String left: generate(c)) {
                for (String right: generate((n-1)-c)) {
                    String subString = String.format("(%s)%s", left, right);
                    res.add(subString);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        for (String s: generate(3)) {
            System.out.println(s);
        }
    }
}


// public class P07_22_GenerateParentheses {

//     private static String[] generate(int n) {
//         if (n == 0) {
//             String[] res = {"0"};
//             return res;
//         }
        
//         String[] res = new String[n+1];
//         int i = 0;
//         for (String r: generate(n-1)) {
//             res[i] = r;
//             i += 1;
//         }
//         res[i] = ""+n;

//         return res;
//     }
//     public static void main(String[] args) {
//         String[] gs = generate(2);
//         for (String s: gs) {
//             System.out.println(s);
//         }
//     }
// }



// private static String[] generate(int n) {
//     System.out.println(n);
//     if (n == 0) {
//         String[] res = {""};
//         return res;
//     }

//     String[] subSequences = generate(n-1);
//     System.out.println("L : " + subSequences.length);
//     String[] res;
//     if (subSequences[0].length() == 0) {
//         res = new String[1];
//     } else {
//         res = new String[subSequences.length*2];
//     }
//     int i = 0;
//     for (String subSeq: subSequences) {
//         String leftSeq = String.format("(%s%s", subSeq, ")");
//         res[i++] = leftSeq;
//         if (subSeq.length() > 0) {
//             String rightSeq = String.format("(%s%s", ")", subSeq);
//             res[i++] = rightSeq;
//         }
//     }
//     return res;
// }