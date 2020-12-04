package tddominik.src.java.Days.Day02;

import tddominik.src.java.utils.TxtReader;

import java.io.File;

public class Task1and2
{
    private static final File inputFile = new File("tddominik/src/java/Days/Day02/input.txt");

    public static void main(String[] args)
    {
        String[] input = TxtReader.readfile(inputFile);
        System.out.println("Part1: "+find(input,1)+" right passwords found");
        System.out.println("Part2: "+find(input,2)+" right passwords found");
    }

    private static int find(String[] args, int method)
    {
        int rightPws = 0;
        for(String Line:args)
        {
            String[] seperatePassword= Line.split(": ");
            String[] seperateChar = seperatePassword[0].split(" ");
            String[] numbers = seperateChar[0].split("-");

            int number1 = Integer.parseInt(String.valueOf(numbers[0]));
            int number2 = Integer.parseInt(String.valueOf(numbers[1]));
            String password = seperatePassword[1];
            char searchChar = seperateChar[1].toCharArray()[0];

            if(method==1) {
                if (checkPassword(searchChar, password,number1,number2)) rightPws++;
            }
            else {
                if(checkPasswordPart2(searchChar,password,number1,number2)) rightPws++;
            }
        }
        return rightPws;
    }

    private static boolean checkPassword(char searchChar, String password,int from,int to)
    {
        int occurrences = countOccurences(password,searchChar,0);
        return from <= occurrences && occurrences <= to;
    }

    private static boolean checkPasswordPart2(char searchChar , String password,int pointer1,int pointer2)
    {
        char[] passwordChars = password.toCharArray();

        boolean first;
        boolean second;
        first = passwordChars[pointer1 - 1] == searchChar;
        second = passwordChars[pointer2 - 1] == searchChar;

        return first != second;
    }

    private static int countOccurences(String inputString, char searchedChar, int index)
    {
        if (index >= inputString.length()) {
            return 0;
        }

        int count = inputString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurences(inputString, searchedChar, index + 1);
    }
}
