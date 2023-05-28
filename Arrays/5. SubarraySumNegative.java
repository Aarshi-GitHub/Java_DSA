import java.util.*;

class Solution {
    
    public static ArrayList<Integer> subArraySum(int arr[],int n,int target){
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            mp.put(sum,i);
            if(sum==target){
                res.add(0);
                res.add(i);
                return res;
            }
            int index = mp.getOrDefault(sum-target,-1);
            if(index!=-1){
                res.add(index);
                res.add(i);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
    
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int target = -10;
        System.out.println(subArraySum(arr,arr.length,target));
    }
}
