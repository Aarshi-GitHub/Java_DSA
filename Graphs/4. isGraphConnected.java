import java.util.*;

class Graph {
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        boolean[] visited = new boolean[n];
        traverse(graph,0,visited);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                System.out.println("Not Connected");
                return;
            }
        }
        System.out.println("Connected");
    }
    
    public static void traverse(ArrayList<Edge>[] graph,int src,boolean[] visited){
        visited[src] = true;
        for(Edge e : graph[src])
          if(!visited[e.nbr])
            traverse(graph,e.nbr,visited);
    }
}
