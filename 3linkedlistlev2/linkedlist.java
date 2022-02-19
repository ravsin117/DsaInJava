import java.util.List ;
public class linkedlist {
    public class ListNode {
        int data = 0;
        ListNode next = null;

        ListNode(int val) {
            this.data = val;
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
    //segregate01
    //segregate012 (edge case imp)
    //

    public static ListNode mergetwoList(ListNode l1, ListNode l2){
        if(l1==null || l2==null)
        return l1!=null?l1:l2;

        ListNode dummy = new ListNode(-1), p = dummy , c1= l1,c2 = l2;
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

}
