import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Othello {
    public static char player = 42;
    public static char opponent = 42;
    public static char[][] grid = new char[8][8];

    public Othello() {
    }

    public static void main(String[] args) throws Exception {
        Scanner fromFile = new Scanner(new File("othello.dat"));

        while(true) {
            while(fromFile.hasNextLine()) {
                player = fromFile.nextLine().charAt(0);
                if(player == 87) {
                    opponent = 66;
                } else {
                    opponent = 87;
                }

                ArrayList<Point> points = new ArrayList<>();

                int x;
                for(x = 0; x < grid.length; ++x) {
                    String c = fromFile.nextLine();

                    for(int c1 = 0; c1 < grid[0].length; ++c1) {
                        grid[x][c1] = c.charAt(c1);
                    }
                }

                for(x = 0; x < grid.length; ++x) {
                    for(int var6 = 0; var6 < grid[0].length; ++var6) {
                        if(grid[x][var6] == 45 && (captures(var6, x, -1, -1) || captures(var6, x, 0, -1) || captures(var6, x, 1, -1) || captures(var6, x, 1, 0) || captures(var6, x, 1, 1) || captures(var6, x, 0, 1) || captures(var6, x, -1, 1) || captures(var6, x, -1, 0))) {
                            points.add(new Point(var6, x));
                        }
                    }
                }

                if(points.size() == 0) {
                    System.out.println("There are no moves for this player.");
                } else {
                    System.out.print("{");

                    for(x = 0; x < points.size() - 1; ++x) {
                        System.out.print("(" + ((Point)points.get(x)).getX() + ", " + ((Point)points.get(x)).getY() + "), ");
                    }

                    System.out.println("(" + ((Point)points.get(points.size() - 1)).getX() + ", " + ((Point)points.get(points.size() - 1)).getY() + ")}");
                }
            }

            return;
        }
    }

    public static boolean captures(int c, int r, int modC, int modR) {
        if(r + modR >= 0 && r + modR < grid.length && c + modC >= 0 && c + modC < grid[0].length && grid[r + modR][c + modC] == opponent) {
            for(int mult = 2; r + mult * modR >= 0 && r + mult * modR < grid.length && c + mult * modC >= 0 && c + mult * modC < grid[0].length; ++mult) {
                if(grid[r + modR * mult][c + modC * mult] == 45) {
                    return false;
                }

                if(grid[r + modR * mult][c + modC * mult] == player) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
