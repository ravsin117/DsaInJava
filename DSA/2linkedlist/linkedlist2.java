public class linkedlist2 {

    private class Node{
        int data = 0 ; 
        Node next = null;

        Node(){

        }
        Node (int data){
            this.data = data;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    private void addFirst(Node node){
        if(this.size==0){
            this.head = this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    } 
    public void addFirst(int data){
        Node node  = new Node(data);
        addFirst(node);
    }

    private void addLast(Node node){
        if(this.size==0){
            this.head = this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }
    public void addLast(int data){
        Node node = new Node(data);
        addLast(node);
    }
    
    private Node removeFirstNode(){
        Node node = this.head;
        if(this.size==1){
            this.head = this.tail = null;
        }else{
            // creating a duplicate connection
            Node nn = this.head.next;
            //break connection
            this.head.next = null;
            this.head = nn;        
        }
        this.size--;
        return node;            

    }
    public int removeFirst(){
        if(this.size==0){
            return -1;
        }
        Node node = removeFirstNode();
        return node.data;
    }

    private Node removeLastNode(){
        Node node = this.tail;
        if(this.size==1){
            this.tail = this.head = null;
        }else{
            Node nn = this.head;
            while(nn.next!=this.tail){
                nn = nn.next;
            }
            nn.next = null;
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


    private Node getFirstNode(){
        return this.head;
    }
    public int getFirst(){
        if(this.size<=0){
            return -1;
        }
        Node node = getFirstNode();
        return node.data;
    }


    private Node getLastNode(){
        return this.tail;
    }
    public int getLast(){
        if(this.size<=0){
            return -1;
        }
        Node node = getLastNode();
        return node.data;
    }


    public Node getNodeAt(int idx){
        Node curr = this.head;
        int count=0;
        while(count!=idx){
            curr = curr.next;
            count++;
        }
        return curr;
    }
    public int getAt(int idx){
        if(idx<0 || idx>this.size){
            return -1;
        }
        Node node = getNodeAt(idx);
        return node.data;
    }

    public void addAt(Node node , int idx){
        if(idx==0){
           addFirst(node);
        }else if(idx == this.size-1){
            addLast(node);
        }else{
            Node prev = getNodeAt(idx-1);
            Node curr = prev.next;
            prev.next = node;
            node.next = curr;
        }
        this.size++;
        return;
    }

    public void removeNode(int idx){
        if(idx==0){
            removeFirst();
            return;
        }else if(idx== this.size-1){
            removeLastNode();
        }else{
            Node node = getNodeAt(idx);
            Node prev = getNodeAt(idx-1);
            prev.next = node.next;
            node.next = null;
        }
        this.size--;
        return;
    }

    // mid of a node
    public Node getMidNode(Node node){
        if(node==null || node.next==null){
            return node ;
        }
        Node slow = head , fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // segregate odd and even list
    //> odd first
    public Node segragateOddEven(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node even = new Node() , ep = even , odd = new Node(), op = odd;
        Node curr = head;
        while(curr!= null){
            if(curr.data%2==1){
                ep.next = curr;
                ep = ep.next;
            }else{
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        op.next = ep.next= null;
        op.next = even.next;
        return odd.next;
    }

    //remove duplicate Nodes 
    public  Node removeDuplicate(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node dummy = new Node(-1);
        Node dp = head , curr = dp.next;
        while(curr!=null){
            while(curr!=null && dp.data == curr.data){
                Node forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            dp.next = curr;
            if(curr != null){
                curr = curr.next;
                dp = dp.next;
                
            }
        }
        return dummy.next;
    }
    
    // add 2 linkedlist
    public Node add2list(Node l1 , Node l2){
        
    }
}
