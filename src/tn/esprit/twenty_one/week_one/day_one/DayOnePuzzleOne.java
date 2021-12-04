package tn.esprit.twenty_one.week_one.day_one;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;

public class DayOnePuzzleOne {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(PathToFile.pathToBufferReader("dayOne.txt")))
        {
            String line;
            int prev = 0;
            int current;
            int i = 0;
            int increasedCounter = 0;
            while((line=br.readLine())!=null)
            {
                current = Integer.parseInt(line);
                if (i==0){
                    System.out.println("(N/A - no previous measurement)");
                }else{
                    System.out.println(i + "Previous : " + prev + " Current : "+ current + (current > prev ? " (INCREASED)" : " (DECREASED)"));
                }
                if (current > prev && i!=0)
                    increasedCounter++;
                prev = Integer.parseInt(line);
                i++;
            }
            System.out.println(increasedCounter);
            // Answer is 1462
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
