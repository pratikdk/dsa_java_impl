import java.util.List;

public class LLUtil<T> {
    public static <S> Node generateLList(S[] s) {
        Node head = new Node();
        Node previous = head;
        for (S element: s) {
            Node node = new Node(element);
            previous.next = node;
            previous = node;
        }
        return head.next;
    }

    public static void printLlist(Node node) {
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
