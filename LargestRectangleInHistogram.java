package stacks;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInHistogram
{
    public static int largestRectangleArea(int[] heights) 
    {
        int maxx=0;
        int [] ans1=nsr(heights);
        int [] ans2=nsl(heights);
        for(int i =0;i<heights.length;i++)
        {
            int w=ans1[i]-ans2[i]-1;
            int area=w*heights[i];
            maxx=Math.max(area,maxx);      
        }
        
        return maxx;
               
    }
    public static int[] nsr(int [] arr)
    {
        int n=arr.length;
        int []s=new int [n];
        // Arrays.fil(s,n);
        for(int i=0;i<n;i++)
        {
            s[i]=n;
        }
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(st.size()!=0 && arr[st.peek()]>arr[i])
            {
                int idx=st.pop();
                s[idx]=i;
            }
            st.push(i);
        }
        return s;
    } 
    
     public static int[] nsl(int [] arr)
    {
        int n=arr.length;
        int []s=new int [n];
        // Arrays.fil(s,-1);
         for(int i=0;i<n;i++)
        {
            s[i]=-1;
        }
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(st.size()!=0 && arr[st.peek()]>arr[i])
            {
                int idx=st.pop();
                s[idx]=i;
            }
            st.push(i);
        }
        return s;
    } 
    public static void main(String []args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []heights=new int [n];
        for(int i=0;i<n;i++)
        {
            heights[i]=scn.nextInt();
        }
        int ans=largestRectangleArea(heights);
        System.out.println(ans);

    }
    
}
