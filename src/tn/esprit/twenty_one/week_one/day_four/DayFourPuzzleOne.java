package tn.esprit.twenty_one.week_one.day_four;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class DayFourPuzzleOne {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(PathToFile.pathToBufferReader("dayFour"))) {
            String line;
            var allInputs = Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).toList();
            var initial = new ArrayList<>(allInputs.subList(0, 4));
            List<Integer> board = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    Arrays.stream(line.split(" ")).toList().stream().filter(s -> !s.isEmpty()).map(Integer::parseInt).map(s -> {
                        if (initial.contains(s))
                            return -1;
                        return s;
                    }).forEach(board::add);
                }
            }
            byte wordCounter = 4;
            boolean bingo = false;
            while (wordCounter < allInputs.size() && !bingo) {
                if(Collections.replaceAll(board, allInputs.get(wordCounter),-1)){
                    int i = 0;
                    while (i < board.size() && !bingo) {
                        System.out.println(board.subList(i,i+5));
                        if(board.subList(i,i+5).stream().allMatch(integer -> integer == -1)){
                            System.out.println("BINGO");
                            System.out.println(wordCounter);
                            bingo = true;
                            break;
                        }
                        for (int j = 0; j < 5; j++) {
                            for (int k = 0; k < 5; k++) {
                                System.out.println();
                            }
                        }
                        i += 5;
                    }

                }
                System.out.println("NEW INPUT");
                wordCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
