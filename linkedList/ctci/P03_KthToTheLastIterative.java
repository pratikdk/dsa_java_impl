public class P03_KthToTheLastIterative {
    
    private static Integer find(Node<Integer> node, Integer k) {
        Node<Integer> a = node;
        Node b = node;
        for (int i = 0; i < k; i++) {
            if (b == null) {return -1;}
            b = b.next;
        }
        while (b != null) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
    public static void main(String[] args) {
        Integer[][][] probs = {
            {{1, 4, 5, 3, 2}, {3}},
            {{1, 2, 3, 4, 5}, {2}}
        };
        for (Integer[][] prob: probs) {
            Node node = LLUtil.generateLList(prob[0]);
            System.out.println(find(node, prob[1][0]));
        }
    }
}
