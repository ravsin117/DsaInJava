import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class practice{
    
    public static class Node{
        int val = 0 ;
        Node left = null;
        Node right = null;
        Node(int val , Node left , Node right){
            this.val = val ;
            this.left = left;
            this.right = right;
        }
        Node(int data){
            this(data,null,null);
        }
    }
    //preorder
    public static void preorder(Node head){
        if(head==null) return ;
        System.out.println(head.val);
        preorder(head.left);
        preorder(head.right);
    }
    //inorder -> recursive
    public static void inorder(Node head){
        if(head==null) return ;
        inorder(head.left);
        System.out.println(head.val);
        inorder(head.right);
    }
    //inorder recursive 2 R
    public static ArrayList<Integer> inorder_1(Node head){
        if(head==null){
            return new ArrayList<>();
        }
        ArrayList<Integer>myAns = new ArrayList<>();
        ArrayList<Integer> left = inorder_1(head.left);
        for(int ele: left){
            myAns.add(ele);
        }
        myAns.add(head.val);
        ArrayList <Integer> right = inorder_1(head.right);
        for(int ele:right){
            myAns.add(ele);
        }
        return myAns;
    }
    //inorder iterative with stack Tc- ON sc-ON
    public static List<Integer> inorder_2(Node head){
        List<Integer>inorder = new ArrayList<Integer>();
        stack<Node>st = new stack<Node>();
        Node node = head;
        while(true){
            if(node!=null){
             st.push(node);
             node = node.left; 
            }else{
              if(st.isEmpty()){
                  break;
              }
              node = st.pop();
              inorder.add(node.val);
            }
        }
        return node;

    }

    //postorder
    public static void postorder(Node head){
        if(head==null) return ;
        postorder(head.left);
        postorder(head.right);
        System.out.println(head.val);
    }

    // size
    public static int size(Node head){
        if(head==null)
        return 0;
        int count = 0;
        int lcount = size(head.left);
        int rcount = size(head.right);
        count+=(lcount+rcount);
        return count+1;
    }

    //height edge
    public static int height(Node head){
        if(head==null)
        return -1;
        int lh =height(head.left);
        int rh = height(head.right);
        int maxh = Math.max(lh,rh)+1;
        return maxh;

    }
    //height nodes
    public static int height_2(Node head){
        if(head==null)
        return 0;
        int lh = height_2(head.left);
        int rh = height_2(head.right);
        int maxh = Math.max(lh,rh)+1;
        return maxh;
    }
    // no of leaf nodes 
    public static int leafnodescount(Node head){
        if(head==null)
        return 0;
        if(head.left==null && head.right==null)
        return 1;

        int lcount = leafnodescount(head.left);
        int rcount = leafnodescount(head.right);
        return lcount + rcount;

    }
    // print parent having exactly one child
    public static void countparentwithoneChild(Node head){
        if(head==null || (head.left==null && head.right==null)){
            return ;
        }
        if(head.left==null || head.right==null){
            System.out.println(head.val);
        }
        countparentwithoneChild(head.left);
        countparentwithoneChild(head.right);
    }

    // count single childed parent
    public static int countParent(Node head){
        if(node==null ||(node.left==null && node.right==null)){
            return 0;
        }
        int sum =0;
        int leftC= countParent(head.left);
        int rightC = countParent(head.right);
        if(head.left==null|| head.right==null){ // single parent
            sum+=1;
        }
        return sum;
    } 

    //node to root path striver 
    public static boolean getPath(Node head, ArrayList<Integer> ans , int data){
        if(head==null){
            return false;
        }
        ans.add(head.val);
        if(head.val==data){
            return true;
        }
        if(getPath(head.left, ans, data)|| getPath(head.right, ans, data)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    // node to root path R
    // findData
    public static boolean findData(int data , Node node){
        if(node ==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        return findData(data,node.left)|| findData(data, node.right);
    }

    //node to root path -2
    public static boolean nodeToRootpath(Node node , ArrayList<Node>ans , int data){
        if(node ==null){
            return false;
        }
        if(node==data){
            ans.add(node);
            return true;
        }
        boolean res = nodeToRootpath(node.left, ans, data)|| nodeToRootpath(node.right, ans, data);
        if(res){
            ans.add(node);
        }
        
        return res;
    }

    //node to root path method3
    public static ArrayList<Node> nodetorootpath_3(Node node, int data){
        if(node==null){
            return null;
        }
        if(node.val ==data ){
            ArrayList<Node> base= new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList <Integer> left = nodetorootpath_3(node.left, data);
        if(left!=null){
            left.add(node);
            return left;
        }
        ArrayList <Integer> right = nodetorootpath_3(node.left, data);
        if(right!=null){
            right.add(node);
            return right;
        }
        return null;
    }

    //print K levels down
    public static void printKlevelsDown(Node node , int k , ArrayList<Integer>ans){
        if(node==null || k<0){
            return;
        }
        if(k==0){
            System.out.println(node.val);
            return;
        }
        printKlevelsDown(node.left, k-1, ans);
        printKlevelsDown(node.right, k-1, ans);
    }
    //print node that are k distance away
    public static ArrayList<Integer>kaway(Node node,int data,int k){
        ArrayList<Node>ans = new ArrayList<>();
        nodeToRootpath(node, ans, data);
        ArrayList<Integer>res = new ArrayList<>();
        Node block = null;
        for(int i = 0 ; i< ans.size();i++){
            kleveldown(ans.get(i),k-i,block,res);
            block = ans.get(i);
        }
        return ans;
    }
    public static void kleveldown(Node node , int k , Node block , ArrayList<Integer> res){
        if(node==null || node==block || k<0){
            return ;
        }
        if(k==0){
            res.add(node.val);
        }
        kleveldown(node.left, k-1, block, res);
        kleveldown(node.right, k-1, block, res);
    }

    // method 2 of print nodes that are k distance away
}