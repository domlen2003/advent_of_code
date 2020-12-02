package tddominik.src.java.Day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1and2
{
    public static void main(String[] args) 
    {

       System.out.println("Part1: "+find(args,1)+" right passwords found");
       System.out.println("Part2: "+find(args,2)+" right passwords found");
    }

    public static int find(String[] args, int method)
    {
        int rightPws = 0;
        for(int i=0; i< args.length/3; i++)
        {
            int start = i*3;
            int end = start+3;
            String[] part = Arrays.copyOfRange(args,start,end);
            ArrayList<String> numbers = new ArrayList<>();

            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(part[0]);
            while (m.find()) {
                numbers.add(m.group());
            }

            char searchChar = part[1].charAt(0);
            int number1 = Integer.parseInt(String.valueOf(numbers.get(0)));
            int number2 = Integer.parseInt(String.valueOf(numbers.get(1)));

            if(method==1) {
                if (checkPassword(searchChar, part[2],number1,number2)) rightPws++;
            }
            else {
                if(checkPasswordPart2(searchChar,part[2],number1,number2)) rightPws++;
            }
        }
        return rightPws;
    }

    public static boolean checkPassword(char searchChar, String password,int from,int to)
    {
        int occurrences = countOccurences(password,searchChar,0);
        return from <= occurrences && occurrences <= to;
    }

    public static boolean checkPasswordPart2(char searchChar , String password,int pointer1,int pointer2)
    {
        char[] passwordChars = password.toCharArray();

        boolean first;
        boolean second;
        first = passwordChars[pointer1 - 1] == searchChar;
        second = passwordChars[pointer2 - 1] == searchChar;

        return first != second;
    }

    private static int countOccurences(String someString, char searchedChar, int index)
    {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurences(someString, searchedChar, index + 1);
    }
}
