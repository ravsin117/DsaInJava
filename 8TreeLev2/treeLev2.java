import java.util.ArrayList;

public class treeLev2{
    public static class Node{
        int val = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.val = data;
        }
    }
    //morris traversal - inorder
    public static ArrayList<Integer> inorder(Node node){
        ArrayList <Integer>ans = new ArrayList<>();
        Node curr = node;
        while(curr!=null){
            Node left = curr.left;
            if(left==null){
                curr = curr.right;
                ans.add(curr.val);
            }else{
                Node rightmostNode = getRightMostNode(left,curr);
                if(rightmostNode.right==null){ // create thread
                    rightmostNode.right = curr;
                    curr = curr.left;
                }else{ // thread exist already need to break it 
                    rightmostNode.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }

            }
        }
        return ans;
    }
    //getrightmost node
    public static Node getRightNode(Node node, Node curr){
        while(node.right!=null && node.left!=null){
            node = node.right;
        }
        return node;
    }
    //preorder
    public static ArrayList<Integer> preorder(Node node){
        ArrayList<Integer>ans = new ArrayList<>();
        TreeNode curr = head;
        while(curr!=null){
            Node left = curr.left;
            if(left==null){
                ans.add(curr);
                curr = curr.right;
            }else{
                Node rightNode = getRightNode(left, curr);
                if(rightNode.right==null){ // create thread
                    rightNode.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }else{
                    rightNode.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    //camers in bt
    static int camera;
    public static int camRequired(Node root){
        if(root==null){
            return 1;
        }
        int lchild = camRequired(root.left);
        int rchild = camRequired(root.right);
        if(lchild==-1 || rchild==-1){
            cameras++;
            return 0;
        }
    }
    public static int findCam(NOde node){
        camera =0;
        if(camRequired(root)==-1) camera++;
        return camera;
    }
    //house robbery
    //with pair class
    //lonegst zig zag bt     &&&
    //isbst byb morris
    //recover bst 
    // by morris
    //construct bt from inorder and preorder
    //-post order and inorder
    //-inorder 
    //-post order
    //-level order
    //searialise in bt
    // desearialize
    //-in genric tree
    //left view 
    //right view
    //width of shadow
    //width of bt
    //vertical order traversal
    //bottom view
    //top view
    //diagonal order traversal
    //-(anticlockwise)
    // vertical order sum by bfs
    //vretical order of bt by 2 queue
    //diagonal order sum using dfs
    //diagonal order sum using bfs
    //// bst iterator using stack
    //bt iterator using morris
    //burning tree
    //burning tree2
    //convert a bst to sorted dll
    //m2
    //m3
    //conver a sorted dll to binary tree
    //path sum in bt
    //path sum2 in bt




}