package stacks;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan 
{
    public static int[] ngol(int []arr)
    {
        int n=arr.length;
        int []s=new int[n];
        for(int i=0;i<n;i++)
        {
            s[i]=-1;
        }
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(st.size()!=0 && arr[st.peek()]<arr[i])
            {
                int idx=st.pop();
                s[idx]=i;
            }
            st.push(i);
        }
        return s;
    }
   
    public static void display(int []stockss)
    {
        for(int i=0;i<stockss.length;i++)
        {
            System.out.println(stockss[i]);
        }     
    }

    public static int[] stocks(int []arr) 
    {
        int []anss=ngol(arr);
        int []stock=new int[arr.length];
        for(int i=0;i<stock.length;i++)
        {
            stock[i]=i-anss[i];
        }
        return stock;
    }

    public static void main(String []args)
    {
        Scanner scn=new Scanner(System.in);
        int n = scn.nextInt();
        int []arr=new int [n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        // int anss=0;
        // int []ans=ngol(arr);
        // int []stock=new int [n];  
        // for(int i=0;i<stock.length;i++)
        // {
        //     stock[i]=i-ans[i];
        // }
        int []a=stocks(arr);
        display(a);
        
    }
    
}
