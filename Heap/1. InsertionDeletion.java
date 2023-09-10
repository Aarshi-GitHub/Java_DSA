import java.util.*;

class Heap{
    int heap[];
    int size;
    int maxSize;
    Heap(int maxSize){
        heap = new int[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
    }
    
    private void swap(int p,int i){
        int temp = heap[p];
        heap[p] = heap[i];
        heap[i] = temp;
    }
    
    void display(){
        for(int i =0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    
    void insert(int val){
        if(size==maxSize){
            System.out.println("Overflow");
            return;
        }
        heap[size++] = val;
        int i = size-1;
        while(i>0){
            int p = ((i+1)/2)-1;
            if(heap[p]<heap[i]){
                swap(p,i);
                i = p;
            }
            else break;
        }
    }
    
    int remove(){
        if(size==0){
            return -1;
        }
        int res = heap[0];
        swap(0,size-1);
        heap[size-1] = 0;
        size--;
        int p = 0;
        while(p<size){
            int largest = p;
            int l = 2*p + 1;
            int r = 2*p + 2;
            if(l<size && heap[largest]<heap[l]) 
                largest = l;
            if(l<size && heap[largest]<heap[r])
                largest = r;
            if(largest!=p){
                swap(largest,p);
                p = largest;
            } 
            else break;
        }
        return res;
    }
}

class Practise {
    public static void main(String[] args) {
        Heap h = new Heap(7);
        h.insert(50);
        h.insert(15);
        h.insert(20);
        h.insert(30);
        h.insert(10);
        h.insert(25);
        h.insert(5);
        h.display();
        System.out.println("Removed : "+h.remove());
        h.display();
    }
}
