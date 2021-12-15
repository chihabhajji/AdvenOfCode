package tn.esprit.twenty_one.week_two;

import tn.esprit.helpers.PathToFile;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class DayFifteen {
    public static void main(String[] args) {
        String line;
        try (var br = PathToFile.pathToBufferReader("dayFifteen")) {
            Integer[][] map = new Integer[10][10];
            int i = 0;
            while ((line = br.readLine()) != null) {
                var densities = line.toCharArray();
                for (int j = 0; j < densities.length; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(densities[j]));
                }
                i++;
            }
            var res = doRecursion(map, new ArrayList<>(), 0, 0, 0,true);
            debug(map, res.getValue());
            System.out.println(res.getKey());
        } catch (IOException e) {
            System.out.println("Dum dum");
        }
    }

    static Map.Entry<Long, List<Point>> doRecursion(Integer[][] map, List<Point> trajectory, int i, int j, long weight, boolean aux) {
        if(i != 0 && j != 0 && aux){
            weight += map[i][j];
        }
        if(aux)
            trajectory.add(new Point(i, j));
        if (i == map.length - 1 && j == map[0].length - 1) {
            return new AbstractMap.SimpleEntry<>(weight, trajectory);
        } else{
            if(i == map.length - 1){
                return doRecursion(map, trajectory, i , j + 1, weight,true);
            } else if( j == map[0].length - 1){
                return doRecursion(map, trajectory, i + 1 , j, weight, true);
            } else {
                if (map[i + 1][j] < map[i][j + 1]) {
                    return doRecursion(map, trajectory, i + 1, j, weight, true);
                } else if (map[i][j + 1] < map[i + 1][j]) {
                    return doRecursion(map, trajectory, i, j + 1, weight, true);
                } else {
                    // TODO : idk anymore !! HELP
                    if(doRecursion(map, trajectory, i + 1, j, weight,false).getKey() < doRecursion(map, trajectory, i, j + 1, weight, false).getKey()){
                        return doRecursion(map,trajectory,i + 1 ,j,weight,true);
                    } else {
                        return doRecursion(map,trajectory,i,j  +1,weight, true);
                    }
                }
            }
        }
    }

    static void debug(Integer[][] map, List<Point> trajectory) {
        for (var point : trajectory) {
            map[point.x][point.y] = -1;
        }
        for (var line : map) {
            System.out.println(Arrays.toString(line));
        }
    }
}
