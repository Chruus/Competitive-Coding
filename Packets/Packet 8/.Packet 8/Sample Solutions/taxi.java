
import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;


public class taxi {

    public static void main(String[] args) throws Exception {
        new taxi().run();
    }

    public void run() throws Exception {
        Scanner s = new Scanner(new File("taxi.dat"));
        int asdf = s.nextInt();
        s.nextLine();
        for (int xxx = 0; xxx < asdf; ++xxx) {
            int ppl = s.nextInt();
            PriorityQueue<Person> q = new PriorityQueue<>();
            for (int i = 0; i < ppl; ++i) {
                q.add(new Person(s.nextInt(), s.nextInt()));
            }
            int usedit = 0;
            int use = 0;
            int last = q.peek().a;
            while (!q.isEmpty()) {
                Person p = q.poll();
                if (p.b <= last)
                    continue;
                ++usedit;
                if (last < p.a)
                    last = p.a;
                use += p.b - last;
                last = p.b;
            }
            System.out.printf("%d %d %d%n", usedit, ppl - usedit, use);
        }
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
