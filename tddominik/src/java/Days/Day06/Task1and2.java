package tddominik.src.java.Days.Day06;

import tddominik.src.java.utils.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day06/input.txt");

	public static void main(String[] args) {
		ArrayList<String[]> input= parseAnswerData(TxtReader.readfile(inputFile));
		System.out.println("Part 1: sum of Yes = "+ Part1(input));
		System.out.println("Part 2: sum of united Yes = "+ Part2(input));
	}

	private static int Part1(ArrayList<String[]> input)
	{
		int i = 0;
		for(String[] groupAnswer:input)
		{
			List<Character> chars = new ArrayList<>();
			for(String answer:groupAnswer)
			{
				for(char letter:answer.toCharArray())
				{
					if(chars.contains(letter)) continue;
					chars.add(letter);
					i++;
				}
			}
		}
		return i;
	}

	private static int Part2(ArrayList<String[]> input)
	{
		int i = 0;
		for(String[] groupAnswer:input)
		{
			List<Character> chars = new ArrayList<>();
			for(String answer:groupAnswer) {
				for(char letter:answer.toCharArray()) {
					if(chars.contains(letter)) continue;
					chars.add(letter);
				}
			}
			for(Character matchChar:chars) {
				boolean allMatch = true;
				for(String answer:groupAnswer) {
					if (!answer.contains(matchChar.toString())) {
						allMatch = false;
						break;
					}
				}
				if(allMatch)i++;
			}
		}
		return i;
	}

	private static ArrayList<String[]> parseAnswerData(String[] input) {
		StringBuilder threshold = new StringBuilder();
		ArrayList<String> groupStrings = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (input[i].length() < 1) {
				groupStrings.add(threshold.toString());
				threshold = new StringBuilder();
			} else if (i == input.length - 1) {
				threshold.append("-").append(input[i]);
				groupStrings.add(threshold.toString());
			} else threshold.append("-").append(input[i]);
		}
		ArrayList<String[]> answers = new ArrayList<>();
		for(String group:groupStrings)
		{
			answers.add(group.substring(1).split("-"));
		}
		return answers;
	}
}