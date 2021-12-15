package tn.esprit.twenty_one.week_two;

import tn.esprit.helpers.PathToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayTenPuzzleOne {
    public static void main(String[] args) {
        String line;
        List<List<MyCharacter>> state = new ArrayList<>();
        try(var br = PathToFile.pathToBufferReader("dayTen")){
            while ((line = br.readLine()) !=null ){
                var charArray = line.toCharArray();
                List<Character> characters = IntStream.range(0, line.toCharArray().length).mapToObj(i -> charArray[i]).collect(Collectors.toList());
                int i = 0;
                boolean foundError = false;
                while (!characters.isEmpty() && !foundError) {
                    if(characters.contains(reverse(characters.get(i)))){
                        characters.remove(reverse(characters.get(i)));
                        characters.remove(i);
                        System.out.println(characters);
                    }
                    else foundError = true;
                    i++;
                }
                System.out.println(characters);
            }
        } catch (IOException e ){
            System.out.println("Wrong file dummy");
        }
        System.out.println(state);
    }
    static int check(List<MyCharacter> input){
        if(input.isEmpty()) return -1;
        if(input.contains(new MyCharacter(reverse(input.get(0).character)))){
            input.remove(new MyCharacter(reverse(input.get(0).character)));
            input.remove(0);
            return check(input);
        }
        return input.get(0).initialPosition;
    }
    static char reverse(char c){
        switch (c){
            case '<' -> {
                return '>';
            }
            case '{' -> {
                return '}';
            }
            case '(' -> {
                return ')';
            }
            case '[' -> {
                return ']';
            }
            default -> {
                return ' ';
            }
        }
    }
}
class MyCharacter{
    public char character;
    public int initialPosition;
    public MyCharacter(char character, int initialPosition){
        this.character = character;
        this.initialPosition = initialPosition;
    }
    public MyCharacter(char character){
        this.character = character;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCharacter that = (MyCharacter) o;
        return character == that.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return "{ value=" + character + ", initialPosition=" + initialPosition + '}';
    }
}
