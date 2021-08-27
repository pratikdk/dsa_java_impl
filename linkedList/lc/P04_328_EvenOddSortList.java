public class P04_328_EvenOddSortList {

    private static Node sort(Node<Integer> node) {
        Node left = new Node();
        Node right = new Node();
        Node leftHead = left;
        Node rightHead = right;
        while (node != null) {
            if (node.value % 2 == 0) {
                left.next = node;
                left = node;
            } else {
                right.next = node;
                right = node;
            }
            node = node.next;
        }
        if (right == rightHead) {
            left.next = null;
        } else {
            left.next = rightHead.next;
        }
        right.next = null;

        return leftHead.next;
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {1, 2, 3, 4, 5},
            {60, 50, 40, 30, 20, 10},
            {},
            {3, 2},
            {1}
        };
        for (Integer[] prob: probs) {
            Node node = LLUtil.generateLList(prob);
            Node rNode = sort(node);
            LLUtil.printLlist(rNode);
        }
    }
}
