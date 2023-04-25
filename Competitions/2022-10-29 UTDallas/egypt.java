//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;
import java.lang.*;

public class egypt{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        ArrayList <Integer> nums = new ArrayList <Integer>();
        for(int i = 0; i < num*3; i++)
            nums.add(input.nextInt());
        Collections.sort(nums, Collections.reverseOrder());
            
        out.println(returnVar(num, nums));
    }
        
    public static double returnVar(int bins, ArrayList balls){
        int[] binsArr = new int[bins];
        double output = 0;
        int looplength = 0;
        for(int i = binsArr.length - 1; i >= 0; i--){
            for(int j = 0; j < 3; j ++){
                looplength ++;
                if(looplength >= balls.size())
                    break;
                output += (int)balls.get(looplength) * i;
            }
        }
        return output;
    }
}

