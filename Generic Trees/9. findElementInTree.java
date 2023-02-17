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
    
   public static boolean findElement(Node node,int ele){
       if(node.data == ele) return true;
       for(Node child : node.children){
           boolean isPresent = findElement(child,ele);
           if(isPresent) return true;
       }
       return false;
   }
    
    public static void main(String[] args){
        int arr[] = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
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
        levelOrderTraversal(root);
        System.out.println("40 Present : "+findElement(root,40));
        System.out.println("70 Present : "+findElement(root,70));
    }
}
