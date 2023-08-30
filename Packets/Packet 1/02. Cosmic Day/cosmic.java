//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class cosmic {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("cosmic.dat"));
        int end = Integer.parseInt(input.nextLine());
        // Array of all the months
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int i = 0; i < end; i++) {

            // Taking month and day out of line
            String line = input.nextLine();
            int month = Integer.parseInt(line.substring(0, line.indexOf("/")));
            int day = Integer.parseInt(line.substring(line.indexOf("/") + 1));
            double daysTotal = 0;

            // Converting months to days
            for (int j = 0; j < month - 1; j++)
                daysTotal += months[j];
            daysTotal += day - 1;

            // Converting days to minutes then minutes to normal time
            double totalMinutes = daysTotal * 1440.0 / 365.0;
            int hour = (int) Math.round(totalMinutes / 60);
            int minute = (int) (totalMinutes % 60);
            if (minute > 30)
                hour--;

            // Printing result in standard format, making sure there's 0 in front of single
            // digit numbers
            if (hour < 10)
                out.print("0" + hour + ":");
            else
                out.print(hour + ":");
            if (minute < 10)
                out.println("0" + minute);
            else
                out.println(minute);
        }
    }
}
