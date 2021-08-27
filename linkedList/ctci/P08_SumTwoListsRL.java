public class P08_SumTwoListsRL {

    private static Node reverseLL(Node node) {
        Node head = new Node<>();
        Node next;
        while(node != null) {
            next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        return head.next;
    }

    private static Node sumLR(Node<Integer> n1, Node<Integer> n2) {
        Node res = new Node();
        Node head = res;
        Integer value = 0;
        Integer carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            value = carry;
            if (n1 != null) {
                value += n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                value += n2.value;
                n2 = n2.next;
            }
            carry = value/10;
            res.next = new Node(value%10);
            res = res.next;
        }
        return head.next;
    }

    private static Node sumRL(Node n1, Node n2) {
        // reverse and sum(LR) both lists;
        Node reversedN1 = reverseLL(n1);
        Node reversedN2 = reverseLL(n2);
        Node rNode = sumLR(reversedN1, reversedN2);
        // reverse rNode 
        rNode = reverseLL(rNode);
        // reset back reveresed LLists n1 and n2
        n1 = reverseLL(reversedN1);
        n2 = reverseLL(reversedN2);
        return rNode;
    }
    public static void main(String[] args) {
        Integer[][][] probs = {
            {{6, 1, 7}, {2, 9, 5}},
            {{9, 0, 0}, {2, 0, 0}},
            {{9, 9}, {9, 9}}
        };

        for (Integer[][] prob: probs) {
            Node<Integer> node1 = LLUtil.generateLList(prob[0]);
            Node<Integer> node2 = LLUtil.generateLList(prob[1]);
            Node rNode = sumRL(node1, node2);
            LLUtil.printLlist(rNode);
            LLUtil.printLlist(node1);
            LLUtil.printLlist(node2);
            System.out.println();
        }
        
    }
}
