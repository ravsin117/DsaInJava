import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.IsBstPair;
class practice{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data){
            this(data , null , null);
        }

    }

    public static void recPreorder(Node node,ArrayList<Integer>ans){
        if(node==null){
            return ;
        }
        ans.add(node.data);
        recPreorder(node.left,ans);
        recPreorder(node.right,ans);
    }

    public static void recInorder(Node node, ArrayList<Integer>ans){
        if(node==null){
            return ;
        }
        recInorder(node.left,ans);
        ans.add(node.data);
        recInorder(node.right,ans);
    }

    public static void recPostOrder(Node node , ArrayList<Integer> ans){
        if(node==null){
            return;
        }
        recPostOrder(node.left,ans);
        recPostOrder(node.right,ans);
        ans.add(node.data);
    }

    //iterative inorder with stack(Striver)
    public static List<Integer> iterativeInorder(Node node){
        if(node==null)
        return null;
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<Node>st = new Stack<>();
        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty())
                break;
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
        
    }
    
    // inorder leetcode recursive soln by rajneesh sir
    public static List<Integer> inorderTrav(Node node){
        if(node==null){
            return new ArrayList<>();
        }
        List<Integer>ans = new ArrayList<>();
        List<Integer> left = inorderTrav(node.left);
        for(int ele :left){
            ans.add(ele);
        }
        ans.add(node.data);
        List<Integer> right = inorderTrav(node.right);
        for(int ele:right){
            ans.add(ele);
        }
        return ans;
    }

    //size
    public static int sizeOftree(Node node){
        if(node==null){
            return 0;
        }
        int count = 0;
        int ls = sizeOftree(node.left);
        count+=ls;
        int rs = sizeOftree(node.right);
        count+=rs;
        return count+1;
    }
    
    //sum of all node
    public static int sumOfNodes(Node node){
        if(node==null){
            return 0;
        }
        int sum = 0 ; 
        int lsum = sumOfNodes(node.left);
        sum+=lsum;
        int rsum = sumOfNodes(node.right);
        sum+=rsum;
        return sum+node.data;
    }
    
    // max of all node
    public static int maxOfAllNode(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int maxval = 0;
        int lmax = maxOfAllNode(node.left);
        int rmax = maxOfAllNode(node.right);
        maxval = Math.max(node.data,Math.max(lmax,rmax));
        return maxval;
    }

    // min of all node
    public static int minOfAllNode(Node node){
        if(node ==null){
            return Integer.MAX_VALUE;
        }
        int minVal = 0 ; 
        int lmin = minOfAllNode(node.left);
        int rmin = minOfAllNode(node.right);
        minVal = Math.min(node.data,Math.min(lmin,rmin));
        return minVal;
    }
    //height of all node(int term of node)
    public static int heightOfTree(Node node){
        if(node==null){
            return 0;
        }
        int fh = 0 ; 
        int lh = heightOfTree(node.left);
        int rh = heightOfTree(node.right);
        fh = Math.max(lh,rh)+1;
        return fh;
    }

    // height in term of edge
    public static int heightOfTreeE(Node node){
        if(node==null){
            return -1;
        }
        int fh = 0; 
        int lh = heightOfTreeE(node.left);
        int rh = heightOfTreeE(node.right);
        fh = Math.max(lh,rh)+1;
        return fh;
    }
    // no of leaf node in binary tree
    public static int countOfLeafNode(Node node){
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }
        int lc = countOfLeafNode(node.left);    
        int rc = countOfLeafNode(node.right);    
        
        return lc+rc;
    }
    // print & store node having excatly one child
    public static void printExcaltyOneChildNode(Node node,ArrayList<Integer>ans){
        if(node==null || (node.left==null && node.right==null)){
            return;
        }
        if(node.left==null || node.right==null){
            ans.add(node.data);
            System.out.println(node.data);
        }
        printExcaltyOneChildNode(node.left,ans);
        printExcaltyOneChildNode(node.right,ans);
    }

    // count nodes having excatly one child in binary tree
    public static int countOfNodesWithExcatlyOneChild(Node node){
        if(node==null || (node.left==null && node.right==null)){
            return 0;
        }        
        int lc =countOfNodesWithExcatlyOneChild(node.left);
        int rc =countOfNodesWithExcatlyOneChild(node.right);
        if(node.left==null || node.right==null){
            return lc + rc +1;
        }
        return lc+rc;
        
    }

    // node to root path : rajnessh sir approach 1

    public static boolean nodeToRootPath(Node node, int data,ArrayList<Node>ans){
        if(node==null){
            return false;
        }
        if(node.data == data){
            ans.add(node);
            return true;
        }
        boolean res = nodeToRootPath(node.left, data, ans)|| nodeToRootPath(node.right, data, ans);
        if(res)
        ans.add(node);
        return res;

    }
    public static ArrayList<Node> storeNodeToRootPath(Node node,int data){
        if(node==null){
            return null;
        }
        ArrayList<Node>ans = new ArrayList<>();
        nodeToRootPath(node, data,ans);
        return ans;
    }

    // node to root path with 1 function only 
    public static ArrayList<Node> nodeToRootPath_02(int x , Node node){
        if(node==null){
            return null;
        }
        if(node.data == x){
            ArrayList <Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<Node> myAns = new ArrayList<>();
        ArrayList<Node>left = nodeToRootPath_02(x,node.left);
        if(left!=null){
            for(Node ele : left){
                myAns.add(ele);
            }
            return myAns;
        }
        ArrayList<Node> right = nodeToRootPath_02(x, node.right);
        if(right!=null){
            for(Node ele : right){
                myAns.add(ele);
            }
            return myAns;
        }
        return null; // if i have received null from both left and right so node doesnt exist there and i must return null therefore

    }

    //striver node to root path
    public static boolean nodeToRootPath_Striver(ArrayList<Integer>ans,int x, Node node){
        if(node==null){
            return false;
        }
        ans.add(node.data);
        if(node.data == x){
            return true;
        }
        if(nodeToRootPath_Striver(ans, x, node.left)||nodeToRootPath_Striver(ans, x, node.left)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

    // print k levels down
    public static void printKLevelsDown(Node node , int k , ArrayList<Node>ans){
        if(node==null || k< 0){
            return;
        }
        if(k==0){
            ans.add(node);
            return ;
        }
        printKLevelsDown(node.left, k-1, ans);
        printKLevelsDown(node.right, k-1, ans);

    }

    //print/store nodes that are k distance away : rajneesh
    public static ArrayList<Integer>kAway(Node node , int x, int k){
        ArrayList<Node>list = new ArrayList<>();
        if(node==null)
        return null;

        nodeToRootPath(node,x,list);
        Node block = null;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0 ; i< list.size();i++){
            addKLevelDown(node, k-i,block, res);
            block = list.get(i);
        }
        return res;
    }
    public static void addKLevelDown(Node node , int k , Node block,ArrayList<Integer>res){
        if(node==null || k< 0 || node==block){
            return ;
        }
        if(k==0){
            res.add(node.data);
            return;
        }
        addKLevelDown(node.left, k-1, block, res);
        addKLevelDown(node.right, k-1, block, res);
    }

    // method 2 -> print/store nodes k levels away TC-O(N) , SC-O(1)
    public static int kAway_02(Node node, int data , int k , ArrayList<Integer>ans){
        if(node==null){
            return -1;
        }
        if(node.data == data){
            addKLevelDown(node, k,null,ans);
            return 1;
        }
        int ld = kAway_02(node.left, data, k, ans);
        if(ld!=-1){
            addKLevelDown(node, k-ld,node.left,ans);
            return ld+1;
        }
        int rd = kAway_02(node.right, data, k, ans);
        if (rd != -1) {
            addKLevelDown(node, k - rd, node.right, ans);
            return rd + 1;
        }
        return -1;
    }
    
    // is binary search tree method 1 
    static Node prev = null;
    public static boolean isBST(Node node){
        if(node==null){
            return true;
        }
        if(!isBST(node.left)){
            return false;
        }
        
        if(prev!=null && prev.data>node.data){
            return false;
        }
        prev = node;
        if(!isBST(node.right)){
            return true;
        }
        return true;
    }

    // method 2 -> by making using use pair class
    public  static class isBstPair{
        boolean isBst = true;
        long maxElem = Integer.MIN_VALUE;
        long minElem = Integer.MAX_VALUE;
        isBstPair(boolean isBst, long maxElem , long minElem){
            this.isBst = isBst;
            this.maxElem = maxElem;
            this.minElem = minElem;
        }
        isBstPair(){
            
        }
    }
    public static isBstPair isBst_02(Node node){
        if(node==null){
            return new isBstPair();
        }

        isBstPair left = isBst_02(node.left);
        if(left.isBst==false){
            return left;
        }
        isBstPair right = isBst_02(node.right);
        if(right.isBst==false)
            return right;

        isBstPair self = new isBstPair();
        self.isBst = false;
        if(right.maxElem<node.data && left.minElem > node.data){
            self.maxElem = Math.max(node.data,right.maxElem);
            self.minElem = Math.min(node.data,left.minElem);
            self.isBst = true;
        }    
        return self;
    }
    

}