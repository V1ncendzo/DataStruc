package tree.redo;

public class Node {
    int id;
    Node leftMostChild, rightSibling;
    Node(int id){
        this.id = id;
        leftMostChild = rightSibling = null;
    }
}
