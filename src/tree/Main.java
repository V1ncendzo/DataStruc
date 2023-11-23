package tree;

public class Main {
    public static void main(String[] args) {
        // Creating nodes
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);

        // Creating a tree and adding children
        Tree tree = new Tree(root);
        tree.addChild(root, child1);
        tree.addChild(root, child2);
        tree.addChild(child1, child3);

        // Now you have a simple tree structure

        System.out.println(tree.count(root));
    }
}
