package sorting;

import java.util.*;
class SelectionSort {
    /* Selection Sort function */
    int[] a;
    void sort(int arr[]) {
        int N = arr.length;
        int i, j, pos, temp;
        for (i = 0; i < N - 1; i++) {
            pos = i;
            for (j = i + 1; j < N; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            /* Swap arr[i] and arr[pos] */
            temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
        a = arr;
    }
    
    void display() {
        System.out.println("[+] Sorted elements: ");
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
