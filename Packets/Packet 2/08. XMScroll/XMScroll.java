//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class XMScroll{
    public static void main(String[] args) throws IOException{
        //Variable declaration
        Scanner input = new Scanner(new File("xmscroll.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        
        //Loops thru every line
        for(int i = 0; i < loopLength; i++){
            //Variable declaration strikes back
            String author = input.nextLine();
            String song = input.nextLine();
            
            //Cuts off author if it's too long
            if(author.length() > 16)
                out.println(author.substring(0,16));
            else
                out.println(author);
            
            //Right justifies song if <=16, if >17 moves string from left to right one char at a time
            if(song.length() <= 16){
                String songSpace = "";
                for(int j = 0; j < 16-song.length(); j++)
                    songSpace = songSpace + " ";
                out.println(songSpace + song);
            }
            else{
                for(int j = 0; j < song.length()-16; j++)
                    out.println(song.substring(j,j+16));
            }
            out.println();
        }
    }
}

