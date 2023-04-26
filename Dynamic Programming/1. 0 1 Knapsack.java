import java.util.*;

class HelloWorld{
    
    public static int knapsackTab(int[] wt,int[] val,int n,int W){
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(wt[i-1]>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j],val[n-1]+dp[i-1][j-wt[i-1]]);
            }
        }
        return dp[n][W];
    }
    
    public static int knapsackRec(int[] wt,int[] val,int n,int W){
        if(n==0 || W==0) return 0;
        if(wt[n-1]>W) return knapsackRec(wt,val,n-1,W);
        else
        return Math.max(knapsackRec(wt,val,n-1,W),val[n-1]+knapsackRec(wt,val,n-1,W-wt[n-1]));
    }
    
    public static int knapsackMemo(int[] wt,int[] val,int n,int W,int[][] dp){
        if(n==0 || W==0) return dp[n][W] = 0;
        if(dp[n][W]!=-1) return dp[n][W];
        if(wt[n-1]>W) dp[n][W] =  knapsackMemo(wt,val,n-1,W,dp);
        else
        dp[n][W] = Math.max(knapsackMemo(wt,val,n-1,W,dp),val[n-1]+knapsackMemo(wt,val,n-1,W-wt[n-1],dp));
        return dp[n][W];
    }
    
    
    
    public static void main(String[] args) {
        int n = 3, W = 4;
        int profit[] = {1, 2, 3};
        int weight[] = {4, 5, 1};
        System.out.println("Recursive : "+knapsackRec(weight,profit,n,W));
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        System.out.println("Memoization : "+knapsackMemo(weight,profit,n,W,dp));
        System.out.println("Tabulation : "+knapsackTab(weight,profit,n,W));
    }
}
