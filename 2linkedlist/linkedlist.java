public class linkedlist {   
       
    private class Node{ 
        int data = 0;
        Node next = null;
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
        else if (idx==this.size) addLastNode(node);
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
    public int mid(){
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
    public Node midNode(Node head){
        Node slow = this.head;
        Node fast = this.head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    

    // public static void main (String[] args){
    //     Linkedlist l1 = new Linkedlist();
    
    // }
}
