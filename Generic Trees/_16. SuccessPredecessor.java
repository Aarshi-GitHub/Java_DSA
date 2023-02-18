import java.util.*;
class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    
    static Node predecessor = null;
    static Node successor = null;
    static int state = 0;
    
    public static void levelOrderTraversal(Node node){
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(node);
        int level = q.size();
        while(q.size()>0){
            Node temp = q.remove();
            System.out.print(temp.data+" ");
            for(Node child : temp.children)
                q.add(child);
            level--;
            if(level==0){
                level = q.size();
                System.out.println(".");
            }
        }
    }
    
   public static void SuccPredecessor(Node node,int ele){
       if(node==null) return;
       if(state==0){
           if(node.data==ele) state = 1;
           else predecessor = node;
       }
       else if(state==1){
           successor = node;
           state = 2;
       }
       for(Node child : node.children)
            SuccPredecessor(child,ele);
   }
   
   public static Node createTree(int arr[]){
       Node root = null;
        Stack<Node> s = new Stack<Node>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1) s.pop();
            else{
                Node temp = new Node();
                temp.data = arr[i];
                if(s.isEmpty()) root = temp;
                else s.peek().children.add(temp);
                s.push(temp);
            }
        }
        return root;
   }
   
   
   
    public static void main(String[] args){
        int[] arr = {10, 20,50,-1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = createTree(arr);
        levelOrderTraversal(root);
        SuccPredecessor(root,110);
        System.out.println("Predecessor : "+predecessor.data);
        System.out.println("Successor : "+successor.data);
    }
}
