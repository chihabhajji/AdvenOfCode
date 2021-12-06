package tn.esprit.twenty_one.week_one.day_six;

import tn.esprit.helpers.PathToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DaySixPuzzleOne {
    static final Map<Integer, Long> hatchlings = new TreeMap<>();
    public static void main(String[] args) {
        try (var br = PathToFile.pathToBufferReader("daySix")) {
            Long[] overflow = new Long[2];
            Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).collect(Collectors.groupingBy(o -> o)).forEach((integer, integers) -> hatchlings.put(integer, (long) integers.size()));
            Arrays.fill(overflow, 0L);
            for (int i = 0; i <= 6; i++) hatchlings.putIfAbsent(i, 0L);
            for (int i = 0; i < 256; i++) {
                Long newGen = overflow[0] , oldGen = hatchlings.get(0);
                overflow[0] = overflow[1];
                overflow[1] = hatchlings.get(0);
                for (int j = 1; j <= 7; j++) hatchlings.put(j - 1, hatchlings.getOrDefault(j, oldGen + newGen));
            }
            System.out.println(hatchlings.values().stream().mapToLong(value -> value).sum() + overflow[0] + overflow[1]);
        } catch (IOException e) {System.out.println("Dum dum you forgot the inputs!");}
    }
}

