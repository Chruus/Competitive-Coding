//Christopher Petty

import java.util.*;
import java.io.*;

public class Communication {
    static ArrayList<Channel> channels;

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(new File("communication.in"));
        channels = new ArrayList<Channel>();
        String line = "";

        // Stores channels in arraylist
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Checks if at end of input
            if (line.equals("-"))
                break;

            // Checks if a channels notif's are cleared
            if (line.charAt(0) == '!') {
                getChannel("#" + line.substring(1)).mentions = 0;
                continue;
            }

            // Prints current number of mentions
            if (line.charAt(0) == '?') {
                System.out.println(getMentions());
                continue;
            }

            String channelName = line.substring(0, line.indexOf(' '));
            String text = line.substring(line.indexOf(':') + 1);

            if (getChannel(channelName) == null)
                channels.add(new Channel(channelName));

            getChannel(channelName).mentions += findMentions(text);
        }
    }

    // Simplified method for getting channel by its name
    public static Channel getChannel(String channelName) {
        for (Channel channel : channels) {
            if (channel.name.equals(channelName))
                return channel;
        }
        return null;
    }

    // Returns # of times "@latterization" appears in text
    public static int findMentions(String text) {
        int output = 0;

        while (text.indexOf("@latterization") > -1) {
            output++;
            text = text.substring(text.indexOf("@latterization") + 14);
        }

        return output;
    }

    // Sums up mentions in each channel
    public static int getMentions() {
        int num = 0;
        for (Channel channel : channels) {
            num += channel.mentions;
        }
        return num;
    }
}

// Stores channel name and mentions in that channel
class Channel {
    int mentions;
    String name;

    public Channel(String name) {
        this.name = name;
    }

    public String toString() {
        return name + " " + mentions;
    }
}