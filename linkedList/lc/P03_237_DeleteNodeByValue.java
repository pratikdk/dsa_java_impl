public class P03_237_DeleteNodeByValue {

    private static Node delete(Node<Integer> node, Integer value) {
        Node head = new Node();
        Node previous = head;

        while (node != null) {
            if (node.value != value) {
                previous.next = node;
                previous = node;
            }
            node = node.next;
        }

        return head.next;
    }
    public static void main(String[] args) {
        Integer[][][] probs = {
            {{4, 5, 1, 9}, {5}},
            {{4, 5, 1, 9}, {1}},
            {{1, 2, 3, 4}, {3}},
            {{0, 1}, {0}},
            {{1}, {1}},
            {{-3, 5, -99}, {-3}},
            {{4, 8, 10}, {100}}
        };

        for (Integer[][] prob: probs) {
            Node node = LLUtil.generateLList(prob[0]);
            Node rNode = delete(node, prob[1][0]);
            LLUtil.printLlist(rNode);
        }
    }
}
