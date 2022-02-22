import java.util.List ;
public class linkedlist {

    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // private ListNode head = null;
    // private ListNode tail = null;
    // private int size = 0;

    //midnode
    //reverse a linkedlist
    //ispalindrome
    //fold
    //unfold
    //removeNthfromend
    //swgregateEvenOdd
    public static ListNode segregateOddandEven(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode even = new ListNode(-1) , ep = even ;
        ListNode odd = new ListNode(-1), op = odd;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val%2==0){
                ep.next = curr;
                ep = ep.next;
            }else{
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        op.next = even.next; // for odd first
        ep.next = null;
        return odd.next;

    }
    //segregate01
    public static ListNode segregate01(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode zero = new ListNode(-1), zp = zero;
        ListNode one = new ListNode(-1), op = one;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val==0){
                zp.next =curr;
                zp = zp.next;
            }else{
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        zp.next = one.next;
        op.next = null;

        return zero.next;
    }
    //segregate012 (edge case imp)
    public static ListNode segregate012(ListNode head){
        if(head==null || head.next==null)
        return head;
        ListNode zero = new ListNode(-1), one = new ListNode(-1), two = new ListNode(-1), zp = zero,
        op = one , tp = two, curr = head;
        while(curr!=null){
            if(curr.val==0){
                zp.next = curr;
                zp = zp.next;
            }else if(curr.val==1){
                op.next = curr;
                op = op.next;
            }else{
                tp.next = curr;
                tp = tp.next;
            }
            curr = curr.next;
        }
        op.next = zp.next = tp.next = null;
        op.next = two.next;
        zp.next = one.next;
        return zero.next;

    }

    public static ListNode mergetwoList(ListNode l1, ListNode l2){
        if(l1==null || l2==null)
        return l1!=null?l1:l2;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy , c1= l1,c2 = l2;
        while(c1!=null&& c2!=null){
            if(c1.val<=c2.val){
                p.next = c1;
                c1 = c1.next;
            }else{
                p.next = c2;
                c2 = c2.next;
            }
            p = p.next;
        }
        p.next = c1!=null? c1:c2;
        return dummy.next;   // head of list 

    }

    public static ListNode mergekList(ListNode[] list, int si, int ei) {
        if (si == ei)
            return list[ei];

        int mid = (si + ei) / 2;
        ListNode leftlist = mergekList(list, si, mid);
        ListNode rightlist = mergekList(list, mid + 1, ei);

        return mergetwoList(leftlist, rightlist);

    }
     

    // reverse node in k group
    private static ListNode th = null, tt = null;

    private static void addFirstNode(ListNode node) {  
        if (th == null)
            th = tt = node;
        else {
            node.next = th;
            th = node;
        }
        // return th;

    }

    public static int length(ListNode head) {
        if (head == null)
            return 0;

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;
        int len = length(head);
        ListNode curr = head, oh = null, ot = null;
        while (len >= k) {
            int tempk = k;
            while (tempk-- > 0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }
            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            th = tt = null;
            len -= k;
        }

        ot.next = curr; // even if there still exist some nodes in list they will bw added in list
        return oh;

    }

    public static ListNode reverseInRange(ListNode head ,int n , int m ){
        if(head == null || head.next ==null || n==m)
        return head;
        ListNode dummy = new ListNode(-1), prev = dummy , curr = head;
        prev.next = head;
        int i  = 1;
        while(i<=m){
            while(i>=n && i<=m){
                ListNode forw = curr.next ;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }
            if(i>m){
                prev.next = th;
                tt.next = curr;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    //remove duplicates from linkedlist
   /* 
    // public static ListNode removeDupNode(ListNode head){
    //     if(head ==null || head.next==null)
    //     return head;
    //     ListNode dummy = new ListNode(-101);
    //     ListNode curr = head;
    //     ListNode dp = dummy;
    //     while(curr!=null){
    //         if(curr.val!=dp.val){
    //             dp.next = curr;
    //             dp = curr;
    //         }else{
    //             dp.next=null;
    //             ListNode forw = curr.next;
    //             curr.next = null;
    //             curr = forw;
    //             continue;
    //         }
    //         curr = curr.next;
    //     }
    //     return dummy.next;

    // }
    */

    //better code
    public static ListNode removeDupNodes(ListNode head){
        if(head==null || head.next==null)
        return head;

        ListNode dummy = new ListNode(-1),prev = dummy , curr = head;
        while(curr!=null){
            while(curr!=null && curr.val == prev.val){
                ListNode forw = curr.next;
                curr.next = null ;
                curr = forw;
            }
            prev.next = curr;
            if(curr!=null){
                curr = curr.next;
                prev = prev.next;
            }  
        }
        return dummy.next;
    }

    // reverse a list
     public static ListNode reverse(ListNode head){
         if(head==null || head.next==null)
         return head;
        ListNode prev = null, curr = head;
        while(curr!=null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr ;
            curr= forw;
        } 
        return prev;
     }
     // add two linkedlist version:pepcoding
     public static ListNode addTwoNode(ListNode l1, ListNode l2){
        if(l1==null || l2==null) 
        return l1==null?l2:l1;
        ListNode dummy = new ListNode(-1), prev = dummy;
        ListNode c1 = reverse(l1) , c2 = reverse(l2) ;
        int carry = 0 ;
        while(c1!=null || c2!=null ||carry!=0){
            int sum = carry+(c1!=null ?c1.val:0)+(c2!=null?c2.val:0);
            int digit = sum%10;
            carry = sum /10;
            prev.next = new ListNode(digit);
            prev = prev.next;
            if(c1!=null) c1 = c1.next;
            if(c2!=null) c2 = c2.next;             
        }
        return reverse(dummy.next);
     }

     // add two linkedlist version:leetcode 

     // subtract two linkedlist
    
     // multiply two digits 
    
    public static ListNode multiplyTwoll(ListNode l1,  ListNode l2){
        l1 = reverse(l1);
        l2 = reverse(l2);

         ListNode ans = new ListNode(-1), prev = ans;
        while(l2!=null){
            ListNode producthead = multiplydigits(l1,l2.val);
            addList(prev,producthead);
            prev = prev.next;
            l2 = l2.next;
        }
        return reverse(ans.next);
    }
    public static ListNode multiplydigits(ListNode list , int d ){
        ListNode dummy = new ListNode(-1), curr= list, prev = dummy;
        int carry = 0; 
        while(curr!=null || carry!=0){
            int ans = carry + (curr!=null?curr.val:0)* d;
            int digit = ans%10;
            carry = ans/10;
            prev.next = new ListNode(digit);
            prev =prev.next;
            if(curr!=null)
            curr = curr.next;
        }
        return dummy.next; // new mutliplied list is created here
    }

    public static void addList(ListNode prev, ListNode list){
        int carry =0 ;
        
        while(list!=null || carry!=0){
            int sum = carry + (list!=null?list.val:0)+(prev.next!=null?prev.next.val:0);
            int digit = sum % 10;
            carry = sum/10;
            if(prev.next!=null)
            prev.next.val = digit;
            else
            prev.next = new ListNode(digit);

            prev = prev.next;
            if(list!=null)
            list = list.next;
        }
    }
    //Random pointer question

    //do dubly linkedlist yourself

    // cycle detection in linkedlist
    public static boolean isCycle(ListNode head){
        if(head==null || head.next==null)
        return false;

        ListNode slow = head ;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    
    // starting point of a cycle in LL
    public static ListNode entryPoint(ListNode head){
        if(head==null || head.next==null)
        return null; //*

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){ // cycle exist if true
                while(slow!=entry){
                    slow = slow.next;
                    entry= entry.next;
                }
                return entry;
            }
        }
        return null;
    }
    // intersection point of 2 LL // leetcode 160
    // rajnish sir's approach
    public static ListNode getIntersection(ListNode headA, ListNode headB){
        if(headA==null || headB==null)
        return null;

        ListNode tail = headA;

        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = headB;
        ListNode interPt = entryPoint(headA);
        tail.next= null; // restoring the original list
        return interPt;
    }

    // strivers approach 
    public static ListNode getIntersection2(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        while(d1!=d2){
            if(d1==null){
            d1= headB;
            }else{
                d1= d1.next;
            }
            if(d2==null){
                d2 = headA;
            }else{
                d2= d2.next;
            }
        }
        return d1;
    }

    // many questions to be added 

}
