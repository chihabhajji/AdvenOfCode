package tn.esprit.dayTwo;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwoPuzzleOne {
    public static void main(String[] args) {
        int horizontal = 0 , depth = 0;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(PathToFile.convertActual("dayTwo.txt")))) {
            while ((line = br.readLine()) != null) {
                if(line.startsWith("up")){
                    depth -= Integer.parseInt(line.replace("up ",""));
                } else if (line.startsWith("down")){
                    depth += Integer.parseInt(line.replace("down ",""));
                } else {
                    // Forward
                    horizontal += Integer.parseInt(line.replace("forward ",""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(horizontal);
        System.out.println(depth);
        int sum = horizontal*depth;
        System.out.println(sum);
        // 2083
        // 955
        // 1989265
    }
}
