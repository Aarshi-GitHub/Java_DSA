import java.util.*;
class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }
    
    public static int size(Node node){
        if(node==null) return 0;
        int count = 1;
        for(Node child : node.children)
            count+=size(child);
        return count;
    }
    
    public static int maximumNode(Node node){
        int max = node.data;
        for(Node child : node.children)
            max = Math.max(max,maximumNode(child));
        return max;
    }
    
    public static int minimumNode(Node node){
        int min = node.data;
        for(Node child : node.children)
            min = Math.min(min,minimumNode(child));
        return min;
    }
    
    public static int height(Node node){
        if(node==null) return 0;
        int maxHeight = -1;
        for(Node child : node.children)
            maxHeight = Math.max(maxHeight,height(child));
        maxHeight+=1;
        return maxHeight;
    }
    
    public static void traversal(Node node){
        if(node==null) return;
        
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
        System.out.println("Size of Generic Tree : "+size(root));
        System.out.println("Maximum of Generic Tree : "+maximumNode(root));
        System.out.println("Minimum of Generic Tree : "+minimumNode(root));
        System.out.println("Height of Generic Tree : "+height(root));
    }
}
