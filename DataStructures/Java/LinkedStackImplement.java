package pkg1560415;
import java.util.*;
/**
 *
 * @author Chandrapal
 */

class Node
{
    protected int data;
    protected Node link;
    public Node()
    {
        link = null;
        data = 0;
    }
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }
    public void setLink(Node n)
    {
        link = n;
    }    
    public void setData(int d)
    {
        data = d;
    }    
    public Node getLink()
    {
        return link;
    }
    public int getData()
    {
        return data;
    }
}

class linkedStack
{
    protected Node top ;
    
    public linkedStack()
    {
        top = null;
    }    
    public boolean isEmpty()
    {
        return top == null;
    }     
    public void push(int data)
    {
        Node nptr = new Node(data, null);
        if (top == null)
            top = nptr;
        else
        {
            nptr.setLink(top);
            top = nptr;
        }
    }
    public int pop()
    {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        Node ptr = top;
        top = ptr.getLink();
        return ptr.getData();
    }  
    public void display()
    {
        Node ptr = top;
        if (top == null) 
        {
            System.err.println("The LinkedStack is empty");
        }
        while (ptr != null)
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();
    }
}

public class LinkedStackImplement
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);  
        linkedStack ls = new linkedStack();
        System.out.println("Stacks using Linked List");  
        char ch;
        do
        {
            System.out.println("1) Push");
            System.out.println("2) Pop");
            System.out.println("3) Display elements"); 
            System.out.print("Choice: "); 
            int choice = scan.nextInt();
            switch (choice) 
            {
            case 1 :
                System.out.print("Enter integer: ");
                ls.push( scan.nextInt() ); 
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Popped Element : "+ ls.pop());
                }
                catch (Exception e){ }
                break;                                                
            case 3 : 
                //System.out.println("Stack: "); 
                ls.display();
                break;
            default : 
                System.out.println("Wrong Entry");
                break;
            } 
            ls.display();
            System.out.print("\nTo continue type Y: ");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}