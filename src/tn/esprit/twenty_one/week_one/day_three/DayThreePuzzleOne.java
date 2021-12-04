package tn.esprit.twenty_one.week_one.day_three;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;

public class DayThreePuzzleOne {
    public static void main(String[] args) {
        // CANT I SOLVE THIS USING HASH ?
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        int[][] diagnostics = new int[1000][12];
        String line;
        int i = 0;
        try (BufferedReader br = PathToFile.pathToBufferReader("dayThree.txt")) {
            while ((line = br.readLine()) != null) {
                char[] chararray = line.toCharArray();
                for(int j = 0; j< 12; j++)
                    diagnostics[i][j] = Integer.parseInt(String.valueOf(chararray[j]));
                i++;
            }
            for (int j = 0; j < 12; j++) {
                int zeros = 0;
                int ones = 0;
                for (int k = 0; k < 1000; k++) {
                    if(diagnostics[k][j] == 0)
                        zeros ++;
                    else
                        ones ++;
                }
                if (zeros > ones){
                    gammaRate.append("0");
                    epsilonRate.append("1");
                }else{
                    gammaRate.append("1");
                    epsilonRate.append("0");
                }
            }
            System.out.println(Long.parseLong(gammaRate.toString(), 2) * Long.parseLong(epsilonRate.toString(), 2));
            // 3923414
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
