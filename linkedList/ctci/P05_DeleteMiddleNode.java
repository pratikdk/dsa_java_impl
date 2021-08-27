public class P05_DeleteMiddleNode {

    private static void delete(Node node) {
        Node slow = new Node();
        slow.next = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {1, 2, 2, 3, 4},
            {1, 2, 3, 3}
        };
        for (Integer[] prob: probs) {
            Node node = LLUtil.generateLList(prob);
            delete(node);
            LLUtil.printLlist(node);
        }
    }
}
