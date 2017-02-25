package sorting;

import java.util.Scanner;

public class InsertionSort {
    public long[] input;
    public int len;
    public InsertionSort(int m) {
        input = new long[m];
        len = 0;
    }

    public void insertVal(long value) {
        input[len] = value;
        len++;
    }

    public void display() {
        for (int x = 0; x < input.length; x++) {
            System.out.println(input[x]);
        }
    }

    public void insSort() {
        int i, j;
        long temp;
        for (i = 1; i < input.length; i++) {
            j = i - 1;
            while (j >= 0 && input[j] > input[i]) {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i = j;
                j--;
            }
        }
    }
}
