
public class Solution {
	
	public static int gcd(int a,int b)
	{
		// Write your code here
        if(b==0)
         return a;
        
        if(a>b)
         return gcd(b,a%b);
        else
         return gcd(a,b%a);
        
	}		
}
