import java.util.*;
import java.awt.*;
import java.io.*;
public class ThreeD_Maze
{
	private static char[][][] maze;
	private static int[][][] distance;

	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("three_d_maze.dat"));
		
		while(fromFile.hasNextLine())
		{
			Scanner fromLine = new Scanner(fromFile.nextLine()).useDelimiter("x");
			int width = fromLine.nextInt();
			int height = fromLine.nextInt();
			int depth = fromLine.nextInt();
			maze = new char[depth][height][width];
			distance = new int[depth][height][width];
			
			int endCol=-1;
			int endRow=-1;
			int endDepth=-1;
			for(int row=0; row<maze[0].length; row++)
			{
				
				for(int dep=maze.length-1; dep>=0; dep--)
				{
					String s = fromFile.nextLine();
					for(int col=0; col<maze[0].length; col++)
					{
						maze[dep][row][col] = s.charAt(col);
						distance[dep][row][col] = -1;
						if(maze[dep][row][col] == 'S')
						{
							distance[dep][row][col]=0;
						}
						else if(maze[dep][row][col] == 'E')
						{
							endCol = col;
							endRow = row;
							endDepth = dep;
						}
					}
					
				}
				if(row!=maze.length-1)
					fromFile.nextLine();
			}
			int d=0;
			while(markDistances(d++));
			
		
			if(distance[endDepth][endRow][endCol] == -1)
				System.out.println("No Solution");
			else
				System.out.println("Shortest solution is "+distance[endDepth][endRow][endCol]+" move(s)");
		}
	}

	public static boolean markDistances(int dist)
	{
		boolean marked = false;
		
		for(int dep=0; dep<maze.length; dep++)
		{
			for(int row=0; row<maze[0].length; row++)
			{
				for(int col=0; col<maze[0].length; col++)
				{
					if(distance[dep][row][col]==dist)
					{
						
						if(dep+1 < maze.length && distance[dep+1][row][col]==-1 && maze[dep+1][row][col]!='W')
						{
							distance[dep+1][row][col]=dist+1;
							marked=true;
						}
						if(row+1 < maze[0].length && distance[dep][row+1][col]==-1 && maze[dep][row+1][col]!='W')
						{
							distance[dep][row+1][col]=dist+1;
							marked=true;
						}
						if(col+1 < maze[0][0].length && distance[dep][row][col+1]==-1 && maze[dep][row][col+1]!='W')
						{
							distance[dep][row][col+1]=dist+1;
							marked=true;
						}
						if(dep-1 >=0 && distance[dep-1][row][col]==-1 && maze[dep-1][row][col]!='W')
						{
							distance[dep-1][row][col]=dist+1;
							marked=true;
						}
						if(row-1 >=0 && distance[dep][row-1][col]==-1 && maze[dep][row-1][col]!='W')
						{
							distance[dep][row-1][col]=dist+1;
							marked=true;
						}
						if(col-1 >=0 && distance[dep][row][col-1]==-1 && maze[dep][row][col-1]!='W')
						{
							distance[dep][row][col-1]=dist+1;
							marked=true;
						}
					}
					
				}
				
			}
		}
		
		return marked;
	}
}