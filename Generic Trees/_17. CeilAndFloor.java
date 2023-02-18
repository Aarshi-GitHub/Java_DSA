import java.util.*;
class GenericTree{
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    
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
    
   public static void ceilAndFloor(Node node,int ele){
       if(node.data>ele){
           if(node.data<ceil) ceil = node.data;
       }
       if(node.data<ele){
           if(node.data>floor) floor = node.data;
       }
       for(Node child : node.children)
            ceilAndFloor(child,ele);
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
        ceilAndFloor(root,70);
        System.out.println("Ceil : "+ceil);
        System.out.println("Floor : "+floor);
    }
}
