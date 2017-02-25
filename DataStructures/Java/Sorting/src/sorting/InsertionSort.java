package sorting;

public class InsertionSort {
    public int[] input;
    public int len;
    public InsertionSort(int m) {
        input = new int[m];
        len = 0;
    }

    public void insertVal(int value) {
        input[len] = value;
        len++;
    }

    public void display() {
        System.out.println("[+] Sorted elements: ");
        for (int x = 0; x < input.length; x++) {
            System.out.print(input[x] + " ");
        }
        System.out.println();
    }

    public void insSort() {
        int i, j;
        int temp;
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
