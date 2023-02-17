import java.util.*;
class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    
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
    
   public static ArrayList<Integer> nodeToRoot(Node node,int ele){
       if(node.data == ele){
           ArrayList<Integer> res = new ArrayList<Integer>();
           res.add(node.data);
           return res;
       }
       for(Node child : node.children){
           ArrayList<Integer> arr = nodeToRoot(child,ele);
           if(arr.size()>0){
               arr.add(node.data);
               return arr;
           }
       }
       return new ArrayList<Integer>();
   } 
    
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
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
        ArrayList<Integer> res = nodeToRoot(root,110);
        for(int x : res)
            System.out.print(x+" -> ");
        
    }
}
