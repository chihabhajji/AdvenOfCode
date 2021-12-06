package tn.esprit.twenty_one.week_one.day_four;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DayFourPuzzleOne {
    static boolean bingo = false;
    static List<Integer> board = new ArrayList<>();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(PathToFile.pathToBufferReader("dayFour"))) {
            String line;
            var numbers = Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).toList();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    Arrays.stream(line.split(" ")).toList().stream().filter(s -> !s.isEmpty()).map(Integer::parseInt).map(s -> {
                        if (numbers.subList(0, 4).contains(s))
                            return 0;
                        return s;
                    }).forEach(board::add);
                }
            }
            byte wordCounter = 4;
            while (wordCounter < numbers.size() && !bingo) {
                if(Collections.replaceAll(board, numbers.get(wordCounter),0)){
                    int blocks = 0;
                    while (blocks < board.size() && !bingo) {
                        bingo = board.subList(blocks, blocks + 5).stream().allMatch(integer -> integer == 0) || isBingoHorizontal(blocks);
                        if(bingo){
                            int number = numbers.get(wordCounter);
                            System.out.println(blocks);
                            board.subList(blocks,blocks + 25).stream().reduce(Integer::sum).ifPresent(integer -> System.out.println(integer * number) );
                        }
                        blocks += 25;
                    }
                }
                wordCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isBingoHorizontal(int blocks) {
        int rows = 0;
        while (rows < 5 && !bingo) {
            int columns = 0;
            while (columns < 5 && !bingo) {
                List<Integer> lines = new ArrayList<>();
                for (int l = 0; l < 5; l++) {
                    lines.add(board.get(blocks + rows + columns + l*5 ));
                }
                bingo = lines.stream().allMatch(p -> p.equals(0));
                columns += 5;
            }
            rows++;
        }
        return bingo;
    }
}
