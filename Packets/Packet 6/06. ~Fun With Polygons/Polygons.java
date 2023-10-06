//Christopher Petty

import java.io.*;
import java.util.*;

public class Polygons {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("polygons.in"));
        int ds = Integer.parseInt(input.nextLine());

        for (int i = 0; i < ds; i++) {
            int numOfVertices = input.nextInt();
            Vertex[] vertices = new Vertex[numOfVertices];

            for (int j = 0; j < numOfVertices; j++) {
                input.nextLine();
                int x = input.nextInt();
                int y = input.nextInt();
                vertices[j] = new Vertex(x, y);
            }

            double longest = 0;

            for (int p1 = 1; p1 < vertices.length; p1++) {
                for (int p2 = p1 + 1; p2 < vertices.length; p2++) {
                    if (!collidesWithShape(vertices, p1, p2)) {
                        longest = Math.max(longest, dist(vertices[p1], vertices[p2]));
                    }
                }
            }

            System.out.println(longest);
        }
    }

    public static boolean collidesWithShape(Vertex[] vertices, int p1, int p2) {
        int p3 = p2 + 1;
        int p4 = p3 + 1;
        if (p3 >= vertices.length)
            p3 -= vertices.length;
        if (p4 >= vertices.length)
            p4 -= vertices.length;

        while (p4 != p1) {
            if (collides(vertices[p1], vertices[p2], vertices[p3], vertices[p4]))
                return true;

            p3++;
            p4++;
            if (p3 >= vertices.length)
                p3 -= vertices.length;
            if (p4 >= vertices.length)
                p4 -= vertices.length;
        }
        return false;
    }

    public static boolean collides(Vertex p1, Vertex p2, Vertex p3, Vertex p4) {
        double ua = 0.0;
        double ub = 0.0;
        double ud = (p4.y - p3.y) * (p2.x - p1.x) - (p4.x - p3.x) * (p2.y - p1.y);

        if (ud != 0) {
            ua = ((p4.x - p3.x) * (p1.y - p3.y) - (p4.y - p3.y) * (p1.x - p3.x)) / ud;
            ub = ((p2.x - p1.x) * (p1.y - p3.y) - (p2.y - p1.y) * (p1.x - p3.x)) / ud;
            if (ua < 0.0 || ua > 1.0 || ub < 0.0 || ub > 1.0)
                return false;
        }
        return true;
    }

    public static double dist(Vertex p1, Vertex p2) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}

class Vertex {
    int x, y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + " " + y + ")";
    }
}