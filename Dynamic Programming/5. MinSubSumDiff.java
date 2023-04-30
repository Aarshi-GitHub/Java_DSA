import java.util.*;

class MinSubSumDiff {
    
    public static int subsetSum(int arr[],int n,int sum){
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) 
                    dp[i][j] = dp[i-1][j];
                
                else 
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
            }
        }
        
        for(int i=sum;i>=1;i--)
        if(dp[n][i]==true) return i;
        return 0;
    }
    
    public static int minSubSumDiff(int[] arr){
        int sum = 0;
        for(int x : arr) sum+=x;
        int sum2 = subsetSum(arr,arr.length,sum/2);
        int sum1 = sum - sum2;
        return sum1-sum2;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,4};
        System.out.println(minSubSumDiff(arr));
    }
}
