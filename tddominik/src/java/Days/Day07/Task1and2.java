package tddominik.src.java.Days.Day07;

import tddominik.src.java.utils.TxtReader;

import java.io.File;

import java.util.*;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day07/input.txt");

	public static void main(String[] args) {
		String[] input = TxtReader.readfile(inputFile);
		System.out.println("Part1: " + Part1(input));
		System.out.println("Part2: " + Part2(input));
	}

	private static int Part1(String[] input) {
		Set<String> linkedHashSet = new LinkedHashSet<>();
		System.out.println(input.length);
		for (String rule : input) {
			if (rule.contains("shiny gold") && !(rule.split(" ")[0] + " " + rule.split(" ")[1]).equals("shiny gold")) {
				linkedHashSet.add(rule.split(" ")[0] + " " + rule.split(" ")[1]);
			}
		}
		boolean oneNew = true;
		while (oneNew) {
			oneNew = false;
			ArrayList<String> temp = new ArrayList<>();
			for (String bag : linkedHashSet) {
				for (String rule : input) {
					if (rule.contains(bag)) temp.add(rule.split(" ")[0] + " " + rule.split(" ")[1]);
				}
			}
			int previous = linkedHashSet.size();
			linkedHashSet.addAll(temp);
			if (previous < linkedHashSet.size()) oneNew = true;
		}
		return linkedHashSet.size();
	}

	private static int Part2(String[] input) {
		int i = 0;
		String[] shinyGoldRule = null;
		for (String rule : input) {
			if ((rule.split(" ")[0] + " " + rule.split(" ")[1]).equals("shiny gold")) {
				shinyGoldRule = Arrays.copyOfRange(rule.split(" "), 4, rule.split(" ").length);
			}
		}
		System.out.println(Arrays.toString(shinyGoldRule));
		for (int k = 0; k < Objects.requireNonNull(shinyGoldRule).length / 4; k++) {
			i += countNested(shinyGoldRule[(k * 4 + 1)] + " " + shinyGoldRule[(k * 4 + 2)], Integer.parseInt(shinyGoldRule[k * 4]), input);
		}
		return i;
	}

	private static int countNested(String bag, int amount,String[] input) {
		int i = amount;
		for (String rule : input) {
			if((rule.split(" ")[0] + " " + rule.split(" ")[1]).equals(bag)) {
				System.out.println(rule);
				String[] nextRule = Arrays.copyOfRange(rule.split(" "), 4, rule.split(" ").length);
				if(nextRule.length<4) return amount;
				for (int k = 0; k < Objects.requireNonNull(nextRule).length / 4; k++) {
					i += amount*countNested(nextRule[(k * 4 + 1)] + " " + nextRule[(k * 4 + 2)],  Integer.parseInt(nextRule[k*4]),input);
				}
			}
		}
		return i;
	}
}