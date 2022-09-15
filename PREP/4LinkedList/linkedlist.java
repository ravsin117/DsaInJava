import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class linkedlist {

    private class Node {
        int data = 0 ; 
        Node next = null ;
        Node(){

        }
        Node(int data){
            this.data = data ;
        }
    }

    private Node head = null ;
    private Node tail = null;
    private int size = 0 ;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void addFirst(Node node){
        if(this.size==0){
            this.head = this.tail =  node ;
        }else{
            node.next = this.head;
            this.head = node ;
        }
        this.size++;
    }
    public void addFirst(int data){
        Node node = new Node(data);
        addFirst(node);
    }

    public void addLast(Node node){
        if(this.size==0){
            this.head = this.tail = node ;
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
    

    private Node  removeFirstNode(){
        Node nNode = this.head; // return new Node
        if(this.size==1){
            this.head = this.tail = null;
        }else{
            this.head= this.head.next;
            nNode.next= null;
        }
        this.size--;
        return nNode;
    }
    public int removeFirst(){
        if(this.size==0){
            return -1;
        }
        Node node = removeFirstNode();
        return node.data;
    }

    private Node getFirstNode(){
        return this.head;
    }
    public int getFirst(){
        if(this.size==0) return -1;
        Node node = getFirstNode();
        return node.data;
    }

    private Node getLastNode(){
        return this.tail;
    }
    public int getLast(){
        if(this.size==0) return -1;
        Node node = getLastNode();
        return node.data;
    }

    private Node getNodeAt(int idx){
        if(idx==0){return this.head;}
        Node node = this.head;
        while(idx-- >0){
            node = node.next;
        }
        return node;
    }
    public int getNode(int idx){
        if(idx>=this.size || idx<0){
            return -1;
        }
        Node node = getNodeAt(idx);
        return node.data;
    }
    
    private Node removeLastNode(){
        Node node = this.tail;
        if(this.size==0){
            this.tail = this.head = null;
        }else{
            Node prev = this.head;
            while(prev.next!=this.tail){
                prev = prev.next;
            }
            prev.next = null;
            this.tail = prev;
        }
        return node ;
    }
    public int removeLast(){
        if(this.size==0) return -1;
        Node node = removeLastNode();
        return node.data;
    }
    
    private void addNodeAt(int idx , Node node){
        if(idx==0) addFirst(node);
        if(idx== this.size-1.) addLast(node);

        Node prev = getNodeAt(idx-1);
        Node curr = prev.next;
        
        prev.next = node ;
        node.next = curr;
        this.size++;
    }
    public void addAt(int idx , int data){
        if(idx<0 || idx>this.size){
            return;
        }
        Node node = new Node(data);
        addNodeAt(idx,node);
    }
    
    private Node removeNode(int idx){
        if(idx==0) removeFirstNode();
        if(idx== this.size-1) removeLastNode();

        Node prev = getNodeAt(idx-1);
        Node curr = prev.next;

        prev.next = curr.next;
        curr.next = null;
        this.size--;
        return curr;
    }
    public int removeAt(int idx){
        if(idx<0 || idx >= this.size){
            return -1;
        }
        Node node = removeNode(idx);
        return node.data;
    }
    
    // mid node -> either return the mid node or its data
    public int getMidNode(Node head){
        if(head == null || head.next==null){
            return head.data;
        }
        Node slow = head , fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public  Node getMid(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node fast = head , slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;    
    }

    // segregate odd even linkedlist
    public  Node segOddEven(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node even = new Node(-1);
        Node odd = new Node(-1), ep = even , op = odd;
        Node curr = head;
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
    //segregate 01 
    public  Node seg01(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node one = new Node(-1) , op = one , zero = new Node(-1) , zp = zero;
        Node curr = head;
        while(curr!=null){
            if(curr.data==0){
                zp.next = curr;
                zp = zp.next;
            }else{
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;            
        }
        op.next = zp.next = null;
        zp.next = one.next ;
        return zero.next;
    }
    
    // remove duplicates 
    public  Node removeDuplicates(Node head){
        if(head== null || head.next == null){
            return head;
        }
        Node dummy = new Node(-1) ;
        Node dp = dummy ;
        Node curr = head.next ;
        dummy.next = head ;
        dp = dummy.next;
        while(curr!=null){
            while(curr!=null && dp.data==curr.data){
                Node forw = curr.next;
                curr.next = null ;
                curr = forw;
            }
            dp.next = curr ;
            dp = dp.next;
            if(curr!= null){
                curr = curr.next;
            }    
        }
        return dummy.next;
    }    
    
    // reverse a list 
    public  Node reverseList(Node head){ 
    if(head == null || head.next== null){
            return head;
        }
        Node prev = null , curr = head;
        while(curr!=null){
            Node forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    // add two list
    public  Node getSumList(Node h1 , Node h2){
        if(h1 == null || h2== null){
            return h1!=null ? h1 : h2;
        }
        Node l1 = reverseList(h1);
        Node l2 = reverseList(h2);
        Node aSum = new Node() , sp = aSum;
        int carry = 0;
        while(l1 != null || l2 !=null || carry !=0){
            int sum = 0;
            if(l1!=null){
                sum = l1.data;
            }
            if(l2!=null){
                sum += l2.data;
            }
            sum+=carry;
            
            carry = sum/10;
            sum = sum%10;
            Node sNode = new Node(sum);
            sp.next = sNode;
            sp = sp.next;
        }
        return aSum.next;
    }
    // fold a list
    public  Node foldList(Node head){
        if(head == null || head.next == null){
            return head ;
        }
        Node midNode = getMid(head);
        Node  second = midNode.next;
        midNode.next = null;
        Node cur1 = head , dummy = head;
        Node cur2 = reverseList(second);

        while(cur2!=null){
            Node for1 = cur1.next;
            Node for2 = cur2.next;
            cur1.next = cur2;
            cur2.next = for1;
            cur1 = for1;    
            cur2 = for2;    
        }
        // if the size of list id odd then mid is tail else it is mid.next
        return head; 
    }

    // merge two sorted lists
    public  Node mergetwoList(Node l1 , Node l2){
        if(l1==null || l2 == null){
            return l1==null?l2:l1;
        }
        Node dummy = new Node(-1) , prev = dummy ;
        Node c1 = l1 , c2 = l2;
        if(l1.data <= l2.data){
            dummy.next = l1;
        }else{
            dummy.next= l2;
        }
        while(c1!=null && c2!=null){
            
            if(c1.data<=c2.data){
                prev.next = c1;
                prev = prev.next;
                c1 = c1.next;
            }else{
                prev.next = c2;
                prev = prev.next;
                c2 = c2.next;
            }

        }
        if(c1!=null) prev.next = c1;
        else {
            prev.next = c2;
        }
        return dummy.next;
        
    }
    // sort list
    public Node sortList(Node head){
        
        Node mid = getMid(head);
        Node nhead = mid.next;
        mid.next = null;
        Node leftSortedList = sortList(head);
        Node rightSortedList = sortList(nhead);
        
        return mergetwoList(leftSortedList, rightSortedList);
    }
    // checking palindrome 
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node mid = getMid(head);
        Node nhead = mid.next;
        mid.next = null;
        nhead = reverseList(nhead);
        Node c1 = head , c2 = nhead;
        while(c1!= null && c2!=null){
            if(c1.data!=c2.data){
                return false;
            }else{
                c1 = c1.next;
                c2 = c2.next;
            }
        }
        return true;
    }

    // segregate 012 
    
    
    
    public static void main(String[] args){

    }
}
