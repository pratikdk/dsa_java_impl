public class P01_19_RemoveNthNodeFromEnd {

    private static Node remove(Node node, Integer k) {
        Node head = new Node();
        head.next = node;
        Node slow = head;
        Node fast = head;
        
        while (k >= 0) {
            k--;
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        if (k != -1) {
            return head.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head.next;
    }

    public static void main(String[] args) {
        Integer[][][] probs = {
            {{0}, {1}},
            {{1, 2, 3, 4, 5}, {2}},
            {{2, 3, 4, 2}, {3}},
            {{3, 0, 0, 3}, {4}},
            {{3, 0, 0, 3}, {1}},
            {{3}, {1}}
        };
        for (Integer[][] prob: probs) {
            Node node = LLUtil.generateLList(prob[0]);
            Node rNode = remove(node, prob[1][0]);
            LLUtil.printLlist(rNode);
        }
    }
}