package sorting;

class BubbleSort {
    private int[] ar;
    void bubble_srt(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
        }
        ar = array.clone();
        //printNumbers(array);
    }
    private void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    void printNumbers() {
        System.out.println("[+] Sorted elements: ");
        for (int i = 0; i < ar.length; i++) {
           System.out.print(ar[i] + " ");
        }
        System.out.println();
    }
}
