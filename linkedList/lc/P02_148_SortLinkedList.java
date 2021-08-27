public class P02_148_SortLinkedList {

    private static Node sort(Node<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node rightHead = split(node);
        Node left = sort(node);
        Node right = sort(rightHead);
        return merge(left, right);
    }

    private static Node split(Node node) {
        Node left = node;
        Node right = left.next;
        left.next = null; // detach left and right
        return right;
    }    

    private static Node merge(Node<Integer> left, Node<Integer> right) {
        Node head = new Node();
        Node previous = head;

        while (left != null && right != null) {
            if (left.value < right.value) {
                previous.next = left;
                previous = left;
                left = left.next;
            } else {
                previous.next = right;
                previous = right;
                right = right.next;
            }
            previous.next = null;
        }
        if (left != null) {
            previous.next = left;
        } else {
            previous.next = right;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {5, 4, 3},
            {5, 4, 3, 2, 1, -1},
            {1},
            {2, 1, 3},
            {3, 0}
        };

        for (Integer[] prob: probs) {
            Node node = LLUtil.generateLList(prob);
            Node rNode = sort(node);
            LLUtil.printLlist(rNode);
        }
    }
}
