//Christopher Petty 

import java.util.*;
import java.io.*;

public class QuizUpgrade {
    public static void main(String[] args) throws IOException {
        // Convert data into sortable Team classes, then sort and return the top three
        Scanner input = new Scanner(new File("quiz_upgrade.dat"));
        int ll = input.nextInt();
        input.nextLine();
        ArrayList<Team> teams = new ArrayList<Team>();

        for (int i = 0; i < ll; i++) {
            teams.add(new Team(input.nextLine()));
        }

        Collections.sort(teams);

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + " - (" + teams.get(i) + ")");
        }
    }
}

class Team implements Comparable<Team> {
    String name;
    int score;

    // Convert line into usable data
    public Team(String line) {
        String[] data = line.split(" - ");
        name = data[0];
        String[] scores = data[1].split(",");
        for (String str : scores) {
            score += 60 - Integer.parseInt(str.strip());
        }
    }

    // Sort based on team score
    public int compareTo(Team team) {
        if (score < team.score)
            return 1;
        if (score > team.score)
            return -1;
        return 0;
    }

    public String toString() {
        return name + " - " + score;
    }
}