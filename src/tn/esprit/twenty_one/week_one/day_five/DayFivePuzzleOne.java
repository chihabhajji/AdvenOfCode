package tn.esprit.twenty_one.week_one.day_five;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class DayFivePuzzleOne {
    static int occurences = 0;
    static final List<Integer[]> xs = new ArrayList<>();
    static final List<Integer[]> ys = new ArrayList<>();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(PathToFile.pathToBufferReader("dayFive"))) {
            String line;
            int size = 0;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] xyxy = line.split(" -> ");
                    String[] xy1 = xyxy[0].split(",");
                    String[] xy2 = xyxy[1].split(",");
                    xs.add(new Integer[] { Integer.parseInt(xy1[0]) , Integer.parseInt(xy2[0]) });
                    ys.add(new Integer[] { Integer.parseInt(xy1[1]) , Integer.parseInt(xy2[1]) });
                    size = Math.max(size,Math.max(Math.max(Integer.parseInt(xy1[0]),Integer.parseInt(xy1[1])),Math.max(Integer.parseInt(xy2[0]),Integer.parseInt(xy2[1]))));
                }
            }
            Integer[][] map = new Integer[size + 1][size+1];
            for (Integer[] integers : map) {
                Arrays.fill(integers, 0);
            }
            for (int i = 0; i < xs.size(); i++) {
                paintMap(map, xs.get(i), ys.get(i), 'X');
                paintMap(map, ys.get(i), xs.get(i),'Y');
            }
            debug(map);
            System.out.println(occurences);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void paintMap(Integer[][] map, Integer[] xTuple, Integer[] yTuple, char coord) {
        if (Objects.equals(xTuple[0], xTuple[1]) && !Objects.equals(yTuple[0], yTuple[1]))
            for (int i = Math.min(yTuple[0], yTuple[1]); i < Math.max(yTuple[0], yTuple[1]) + 1; i++)
                switch (coord) {
                    case 'X' -> {
                        map[i][xTuple[0]] += 1;
                        if (map[i][xTuple[0]] == 2)
                            occurences++;
                    }
                    case 'Y' -> {
                        map[xTuple[0]][i] += 1;
                        if (map[xTuple[0]][i] == 2)
                            occurences++;
                    }
                }
    }
    public static void debug(Integer[][] map){
        for (Integer[] integers : map) {
            for (Integer integer : integers) {
                if (integer == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(integer);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
