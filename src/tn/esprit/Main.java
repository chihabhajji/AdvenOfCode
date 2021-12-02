package tn.esprit;

import tn.esprit.twentyOne.dayOne.DayOnePuzzleOne;
import tn.esprit.twentyOne.dayOne.DayOnePuzzleTwo;
import tn.esprit.twentyOne.dayThree.DayThreePuzzleOne;
import tn.esprit.twentyOne.dayThree.DayThreePuzzleTwo;
import tn.esprit.twentyOne.dayTwo.DayTwoPuzzleOne;
import tn.esprit.twentyOne.dayTwo.DayTwoPuzzleTwo;

import java.util.Scanner;

public class Main {
    public static final Exception unhandled = new IllegalStateException("Unexpected value !");
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        byte day;
        do {
            System.out.println("Input day");
            day = sc.nextByte();
        } while (day <= 0 || day >= 30);
        byte puzzle;
        do {
            System.out.println("Input puzzle");
            puzzle = sc.nextByte();
        }while (puzzle != 1 && puzzle != 2);
        sc.close();
        switch (day) {
            case 1 -> {
                switch (puzzle) {
                    case 1 -> DayOnePuzzleOne.main(null);
                    case 2 -> DayOnePuzzleTwo.main(null);
                    default -> throw unhandled;
                }
            }
            case 2 -> {
                switch (puzzle) {
                    case 1 -> DayTwoPuzzleOne.main(null);
                    case 2 -> DayTwoPuzzleTwo.main(null);
                    default -> throw unhandled;
                }
            }
            case 3 -> {
                switch (puzzle) {
                    case 1 -> DayThreePuzzleOne.main(null);
                    case 2 -> DayThreePuzzleTwo.main(null);
                    default -> throw unhandled;
                }
            }
            case 4 -> {
                switch (puzzle) {
                    case 1, 2 -> System.err.println("We're still in day 3");
                    default -> throw unhandled;
                }
            }
            default -> System.out.println("Huh, YOU WOT M8 ?!");
        }
    }
}
