import java.util.HashMap;
import java.util.Map;

public class P11_FindLoopStart {

    private static Node find(Node<Integer> node) {
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = node;
        while (slow != fast) {
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(find(n0).value);
    }
}
