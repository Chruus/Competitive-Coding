import java.util.*;
import java.awt.*;
import java.io.*;
public class JumpMaze
{
	private static char[][] m;
	private static boolean[][] v;

	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("jump_maze.dat"));
		
		while(fromFile.hasNextLine())
		{
			Scanner fromLine = new Scanner(fromFile.nextLine()).useDelimiter("x");
			int width = fromLine.nextInt();
			int height = fromLine.nextInt();
			m = new char[height][width];
			v = new boolean[height][width];
			
			int startcol=-1;
			int startrow=-1;
			for(int row=0; row<m.length; row++)
			{
				String s = fromFile.nextLine();
				
				for(int col=0; col<m[0].length; col++)
				{
					m[row][col] = s.charAt(col);
					v[row][col] = false;
					if(m[row][col] == 'S')
					{
						startcol=col;
						startrow=row;
					}
				}
			}
			boolean b= solvable(startcol,startrow);
		
			if(b == true)
				System.out.println("keep");
			else
				System.out.println("scrap");
		}
	}

	public static boolean solvable(int col, int row)
	{
		if(row<0 || row>=m.length || col < 0 || col >=m[0].length || v[row][col]==true || m[row][col]=='W')
			return false;
			
		v[row][col]=true;
		if(m[row][col]=='E')
			return true;
			
		boolean a,b,c,d;
		a=b=c=d=false;
		
		if(m[row][col]=='-' || m[row][col]=='S')
		{
				a = solvable(col-1,row); 
				b = solvable(col,row-1);
				c = solvable(col,row+1);
				d = solvable(col+1,row);
		}
		else
		{
				a = solvable(col-2,row); 
				b = solvable(col,row-2);
				c = solvable(col,row+2);
				d = solvable(col+2,row);
		}
		
		return a || b || c || d;
	}
}