import java.util.*;

class CountSubsetSum {
    
    public static int CountSubsetSum(int arr[],int n,int target){
        int dp[][] = new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]>j) dp[i][j] = dp[i-1][j];
                else 
                dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
            }
        }
        return dp[n][target];
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3};
        int target = 6;
        System.out.println(CountSubsetSum(arr,arr.length,target));
    }
}
