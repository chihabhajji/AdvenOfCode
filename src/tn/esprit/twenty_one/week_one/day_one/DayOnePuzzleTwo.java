package tn.esprit.twenty_one.week_one.day_one;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayOnePuzzleTwo {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        String line;
        try (BufferedReader br = PathToFile.pathToBufferReader("dayOne.txt")) {
            while ((line = br.readLine()) != null) {
                input.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int counter = 0;
        long prevSum = input.get(0) + input.get(1) + input.get(2);
        long currentSum;
        for (int i = 1; i < input.size() - 1; i++) {
            currentSum = input.get(i-1) + input.get(i) + input.get(i+1);
            if (currentSum > prevSum)
                counter++;
            prevSum = input.get(i-1) + input.get(i) + input.get(i+1);
        }
        System.out.println(counter);
        // Answer is : 1497
    }
}
