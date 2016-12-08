/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1560415;
import java.io.*;
/**
 *
 * @author christ
 */

public class Queue
{
    static int x, f=-1, r=-1, max_size=5;
    static int q[] = new int[max_size];
    
    static void push(int x)
    {
        if(r>max_size)
            System.err.println("Queue is full");
        else
        {
            q[++r]=x;
            if(f==-1)
                f=0;
        }
    }
    
    static int pop()       
    {
        if(f==-1||f>r)
            return -1;
        else
            return q[f++];
    }

    static void display()
    {
        if(f==-1||f>r)
            System.err.println("Queue is empty");
        else
        {
            System.out.println("Queue elements are: ");
            for(int i=f;i<=r;i++) {
                System.out.print(q[i]);
                System.out.print(' ');
            }
            System.out.println('\n');
        }
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("1) Push element");
            System.out.println("2) Pop element");
            System.out.println("3) Display elements");
            System.out.println("4) Exit");
            System.out.print("Option: ");
            int ch=Integer.parseInt(br.readLine());
            switch(ch) {
                case 1 :    if(r>3)
                                System.err.println("Queue is full");
                            else
                            {
                                System.out.print("Enter element: ");
                                x=Integer.parseInt(br.readLine());
                                push(x);
                            }
                            break;
                case 2 :    int y=pop();
                            if(y!=-1)
                                System.out.println("Popped element is: "+y);
                            else
                                System.err.println("Queue is empty");
                            break;
                case 3 :    display();
                            break;
                case 4 :    System.exit(0);
            }
        }
    }
}

