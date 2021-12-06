package tn.esprit.twenty_one.week_one.day_five;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class DayFivePuzzleTwo {
    static final ArrayList<Integer[]> xs = new ArrayList<>();
    static final ArrayList<Integer[]> ys = new ArrayList<>();
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
            Integer[][] map = new Integer[size +1][size +1];
            System.out.println(map.length);
            for (Integer[] integers : map) {
                Arrays.fill(integers, 0);
            }
            for (int i = 0; i < xs.size() ; i++) {
                if(Objects.equals(xs.get(i)[0], xs.get(i)[1])){
                    for (int j = Math.min(ys.get(i)[0], ys.get(i)[1]); j < (Math.max(ys.get(i)[0], ys.get(i)[1])+1); j++) {
                        map[xs.get(i)[1]][j] += 1;
                    }
                }
                else if(Objects.equals(ys.get(i)[0], ys.get(i)[1])){
                    for (int j = Math.min(xs.get(i)[0], xs.get(i)[1]); j < (Math.max(xs.get(i)[0], xs.get(i)[1])+1); j++) {
                        map[j][ys.get(i)[1]] += 1;
                    }
                }
                else{
                    if (xs.get(i)[0] < xs.get(i)[1] && ys.get(i)[0] < ys.get(i)[1]) {
                        int k = ys.get(i)[0];
                        for (int j = xs.get(i)[0]; j < (xs.get(i)[1]+1); j++){
                            map[j][k] += 1;
                            k++;
                        }
                    }
                    else if (xs.get(i)[0] > xs.get(i)[1] && ys.get(i)[0] > ys.get(i)[1]) {
                        int k = ys.get(i)[0];
                        for (int j = xs.get(i)[0]; j > (xs.get(i)[1]-1); j--){
                            map[j][k] += 1;
                            k--;
                        }
                    }
                    else if (xs.get(i)[0] > xs.get(i)[1] && ys.get(i)[0] < ys.get(i)[1]) {
                        int k = ys.get(i)[0];
                        for (int j = xs.get(i)[0]; j > (xs.get(i)[1]-1); j--){
                            map[j][k] += 1;
                            k++;
                        }
                    }
                    else if (xs.get(i)[0] < xs.get(i)[1] && ys.get(i)[0] > ys.get(i)[1]) {
                        int k = ys.get(i)[0];
                        for (int j = xs.get(i)[0]; j < (xs.get(i)[1]+1); j++){
                            map[j][k] += 1;
                            k--;
                        }
                    }
                }
            }
            int counter = 0;
            for (Integer[] integers : map) {
                for (int j = 0; j < map.length; j++) {
                    if (integers[j] >= 2) {
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
