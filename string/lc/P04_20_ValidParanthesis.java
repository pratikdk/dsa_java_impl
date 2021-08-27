import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P04_20_ValidParanthesis {
    private static final Map<Character, Character> bracketsMap;

    static{
        bracketsMap = new HashMap<>();
        bracketsMap.put(']', '[');
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
    }

    private static boolean validate(String s) {
        List<Character> tempStack = new ArrayList<>();
        int sCounter = -1;

        char lastElement;
        for (int i = 0; i < s.length(); i++) {
            if (bracketsMap.containsKey(s.charAt(i))) {
                // pop from tempStack
                lastElement = tempStack.get(sCounter);
                tempStack.remove(sCounter);
                sCounter -= 1;
                
                if (lastElement != bracketsMap.get(s.charAt(i))) {
                    return false;
                }
            } else {
                tempStack.add(s.charAt(i));
                sCounter += 1;
            }
        }
        return sCounter == -1; // true if stack is empty
    }

    public static void main(String[] args) {
        String[] probs = {
            "[([])]",
            "{}",
            "{)",
            "{("
        };

        for (String prob: probs) {
            System.out.println(validate(prob));
        }
    }
}