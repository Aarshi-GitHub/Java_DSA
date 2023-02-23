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
    
    static void LevelOrderTraversal(){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int k = q.size();
            while(k>0){
                Node temp = q.remove();
                System.out.print(temp.data+" ");
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                k--;
                if(k==0){
                    System.out.println(".");
                    k = q.size();
                }
            }
        }
    }
    
    static int[] diameter(Node node){
        if(node==null) return new int[]{0,0};
        int res[] = new int[2];
        int[] leftDiameter = diameter(node.left);
        int[] rightDiameter = diameter(node.right);
        int op1 = leftDiameter[1];
        int op2 = rightDiameter[1];
        int op3 = leftDiameter[0] + rightDiameter[0];
        res[0] = Math.max(leftDiameter[0],rightDiameter[0])+1;
        res[1] = Math.max(op1,Math.max(op2,op3));
        return res;
    }
    
    static Node createTree(Integer[] arr){
        if(arr.length==0 || arr[0]==null) return null;
        Stack<Pair> s = new Stack<>();
        Node root = new Node(arr[0],null,null);
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
            else{
                s.pop();
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        root = createTree(arr);
        LevelOrderTraversal();
        int[] res = diameter(root);
        System.out.println("Diameter : "+res[1]);
    }
}
