import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P07_SumTwoListsLR {

    private static Node<Integer> add(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> res = new Node();
        Node<Integer> head = res;
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
            carry = value / 10;
            res.next = new Node(value%10);
            res = res.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        Integer[][][] probs = {
            {{6, 1, 7}, {2, 9, 5}},
            {{9, 9}, {9, 9}}
        };

        for (Integer[][] prob: probs) {
            Node<Integer> node1 = LLUtil.generateLList(prob[0]);
            Node<Integer> node2 = LLUtil.generateLList(prob[1]);
            Node<Integer> rNode = add(node1, node2);
            LLUtil.printLlist(rNode);
        }
        
    }
}
