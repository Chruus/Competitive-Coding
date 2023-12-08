import java.util.*;
import java.io.*;

public class stack {
        
    static double inside = 0;
    static int S;
    double monte;
    
    public static void main(String[] args) throws Exception
    {
    	new stack().run();
    }
    
    public void run() throws Exception{
    	Scanner file = new Scanner(new File("stack.dat"));
    	int zz = file.nextInt();
    	file.nextLine();
   	loop:
    	for(int z = 0;z<zz;z++)
    	{
    		file.nextLine();
    		String a = file.nextLine().trim().replaceAll(" ","");
    		String b = file.nextLine().trim().replaceAll(" ","");
    		state initial = new state(a,b,0);
    		HashSet<String> vis = new HashSet<String>();
    		PriorityQueue<state> que = new PriorityQueue<state>();
    		que.add(initial);
    		while(!que.isEmpty())
    		{
    			state st = que.poll();
    			if(vis.contains(st.toString()))
    				continue;
    			vis.add(st.toString());
    			if(st.complete())
    			{
    				System.out.println(st.cost);
    				continue loop;
    			}
    			state[] next = st.getMoves();
    			Arrays.sort(next);
    			for(state s:next)
    			{
    				if(!vis.contains(s.toString()))
    					que.add(s);
    			}
    		}
    	}
    	
    }
    
    public int weight(String s)
    {
    	int x = 0;
    	for(char ch:s.toCharArray())
    		x+=ch-48;
    	return x;
    }
    
    public String rev(String s)
    {
    	return s;//new StringBuffer(s).reverse().toString();
    }
    
    class state implements Comparable<state>
    {
    	String a;
    	String b;
    	int cost;
    	
    	public state(String x, String y, int c)
    	{
    		a = x;
    		b = y;
    		cost = c;
    	}
    	
    	public state[] getMoves()
    	{
    		state[] states = new state[5];
    		int x = 0;
    		for(int i = 0;i<a.length();i++)
    			states[x++] = new state(a.substring(0,i),b+a.substring(i),cost+weight(a.substring(i)));
    		for(int i = 0;i<b.length();i++)
    			states[x++] = new state(a+b.substring(i),b.substring(0,i),cost+weight(b.substring(i)));
    		return states;
    	}
    	
    	public String toString()
    	{
    		return a+" "+b;
    	}
    	
    	public int compareTo(state s)
    	{
    		return cost-s.cost;
    	}
    	
    	public boolean complete()
    	{
    		return a.equals("54321")||b.equals("54321");
    	}
    }

}
