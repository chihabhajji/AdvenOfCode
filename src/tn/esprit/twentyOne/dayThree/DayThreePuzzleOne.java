package tn.esprit.twentyOne.dayThree;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayThreePuzzleOne {
    public static void main(String[] args) {
        // CANT I SOLVE THIS USING HASH ?
        String gammaRate = "", epsilonRate = "";
        int[][] diagnostics = new int[1000][12];
        String line;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(PathToFile.convertActual("dayThree.txt")))) {
            while ((line = br.readLine()) != null) {
                char[] chararray = line.toCharArray();
                for(int j = 0; j< 12; j++){
                    diagnostics[i][j] = Integer.parseInt(String.valueOf(chararray[j]));
                }
                i++;
            }
            for (int j = 0; j < 12; j++) {
                int zeros = 0, ones = 0;
                for (int k = 0; k < 1000; k++) {
                    if(diagnostics[k][j] == 0)
                        zeros ++;
                    else
                        ones ++;
                }
                if (zeros > ones){
                    gammaRate += "0";
                    epsilonRate += "1";
                }else{
                    gammaRate += "1";
                    epsilonRate += "0";
                }
            }
            System.out.println(Long.parseLong(gammaRate, 2) * Long.parseLong(epsilonRate, 2));
            // 3923414
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
