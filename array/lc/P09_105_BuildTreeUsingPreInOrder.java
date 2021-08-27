import java.util.Arrays;

public class P09_105_BuildTreeUsingPreInOrder {

    private static Node build(int[] preorder, int preIdx, int[] inorder, int inStartIdx, int inEndIdx) {
        Node parentNode = null;

        if (inStartIdx < inEndIdx) {
            int parentValue = preorder[preIdx];
            int parentIndex = searchIntegerArray(inorder, parentValue, inStartIdx, inEndIdx);
            parentNode = new Node(inorder[parentIndex]);
            Node leftChildNode = build(preorder, preIdx+1, inorder, inStartIdx, parentIndex);
            Node rightChildNode = build(preorder, preIdx+((parentIndex-inStartIdx)+1), inorder, parentIndex+1, inEndIdx);
            parentNode.left = leftChildNode;
            parentNode.right = rightChildNode;
        }
        return parentNode;
    }

    private static int searchIntegerArray(int[] arr, int value, int startIndex, int endIndex) {
        int index = -1;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void inorder(Node node) {
        if (node == null) {
            System.out.print("NA ");
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
        
    }

    private static void buildPrintTree(int[][] prob) {
        Node root = build(prob[0], 0, prob[1], 0, prob[1].length);
        inorder(root);
    }
    public static void main(String[] args) {
        int[][][] probs = {
            {{1,2,4,5,3,6,7}, {4,2,5,1,3,7,6}}
        };
        
        buildPrintTree(probs[0]);
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;
    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}