package tn.esprit.twenty_one.week_two;

import tn.esprit.helpers.PathToFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class DayThirteenPuzzleOne {
    public static void main(String[] args) {
        List<Point> coordinates = new ArrayList<>();
        List<Map.Entry<Character, Integer>> folds = new ArrayList<>();
        try (var br = PathToFile.pathToBufferReader("dayThirteen")) {
            br.lines().filter(line -> !line.isEmpty()).forEach(line -> {
                if (line.contains(",")) {
                    var split = line.split(",");
                    coordinates.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
                } else folds.add(new AbstractMap.SimpleEntry<>(line.charAt(11), Integer.parseInt(line.substring(13))));
            });
            foldCoordinatesByAxis(folds,coordinates);
            var paper = initPaperByCoordinates(coordinates);
            for (var coordinate : coordinates)
                try {
                    paper[coordinate.y][coordinate.x] = true;
                } catch (ArrayIndexOutOfBoundsException e) {System.out.println("Defunct : " + coordinate);}
            printPaper(paper);
            System.out.println(countVisiblePoints(paper));
        } catch (IOException e) {System.out.println("Wrong input ?");}
    }
    static void foldCoordinatesByAxis(List<Map.Entry<Character, Integer>> folds, List<Point> coordinates){
        for (int i = 0; i < folds.size(); i++) {
            var fold = folds.get(i);
            for (Point coordinate : coordinates) {
                if (fold.getKey() == 'x') {
                    if(coordinate.x > fold.getValue())
                        if(coordinate.x % fold.getValue() != 0)
                            coordinate.x = fold.getValue() - (coordinate.x % fold.getValue());
                        else
                            coordinate.x = coordinate.x - (fold.getValue() * (coordinate.x / fold.getValue()));
                } else if (fold.getKey() == 'y') {
                    if(coordinate.y > fold.getValue())
                        if(coordinate.y % fold.getValue() != 0)
                            coordinate.y = fold.getValue() - (coordinate.y % fold.getValue());
                        else
                            coordinate.y = coordinate.y - (fold.getValue() * (coordinate.y / fold.getValue()));
                }
            }
        }
    }
    static long countVisiblePoints(Boolean[][] paper){
        return Arrays.stream(paper).mapToLong(value -> Arrays.stream(value).filter(character -> character).count()).sum();
    }

    static Boolean[][] initPaperByCoordinates(List<Point> coordinates){
        //noinspection OptionalGetWithoutIsPresent
        var paper = new Boolean[coordinates.stream().map(value -> value.y).max(Comparator.comparingInt(o -> o)).get() + 1][coordinates.stream().map(value -> value.x).max(Comparator.comparingInt(o -> o)).get() +1];
        for (Boolean[] points : paper) Arrays.fill(points, false);
        return paper;
    }

    static void printPaper(Boolean[][] paper) {
        for (var points : paper) {
            for (var point : points) {
                System.out.print(point ? '#' : '.');
            }
            System.out.println();
        }
    }
}






//     static Boolean[][] initPaper(List<Map.Entry<Character, Integer>> folds){
//        var minX = folds.stream().filter(characterIntegerEntry -> characterIntegerEntry.getKey()=='y').min(Map.Entry.comparingByValue());
//        var minY = folds.stream().filter(characterIntegerEntry -> characterIntegerEntry.getKey()=='x').min(Map.Entry.comparingByValue());
//        if(minX.isPresent() && minY.isPresent()){
//            Boolean[][] paper = new Boolean[minX.get().getValue() ][minY.get().getValue()];
//            for (Boolean[] points : paper) Arrays.fill(points, false);
//            return paper;
//        }
//        return null;
//    }







//         for (var fold : folds) {
//            switch (fold.getKey()) {
//                case 'x' -> {
//                    System.out.println(fold.getValue());
//                    for (int i = 0; i < paper.length; i++) {
//                        paper[i][fold.getValue()] = '|';
//                    }
//                }
//                case 'y' -> {
//                    for (int i = 0; i < paper[0].length; i++) {
//                        paper[fold.getValue()][i] = '_';
//                    }
//                }
//                default -> throw new IllegalStateException("Unexpected value: " + fold.getKey());
//            }
//        }



