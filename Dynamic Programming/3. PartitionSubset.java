import java.util.*;

class PartitionSubset{
    
    public static boolean partitionEqualSubset(int[] arr,int n){
        int sum = 0;
        for(int x : arr) sum+=x;
        if(sum%2==1) return false;
        return subsetSum(arr,n,sum/2);
    }
    
    public static boolean subsetSum(int[] arr,int n,int target){
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]>j) dp[i][j] = dp[i-1][j];
                else 
                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
            }
        }
        return dp[n][target];
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        System.out.println(partitionEqualSubset(arr,arr.length));
    }
}
