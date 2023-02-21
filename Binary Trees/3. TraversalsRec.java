import java.util.*;

class BinaryTree {
    
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    
    static Node createTree(Integer arr[]){
        if(arr[0]==null) return null;
        Node root = new Node(arr[0],null,null);
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root,1));
        int idx = 1;
        while(s.size()>0){
            Pair top = s.peek();
            if(top.state==1){
                top.state+=1;
                if(arr[idx]!=null){
                    Node ln = new Node(arr[idx],null,null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln,1);
                    s.push(lp);
                }
                idx++;
            }
            else if(top.state==2){
                top.state+=1;
                if(arr[idx]!=null){
                    Node rn = new Node(arr[idx],null,null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn,1);
                    s.push(rp);
                }
                idx++;
            }
            else s.pop();
        }
        return root;
    }
    
    static void preorderTraversal(Node node){
        if(node==null) return;
        System.out.print(node.data+" ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    
    static void inorderTraversal(Node node){
        if(node==null) return;
        inorderTraversal(node.left);
        System.out.print(node.data+" ");
        inorderTraversal(node.right);
    }
    
    static void postorderTraversal(Node node){
        if(node==null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data+" ");
    }
    
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        root = createTree(arr);
        System.out.print("Preorder Traversal : ");
        preorderTraversal(root);
        System.out.print("\nInorder Traversal : ");
        inorderTraversal(root);
        System.out.print("\nPostorder Traversal : ");
        postorderTraversal(root);
    }
}
