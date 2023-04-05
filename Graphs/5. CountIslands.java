import java.util.*;

class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    traverse(arr,i,j,m,n);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void traverse(int[][] arr,int i,int j,int m,int n){
        if(i<0 || j<0 || i==m || j==n || arr[i][j]==1) return;
        arr[i][j] = 1;
        traverse(arr,i+1,j,m,n);
        traverse(arr,i,j+1,m,n);
        traverse(arr,i-1,j,m,n);
        traverse(arr,i,j-1,m,n);
    }
}
