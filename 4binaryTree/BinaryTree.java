import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTree{
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left , Node right){
            this.data = data ;
            this.left = left;
            this.right = right;
        }
        Node(int data){
            this(data,null,null); // constructor chaining : its calling above constructor
            // we can write this.data = data but why write it again when we can acces it from above
            // this.data = data;
        }
    }
    
    //recursive preorder
    public static void preOrder(Node root,ArrayList<Integer>ans){
        if(root==null) 
        return ;
        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);

    }
    
    // recursive inorder
    public static void inorder(Node root, List<Integer>ans){
        if(root==null)
        return ;
        inorder(root.left,ans);
        ans.add(root.data);
        inorder(root.right,ans);
    }

    //iterative inorder traversal wit stack (Striver)
    public static List<Integer>inorderIt(Node root){
        List<Integer>inorder = new ArrayList<Integer>();
        Stack<Node>stack = new Stack<Node>();
        Node node = root;
        while(true){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{ // reached on null node 
                if(stack.isEmpty())
                break;

                node = stack.pop();
                inorder.add(node.data);
                node = node.right;
            }

        }
        return inorder;
    } 

    //inorder lettcode  by recursion(Rajneesh)
    public static List<Integer> inordertrav(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> myAns = new ArrayList<>();
        List<Integer>left = inordertrav(root.left);
        for(int ele :left){
            myAns.add(ele);
        }
        myAns.add(root.data);
        List<Integer>right = inordertrav(root.right);
        for(int ele :right){
            myAns.add(ele);
        }
        return myAns;
    }
    
    //recursive postorder
    public static void preorder2(Node root, ArrayList<Integer>ans){       
        if(root==null)
        return ;

        preorder2(root.left,ans);
        preorder2(root.right,ans);
        ans.add(root.data);
    }

    //size (My approach)
    public static int size(Node root){
        if(root==null)
        return 0;
        int count = 0;
        int left =size(root.left);
        count += left;
        int right = size(root.right);
        count+=right;
        return count+1; // +1 for root itself

        // 1line sol by rajneesh
        // return node==null ?0:size(node.left)+size(node.right)+1;
    }
    
    //sum of all nodes 
    public static int sum(Node root){
        if(root==null)
        return 0;
        int sum = 0;
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        sum+=(lsum+rsum+root.data);
        return sum; 
    }
    
    //max among all nodes
    public static int max(Node root){
        if(root==null)
        return Integer.MIN_VALUE;
        int maxV = 0;
        int lmax = max(root.left);
        int rmax = max(root.right);
        maxV = Math.max(root.data,(Math.max(lmax,rmax)));
        return maxV;
    }
    
    //min amoong all nodes
    public static int min(Node root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
            int minV = 0;
            int lmin = min(root.left);
            int rmin = min(root.right);
            minV = Math.min(root.data,Math.min(lmin,rmin));
            return minV;
    }
    
    // height of the tree :interms of nodes
    public static int height(Node root){
        if(root==null)
        return 0;
        int h = 0 ;
        int lh = height(root.left);
        int rh = height(root.right);
        h = Math.max(lh,rh)+1;
        return h;
    }
    
    //height in terms of edges
    public static int heightE(Node root){
        if(root==null)
        return -1;
        int h = 0 ;
        int lh = height(root.left);
        int rh = height(root.right);
        h = Math.max(lh,rh)+1;
        return h;
    }

    //no of leaf nodes in binary tree
    public static int countLeaves(Node node){
        if(node==null) return 0;
        if(node.left==null&& node.right==null)
        return 1;

        return countLeaves(node.left)+countLeaves(node.right);
    }

    //print nodes having exactly one child in binary tree
    public static void exactlyOneChild(Node node , ArrayList<Integer> ans){
        if(node==null || (node.left==null && node.right==null)){
            return;
        } // leaf doesnt goes below this line 

        if(node.left==null || node.right==null)
            ans.add(node.data);
            
        exactlyOneChild(node.left, ans);
        exactlyOneChild(node.right, ans);
    }   

    // count nodes having exactly one child in tree
    public static int countExactlyOneChild(Node node){
        if(node==null || (node.left==null && node.right==null)){
            return 0;
        }
        int left = countExactlyOneChild(node.left);
        int right = countExactlyOneChild(node.right);
        int sum = left+right;
        if(node.left==null || node.right==null){
            sum+=1;
        }
        return sum;
    }

   //node to root path //RAJNISH SIR 1:
    public static boolean nodeToRootPath(Node root, int data, ArrayList<Node>ans){
       if(root==null){
           return false;
       }
        if(root.data==data){
         ans.add(root);
           return true;
        }
        boolean res = nodeToRootPath(root.left, data, ans)||
        nodeToRootPath(root.right, data, ans);
        if(res) ans.add(root);
        return res;
    }
    
    public static ArrayList<Node> nodeToRootPath(Node root, int data){
    ArrayList<Node>ans = new ArrayList<>();
    nodeToRootPath(root,data,ans);
    return ans ;
    }
  
    // node to root path // method 2 :Rajnish sir
    // with one function only 
    public static ArrayList<Node> nodeToRootpath_02(int x , Node node){
        if(node==null){
            return null;
        }
        if(node.data==x){
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<Node>left = nodeToRootpath_02(x,node.left);
        if(left!=null){
            left.add(node);
            return left;
        }
        ArrayList<Node>right = nodeToRootpath_02(x,node.right);
        if(right!=null){
            right.add(node);
            return right;
        }
        return null;
    }

    // Strivers approach
    public static boolean nodeTorootpath_striver(ArrayList<Integer> ans , int x, Node node){
        if(node==null){
            return false;
        }
        ans.add(node.data);
        if(node.data==x){
            return true;
        }
        if(nodeTorootpath_striver(ans, x, node.left)||nodeTorootpath_striver(ans, x, node.right)){
           return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

    //print k levels down 
    public static void printKLevelDown(Node node,int k , ArrayList<Node>ans){
        if(node==null || k<0 ){
            return ;
        }
        if(k==0){
            ans.add(node);
            return ;
        }
        printKLevelDown(node.left, k-1, ans);
        printKLevelDown(node.right, k-1, ans);
    }

    // print nodes that are kdistance away :Rajnish sir 
    // Print nodes that are k distance away method1
    public static ArrayList<Node>kaway(Node node , int x , int k ){
        if(node==null) return null;
        ArrayList<Node> ans = nodeToRootPath(node, x);// node to root path;
        ArrayList<Node> res = new ArrayList<>();
        Node block=null;
        for(int i = 0 ; i < ans.size();i++){
            addKLevelDown(node, k,block, res);
            block = ans.get(i);
        }
        return res;
    }
    public static void addKLevelDown(Node node, int k , Node block, ArrayList<Node>res){
        if(node==null || (k<0)){
            return ;
        }
        if(k==0){
             res.add(node);
             return ;
        }
        addKLevelDown(node.left, k-1, block, res);
        addKLevelDown(node.right, k-1, block, res);

    }

    //method:2 //T-O(N) S-O(1)
    public static int kaway_2(Node node , int x , int k,ArrayList<Node>ans){
        if(node==null){
            return -1;
        }
        if(node.data==x){
            addKLevelDown(node, k, null, ans);
            return 1;
        }
        int ld = kaway_2(node.left, x, k, ans);
        if(ld!=-1){
            addKLevelDown(node, k-ld, node.left,ans);
            return ld+1;
        }
        int rd = kaway_2(node.right, x, k, ans);
        if(rd!=-1){
            addKLevelDown(node, k-rd,node.right ,ans);
            return rd+1;
        }
        return -1;
    }

    //Is binary search tree method 1
    // method 1
    static Node prev= null;
    public static boolean isBst(Node node){
        if(node==null){
            return true;
        }
        if(isBst(node.left)){
            return false;
        }
        if(prev!=null && prev.data > node.data){
            return false;
        }
        prev = node;

        if(isBst(node.right)){
            return false;
        }
        return true;
    }

    // method 2 
    public static class IsBstPair{
        boolean isBst = true;
        int maxElem = -(int)1e9;
        int minElem = (int)1e9;
        IsBstPair(){

        }
    }
    public static IsBstPair isBst_01(Node node){
        if(node==null){
            return new IsBstPair();
        }
        IsBstPair left = isBst_01(node.left);
        if(!left.isBst){
            return left;
        }
        IsBstPair right = isBst_01(node.right);
        if(!right.isBst){
            return right;
        }
        IsBstPair self = new IsBstPair();
        self.isBst = false;
        if(left.maxElem<node.data && right.minElem>node.data){
            self.minElem= Math.min(node.data,left.minElem);
            self.maxElem = Math.max(node.data , right.maxElem);
            self.isBst= true;
        }
        return self;
    }

    // strivers approach of isBst

    //is balanced tree O(n2) :rajnish
    public static boolean isbalanced(Node node){
        if(node==null){
            return true;
        }
        if(!isbalanced(node.left)) return false;
        if(!isbalanced(node.right)) return false;
        int lh = height(node.left);
        int rh = height(node.right);
        int diff = Math.abs(lh-rh);
        if(diff>=1){
            return false;
        }
        return true;
    
    }

    // optimised O(N)
    public static int isbal_02(Node node){
        if(node==null){
            return -1;
        }
        int lh = isbal_02(node.left);
        if(lh==-2){
            return -2;
        }
        int rh = isbal_02(node.right);
        if(rh==-2){
            return -2;
        }
        if(Math.abs(lh-rh)>1){
            return -2;
        }
        return Math.max(lh,rh)+1;
    } // in call statement if we receive -2 as result give false else true


    //Tilt of Binary tree
    public static class tiltPair{
        int sum = 0; 
        int tsf = 0;
        tiltPair(){

        }
    }
    public static tiltPair tilt(Node node){
        if(node==null){
            return new tiltPair();
        }
        tiltPair left = tilt(node.left);
        tiltPair right = tilt(node.right);
        tiltPair myPair = new tiltPair();
        myPair.tsf = left.sum+ right.sum+Math.abs(left.sum - right.sum);
        myPair.sum = left.sum+right.sum +node.data;
        return myPair;
    }//myPair.tsf is the result 

    // {tsf,sum}
    public static int[] findTilt(Node node){
        if(node==null){
            int [] base = new int [2];
            return base;
        }
        int left [] = findTilt(node.left);
        int right[] = findTilt(node.right);
        int[] myAns = new int[2];
        myAns[0] = left[0]+right[0]+Math.abs(left[1]-right[1]);
        myAns[1] = left[1] + right[1]+node.data;
        return myAns;
    }

    //diameter of bt striver

    public static int diameter(Node node, int d[]){
        if(node==null){
            return -1;
        }
        int lh = diameter(node.left, d);
        int rh = diameter(node.right,d);
        d[0] = Math.max(d[0],lh+rh+2);
        return Math.max(lh,rh)+1;

    }

    // -------###############################################################################Due
    // largest bst

    //bst
    //size
    public static int BSTsize(Node node){
        if(node==null){
            return 0;
        }
        int ls = BSTsize(node.left);
        int rs = BSTsize(node.right);

        return ls+rs+1;
    }
    // minimum
    public static int minimumBST(Node node){
        if(node==null)
        return 0;
        while(node.left!=null){
            node= node.left;
        }
        return node.data;
    }

    //maximum
    public static int BSTmaximum(Node node){
        if(node==null){
            return 0;
        }
        while(node.right!=null){
            node = node.right;
        }
        return node.data;
    }
    //find
    public static boolean find(Node node, int val){
        while(node!=null){
            if(node.data<val){
                node= node.right;
            }else if(node.data>val){
                node = node.left;
            }else{
                return true;
            }
        }
        return false;
    }
    //node to root path
    public static ArrayList<Node> rootToNodePath(Node node , int val){
        ArrayList<Node> ans = new ArrayList<>();
        boolean flag = false;
        while(node!=null){
            ans.add(node);
            if(node.data==val){
                flag = true;
                break;
            }else if(node.data<val){
                node =node.right;
            }else{
                node = node.left;
            }
        }
        if(!flag)
        ans.clear();
        
        Collections.reverse(ans);
        return ans;
    }

    
    //lowest common ancestor
    public static int lowestCommonAns(Node node , int d1 , int d2){
        int lca = -1;
        while(node!=null){
            if(node.data<d1 && node.data<d2){
                node= node.right;
            }else if(node.data>d1 && node.data>d2){
                node = node.left;
            }
            else{
                lca = node.data;
                break;
            }
        }
        return lca;
    }

    //print in range
    public static void printInRange(Node node , int lr , int rr){
        if(node==null){
            return ;
        }
        printInRange(node.left, lr, rr);
        if(node.data>=lr && node.data<=rr){
            System.out.println(node.data);
        }
        printInRange(node.right, lr, rr);

    }

    //add node to bst
    public static Node addTobst(Node node,int val){
        if(node==null){
            return new Node(val);
        }
        if(node.data<val){
            node.right = addTobst(node.right, val);
        }else if(node.data>val){
            node.left = addTobst(node.left, val);
        }
        return node;
    }
    

    //remove node in bst
    public static Node removeElem(Node node , int val){
        if(node==null){
            return null;
        }
        if(node.data<val){
            node.right = removeElem(node.right, val);
        }else if(node.data>val){
            node.left = removeElem(node.left, val);
        }else{
            //reached node 
            //-> can be leaf node or a node that is a single parent
            // these cases handled by below line
            if(node.left==null || node.right==null){
                 return node.left!=null ? node.left :node.right;
            }
            int minElem = minimumBST(node.right);
            node.data = minElem;
            node.right = removeElem(node.right, minElem);
        }
        return node;
    }

    //transform a bst to greater sum tree

    public static void greaterSum(Node node, int [] arr){
        if(node==null){
            return ;
        }
        greaterSum(node.right, arr);
        arr[0]= node.data+arr[0];
        node.data = arr[0];
        greaterSum(node.left,arr);

    }

    //generic tree

    //size
    //height
    //min
    //max
    //sum
    //find
    //countleaves
    //node to root path
    //lca
    //distance between two node in generic tree
    //are trees similar
    //are trees mirror
    //ceil and floor
    //kth largest element
    //linearize





}