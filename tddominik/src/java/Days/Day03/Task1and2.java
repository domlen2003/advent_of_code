package tddominik.src.java.Days.Day03;

import tddominik.src.java.utils.TxtReader;

import java.io.File;
import java.util.Arrays;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day03/input.txt");
	private static final char treeSymbol='#';

	public static void main(String[] args)
	{

		String[] input = TxtReader.readfile(inputFile);
		for(String line:input)
		{
			System.out.println(line);
		}

		System.out.println("Part 1: " + countTreesHit(input,3,1)+" trees hit");
		int[] hits = {
				countTreesHit(input, 1, 1),
				countTreesHit(input, 3, 1),
				countTreesHit(input, 5, 1),
				countTreesHit(input, 7, 1),
				countTreesHit(input, 1, 2),
		};
		long result = 1;
		for (int hit : hits) result *= hit;

		System.out.println("Part 2: " + Arrays.toString(hits)+" multiplied "+result);
	}

	private static int countTreesHit(String[] input, int moveRight, int moveDown) {
		int length = input[0].length();

		int treesHit=0;
		for(int i=0;i<input.length/moveDown;i++) {
			if(input[i * moveDown].charAt((i * moveRight) % length)==treeSymbol) treesHit++;
		}
	return treesHit;
	}

}
