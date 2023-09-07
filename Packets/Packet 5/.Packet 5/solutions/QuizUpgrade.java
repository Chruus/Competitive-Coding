import java.util.*;
import java.io.File;

public class QuizUpgrade
{
	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("quiz_upgrade.dat"));
		ArrayList<Team> teams = new ArrayList<>();
		
		int numTeams = fromFile.nextInt();
		fromFile.nextLine();
	
		for(int t=0; t<numTeams; t++)
		{
			String s = fromFile.nextLine();
			
			String[] data = s.split("[-,]");
			Team team =new Team(data[0].trim());
			for(int x = 1; x<data.length;x++)
			{
				team.increaseScore(60-Integer.parseInt(data[x].trim()));
			}
			
			teams.add(team);
		}
		Collections.sort(teams);
		
		System.out.println("The top 3 teams are as follows: ");
		for(int t=0; t<3; t++)
			System.out.printf("%d - %s\n",t+1,teams.get(teams.size()-1-t));
	}
}

class Team implements Comparable
{
	private String name;
	private int score;
	
	public Team(String name)
	{	this.name = name;	}
	
	public void increaseScore(int add)
	{	score+=add;	}
	
	public int getScore()
	{	return score;	}
	
	public String toString()
	{	return "("+name+" - "+score+")";	}
	
	public int compareTo(Object o)
	{	return score - ((Team)o).getScore();	}
}