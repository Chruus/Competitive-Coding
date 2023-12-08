import java.util.*;
import java.io.*;

public class paints {
        
    static double inside = 0;
    static int S;
    double monte;
    
    public static void main(String[] args) throws Exception
    {
    	new paints().run();
    }
    
    public void run() throws Exception{
    	Scanner file = new Scanner(new File("paints.dat"));
    	int zz = file.nextInt();
    	for(int z = 0;z<zz;z++)
    	{
			inside = 0;
    		S = file.nextInt();
    		int K = file.nextInt();
    		int[] x = new int[K];
    		int[] y = new int[K];
    		int[] r = new int[K];
    		for(int i = 0;i<K;i++)
    		{
    			x[i] = file.nextInt();
    			y[i] = file.nextInt();
    			r[i] = file.nextInt();
    		}
    		//double mc = monteCarlo(S,x,y,r,10000000);
    		inside = quadTrees(0,0,S,S,x,y,r,0);
    		System.out.printf("%.1f %.1f%n",inside,S*S-inside);
    	}
    }
    
    public double quadTrees(double tlx, double tly, double brx, double bry,int[] x, int[] y, int[] r, int dep)
    {
    	boolean intersect = false;
    	if(dep==15)
    		return 0;
    	for(int i = 0;i<x.length;i++)
    	{
    		if(inside(tlx,tly,brx,bry,x[i],y[i],r[i]))
    		{
    			return (brx-tlx)*(bry-tly);
    		}
    			
    		if(intersects(tlx,tly,brx,bry,x[i],y[i],r[i]))
    			intersect = true;
    	}
    	if(intersect)
    	{
    		double mx = (tlx+brx)/2;
			double my = (tly+bry)/2;
			double a = quadTrees(tlx,tly,mx,my,x,y,r,dep+1);
			double b = quadTrees(mx,tly,brx,my,x,y,r,dep+1);
			double c = quadTrees(tlx,my,mx,bry,x,y,r,dep+1);
			double d = quadTrees(mx,my,brx,bry,x,y,r,dep+1);
			return a+b+c+d;
    	}
    	return 0;
    }
    
    public  double monteCarlo(int S, int[] x, int[] y, int[] r, int iterations)
    {
    	double success = 0;
    	for(int i = 0;i<iterations;i++)
    	{
    		double xx = Math.random()*S;
    		double yy = Math.random()*S;
    		for(int j = 0;j<x.length;j++)
    		{
    			if(intersects(xx,yy,x[j],y[j],r[j]))
    			{
    				success++;
    				break;
    			}
    		}
    	}
    	return success/iterations*S*S;
    }
    
    public boolean intersects(double tlx, double tly, double brx, double bry, int cx, int cy, int r)
    {
    	return cx+r>tlx&&cx-r<brx&&cy+r>tly&&cy-r<bry;
    }
    
    public  boolean inside(double tlx, double tly, double brx, double bry, int cx, int cy, int r)
    {
    	if(!intersects(tlx,tly,cx,cy,r))return false;
    	if(!intersects(tlx,bry,cx,cy,r))return false;
    	if(!intersects(brx,tly,cx,cy,r))return false;
    	if(!intersects(brx,bry,cx,cy,r))return false;
    	return true;
    }
    
    public  boolean intersects(double x, double y, int cx, int cy, int r)
    {
    	return (x-cx)*(x-cx)+(y-cy)*(y-cy)<=r*r;
    } 
}
