package sorting;

import java.util.Random;
import java.util.Scanner;

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
    int trials = 1;
    int j;
    double[] avg_trials;
    int flag_for_everything = 0;
    double least_time = Double.MAX_VALUE;
    int less_timed_algo = 0;
    
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
    
    double timecalc(double x, double y) {
        return ((y - x) / 100000);
    }
    
    void display_avg(double[] a, int f) {
        double total = 0;
        for(int k=0; k<a.length; k++) {
            total += a[k];
            //System.out.println(a[k]);
        }
        System.out.println("[*] The average time taken is: " + (total/a.length) + '\n');
        if(flag_for_everything == 1) {
            check_the_least((total/a.length), f);
        }
    }
    
    void check_the_least(double d, int algo) {
        if(least_time > d) {
            least_time = d;
            less_timed_algo = algo;
        }
    }
    
    void operations(int op) {
        avg_trials = new double[trials];
        int index=0;
        //qleast_time = Double.MAX_VALUE;
        switch(op) {
            case 1  :
                System.out.println("[+] Bubble sort selected");
                BubbleSort bs = new BubbleSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    starttime = System.nanoTime();
                    bs.bubble_srt(random_elements);
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //bs.printNumbers();
                display_avg(avg_trials, 1);
                break;
            case 2  : 
                System.out.println("[+] Selection sort selected");
                SelectionSort sel = new SelectionSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    starttime = System.nanoTime();
                    sel.sort(random_elements);
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //sel.display();
                display_avg(avg_trials, 2);
                break;
            case 3  : 
                System.out.println("[+] Insertion sort selected");
                InsertionSort ins = new InsertionSort(ele);
                
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    ins.input = random_elements;
                    starttime = System.nanoTime();
                    ins.insSort();
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //ins.display();
                display_avg(avg_trials, 3);
                break;
            case 4  : 
                System.out.println("[+] Quick sort selected");
                QuickSort quick = new QuickSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    starttime = System.nanoTime();
                    quick.sort(random_elements,ele-1);
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //quick.display();
                display_avg(avg_trials, 4);
                break;
            case 5  : 
                System.out.println("[+] Merge sort selected");
                MergeSort mer = new MergeSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    starttime = System.nanoTime();
                    mer.sort(random_elements);
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //mer.display();
                display_avg(avg_trials, 5);
                break;
            case 6  : 
                System.out.println("[+] Heap sort selected");
                HeapSort heap = new HeapSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    starttime = System.nanoTime();
                    heap.sort(random_elements);
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //heap.display();
                display_avg(avg_trials, 6);
                break;
            case 7  : 
                System.out.println("[+] Shell sort selected");
                ShellSort shel = new ShellSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    shel.sequence = random_elements;
                    starttime = System.nanoTime();
                    shel.shellSort();
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //shel.printSequence(shel.sequence);
                display_avg(avg_trials, 7);
                break;
            case 8  : 
                System.out.println("[+] Bucket sort selected");
                BucketSort buck =new BucketSort();
                for(j = 0; j < trials; j++) {
                    random_elements = backup_re.clone();
                    int maxValue = buck.maxValue(random_elements);
                    starttime = System.nanoTime();
                    buck.sort(backup_re, maxValue);
                    endtime = System.nanoTime();
                    avg_trials[index] = timecalc(starttime, endtime);
                    index++;
                }
                //buck.printSequence();
                display_avg(avg_trials, 8);
                break;
            default  : 
                System.out.println("Wrong option");
                break;
        }            
        random_elements = backup_re.clone();
    }
    
    void set_trials(int a) {
        trials = a;
        System.out.print("[+] " + trials + " trials set");
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
                    System.out.println("a | avg \t- get average time complexity");
                    System.out.println("c | config\t- configure the number of elements");
                    System.out.println("e | all\t\t- execute all algorithms");
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
                case "all":
                case "e":
                    System.out.println("[+] Executing all algorithms");
                    i.flag_for_everything = 1;
                    i.least_time = Double.MAX_VALUE;
                    for(int h =1; h < 9; h++) {
                        i.operations(h);
                    }
                    System.out.println("[*] The minimum time taken was : " + i.least_time);
                    System.out.print("[*] The best algorithm is: ");
                    switch(i.less_timed_algo) {
                        case 1  :   
                            System.out.println("Bubble Sort");
                            break;
                        case 2  :   
                            System.out.println("Selection Sort");
                            break;
                        case 3  :   
                            System.out.println("Insertion Sort");
                            break;
                        case 4  :   
                            System.out.println("Quick Sort");
                            break;
                        case 5  :   
                            System.out.println("Merge Sort");
                            break;
                        case 6  :   
                            System.out.println("Heap Sort");
                            break;
                        case 7  :   
                            System.out.println("Shell Sort");
                            break;
                        case 8  :   
                            System.out.println("Bucket Sort");
                            break;
                        default :   System.out.println("Error");
                    }
                    break;
                case "avg":
                case "a":
                    System.out.print("Enter the maximum number of trials: ");
                    i.set_trials(in.nextInt());
                    System.out.println();
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
