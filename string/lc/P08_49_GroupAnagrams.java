import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P08_49_GroupAnagrams {

    private static Map<String, List<String>> group(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word: words) {
            char[] w = word.toCharArray();
            Arrays.sort(w);
            String sortedW = new String(w);
            
            map.putIfAbsent(sortedW, new ArrayList<>());
            map.get(sortedW).add(word);
        }
        return map;
    }
    public static void main(String[] args) {
        String[][] probs = {
            {"eat","tea","tan"},
            {"eat","tea","tan","ate","nat","bat"},
            {""},
            {"a"},
            {"abbbbbbbbbbb", "aaaaaaaaaaab"},
            {"abbb", "bbba", "aaab"}
        };

        for (String[] prob: probs) {
            System.out.println(group(prob));
        }
    }
}