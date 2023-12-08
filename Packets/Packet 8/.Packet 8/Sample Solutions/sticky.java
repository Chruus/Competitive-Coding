
import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class sticky {

    public static void main(String[] args) throws Exception {
        new sticky().run();
    }

    public void run() throws Exception {
        Scanner s = new Scanner(new File("sticky.dat"));
        int asdf = s.nextInt();
        s.nextLine();
        for (int xxx = 0; xxx < asdf; ++xxx) {
            Person[] ppl = new Person[s.nextInt()];
            for (int i = 0; i < ppl.length; ++i) {
                ppl[i] = new Person(s.nextInt(), s.nextInt());
            }
            Arrays.sort(ppl);
            System.out.println(perm(ppl, 0, ppl[0].a));
        }
    }
    
    int perm(Person[] ppl, int index, int lastEnd) {
        if (index >= ppl.length)
            return 0;
        if (lastEnd > ppl[index].a)
            return perm(ppl, index + 1, lastEnd);
        return Math.max(
                perm(ppl, index + 1, lastEnd),
                1 + perm(ppl, index + 1, ppl[index].b));
    }
    
    static class Person implements Comparable<Person> {
        int a, b;
        Person(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Person x) {
            return Integer.compare(a, x.a);
        }
    }
}
