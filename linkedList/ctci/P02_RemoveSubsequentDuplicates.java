public class P02_RemoveSubsequentDuplicates {

    private static void remove(Node<Integer> node) {
        Node previous = null;
        while (node != null) {
            if (previous != null && previous.value == node.value) {
                previous.next = node.next;
            } else {
                previous = node;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {1, 2, 2, 3, 4},
            {1, 2, 3, 3, 4, 4, 4, 5, 5}
        };
        for (Integer[] prob: probs) {
            Node node = LLUtil.generateLList(prob);
            remove(node);
            LLUtil.printLlist(node);
        }
    }
}
