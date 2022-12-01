package stacks;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class NextGreaterEleOnRight 
{
    public static int[] nger(int []arr, int []s)
    {
        int n= arr.length;
        Stack<Integer>st=new Stack<>();
        for(int i =0;i<n;i++)
        {
            while(st.size()!=0 && arr[st.peek()]<arr[i])
            {
                int idx= st.pop();
                s[idx]=arr[i];
            }
            st.push(i);
        }
        return s;
    }
    public static void display(int []s)
    {
        int n = s.length;
        for(int i =0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
    public static void main (String []args)
    {
        Scanner scn=new Scanner (System.in);
        int n= scn.nextInt();
        int []arr=new int [n];
        for(int i =0; i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        int s[]=new int [n];
        Arrays.fill(s,-1);
        int [] ans=nger(arr,s);
        display(s);
        // System.out.println(ans);

    }
    
}
