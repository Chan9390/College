package sorting;

import java.util.*;
class SelectionSort {
    /* Selection Sort function */
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
    }
}
