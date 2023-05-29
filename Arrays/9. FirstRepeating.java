import java.util.*;

class Solution {
    
    public static int firstRepeated(int[] arr, int n) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i<n;i++){
            int in = mp.getOrDefault(arr[i],-1);
            if(in!=-1) res = Math.min(res,in);
            if(in==-1) mp.put(arr[i],i+1);
        }
        if(res==Integer.MAX_VALUE) return -1;
        return res;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeated(arr,arr.length));
    }
}
