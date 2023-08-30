import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Clothes {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("clothes.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        /*
         * For each dataset, adds each clothing to the front of corresponding arraylist
         * Prints and removes the clothes at index 0 until one of the lists is empty
         */
        for (int i = 0; i < loopLength; i++) {
            ArrayList<String> shirt, pants, socks;
            shirt = new ArrayList<String>();
            pants = new ArrayList<String>();
            socks = new ArrayList<String>();
            int amountOfClothes = input.nextInt();
            input.nextLine();

            for (int j = 0; j < amountOfClothes; j++) {
                String line = input.nextLine();
                if (line.lastIndexOf("shirt") > -1)
                    shirt.add(0, line.substring(0, line.indexOf(" (")));
                else if (line.lastIndexOf("pants") > -1)
                    pants.add(0, line.substring(0, line.indexOf(" (")));
                else if (line.lastIndexOf("socks") > -1)
                    socks.add(0, line.substring(0, line.indexOf(" (")));
            }
            while (!(shirt.isEmpty() || pants.isEmpty() || socks.isEmpty()))
                System.out.println(shirt.remove(0) + ", " + pants.remove(0) + ", " + socks.remove(0));
            System.out.println();

        }
    }
}