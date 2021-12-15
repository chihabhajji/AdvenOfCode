package tn.esprit.twenty_one.week_one.day_seven;

import tn.esprit.helpers.PathToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.google.common.math.Quantiles.median;

public class DaySevenTakeThree {
    public static void main(String[] args) {
        try (var br = PathToFile.pathToBufferReader("daySeven")) {
            List<Integer> input = Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).toList();
            double median = median().compute(input);
            System.out.println(input.stream().mapToDouble(i -> i - median).map(Math::abs).sum());
            double trueAvg = input.stream().mapToInt(i -> i).average().getAsDouble();
            System.out.println(input.stream().mapToInt(i -> i).map(i -> i - (int) Math.floor(trueAvg)).map(Math::abs).map(i -> (i * (i+1))/2).sum());
        } catch (IOException e) {System.out.println("Dum dum you forgot the inputs!");}
    }
}
