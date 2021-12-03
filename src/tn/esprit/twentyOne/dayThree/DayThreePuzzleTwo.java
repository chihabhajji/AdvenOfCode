package tn.esprit.twentyOne.dayThree;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DayThreePuzzleTwo {
    static final StringBuilder oxygen = new StringBuilder();
    static final StringBuilder co2 = new StringBuilder();
    public static void main(String[] args) {
        int zeros = 0;
        int ones = 0;
        String line;
        Set<String> remainingOxygen = new HashSet<>();
        Set<String> remainingCo2 = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PathToFile.convertActual("dayThree.txt")))) {
            while ((line = br.readLine()) != null) {
                if(line.charAt(0) == '0') zeros++; else ones++;
                remainingOxygen.add(line);
                remainingCo2.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object o = checkForRemaining(remainingOxygen, oxygen, 1, zeros, ones,'O');
        Object c = checkForRemaining(remainingCo2, co2, 1, zeros , ones, 'C');
        System.out.println(Long.parseLong(c.toString(), 2) * Long.parseLong(o.toString(), 2));
        // 5852595
    }

    static Object checkForRemaining(Set<String> set, StringBuilder prefixBuilder, int i, long zeros , long ones, char o) {
        if(set.size() == 1){
            return set.toArray()[0];
        } else {
            if(zeros > ones){
                if(o == 'O')
                    prefixBuilder.append("0");
                else
                    prefixBuilder.append("1");
            } else  {
                if(o == 'C')
                    prefixBuilder.append("0");
                else
                    prefixBuilder.append("1");
            }
            set = set.stream().filter(x -> x.startsWith(prefixBuilder.toString())).collect(Collectors.toSet());
            if(i<12){
                zeros = set.stream().filter(s -> s.charAt(i) == '0').count();
                ones = set.stream().filter(s -> s.charAt(i) == '1').count();
            }
            return checkForRemaining(set,prefixBuilder,i+1, zeros, ones,o);
        }
    }

}

