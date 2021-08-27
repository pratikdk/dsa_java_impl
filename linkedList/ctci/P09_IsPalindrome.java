import java.util.ArrayList;
import java.util.List;

public class P09_IsPalindrome {

    private static boolean isPalindrome(Node<Integer> node) {
        boolean res = false;
        List<Integer> stack = new ArrayList<>();
        int i = -1;
        Node<Integer> slow = node;
        Node<Integer> fast = node;

        while (fast != null && fast.next != null) {
            stack.add(++i, slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.remove(i--) != slow.value) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {1, 2, 3, 3, 2, 1},
            {1, 2, 1},
            {1, 2, 3}
        };
        for (Integer[] prob: probs) {
            Node node = LLUtil.generateLList(prob);
            System.out.println(isPalindrome(node));
        }
    }
}
