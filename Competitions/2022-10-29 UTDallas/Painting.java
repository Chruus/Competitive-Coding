import java.util.*;
import java.io.*;
import java.lang.*;


public class Painting
{
    public static void main(String[] args) throws IOException
    {
        
        Scanner in = new Scanner(System.in);
        int numSizes = in.nextInt(); //number of paint can sizes, next numSizes lines are each color
        int numColors = in.nextInt(); //number of colors;
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        ArrayList<Integer> colors = new ArrayList<Integer>();
        int lowestModulo=100000;
        int totalModulo=0;
        
        HashMap <Character, Integer> map = new HashMap <Character, Integer>();
        
        for(int i = 0; i<numSizes; i++)
        {
            map.put('s', in.nextInt());
        }
        for(int i = 0; i<numColors; i++)
        {
            map.put('c', in.nextInt());
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            
        }
        
        /*int numColorLen = (int)colors.size();
        int numSizesLen = (int)sizes.size();
        for(int i = 0; i<numColorLen; i++)
        {
            
            for(int j = 0; j<numSizesLen; j++)
            {
                if(colors.get(i)%sizes.get(j)<=lowestModulo)
                {
                    lowestModulo=colors.get(i)%sizes.get(j);
                }
                if(j==numSizesLen-2)
                {
                    totalModulo+=lowestModulo;
                    lowestModulo=100000;
                }
                
            }
        }*/
        System.out.println(totalModulo);
    }
}