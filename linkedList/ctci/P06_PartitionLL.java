public class P06_PartitionLL {

    private static Node partition(Node<Integer> node, Integer p) {
        Node head = node;
        Node tail = node;
        Node next = null;
        while (node != null) {
            next = node.next;
            if (node.value < p) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
    
    public static void main(String[] args) {
        Integer[][][] probs = {
            {{3, 2, 1, 0}, {2}},
            {{10, 1, 2, 3, 4, 2, 4, 5}, {3}},
            {{3, 5, 8, 5, 10, 2, 1}, {5}}
        };
        for (Integer[][] prob: probs) {
            Node<Integer> node = LLUtil.generateLList(prob[0]);
            Node rNode = partition(node, prob[1][0]);
            LLUtil.printLlist(rNode);
        }
    }
}
