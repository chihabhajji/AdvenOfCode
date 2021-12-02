package tn.esprit.twentyOne.dayThree;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayThreePuzzleOne {
    public static void main(String[] args) {
        int x = 0, y = 0, i = 0 , j = 0;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(PathToFile.convertActual("dayThree.txt")))) {
            while ((line = br.readLine()) != null) {
                Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
