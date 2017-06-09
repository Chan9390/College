/* Program 1: Bit-Stuffing */
#include<stdio.h>
#include<string.h>
int main()
{
    FILE *fp;
    int n,c,i,k,j,b[120];
    char a[100],ans[120];
    printf("Enter bit Stream : ");
    scanf("%s",a);
    fp = fopen("bitstuffed.txt", "w");
    n=strlen(a);
    c=0;
    fputs("Entered Bit Stream : ",fp);
    fputs(a,fp);
    fclose(fp);

    //stuffing
    for(i=0,j=0;i<n;i++,j++)
    {
        if(a[i]=='1')
            c++;
        if(a[i]=='0')
            c=0;
         b[j]=a[i]-'0';
        if(c==5)
        {
            c=0;
             j++;
            b[j]=0;
        }
    }

    //disp

    printf("\nStuffed bit Stream : ");
    for(i=0;i<j;i++)
    {
        printf("%d",b[i]);
        ans[i]=b[i]+'0';
    }
    fp = fopen("bitstuffed.txt", "a");
    ans[i]='\0';
    fputs("\n",fp);
    fputs("Stuffed Bits : ",fp);
    fputs(ans,fp);
    c=0;
    printf("\n\n");

    //destuffing

    printf("Destuffed bit Stream : ");
    for(i=0,k=0;i<j;i++,k++)
    {
        if(b[i]==1)
            c++;
        if(b[i]==0)
            c=0;
        printf("%d",b[i]);
        ans[k]=b[i]+'0';

        if(c>=5 && b[i+1]==0)
        {
            c=0;
            i+=1;
        }
    }
    ans[k]='\0';
    fputs("\n",fp);
    fputs("De-Stuffed Bits : ",fp);
    fputs(ans,fp);
    return 0;
}
