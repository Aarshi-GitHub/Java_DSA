import java.util.*;

class Solution {
    
    public static ArrayList<Integer> subArraySum(int arr[],int n,int target){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int j = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>target && j<i){
                sum-=arr[j];
                j++;
            }
            if(sum==target){
                res.add(j+1);
                res.add(i+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int target = 15;
        System.out.println(subArraySum(arr,arr.length,target));
    }
}
