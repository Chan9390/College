#include <stdio.h>

int main()
{
    FILE *fp;
    int i,j,c,k,n;
    char a[100],ans[200],ans2[100],flag,e;
    fp=fopen("bytestuffed.txt","w");
    printf("Enter String : ");
    fgets(a, 100, stdin);
    //Learnt that if you dont add space infront of %c, the next input will be skipped
    printf("Enter flag :");
    scanf(" %c", &flag);
    printf("Enter Stuffing char :");
    scanf(" %c", &e);
    ans[0]=flag;
    c=0;
    //transfering into file
    fputs("Entered String : ",fp);
    fputs(a,fp);
    fputs("\nEntered flag : ",fp);
    fputc(flag,fp);
    fputs("\nEntered Stuffing Char : ",fp);
    fputc(e,fp);
    fclose(fp);
    for(i=0,j=1;a[i]!='\0';i++,j++)
    {
          ans[j]=a[i];
          if(a[i+1]==flag)
          {
                          j++;
                          ans[j]=e;
          }
    }
    //disp
    ans[j]=flag;
    printf("\n\nStuffed String : ");
    for(i=0;i<=j;i++)
    {
                    printf("%c",ans[i]);
    }
    ans[i]='\0';
    fp=fopen("bytestuffed.txt","a");
    fputs("\n",fp);
    fputs("Stuffed String : ",fp);
    fputs(ans,fp);
    //destuffing
    printf("\n\nDe-Stuffed String : ");
    for(i=1,k=0;i<j;i++)
    {               if(ans[i+1]==flag && ans[i]==e)
                    continue;
                    else
                    {
                        ans2[k]=ans[i];
                        k++;
                    }
    }
    ans2[k]='\0';
    fputs("\n",fp);
    fputs("De-stuffed Bytes : ",fp);
    fputs(ans2,fp);
    fclose(fp);
    printf("%s",ans2);
}
