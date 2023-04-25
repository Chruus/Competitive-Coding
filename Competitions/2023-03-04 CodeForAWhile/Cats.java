
//Christopher Petty
import java.util.*;
import java.io.*;

public class Cats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ll = Integer.parseInt(input.nextLine());
        ArrayList<Position> animals = new ArrayList<Position>();
        for (int i = 0; i < ll; i++) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            double x = lineScan.nextDouble();
            double y = lineScan.nextDouble();
            int type = lineScan.nextInt();
            Position animal = new Position(x, y, type);
            animals.add(animal);
        }

        ArrayList<Position> ul = new ArrayList<Position>();
        ArrayList<Position> ur = new ArrayList<Position>();
        ArrayList<Position> dl = new ArrayList<Position>();
        ArrayList<Position> dr = new ArrayList<Position>();
        ArrayList<Position> u = new ArrayList<Position>();
        ArrayList<Position> d = new ArrayList<Position>();
        ArrayList<Position> l = new ArrayList<Position>();
        ArrayList<Position> r = new ArrayList<Position>();
        for (Position animal : animals) {
            if (animal.x > 0) {
                r.add(animal);
            }
            if (animal.x < 0) {
                l.add(animal);
            }
            if (animal.y > 0) {
                u.add(animal);
            }
            if (animal.y < 0) {
                d.add(animal);
            }

            if (animal.y > animal.x && animal.y > 0)
                dl.add(animal);
            if (animal.y < animal.x && animal.y > 0)
                ur.add(animal);
            if (animal.y > animal.x && animal.x > 0)
                dr.add(animal);
            if (animal.y < animal.x && animal.x > 0)
                ul.add(animal);

            if (isSeperated(u) && isSeperated(d) && isSeperated(l) && isSeperated(r) && isSeperated(ul)
                    && isSeperated(ur) && isSeperated(dl) && isSeperated(dr))
                System.out.println(0);
            else
                System.out.println(1);
        }

    }

    public static boolean isSeperated(ArrayList<Position> animals) {
        int type = 0;
        for (Position animal : animals) {
            if (type == 0)
                type = animal.type;
            else if (animal.type != type)
                return false;
        }
        return true;
    }
}

class Position {
    double x, y;
    int type;

    Position(double x_, double y_, int type_) {
        x = x_;
        y = y_;
        type = type_;
    }
}