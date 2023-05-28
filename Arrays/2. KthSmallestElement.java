import java.util.*;

class Solution {
    
    public static int kthSmallest(int arr[],int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
    
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr,k));
    }
}
