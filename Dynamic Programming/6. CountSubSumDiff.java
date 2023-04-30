import java.util.*;

class CountSubSumDiff {
    
    public static int countSubSum(int arr[],int n,int sum){
        int dp[][] = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
            }
        }
        return dp[n][sum];
    }
    
    public static int countSubSumDiff(int arr[],int diff){
        int sum = 0;
        for(int i=0;i<arr.length;i++) sum+=arr[i];
        //     sum1 -  sum2 = x;
        //     sum1 = sum - sum2;
        //     sum - sum2 - sum2 = x
        //     sum - 2*sum2 = x;
        //     sum2 = (sum - x)/2
        int sum2 = (sum - diff)/2;
        return countSubSum(arr,arr.length,sum2);
    }
    
    public static void main(String[] args) {
        // int arr[] = {5, 2, 6, 4};
        // int diff = 3;
        int arr[] = {1, 2, 3, 1, 2};
        int diff = 1;
        System.out.println(countSubSumDiff(arr,diff));
    }
}
