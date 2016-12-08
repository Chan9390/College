/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.io.*;

/**
 *
 * @author OffSec
 */

public class InfixToPostfix
{
    char[] s=new char[90];
    int top=-1;
    void push(char x)
    {
        s[++top]=x; 
    }
    char pop()
    {
        return s[top--];
    }
    int pr(char x)
    {
        switch(x)
        {
            case '*':
            case '/':
            return 3;
            case '+':
            case '-':
            return 2;
            case '(':
            return 1;
        }
        return -1; 
    }
    void convert(char in[],char po[])
    {
        int i=0,j=0;
        while(in[i]!='\0') {
            char ch=in[i];
            if(ch>='a'&&ch<='z')
                po[j++]=ch;
            else
            {
                switch(ch)
                {
                    case '(':  push(ch);
                               break;
                    case ')':  while(s[top]!='(')
                               po[j++]=pop();
                               pop();
                               break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':  if(top==-1)
                                    push(ch);
                               else
                               {
                               while(top!=-1 && (pr(ch)<=pr(s[top])))
                                    po[j++]=pop();
                                    push(ch);
                               }
                               break; 
                }
            }
            i++;
        }
        while(top!=-1)
            po[j++]=pop();
        po[j++]='\0';
    }
    
    public static void main(String[] args)throws IOException 
    {
        InfixToPostfix obj=new InfixToPostfix();
        char in[]=new char[90];
        char po[]=new char[90];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter infix expression: ");
        String str=br.readLine();
        int len=str.length();
        for(int i=0;i<len; i++) {
            char ch1=str.charAt(i);
            in[i]=ch1; 
        } 
        obj.convert(in, po);
        System.out.println("Postfix expression is: ");
        for(int i=0;i<len; i++ )
            System.out.print(po[i]); 
        System.out.println("");
        double imp[]=new double[len];
        int top1=-1;
        double result=0;
        for(int i=0;i<len; i++) {
            char ch=po[i];
            
            if(ch>='a'&&ch<='z')
            {
                
                double k=Double.parseDouble(br.readLine());
                imp[++top1]=k;
            }
            else if(ch=='*'||ch=='+'||ch=='-'||ch=='/')
            {
                double k=imp[top1];
                double k1=imp[top1-1];
                top1--;
                if(ch=='*')
                    result=k1*k;
                else if(ch=='+')
                    result=k1+k; 
                else if(ch=='-')
                    result=k1-k; 
                else if(ch=='/')
                    result=k1/k; 
                imp[top1]=result;
            }
        } 
        System.out.println("Result: "+imp[top1]);
    }
}
