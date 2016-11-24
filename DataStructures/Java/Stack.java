/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.util.*;
/**
 *
 * @author OffSec
 */
 abstract class ty
{
    public 
            abstract void push();
            abstract void pop();
            abstract void display();
           
}
class ack
{
    int top=-1;
    int a[] = new int[5];
    ty ui = new ty() {
        @Override
        public void push() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        void pop() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        void display() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    public
            void push()
            {
                if(top>=4)
                {
                    System.err.println("Overflow");
                }
                else
                {
                    System.out.println("Add a no");
                    System.out.println("Enter the value");
                    Scanner in = new Scanner(System.in);
                    int c = in.nextInt();
                    top= top+1;
                    a[top] = c ;
                    
                }
            }
               
            
            void pop()
            {
                if(top==-1)
                {
                    System.err.println("Underflow");
                }
                else
                {
                    int x;
                    System.out.println("Delete a no");
                    x = a[top];
                    top = top -1;
                    System.out.println(x);
                }
            }
            void display()
            {
                if(top==-1)
                {
                    System.out.println("Stack is empty");
                }
                else
                {
                    System.out.println("Display a value");
                    for(int i=top;i>-1;i--)
                    {
                        System.out.println(a[i]);
                    }
                }
            }
}

public class StackOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int top=-1;
        int a[] = new int[10];
        Scanner in = new Scanner(System.in); 
        ack sta = new ack();
        
        
        int y=1;
                
        while(y!=0)
        {
            System.out.println("Stack");
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Display all values");
            int b = in.nextInt();
            if(b==1)
            {
                sta.push();
            }   
            else
            if(b==2)
            {
                sta.pop();
            }
            else
            {
                sta.display();
            }
            System.out.println("continue(1/0)");
            y = in.nextInt();
        }
    }

    private static void ack() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
