import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        for(int i = 0;i<ll;i++){
            boolean looking = true; 
            int pos = 0;
            while (looking){
                //pos=1;
                if(in.next().equals("Nimo")){
                    
                    System.out.println(pos+1);
                    in.nextLine();
                    break;
                    //looking = false;
                }
                pos++;
            }
        }
        
    }
}
