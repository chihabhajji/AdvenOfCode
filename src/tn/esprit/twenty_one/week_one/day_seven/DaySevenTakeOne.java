package tn.esprit.twenty_one.week_one.day_seven;

import tn.esprit.helpers.PathToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DaySevenTakeOne {
    public static void main(String[] args) {
        try (var br = PathToFile.pathToBufferReader("daySeven")) {
            Map<Integer, Long> numbers = new TreeMap<>();
            Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).collect(Collectors.groupingBy(o -> o)).forEach((integer, integers) -> numbers.put(integer, (long) integers.size()));
            System.out.println(numbers);
            long max = numbers.values().stream().mapToLong(entry -> entry).max().getAsLong();
            long coordinate = 0 ;
            for (var entry: numbers.entrySet()) {
                if(entry.getValue()==max){
                    coordinate = entry.getKey();
                    System.out.println("POOP");
                }
            }
            long fuel = 0;
            for (var entry: numbers.entrySet()) {
                fuel += Math.abs(entry.getKey() - coordinate) * entry.getValue() ;
                System.out.println(entry + " " + coordinate);
            }
            System.out.println(fuel);
            // Working with test but not with actual data i think i need to median, trying with take two
            // reasoning :
            // Value  to Coordinate : Distance
            //    16  to          2 : 14
            //    16  to          2 : 14
            //    16  to          2 : 14
            // (value - coordinate) * occurences += fuel
        } catch (IOException e) {System.out.println("Dum dum you forgot the inputs!");}
    }
}
