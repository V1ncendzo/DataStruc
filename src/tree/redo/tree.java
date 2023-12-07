package tree.redo;

public class tree {
    public Node makeNode( int id){
        Node p = new Node(id);
        return p;
    }
    public Node find(int id, Node r){
        if(r == null) return null;
        if(r.id == id) return r;
        for(Node p = r.leftMostChild; p != null; p = p.rightSibling ){
            Node q = find(id, p);
            if(q!=null){
                return q;
            }
        }
        return null;
    }
    public void addChildP(int id, Node p){
        if(p == null) return ;
        if(p.leftMostChild == null){
            Node n = makeNode(id);
            p.leftMostChild = n;
            return;
        }
        Node q = p.leftMostChild;
        while (q.rightSibling != null){
            q = q.rightSibling;
        }
        Node n = makeNode(id);
        q.rightSibling = n;
    }
    public void addChild(int id, int u, Node r){
        if(find(id,r) != null) return;
        Node p = find(u,r);
        addChildP(id,p);
    }
    public void printTree(Node r){
        // print the tree rooted at r
        if(r == null) return;   // do nothing
        System.out.print(r.id);
        Node p = r.leftMostChild;
        while (p != null){
            System.out.print(p.id);
            p = p.rightSibling;
        }
        System.out.println();
        // call recursively printTree with children of r
        p = r.leftMostChild;
        while (p != null){
            printTree(p);
            p = p.rightSibling;
        }
    }
    public void preOrder( Node r){
        if(r == null) return;
        System.out.print(r.id + " ");
        for(Node p = r.leftMostChild; p != null; p = p.rightSibling){
            // leftMost Until Null => rightSibling
            preOrder(p);
        }
    }
    public void inOrder(Node r){
        if( r == null) return;
        Node p = r.leftMostChild;
        if( p == null){
            System.out.print(r.id + " ");
            return;
        }
        inOrder(p);
        System.out.print(r.id + " ");
        for(Node q = p.rightSibling; q != null; q = q.rightSibling){
            inOrder(q);
        }
    }
    public void postOrder(Node r){
        if(r == null) return;
        for(Node p = r.leftMostChild; p != null; p = p.rightSibling){
            postOrder(p);
        }
        System.out.print(r.id + " ");
    }

    public static void main(String[] args) {
        tree Tree = new tree();
        Node root = new Node(10);
        Tree.addChild(1,10,root);
        Tree.addChild(7,10,root);
        Tree.addChild(3,10,root);
        Tree.addChild(2,7,root);
        Tree.addChild(9,7,root);
        Tree.addChild(8,3,root);
        Tree.addChild(6,2,root);
        Tree.addChild(5,2,root);
        Tree.addChild(4,2,root);
//        Tree.printTree(root);
        Tree.inOrder(root);
    }
}
