import java.util.*;

class Practise {
    
    public static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void heapify(int arr[],int n,int pos){
        int l = 2*pos+1;
        int r = 2*pos+2;
        int largest = pos;
        if(l<n && arr[largest]<arr[l])
            largest = l;
        if(r<n && arr[largest]<arr[r])
            largest = r;
        if(largest!=pos){
            swap(arr,largest,pos);
            heapify(arr,n,largest);
        }
    }
    
    public static void buildHeap(int arr[],int n){
        for(int  i = n/2 - 1;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    
    public static void heapSort(int arr[],int n){
        buildHeap(arr,n);
        for(int i = 0;i<n-1;i++){
            swap(arr,0,n-i-1);
            heapify(arr,n-i-1,0);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
        heapSort(arr,n);
        for(int x : arr) System.out.print(x+" ");
    }
}
