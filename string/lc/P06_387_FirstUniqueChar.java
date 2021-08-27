import java.util.HashMap;
import java.util.Map;

public class P06_387_FirstUniqueChar {

    private static int find(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        char currChar;
        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i); // Extract char
            if (currChar == ' ') { // this block enables feature to ignores char(space)
                if (result == i) {
                    result += 1;
                }
                continue;
            } 
            map.putIfAbsent(currChar, 0);   // Initialize char in map
            map.put(currChar, map.get(currChar)+1);  // +1 char count in map
            
            while (map.get(s.charAt(result)) > 1) { // if char has count > 1
                result += 1; // move result index to next char
                if (result > i) {  // Break if result crosses i(current position)
                    break;
                }
            }
        }

        if (result == s.length()) {
            result = -1;
        }

        return result;
    } 

    public static void main(String[] args) {
        String[] probs = {
            "lool",
            "love",
            "lovel",
            "leetcode",
            "loveleetcode",
            " ",
            "",
            "ll",
            "loolc",
            "loodlc"
        };

        for (String prob: probs) {
            System.out.println(find(prob));
        }
    }
}