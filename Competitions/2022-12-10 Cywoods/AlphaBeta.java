
public class AlphaBeta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int loopLength = input.nextInt();
        input.nextLine();
        for (int i = 0; i < loopLength; i++) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            int count = 0;
            while (lineScan.hasNext()) {
                lineScan.next();
                count++;
            }
            String[] words = new String[count];
            lineScan = new Scanner(line);
            for (int j = 0; j < count; j++)
                words[j] = lineScan.next();

            Arrays.sort(words, new VowelSort());
            for (String word : words)
                System.out.println(word + " ");
        }
        try {

        } catch (Exception e) {
        }
    }
}

class VowelSort implements Comparator<String> {

    public int compare(String o1, String o2) {
        int o1Count = 0;
        int o2Count = 0;
        o1 = o1.toLowerCase();
        o2 = o2.toLowerCase();
        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i) == 'a' || o1.charAt(i) == 'e' || o1.charAt(i) == 'a' || o1.charAt(i) == 'a'
                    || o1.charAt(i) == 'a')
                o1Count++;
        }
        for (int i = 0; i < o2.length(); i++) {
            if (o2.charAt(i) == 'a' || o2.charAt(i) == 'e' || o2.charAt(i) == 'a' || o2.charAt(i) == 'a'
                    || o2.charAt(i) == 'a')
                o2Count++;
        }

        if (o1Count > o2Count)
            return 1;
        if (o1Count < o2Count)
            return -1;
        return 0;
    }

}