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
        if(r == null) return;  // stop rightaway
        System.out.print(r.id + " ");
        for(Node p = r.leftMostChild; p != null; p = p.rightSibling){
            // leftMost Until Null => rightSibling
            preOrder(p);
        }
    }
    public void inOrder(Node r){
        if( r == null) return; // stop rightaway
        Node p = r.leftMostChild;
        if( p == null){
            System.out.print(r.id + " ");
            return; // stop rightaway
        }
        inOrder(p);
        System.out.print(r.id + " ");
        for(Node q = p.rightSibling; q != null; q = q.rightSibling){
            inOrder(q);
        }
    }
    public void postOrder(Node r){
        if(r == null) return; // stop rightaway
        for(Node p = r.leftMostChild; p != null; p = p.rightSibling){
            postOrder(p);
        }
        System.out.print(r.id + " ");
    }
    int count(Node r){
        if(r == null) return 0;
        Node p = r.leftMostChild;
        int cnt = 1;
        while ( p != null){
            cnt += count(p); p = p.rightSibling;
        }
        return cnt;
    }
    public int countLeaves(Node r){
        // dem so nut la cua cay goc r
        if(r == null) return 0;
        if(r.leftMostChild == null) return 1;
        int cnt = 0;
        Node p = r.leftMostChild;
        while (p !=  null){
            cnt  += countLeaves(p);
            p = p.rightSibling;
        }
        return cnt;
    }
    public int depthR(int id, Node p, int dp){
        // p co do sau la d tren cay dau vao
        if(p == null) return 0;
        if(p.id == id) return dp;
        for(Node q = p.leftMostChild; q != null; q= q.rightSibling){
            if(q.id == id) return dp + 1;
            int d = depthR(id,q,dp+1);
            if(d > 0) return d;
        }
        return 0;
    }
    int depth(int id, Node r){
        return depthR(id,r,1);
    }
    int height(Node r){
        if(r == null) return 0;
        int maxH = 0; // do cao cua nut con lon nhat cua r
        Node p = r.leftMostChild;
        while (p != null){
            int h = height(p); if(h > maxH) maxH = h;
            p = p.rightSibling;
        }
        return maxH + 1;
    }


    public static void main(String[] args) {
        tree Tree = new tree();
        Node root = new Node(1);
        Tree.addChild(2,1,root);
        Tree.addChild(3,1,root);
        Tree.addChild(4,1,root);
        Tree.addChild(5,1,root);
        Tree.addChild(6,2,root);
        Tree.addChild(7,2,root);
        Tree.addChild(8,7,root);
        Tree.addChild(9,3,root);
        Tree.addChild(10,3,root);
        Tree.addChild(11,3,root);
        Tree.addChild(14,4,root);
        Tree.addChild(16,5,root);
        Tree.addChild(15,16,root);

//        Tree.printTree(root);

//        System.out.print("PreOrder: ");
//        Tree.preOrder(root);
//        System.out.println();
//        System.out.print("InOrder: ");
//        Tree.inOrder(root);
//        System.out.println();
//        System.out.print("PostOrder: ");
//        Tree.postOrder(root);
        System.out.println("The node of tree is : " + Tree.count(root));
        System.out.println("The leaves of tree is : " + Tree.countLeaves(root));
        // nut la la nut khong co con (leftMostChild)
    }
}
