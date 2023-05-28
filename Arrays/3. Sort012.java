import java.util.*;

class Solution {
    
    public static void sort012(int arr[],int n){
        int s = 0,mid = 0,high = n-1;
        while(s<n && arr[s]==0) s++;
        mid = s;
        while(mid<n && arr[mid]==1) mid++;
        while(high>=0 && arr[high]==2) high--;
        while(mid<=high){
            if(arr[mid]==0){
                arr[mid] = arr[s];
                arr[s] = 0;
                s++;mid++;
            }
            else if(arr[mid]==1) mid++;
            else{ //2
                arr[mid] = arr[high];
                arr[high] = 2;
                high--;
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 2, 0};
        sort012(arr,arr.length);
        for(int i : arr) System.out.print(i+" ");
    }
}
