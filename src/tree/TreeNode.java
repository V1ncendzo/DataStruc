package tree;

public class TreeNode {
    int id;
    TreeNode leftMostChild;
    TreeNode rightSibling;

    // Constructor if needed
    public TreeNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
