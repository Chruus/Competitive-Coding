import java.util.*;

public class AndayIvyLeague {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> emailList = new ArrayList<String>();
        while (input.hasNextLine())
            emailList.add(input.nextLine());
        Collections.sort(emailList, new WorseCompare());
        for (String email : emailList)
            System.out.println(email);
    }
}

class WorseCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String alphabet = "portwefiylskdgmnjbvcxzaqhu";
        char[] order = alphabet.toCharArray();
        int length = 0;
        if (o1.length() > o2.length())
            length = o2.length();
        else
            length = o1.length();
        for (int i = 0; i < length; i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                for (int j = 0; j < order.length; j++) {
                    if (o1.charAt(i) == order[j])
                        return -1;
                    if (o2.charAt(i) == order[j])
                        return 1s;
                }
            }

        }
        return 0;
    }

}