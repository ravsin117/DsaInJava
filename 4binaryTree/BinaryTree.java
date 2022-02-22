import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree{
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , int left , int right){
            this.data = data ;
            this.left = left;
            this.right = right;
        }
        Node(int data){
            this(data,null,null); // constructor chaining : its calling above constructor
            // we can write this.data = data but why write it again when we can acces it from above
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
    public static void inroder(Node root, ArrayList<Integer>ans){
        if(root==null)
        return ;
        inorder(root.left);
        ans.add(root.data);
        inorder(root.right);
    }

    //iterative inorder traversal wit stack (Striver)
    public static List<Integer>inorderIt(Node root){
        List<Integer>inorder = new ArrayList<Integer>();
        Stack<Node>stack = new Stack<Node>();
        Node node = root;
        while(true){
            if(node!=null){
                stack.push(node.val);
                node = node.left;
            }else{ // reached on null node 
                if(stack.isEmpty())
                break;

                node = stack.pop();
                inorder.add(node.val);
                node = node.right;
            }

        }
        return inorder;
    } 

    //inorder lettcode  by recursion(Rajneesh)
    public static List<Integer> inordertrav(Node root){
        if(root==null){
            return new ArrayList<>()
        }
        List<Intger> myAns = new ArrayList<>();
        List<Integer>left = inordertrav(root.left);
        for(int ele :left){
            myAns.add(ele);
        }
        myAns.add(root.val);
        List<Integer>right = inordertrav(root.right);
        for(int ele :right){
            myAns.add(ele);
        }

        return myAns;
    }
    
    //recursive postorder
    public static void preorder(Node root, ArrayList<integer>ans){       
        if(root==null)
        return ans;

        preorder(root.left);
        preorder(root.right);
        ans.add(root.val);
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
    // height of the tree
    public static int height(Node root){
        
    }

}