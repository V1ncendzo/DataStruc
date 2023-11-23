package tree;

public class bin_tree_traverse {
    // Root of Binary Tree
    Node root;

    bin_tree_traverse() { root = null; }

    // Given a binary tree, print its nodes in inorder
    void printInorder(Node node)
    {
        if (node == null)
            return;

        // First recur on left child
        printInorder(node.left);

        // Then print the data of node
        System.out.print(node.key + " ");

        // Now recur on right child
        printInorder(node.right);
    }
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        // First print data of node
        System.out.print(node.key + " ");

        // Then recur on left subtree
        printPreorder(node.left);

        // Now recur on right subtree
        printPreorder(node.right);
    }
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // First recur on left subtree
        printPostorder(node.left);

        // Then recur on right subtree
        printPostorder(node.right);

        // Now deal with the node
        System.out.print(node.key + " ");
    }
    static int count(Node root)
    {
        if (root == null)
            return 0;

        int l = count(root.left);
        int r = count(root.right);

        return 1 + l + r;
    }
    public static void main(String[] args)
    {
        bin_tree_traverse tree = new bin_tree_traverse();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        // Function call
        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(tree.root);
        System.out.println();
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
        System.out.println();
        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
        System.out.println();
        System.out.println("The total nodes of tree is:  " + tree.count(tree.root));

    }
}
