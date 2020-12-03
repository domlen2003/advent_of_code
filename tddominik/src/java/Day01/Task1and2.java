package tddominik.src.java.Day01;

import tddominik.src.java.utils.TxtReader;

import java.io.File;
import java.util.ArrayList;

public class Task1and2 {
	private static final File inputFile = new File("tddominik/src/java/Day01/input.txt");
	private static ArrayList<Integer> intNumbers = new ArrayList<>();

	public static void main(String[] args) {
		String[] input = TxtReader.readfile(inputFile);
		for (String numbers : input) {
			intNumbers.add(Integer.parseInt(numbers));
		}
		System.out.println("Part 1: " + part1());
		System.out.println("Part 2: " + part2());
	}

	private static int part1()
	{
		int match1=0;
		int match2=0;

		for(int i=0;i<intNumbers.size();i++) {
			for(int j=0;j<intNumbers.size();j++) {
				if(!(i==j)){
					if((intNumbers.get(i)+intNumbers.get(j)==2020)) {
						match1=intNumbers.get(i);
						match2=intNumbers.get(j);
					}
				}
			}
		}
		return(match1*match2);
	}

	private static int part2()
	{
		int match1=0;
		int match2=0;
		int match3=0;

		for(int i=0;i<intNumbers.size();i++) {
			for(int j=0;j<intNumbers.size();j++) {
				for(int k=0;k<intNumbers.size();k++) {
					if ((!(i == j))&&(!(i==k))&&(!(j==k))) {
						if ((intNumbers.get(i) + intNumbers.get(j) + intNumbers.get(k) == 2020)) {
							match1 = intNumbers.get(i);
							match2 = intNumbers.get(j);
							match3 = intNumbers.get(k);
						}
					}
				}
			}
		}
		return(match1*match2*match3);
	}
}
