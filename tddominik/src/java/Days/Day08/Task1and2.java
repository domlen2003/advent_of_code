package tddominik.src.java.Days.Day08;

import tddominik.src.java.utils.TxtReader;

import java.io.File;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day08/input.txt");

	public static void main(String[] args) {
		String[] input = TxtReader.readfile(inputFile);
		System.out.println("Part1: " + Part1(input));
		System.out.println("Part2: " + Part2(input));
	}

	private static int Part1(String[] input) {
		int result = 0;

		boolean[] beenHere = new boolean[input.length];
		int counter = 0;
		while(!beenHere[counter])
		{
			beenHere[counter]=true;
			String cmd = input[counter].substring(0,3);
			switch (cmd) {
				case "nop" -> counter++;
				case "acc" -> {
				result += Integer.parseInt(input[counter].substring(4));
				counter++;
				}
				case "jmp" -> counter+= Integer.parseInt(input[counter].substring(4));
			}
		}
		return result;
	}

	private static int Part2(String[] input) {
		for(int i=0;i<input.length; i++)
		{
			String cmd = input[i].substring(0,3);
			String[] changedInput = new String[input.length];
			System.arraycopy(input,0,changedInput,0,input.length);
			switch (cmd) {
				case "nop" -> changedInput[i]="jmp"+changedInput[i].substring(3);
				case "jmp" -> changedInput[i]="nop"+changedInput[i].substring(3);
			}

			int result = 0;
			boolean[] beenHere = new boolean[input.length];
			int counter = 0;
			while(counter<input.length&&!beenHere[counter])
			{
				beenHere[counter]=true;
				String line = changedInput[counter].substring(0,3);
				switch (line) {
					case "nop" -> counter++;
					case "acc" -> {
						result += Integer.parseInt(changedInput[counter].substring(4));
						counter++;
					}
					case "jmp" -> counter+= Integer.parseInt(changedInput[counter].substring(4));
				}
			}
			if(counter==input.length) return result;
		}
		return -1;
	}
}