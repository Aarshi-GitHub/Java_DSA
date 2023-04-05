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
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ArrayList<Integer> res1 = new ArrayList<>();
                getConnected(graph,i,visited,res1);
                res.add(res1);
            }
        }
        System.out.println(res);
    }
    
    public static void getConnected(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> res){
        res.add(src);
        visited[src] = true;
        for(Edge e : graph[src])
          if(!visited[e.nbr])
            getConnected(graph,e.nbr,visited,res);
    }
}
