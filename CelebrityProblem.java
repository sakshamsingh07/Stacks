package stacks;
import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem
{
    public static  void celebrity(int[][]arr)
    {
        int n=arr.length;
        int m=arr[0].length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            st.push(i);
        }
        while(st.size()>=2)
        {
            int j=st.pop();
            int i =st.pop();
            if(arr[i][j]==1)
            {
                st.push(j);
            }
            else
            {
                st.push(i);
            }
        }
        int pc = st.pop();
        
        boolean ans=true;
        for(int i=0;i<n;i++)
        {
            if(pc!=i && arr[i][pc]==0)
            {
                ans= false;
                break;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(pc!=i && arr[pc][i]==1)
            {
                ans=false;
                break;
            }
        }
        if(ans)
        {
            System.out.println(pc);
        }
        else
        {
            System.out.println("none");
        }
        

        
    }
    public static void main(String []args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int [][]arr=new int [n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=scn.nextInt();

            }
        }
         celebrity(arr);
       

    }
    
}
