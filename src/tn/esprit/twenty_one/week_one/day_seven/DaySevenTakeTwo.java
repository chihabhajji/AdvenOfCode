package tn.esprit.twenty_one.week_one.day_seven;

import tn.esprit.helpers.PathToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class DaySevenTakeTwo {
    public static void main(String[] args) {
        try (var br = PathToFile.pathToBufferReader("daySeven")) {
            Map<Integer, Long> numbers = new TreeMap<>();
            Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).collect(Collectors.groupingBy(o -> o)).forEach((integer, integers) -> numbers.put(integer, (long) integers.size()));
            long max = numbers.values().stream().skip(numbers.size() / 3).limit(numbers.size() / 3).mapToLong(entry -> entry).max().getAsLong();
            numbers.entrySet().stream().skip(numbers.size() / 3).limit(numbers.size() / 3).filter(value -> value.getValue() == max).forEach(res -> {
                long fuel = 0;
                for (var entry : numbers.entrySet()) {
                    fuel += Math.abs(entry.getKey() - res.getKey()) * entry.getValue();
                }
                System.out.println(fuel);
            });
        } catch (IOException e) {System.out.println("Dum dum you forgot the inputs!");}
    }
}
