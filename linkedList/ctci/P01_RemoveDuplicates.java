import java.util.HashMap;
import java.util.Map;

public class P01_RemoveDuplicates {

    private static void remove(Node<Integer> node) {
        System.out.println("helllo");
        Map<Integer, Integer> map = new HashMap<>();
        Node previous = null;
        while (node != null) {
            if (map.containsKey(node.value)) {
                previous.next = node.next;
            } else {
                map.put(node.value, 1);
                previous = node;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {1, 2, 2, 3, 4},
            {1, 2, 3, 2, 1, 4, 9}
        };
        for (Integer[] prob: probs) {
            Node node = LLUtil.generateLList(prob);
            remove(node);
            LLUtil.printLlist(node);
        }
   } 
}
