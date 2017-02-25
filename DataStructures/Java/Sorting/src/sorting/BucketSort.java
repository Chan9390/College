package sorting;

class BucketSort 
{
    int[] sorted;
    void sort(int[] sequence, int maxValue) 
    {
        // Bucket Sort
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[sequence.length];
 
        for (int i = 0; i < sequence.length; i++)
            Bucket[sequence[i]]++;
 
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;
        sorted = sorted_sequence;
    }
 
    void printSequence() 
    {
        System.out.println("[+] Sorted elements: ");
        for (int i = 0; i < sorted.length; i++)
            System.out.print(sorted[i] + " ");
        System.out.println();
    }
 
    int maxValue(int[] sequence) 
    {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];
        return maxValue;
    }
}