import java.util.*;

class QuickSort {
    
    static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    static int partition(int arr[],int l,int h){
        int pivot = arr[l];
        int in = l;
        for(int i = l;i<=h;i++){
            if(arr[i]<pivot) in++;
        }
        swap(arr,l,in);
        int i = l,j = h;
        while(i<in && j>in){
            if(arr[i]<pivot) i++;
            if(arr[j]>=pivot) j--;
            if(arr[i]>=pivot && arr[j]<pivot){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return in;
    }
    
    static void quickSort(int[] arr, int l, int h) {
        if(l<h){
            int pi = partition(arr,l,h);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,h);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = { 2, 1, 6, 10, 4, 1, 3, 9, 7};
        quickSort(arr,0,arr.length-1);
        for(int x : arr) System.out.print(x+" ");
    }
}
