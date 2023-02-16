import java.util.*;
class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    
    public static void zigZagTraversal(Node node){
        Stack<Node> ms = new Stack<Node>();
        Stack<Node> cs = new Stack<Node>();
        ms.push(node);
        int level = 0;
        while(ms.size()>0){
            Node temp = ms.pop();
            System.out.print(temp.data+" ");
            if(level%2==0){
                for(int i=0;i<temp.children.size();i++)
                    cs.push(temp.children.get(i));
            }
            else{
                for(int i=temp.children.size()-1;i>=0;i--)
                    cs.push(temp.children.get(i));
            }
            if(ms.size()==0){
                ms = cs;
                cs = new Stack<Node>();
                level++;
                System.out.println(".");
            }
        }
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
        zigZagTraversal(root);
    }
}
