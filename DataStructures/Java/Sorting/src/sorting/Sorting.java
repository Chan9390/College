package sorting;

import java.util.Random;
import java.util.Scanner;
import static sorting.BubbleSort.bubble_srt;

class init {
    Scanner in = new Scanner(System.in);
    // Random elements are stored in the array - random_elements
    // backup_re : backup the array of random elements
    int[] random_elements;
    int[] backup_re;
    // max : maximum element to be present in the array
    // ele : number of elements in the array
    private int max, ele;
    double starttime = 0, endtime = 0;
    
    void generate_elements() {
        Random rand = new Random();
        random_elements = new int[ele];
        for(int i=0; i<ele; i++) {
            int r = rand.nextInt(max+1);
            random_elements[i] = r;
        }
        backup_re = random_elements.clone();
    }
    
    void display_elements() {
        for(int i=0; i<ele; i++) {
            System.out.print(random_elements[i] + " ");
        }
        System.out.println();
    }
    
    void configure() {
        System.out.print("[+] What is the maximum random value: ");
        max = in.nextInt();
        System.out.print("[+] Enter the maximum number of elements: ");
        ele = in.nextInt();
        generate_elements();
        System.out.println("[+] The generated array: ");
        display_elements();
    }
    
    void timecalc(double x, double y) {
        System.out.println("The time taken by the bubble sort function is " + (y - x) / 100000 + "  milliseconds");
    }
    
    void operations(int op) {
        switch(op) {
            case 1  :
                System.out.println("[+] Bubble sort selected");
                BubbleSort bs = new BubbleSort();
                starttime = System.nanoTime();
                bubble_srt(random_elements);
                endtime = System.nanoTime();
                break;
            case 2  : 
                System.out.println("[+] Selection sort selected");
                SelectionSort sel = new SelectionSort();
                starttime = System.nanoTime();
                sel.sort(random_elements);
                endtime = System.nanoTime();
                break;
            case 3  : 
                System.out.println("[+] Insertion sort selected");
                InsertionSort ins = new InsertionSort(ele);
                starttime = System.nanoTime();
                ins.insSort();
                endtime = System.nanoTime();
                break;
            case 4  : 
                System.out.println("[+] Quick sort selected");
                QuickSort quick = new QuickSort();
                starttime = System.nanoTime();
                quick.sort(random_elements,ele-1);
                endtime = System.nanoTime();
                quick.display();
                break;
            case 5  : 
                System.out.println("[+] Merge sort selected");
                MergeSort mer = new MergeSort();
                starttime = System.nanoTime();
                mer.sort(random_elements);
                endtime = System.nanoTime();
                mer.display();
                break;
            case 6  : 
                System.out.println("[+] Heap sort selected");
                HeapSort heap = new HeapSort();
                starttime = System.nanoTime();
                heap.sort(random_elements);
                endtime = System.nanoTime();
                heap.display();
                break;
            case 7  : 
                System.out.println("[+] Shell sort selected");
                ShellSort shel = new ShellSort();
                shel.sequence = random_elements;
                starttime = System.nanoTime();
                shel.shellSort();
                endtime = System.nanoTime();
                shel.printSequence(shel.sequence);
                break;
            case 8  : 
                System.out.println("[+] Bucket sort selected");
                BucketSort buck =new BucketSort();
                starttime = System.nanoTime();
                int maxValue = buck.maxValue(random_elements);
                buck.printSequence(buck.sort(random_elements, maxValue));
                endtime = System.nanoTime();
                break;
            default  : 
                System.out.println("Wrong option");
                break;
        }
        if(op >= 1 && op <= 8)
            timecalc(starttime, endtime);
        random_elements = backup_re.clone();
    }
}

public class Sorting {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("    ____             _   _             ");             
        System.out.println("   / ___|  ___  _ __| |_(_)_ __   __ _ ");
        System.out.println("   \\___ \\ / _ \\| '__| __| | '_ \\ / _` |");
        System.out.println("    ___) | (_) | |  | |_| | | | | (_| |");
        System.out.println("   |____/ \\___/|_|   \\__|_|_| |_|\\__, |");
        System.out.println("                                 |___/ ");
        System.out.println();
        init i = new init();
        i.configure();
        String b;
        int quit = 0;
        int option = 0;
        
        while(quit == 0) {
            System.out.print("\nSorter> ");
            b = in.next();
            b = b.toLowerCase();
            
            switch (b) {
                case "help":
                case "h":
                    System.out.println("You have the following options");
                    System.out.println("h | help \t- to know the commands");
                    System.out.println("c | config\t- configure the number of elements");
                    System.out.println("o | options \t- to select the sorting algorithm");
                    System.out.println("q | quit \t- to quit the program");
                    System.out.println("r | regen\t- regenerate the random variables");
                    System.out.println("s | see \t- to see the array of random elements");
                    System.out.println("z | credits \t- to know the authors");
                    break;
                case "options":
                case "o":
                    System.out.println("Select the sorting algorithm: ");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Selection Sort");
                    System.out.println("3. Insertion Sort");
                    System.out.println("4. Quick Sort");
                    System.out.println("5. Merge Sort");
                    System.out.println("6. Heap Sort");
                    System.out.println("7. Shell Sort");
                    System.out.println("8. Bucket Sort");
                    System.out.print("Option: ");
                    option = in.nextInt();
                    i.operations(option);
                    break;
                case "config":
                case "c":
                    i.configure();
                    break;
                case "credits":
                case "z":
                    System.out.println("Team lead: Navya Verghese");
                    System.out.println("Contributors: ");
                    System.out.println("\t1. Anand Dixit");
                    System.out.println("\t2. Chandrapal");
                    System.out.println("\t3. Shivam Thakur");
                    break;
                case "quit":
                case "q":
                    quit = 1;
                    break;
                case "regen":
                case "r":
                    i.generate_elements();
                    System.out.println("[+] Regenerated the elements");
                    i.display_elements();
                    break;
                case "see":
                case "s":
                    i.display_elements();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
