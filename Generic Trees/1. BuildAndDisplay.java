import java.util.*;
class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    
    public static void display(Node node){
        if(node==null) return;
        String str = node.data + " -> ";
        for(Node child : node.children)
            str+= child.data + " , ";
        str+=".";
        System.out.println(str);
        for(Node child : node.children)
            display(child);
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
        display(root);
    }
}
