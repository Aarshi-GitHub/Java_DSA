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
    
   public static boolean isSimilar(Node n1,Node n2){
       if(n1.children.size()!=n2.children.size()) return false;
       for(int i=0;i<n1.children.size();i++){
           Node c1 = n1.children.get(i);
           Node c2 = n2.children.get(i);
           if(isSimilar(c1,c2)==false) return false;
       }
       return true;
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
        int[] arr1 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        int[] arr2 = {1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, 10, -1, -1, -1};
        Node root1 = createTree(arr1);
        Node root2 = createTree(arr2);
        System.out.print("Are Trees Similar : "+isSimilar(root1,root2));
    }
}
