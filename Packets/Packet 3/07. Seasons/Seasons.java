import java.io.*;
import java.util.*;

public class Seasons {
    public static final int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) throws FileNotFoundException {
        /*
         * For each data set, gets the distance and date from the starter file
         * Converts date to days with dateToDays(), then calculates distance with move()
         * Finally converts back to date and prints it out
         */
        Scanner input = new Scanner(new File("seasons.dat"));
        int ll = input.nextInt();
        input.nextLine();
        for (int i = 0; i < ll; i++) {
            int distance = input.nextInt();
            input.nextLine();
            String date = input.nextLine();
            int days = dateToDays(date);
            days = move(days, distance);
            System.out.println(daysToDate(days));
        }
    }

    /*
     * Subtracts distance based on season until distance > 0
     * - if days <= 120, calculates spring
     * - if days > 120 && days <= 243, calculates summer
     * - if days > 243, calculates winter
     */
    private static int move(int days, int distance) {
        while (distance > 0) {
            if (days % 365 <= 120) {
                distance -= 3;
                days++;
            } else if (days % 365 <= 243) {
                distance -= 5;
                days++;
            } else {
                distance -= 1;
                days++;
            }
        }
        return days;
    }

    /*
     * Adds days to totalDays
     * Adds (years * 365) to totalDays
     * Adds number of days in previous months to given month to totalDays
     * Returns totalDays
     */
    public static int dateToDays(String date) {
        Scanner dateScan = new Scanner(date);
        String month = dateScan.next();
        String temp = dateScan.next();
        int day = Integer.parseInt(temp.substring(0, temp.indexOf(',')));
        int year = dateScan.nextInt();
        int totalDays = day + (year * 365);

        if (month.equals("Febuary")) {
            totalDays += 31;
        } else if (month.equals("March")) {
            totalDays += 31 + 28;
        } else if (month.equals("April")) {
            totalDays += 31 + 28 + 31;
        } else if (month.equals("May")) {
            totalDays += 31 + 28 + 31 + 30;
        } else if (month.equals("June")) {
            totalDays += 31 + 28 + 31 + 30 + 31;
        } else if (month.equals("July")) {
            totalDays += 31 + 28 + 31 + 30 + 31 + 30;
        } else if (month.equals("August")) {
            totalDays += 31 + 28 + 31 + 30 + 31 + 30 + 31;
        } else if (month.equals("September")) {
            totalDays += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        } else if (month.equals("October")) {
            totalDays += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
        } else if (month.equals("November")) {
            totalDays += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
        } else if (month.equals("December")) {
            totalDays += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
        }

        return totalDays;
    }

    /*
     * Calculates year by (days/365)
     * Calculates days in current year by (days % 365)
     * Array months[] stores length of each month at it's number value - 1
     * Goes thru months and subtracts days by length of month
     * Once days is less than a month, days and months are at the correct length
     * Finally, converts number month to it's word, then returns M/D/Y
     */
    public static String daysToDate(int days) {

        int year = days / 365;
        int day = days % 365;
        int numOfMonths = 1;
        for (int i = 0; day > 31; i++) {
            day -= months[i];
            numOfMonths++;
        }

        String month = "";
        if (numOfMonths == 1)
            month = "January";
        if (numOfMonths == 2)
            month = "Febuary";
        if (numOfMonths == 3)
            month = "March";
        if (numOfMonths == 4)
            month = "April";
        if (numOfMonths == 5)
            month = "May";
        if (numOfMonths == 6)
            month = "June";
        if (numOfMonths == 7)
            month = "July";
        if (numOfMonths == 8)
            month = "August";
        if (numOfMonths == 9)
            month = "September";
        if (numOfMonths == 10)
            month = "October";
        if (numOfMonths == 11)
            month = "November";
        if (numOfMonths == 12)
            month = "December";

        return month + " " + day + ", " + year;
    }
}