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
        int src = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] visited = new boolean[n];
        printAllPaths(graph,src,dest,visited,""+src);
    }
    
    public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String psf){
        if(src==dest){
            System.out.println(psf);
            return;
        }
        visited[src] = true;
        for(Edge e : graph[src])
          if(!visited[e.nbr])
            printAllPaths(graph,e.nbr,dest,visited,psf + e.nbr);
        visited[src] = false;
    }
}
