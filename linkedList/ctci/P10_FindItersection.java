public class P10_FindItersection {

    static class ListInfo {
        public int count;
        public Node<Integer> tail;
        public ListInfo(int count, Node tail) {
            this.count = count;
            this.tail = tail;
        }
    }

    private static Integer find(Node<Integer> a, Node<Integer> b) {
        Integer result = -1;

        ListInfo AInfo = getLLsize(a);
        ListInfo BInfo = getLLsize(b);

        if (AInfo.tail != BInfo.tail) {
            return result;
        }

        if (AInfo.count > BInfo.count) {
            a = moveKSteps(a, AInfo.count-BInfo.count);
        } else if (AInfo.count < BInfo.count) {
            b = moveKSteps(b, BInfo.count-AInfo.count);
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        if (a != null) {
            result = a.value;
        }

        return result;
    }

    private static Node moveKSteps(Node node, Integer k) {
        while (k > 0 && node != null) {
            k--;
            node = node.next;
        }
        return node;
    }

    private static ListInfo getLLsize(Node node) {
        Integer count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return new ListInfo(count, node);
    }

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n0.next = n3;
        
        n1.next = n2;
        n2.next = n3;

        n3.next = n4;

        System.out.println(find(n0, n1));
    }
}
