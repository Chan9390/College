package sorting;

class ShellSort 
{
    int N = 20;
    int[] sequence = new int[N];

    void shellSort() 
    {
        int increment = sequence.length / 2;
        while (increment > 0) 
        {
            for (int i = increment; i < sequence.length; i++) 
            {
                int j = i;
                int temp = sequence[i];
                while (j >= increment && sequence[j - increment] > temp) 
                {
                    sequence[j] = sequence[j - increment];
                    j = j - increment;
                }
                sequence[j] = temp;
            }
            if (increment == 2)
                increment = 1;
            else
                increment *= (5.0 / 11);
 
        }
    }
 
    void printSequence(int[] sorted_sequence) 
    {
        System.out.println("[+] Sorted elements: ");
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
        System.out.println();
    }
}