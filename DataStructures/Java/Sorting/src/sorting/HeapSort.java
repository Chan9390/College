package sorting;

class HeapSort {
    private int[] a;
    private int n;
    private int left;
    private int right;
    private int largest;

    
    void buildheap(int[] a) {
        n = a.length - 1;
        for(int i=n/2; i>=0 ;i--) {
            maxheap(a,i);
        }
    }
    
    void maxheap(int[] a, int i){ 
        left = 2*i;
        right = 2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest != i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    void exchange(int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
    }
    
    void sort(int[] a0){
        a = a0;
        buildheap(a);
        for(int i=n; i>0; i--) {
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
    
    void display() {
        System.out.println("[+] Sorted elements: ");
        for(int i=0; i< a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
