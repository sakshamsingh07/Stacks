package stacks;
import java.util.Stack;
import java.util.Scanner;

public class infixev 
{
    public static void main(String []args)
    {
        Scanner scn=new Scanner(System.in);
        String s=scn.nextLine();
        int ans=infix(s);
        System.out.println(ans);

    }
    public static int infix(String exp)
    {
        Stack<Character>opr=new Stack<>();
        Stack<Integer>opd=new Stack<>();
        for(int i =0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(ch=='(')
            {
                opr.push(ch);
            }
            else if(ch>='0' && ch<='9')
            {
                opd.push(ch-'0');
            }
            else if(ch==')')
            {
                while(opr.peek()!='(')
                {
                    char s= opr.pop();
                    int v2=opd.pop();
                    int v1=opd.pop();
                    int cal=calculation(v1,v2,s);
                    opd.push(cal);
                }
                opr.pop();              
            }
            

            else if(toolss(ch))
            {
                while(opr.size()>0 && precedence(ch)<=precedence(opr.peek()) && opr.peek()!='(')
                {
                   char s= opr.pop();
                   int v2=opd.pop();
                   int v1=opd.pop();
                   int cal=calculation(v1,v2,s);
                   opd.push(cal);
                }
                opr.push(ch);
            }
           
        }

        while(opr.size()!=0)
        {
            char s= opr.pop();
            int v2=opd.pop();
            int v1=opd.pop();
            int cal=calculation(v1,v2,s);
            opd.push(cal);
        }
        return(opd.peek());

    }

    public static int precedence(char oper)
    {
        if(oper=='+' || oper=='-')
        {
            return 1;
        }
        return 2;
    }

    public static boolean toolss(char che)
    {
        if(che=='+'||che=='-'||che=='*'||che=='/')
        {
            return true;
        }
        return false;
    }
     
    public static int calculation(int a,int b, int oprrr)
    {
        if(oprrr=='+')
        {
            return a+b;
        }
        else if(oprrr=='-')
        {
            return a-b;
        }
        else if(oprrr=='*')
        {
            return a*b;
        }
        else if(oprrr=='/')
        {
            return a/b;
        }
        return 0;
        
    }
    
}
