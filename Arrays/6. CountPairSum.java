import java.util.*;

class Solution {
    
    static int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int count=0;
        for(int x : arr){
            int val = mp.getOrDefault(k-x,0);
            count+=val;
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        return count;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1};
        int sum = 2;
        System.out.println(getPairsCount(arr,arr.length,sum));
    }
}
