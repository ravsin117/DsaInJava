public class practice {

    public static class Node{
       int data = 0;
       Node next = null;

       Node(int data){
           this.data = data;
       }
       Node(){

       }
    }
    // sgregate odd even linkedlist -> odd comes first
    public Node segOddEven(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node even = new Node(-1), ep = even, odd = new Node(-1), op = odd;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                ep.next = curr;
                ep = ep.next;
            } else {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        op.next = ep.next = null;
        op.next = even.next;

        return odd.next;
    }

    public static Node seg01(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node one = new Node(-1), op = one;
        Node zero = new Node(-1), zp = zero;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zp.next = curr;
                zp = zp.next;
            } else {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        op.next = zp.next = null;
        zp.next = one.next;
        return zero.next;
    }

    public static Node seg012(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        None zero = new Node(-1), zp = zero;
        None one = new Node(-1), op = zero;
        None two = new Node(-1), tp = zero;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zp.next = curr;
                zp = zp.next;
            } else if (curr.data == 1) {
                op.next = curr;
                op = op.next;
            } else {
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

    public static Node removedup(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(-1);
        Listnode curr = head;
        Listnode dp = dummy;
        while (curr != null) {
            while (curr != null && dp.data == curr.data) {
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            dp.next = curr;
            if (curr != null) {
                dp = dp.next;
                curr = curr.next;
            }

        }
        return dummy.next; // head
    }
    // add two list

    public static Node addtwolist(Node h1, Node h2) {
        if (h1 == null || h2 == null) {
            return h1 != null ? h1 : h2;
        }
        Node l1 = h1, l2 = h2;
        Node dummy = new Node(-1), temp = dummy;
        int c = 0;
        while (l1 != null || l1 != null || c != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += c;
            c = sum / 10;
            prev.next = new Node(sum % 10);
            prev = prev.next;

        }
        return dummy.next;
    }

    // fold list
    public static Node fold(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = midNode(head);
        Node nhead = mid.next;
        mid.next = null;
        nhead = reverse(nhead);
        Node c1 = mid;
        Node c2 = nhead;
        while (c2 != null) {
            Node f1 = c1.next;
            Node f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
        // if size is even set tail to mid else mid.next;

    }

    // reverse a list
    public static void reverse(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node curr = head, prev = null;
        while (curr != null) {
            Node forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

    }

    // merge two list
    public static Node merge2list(Node h1 ,Node h2){
        if(h1==null || h2 == null){
            return h1!=null ? h1 : h2;
        }
        Node c1 = h1 ;
        Node c2 = h2;
        Node dummy = new ListNode(-1), prev = dummy;
        while(c1!=null && c2!=null){
            if(c1.val<=c2.val){
                prev.next = c1;
                prev = prev.next;
                c1 = c1.next;
            }else{
                prev.next = c2;
                prev = prev.next;
                c2= c2.next;
            }

        }
        prev.next = c1!=null ? c1: c2;
        return dummy.next;
    }

    // sort a list -> merge sort in linkedlist
    public static Node sortList(Node head){
        if(head == null || head.next==null)
        return head;
        Node mid = midNode(head);
        Node nhead = mid.next;
        mid.next = null;
        Node leftList = sortList(head);
        Node rightList= sortList(nhead);

        return merge2list(leftList, rightList);
    }
    // is a list palindrome 

    public static boolean isPalindrome(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid = midNode(head);
        Node nhead = mid.next;
        mid.next = null;
        nhead = reverse(nhead);
        Node c1 = head;
        Node c2 = nhead;
        while(c2!=null){
            if(c1.val!=c2.val){
                return false;

            }
            c1 = c1.next;
            c2 = c2.next;
        }
         nhead = reverse(nhead); // repairing list
         mid.next = nhead;
         return true;
    }

    // lev2
    // unfold list
    
    // remove kth from end

    // mergek sorted list

    // reverse in range

    // removellduplicatesinsortedlist -> non duplicate must be remaining in the list 

    // subtract two list

    // multiply two list

    // random pointer

    // cycle detedction

    // starting point of cycle/loop 

    // intersection of two list

    // segregatenode of LinkedList Over LastNode

    // segregate Over Pivot Index

    // quicksort in LL

    // LRU cache Implementation


}
