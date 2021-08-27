import java.util.HashMap;
import java.util.Map;

public class P01_03_LongestNoRepeatSubstring {
    
    public static int findSubString(String s) {
        Map<Character, Integer> nextCharPosMap = new HashMap<>();
        Integer startIndex = 0;
        Integer maxSize = 0;

        for (int i = 0; i < s.length(); i++) {
            Character curCharacter = s.charAt(i);
            if (nextCharPosMap.containsKey(curCharacter)) {
                startIndex = nextCharPosMap.get(curCharacter);
            }
            nextCharPosMap.put(curCharacter, i+1);
            maxSize = Math.max(maxSize, (i+1)-startIndex);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String[] probs = {
            "abcabcbbfglpio",
            "bbbbb",
            "pwwkew",
            "abcdef"
        };
        // ("abcabcbbfglpio", 7),
        // ("bbbbb", 1),
        // ("pwwkew", 3),

        for (String prob: probs) {
            System.out.println(findSubString(prob));
        }
    } 
}
