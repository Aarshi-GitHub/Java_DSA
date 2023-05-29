import java.util.*;

class Solution {
    
    static ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3){
            if(a[i]==b[j] && b[j]==c[k]){
                if(arr.size()==0 || arr.get(arr.size()-1)!=a[i])
                    arr.add(a[i]);
                i++;j++;k++;
            }
            else if(a[i]<b[j] || a[i]<c[k]) i++;
            else if(b[j]<c[k] || b[j]<a[i]) j++;
            else if(c[k]<a[i] || c[k]<b[j]) k++;
        }
        return arr;
    }
    
    
    public static void main(String[] args) {
        int ar1[] = { 1, 5, 10, 20, 40, 80 };
        int ar2[] = { 6, 7, 20, 80, 100 };
        int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
        System.out.print(commonElements(ar1,ar2,ar3,ar1.length,ar2.length,ar3.length));
    }
}
