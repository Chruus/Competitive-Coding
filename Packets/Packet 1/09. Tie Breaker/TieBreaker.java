import java.io.*;
import java.util.*;

public class TieBreaker {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Adds all rows of numbers into team classes and puts them into ArrayList teams
         * Sorts teams, then prints out each team, adding a line break if the previous
         * team was in a different division
         */
        Scanner input = new Scanner(new File("tiebreaker.dat"));
        int loopLength = input.nextInt();
        ArrayList<Team> teams = new ArrayList<Team>();
        for (int i = 0; i < loopLength; i++) {
            input.nextLine();
            int div = input.nextInt();
            int num = input.nextInt();
            int scr = input.nextInt();
            int sub = input.nextInt();
            teams.add(new Team(div, num, scr, sub));
        }
        Collections.sort(teams);
        int lastDiv = 1;
        for (Team team : teams) {
            if (team.division == lastDiv)
                System.out.println(team);
            else {
                lastDiv = team.division;
                System.out.println("**********");
                System.out.println(team);
            }
        }
    }
}

class Team implements Comparable<Team> {
    int division, number, score, lastSub;

    /*
     * Stores division, number, score, and last submission
     * Implements comparable, meaning I can specify how I sort the class
     * Sorts by division, then score, then submission time
     * Also has a toString to make printing the teams at the end easier
     */
    Team(int division_, int number_, int score_, int lastSub_) {
        division = division_;
        number = number_;
        score = score_;
        lastSub = lastSub_;
    }

    public String toString() {
        return "Division " + division + ": Team " + number + " - " + score + " points, Last time: " + lastSub;
    }

    public int compareTo(Team team) {
        if (team.division > this.division)
            return -1;
        if (team.division < this.division)
            return 1;

        if (team.score < this.score)
            return -1;
        if (team.score > this.score)
            return 1;

        if (team.lastSub > this.lastSub)
            return -1;
        if (team.lastSub < this.lastSub)
            return 1;

        return 0;
    }
}