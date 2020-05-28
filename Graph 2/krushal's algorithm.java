import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
        int t1,t2,t3;
		EdgeClass [] edge = new EdgeClass[e];
        for(int i=0;i<e;i++)
        {
             t1 = sc.nextInt();
             t2 = sc.nextInt();
             t3 = sc.nextInt();
            edge[i] = new EdgeClass(t1,t2,t3);
        }
		Arrays.sort(edge, new Comparator<EdgeClass>()  
        { 
            @Override
            public int compare(EdgeClass o1, EdgeClass o2)  
            { 
                return o1.cost.compareTo(o2.cost) ; 
            } 
        }); 
    	EdgeClass [] ans = new EdgeClass[n-1];
        int  parent [] = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] =i;
        }
        for(int i=0,j=0;i<e && j<n-1;i++)
        {
            t1 = edge[i].u;
            t2 = edge[i].v;
            t3 = edge[i].cost;
            if(unionFind(parent,t1,t2)==true)
            {
                ans[j] = new EdgeClass(t1,t2,t3);
                j++;
            }
        }
        for(int i =0;i<n-1;i++)
        {
            if(ans[i].u<ans[i].v)
            	System.out.println(ans[i].u+" "+ans[i].v+" "+ans[i].cost);
            else
                System.out.println(ans[i].v+" "+ans[i].u+" "+ans[i].cost);
                
        }
        
        
        
	}
    
    public static boolean unionFind(int []parent, int start, int end)
    {
        int n = parent.length-1;
        int pre = parent[end];
        
        
        while(parent[start] == parent [end])
        {
            start = parent[start];
            n--;
            if(n<0)
                break;
        }
        if(n<0)
            return false;
        else
        {
            int cur = parent[start];
            for(int i=0;i<parent.length;i++)
            {
                if(parent[i]==pre)
                    parent[i] = cur;
            }
            return true;
        }
    }
    
    
    public static class EdgeClass
    {
        Integer u,v,cost;
        EdgeClass(int u, int v, int cost)
        {
            this.u=u;
            this.v=v;
            this.cost = cost;
        }
        
    }
}
