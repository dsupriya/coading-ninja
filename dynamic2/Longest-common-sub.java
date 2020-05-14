import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int ans = LCS_non_dp(s1,s2,0,0);
        int n = s1.length();
        int m = s2.length();
        n++;
        m++;
        int dp [][] = new int [n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                dp[i][j] =-1;
        }
        System.out.println(ans);
         int ans = LCS_DP(s1,s2,0,0,dp);
        System.out.println(ans);
        
     }
     public static int LCS_DP(String s1,String s2,int n, int m, int [][]dp)
     {
         if(s1.length()==n || s2.length()==m)
         {
             return 0;
         }
         if(dp[n][m]!=-1)
            return dp[n][m];
         if(s1.charAt(n)==s2.charAt(m))
         {
             int ans2=  1+LCS_DP(s1,s2,n+1,m+1,dp);
             dp[n][m]=ans2;
             return ans2;
         }
            
        else
        {
            int op1= LCS_DP(s1,s2,n+1,m,dp);
            int op2=LCS_DP(s1,s2,n,m+1,dp);
            int ans = Math.max(op1,op2);
            dp[n][m]=ans;
            return ans;
        }
         
     }
     public static int LCS_non_dp(String s1,String s2,int n, int m)
     {
         if(s1.length()==n || s2.length()==m)
         {
             return 0;
         }
         if(s1.charAt(n)==s2.charAt(m))
            return 1+LCS_non_dp(s1,s2,n+1,m+1);
        else
        {
            int op1= LCS_non_dp(s1,s2,n+1,m);
            int op2=LCS_non_dp(s1,s2,n,m+1);
            int ans = Math.max(op1,op2);
            return ans;
        }
     }  
}
