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
    
    static void display(Node node){
        if(node==null) return;
        String str="";
        str += node.left==null ? ".." : node.left.data;
        str += (" <-> "+node.data+" <-> ");
        str += node.right==null ? ".." : node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        root = createTree(arr);
        display(root);
    }
}
