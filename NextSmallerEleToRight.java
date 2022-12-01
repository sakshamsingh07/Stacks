package stacks;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerEleToRight 
{public static int[] nsr(int []arr , int [] s)
    {
        int n = arr.length;
        Stack<Integer>st= new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(st.size()!=0 && arr[st.peek()]>arr[i])
            {
                int idx = st.pop();
                s[idx]=arr[i];
            }
            st.push(i);
        }
        return s;

    }
    public static void display(int []s)
    {
        for(int i =0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }
    }
    public static void main(String []args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int []arr=new int [n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        int []s=new int [n];
        Arrays.fill(s,-1);
        int [] ans = nsr(arr,s);
        display(s);
    }
    
}
