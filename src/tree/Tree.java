package tree;

public class Tree {
    TreeNode root;

    // Constructor if needed
    public Tree(TreeNode root) {
        this.root = root;
    }

    // Other methods or attributes if needed

    // Example method to add a child to a parent node
    public void addChild(TreeNode parent, TreeNode child) {
        if (parent.leftMostChild == null) {
            parent.leftMostChild = child;
        } else {
            TreeNode sibling = parent.leftMostChild;
            while (sibling.rightSibling != null) {
                sibling = sibling.rightSibling;
            }
            sibling.rightSibling = child;
        }
    }
    public TreeNode find(TreeNode r, int v){
        if(r == null) return null;
        if(r.id == v) return r;
        TreeNode p = r.leftMostChild;
        while (p != null){
            TreeNode h = find(p,v);
            if(h != null) return h;
            p = p.rightSibling;
        }
        return null;
    }
    public void preOrder(TreeNode r){
        if(r == null) return;
        System.out.println(r.id);
        TreeNode p = r.leftMostChild;
        while (p != null){
            preOrder(p);
            p = p.rightSibling;
        }
    }
    public void inOrder(TreeNode r){
        if(r == null) return;
        TreeNode p = r.leftMostChild;
        inOrder(p);
        System.out.println(r.id);
        if(p != null){
            p = p.rightSibling;
        }
        while (p != null){
            inOrder(p);
            p = p.rightSibling;
        }
    }
    public void postOrder(TreeNode r){
        if(r == null) return;
        TreeNode p = r.leftMostChild;
        while (p != null){
            postOrder(p);
            p = p.rightSibling;
        }
        System.out.println(r.id);
    }
    public int count(TreeNode r){
        if(r == null) return 0;
        int s = 1;
        TreeNode p = r.leftMostChild;
        while (p != null){
            s += count(p);
            p = p.rightSibling;
        }
        return s;
    }

    public int countLeaves(TreeNode r){
        if(r == null) return 0;
        int s = 0;
        TreeNode p = r.leftMostChild;
        if(p == null) s = 1;
        while (p != null){
            s += countLeaves(p);
            p = p.rightSibling;
        }
        return s;
    }
    public int height(TreeNode p){
        if(p == null) return 0;
        int maxh = 0;
        TreeNode q = p.leftMostChild;
        while (q != null){
            int h = height(q);
            if(h > maxh) maxh = h;
            q = q.rightSibling;
        }
        return maxh + 1;
    }
    public int depth(TreeNode r, int v, int d){
        // d la do sau cua nut r
        if(r == null) return -1;
        if(r.id == v) return d;
        TreeNode p = r.leftMostChild;
        while (p != null){
            if(p.id == v) return d+1;
            int dv = depth(p,v,d+1);
            if(dv > 0) return dv;
            p = p.rightSibling;
        }
        return -1;
    }
    public int depth (TreeNode r, int v){
        return depth(r,v,1);
    }
    TreeNode parent(TreeNode p, TreeNode r){
        if(r == null) return null;
        TreeNode q = r.leftMostChild;
        while (q != null){
            if(p == q) return r;
            TreeNode pp = parent(p,q);
            if(pp != null) return pp;
            q = q.rightSibling;
        }
        return null;
    }

}
