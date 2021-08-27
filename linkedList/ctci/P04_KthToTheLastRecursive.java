public class P04_KthToTheLastRecursive {

    static class Counter {
        public Integer count = 0;
    }

    private static Node find(Node node, Integer k, Counter c) {
        if (node == null) {
            return null;
        }
        Node rNode = find(node.next, k, c);
        if (rNode == null) {
            c.count++;
            if (c.count == k) {
                rNode = node;
            }
        }
        return rNode;
    }

    private static Node find(Node node, Integer k) {
        Node rNode = find(node, k, new Counter());
        return rNode;
    }
    public static void main(String[] args) {
        Integer[][][] probs = {
            {{1, 4, 5, 3, 2}, {3}},
            {{1, 2, 3, 4, 5}, {2}}
        };
        for (Integer[][] prob: probs) {
            Node node = LLUtil.generateLList(prob[0]);
            System.out.println(find(node, prob[1][0]).value);
        }
    }
}