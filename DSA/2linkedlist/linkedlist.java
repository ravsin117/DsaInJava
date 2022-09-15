public class linkedlist {   
       
    private static class Node{ 
        int data = 0;
        Node next = null;
        Node(){

        }
        Node(int data){
            this.data = data;
        }

    }  
     
    private Node head =null;
    private Node tail = null;
    private int size = 0;
    
    @Override
    public String toString(){  // overriding inbuilt toString that  is responsible for printing 
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.head;
        while(curr != null){
            sb.append(curr.data);
            if(curr.next!=null)
            sb.append(", ");
            curr = curr.next;
        }
        sb.append(']');
        return sb.toString();
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    private void addFirstNode(Node node){
        
        if(this.size==0){
            this.head=this.tail=node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;

    }    
    public void addFirst(int data){
         Node node = new Node(data);
         addFirstNode(node);
    }

    private void addLastNode(Node node){
        
        if(this.size==0){
            this.head=this.tail=node;
        }else{
            this.tail.next =node;
            this.tail=node; 
        }
        this.size++;

    }
    public void addLast(int data){
         Node node = new Node(data);
         addLastNode(node);
    }
    
    private Node removeFirstNode(){
        Node node = this.head;
        if(this.size==1){
            this.head=this.tail=null;  
        }else{
           this.head = this.head.next; // changing head's position
           node.next=null; // breaking the link
        }
        this.size--;
        return node;
    }
    public int removeFirst(){
        if(this.size==0){
            return -1;
        }
        Node node =removeFirstNode();
        return node.data; 
    }

    private Node getFirstNode(){
        return this.head;
    }
    public int getFirst(){
        if(this.size==0){
          return -1;
        }
        Node node =getFirstNode();
        return node.data;
    }

    private Node getLastNode(){
          return this.tail;
    }
    public int getLast(){
        if(this.size==0){
            return -1;
        }
        return getLastNode().data;
    }
    
    private Node getNodeAt(int idx){
        Node curr = this.head;
        int count = 0;
        while (count != idx) {
            curr = curr.next;
            count++;
        }
        return curr; 
    }
    public int getAt(int idx){
        if(this.size<=idx || idx<0){
            return -1;
        }
        Node node = getNodeAt(idx);
        return node.data;
    }
 
    private Node removeLastNode(){
        Node node = this.tail;
        if(this.size==1){
            this.head=this.tail = null;
        }else{
            // Node curr = this.head ;
            // while(curr.next.next!=null){
            //     curr = curr.next;
            // }
            // curr.next = null; // or

            Node secondLast =getNodeAt(this.size-2);
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
        return node;   
    }
    public int removeLast(){
        if(this.size==0){
            return -1;
        }
        Node node = removeLastNode();
        return node.data;
    }
    

    private void addNodeAt(Node node , int idx){
        if(idx==0) addFirstNode(node);
        else if (idx==this.size-1) addLastNode(node);
        else{
            Node prevNode = getNodeAt(idx-1);
            Node forwardNode = prevNode.next;
            node.next = forwardNode;
            prevNode.next = node;
        }
        this.size++;
    }
    public void addAt(int idx , int data){
        if(idx<0 || idx> this.size) return ;
        Node node = new Node(data);
        addNodeAt(node, idx);

    }

    private Node removeNode(int idx){
        Node node = getNodeAt(idx);
        if(idx==0) return removeFirstNode();
        else if(idx==this.size-1) return removeLastNode();
        else{
            Node prev = getNodeAt(idx-1);
            Node nextNode = node.next;
            prev.next = nextNode;
            node.next = null;  
            this.size--; 
        }
        return node;
    }
    public int removeAt(int idx){
        if(idx<0|| idx>=this.size) return -1;
        Node node = removeNode(idx);  
        return node.data;
    }
    
    //returns data of mid node 
    public int mid(Node head){
        if(this.head==null) return -1;

        Node slow = this.head;
        Node fast = this.head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow.data;
    }
   
    // returns mid node itself
    public static Node midNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //sgregate odd even linkedlist -> odd comes first
    public Node segOddEven(Node head){
        if(head == null || head.next==null){
            return head;
        }
        Node even = new Node(-1), ep = even , odd = new Node(-1), op = odd;
        Node curr = head ;

        while(curr!=null){
            if(curr.data%2==0){
                ep.next = curr;
                ep = ep.next;
            }else{
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        op.next = ep.next = null;
        op.next = even.next;

        return odd.next;
    }

    public static Node seg01(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node one = new Node(-1),op = one;
        Node zero = new Node(-1), zp = zero;
        Node curr = head;
        while(curr!=null){
            if(curr.data==0){
                zp.next = curr;
                zp = zp.next;
            }else{
                op.next = curr;
                op= op.next;
            }
            curr = curr.next;
        }
        op.next = zp.next = null;
        zp.next = one.next;
        return zero.next;
    }

    public static Node seg012(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node zero = new Node(-1), zp = zero;
        Node one = new Node(-1), op = zero;
        Node two = new Node(-1), tp = zero;
        Node curr= head;
        while(curr!=null){
            if(curr.data==0){
                zp.next = curr;
                zp = zp.next;
            }else if(curr.data==1){
                op.next = curr;
                op= op.next;
            }else{
                tp.next = curr;
                tp = tp.next;
            }
            curr = curr.next;
        }
        op.next = tp.next = zp.next = null;
        op.next = two.next;
        zp.next = one.next;
        return zero.next;

    }

    // ---------------------------
    // Practise

    //remove duplicates
    
    public static Node removedup(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node dummy = new Node(-1);
        Node curr = head;
        Node dp = dummy;
        while(curr!=null){
            while(curr!=null && dp.data==curr.data){
                Node forw = curr.next;
                curr.next=null;
                curr= forw;
            }
            dp.next = curr;
            if(curr!=null){
                dp = dp.next;
                curr = curr.next;
            }

        }
        return dummy.next; // head
    }
    // add two list

    public static Node addtwolist(Node h1,Node h2){
        if(h1==null || h2==null){
            return h1!=null?h1:h2;
        }
        Node l1 = h1, l2 = h2 ;
        Node dummy = new Node(-1), temp = dummy;
        int c =0;
        while(l1!=null || l1!=null || c!=0){
            int sum =0;
            if(l1!=null){
                sum+=l1.data;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2 = l2.next;
            }
            sum+=c;
            c = sum/10;
            prev.next = new Node(sum%10);
            prev = prev.next;

        }
        return dummy.next;
    }

    //fold list 
    public static Node fold(Node head){
        if(head==null|| head.next==null){
            return head;
        }
        Node mid = midNode(head);
        Node nhead = mid.next;
        mid.next = null;
        nhead = reverse(nhead);
        Node c1 = mid;
        Node c2 = nhead;
        while(c2!=null){
            Node f1 = c1.next;
            Node f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
        // if size is even set tail to mid else mid.next;
        return head;
    }
    public static void reverse(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node curr = head, prev = null;
        while(curr!=null){
            Node forw = curr.next;
            curr.next= prev;
            prev = curr;
            curr = forw;
        }
        
    }

    

    // public static void main (String[] args){
    //     Linkedlist l1 = new Linkedlist();
    
    // }
}
