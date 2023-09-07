import java.util.Scanner;
import java.io.File;

public class QuizScores
{
	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("quiz_scores.dat"));
		int score = 0;
		for(int x = 0; x<10;x++)
			score+=60-fromFile.nextInt();
		System.out.println("This team earned "+score + " point(s).");
	}
}