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
    
    static boolean nodeToRootPath(Node node,ArrayList<Integer> arr,int data){
        if(node==null) return false;
        if(node.data == data){
            arr.add(data);
            return true;
        }
        if(nodeToRootPath(node.left,arr,data)){
            arr.add(node.data);
            return true;
        }
        if(nodeToRootPath(node.right,arr,data)){
            arr.add(node.data);
            return true;
        }
        return false;
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
        ArrayList<Integer> res = new ArrayList<>();
        if(nodeToRootPath(root,res,70)){
            for(int x : res) System.out.print(x+" ");
        }
        else{
            System.out.println("No Path");
        }
    }
}
