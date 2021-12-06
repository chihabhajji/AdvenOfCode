package tn.esprit.twenty_one.week_one.day_four;

import tn.esprit.helpers.PathToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DayFourPuzzleTwo {
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
            // TODO :
            int winningBoardsCount = 0;
            // board.size() / 25
            while (wordCounter < numbers.size()) {
                if (!numbers.get(wordCounter).equals(0)) {
                    if (Collections.replaceAll(board, numbers.get(wordCounter), 0)) {
                        int blocks = 0;
                        boolean winningBlock = true;
                        while (blocks < board.size() && winningBlock) {
                            int i = 0;
                            boolean poop = false;
                            while (i < 25 && !poop) {
                                poop = board.subList(blocks + i, blocks + i + 5).stream().allMatch(integer -> integer == 0);
                                i += 5;
                            }
                            winningBlock = poop || isBingoHorizontal(blocks);
                            if (winningBlock) {
                                winningBoardsCount++;
                                if(board.size() / 25  == winningBoardsCount){
                                    hurray(blocks, board, numbers.get(wordCounter));
                                }

                            }
                            blocks += 25;
                        }
                    }
                }

                wordCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void hurray(int blocks, List<Integer> board, Integer multiplier) {
        board.subList(blocks, blocks + 25).stream().reduce(Integer::sum).ifPresent(a -> {
            debug(board);
            System.out.println(a * multiplier);
        });
    }

    static boolean isBingoHorizontal(int blocks) {
        boolean bingo = false;
        int rows = 0;
        while (rows < 5 && !bingo) {
            int columns = 0;
            while (columns < 5 && !bingo) {
                List<Integer> lines = new ArrayList<>();
                for (int l = 0; l < 5; l++) {
                    lines.add(board.get(blocks + rows + columns + l * 5));
                }
                bingo = lines.stream().allMatch(p -> p.equals(0));
                columns += 5;
            }
            rows++;
        }
        return bingo;
    }

    static void debug(List<Integer> poop) {
        int i = 0;
        while (i < poop.size()) {
            System.out.println(poop.subList(i, i + 5));
            i += 5;
        }
        System.out.println("____________________");
    }
}
