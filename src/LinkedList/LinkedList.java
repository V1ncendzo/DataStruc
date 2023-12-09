package LinkedList;



public class LinkedList {
    Node makeNode (int id){
        Node p = new Node(id);
        p.next = null;
        return p;
    }
    Node insertBefore(int id, int v, Node h){
        if(h == null) return null;
        if(h.id == v){
            Node q = makeNode(id);
            q.next = h;
            return q;
        }
        Node p = h;
        while (p.next != null){
            if(p.next.id == v){
                Node q = makeNode(id);
                q.next = p.next;
                p.next = q;
                return h;
            }
            p = p.next;
        }
        return h;
    }
    Node inserbeforeR( int id, int v, Node h){
        if(h == null) return null;
        if(h.id == v){
            Node q = makeNode(id);
            q.next = h; return q;
        }
        h.next = inserbeforeR(id,v,h.next);
        return h;
    }
    void printList(Node h){
        for(Node p = h; p != null; p = p.next){
            System.out.print(p.id + " ");
        }
        System.out.println();
    }
    Node removeNode ( int v, Node h){
        if( h == null ) return null;
        if(h.id == v){
            Node tmp = h; h = h.next;
            return h;
        }
        Node p = h;
        while (p.next != null){
            if(p.next.id == v){
                Node tmp = p.next;
                p.next = p.next.next;
                return h;
            }
            p=p.next;
        }
        return h;
    }
    Node reverse(Node h){
        Node p = h; // current node
        Node pp = null;
        Node np = null;
        while (p != null){
            np = p.next;
            p.next = pp;
            pp = p;
            p = np;
        }
        return pp;
    }

    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        Node h = null;
        h = L.makeNode(1);
        for(int i = 2; i <= 5; i++){
            h = L.insertBefore(i, i-1, h);
        }
        L.printList(h);
        h = L.insertBefore(6,3,h);
        L.printList(h);
        h = L.removeNode(2,h);
        L.printList(h);
        h = L.reverse(h);
        L.printList(h);
    }
}
