package tddominik.src.java.Days.Day09;

import tddominik.src.java.utils.TxtReader;

import java.io.File;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day09/input.txt");

	public static void main(String[] args) {
		String[] input = TxtReader.readfile(inputFile);
		System.out.println("Part1: " + Part1(input));
		System.out.println("Part2: " + Part2(input));
	}

	private static long Part1(String[] input) {
		int preLength=25;
		for(int i = preLength;i<input.length;i++)
		{
			long[] pre = new long[preLength];
			for(int j=i-preLength;j<i;j++)
			{
				pre[j-i+preLength]=Long.parseLong(input[j]);
			}
			boolean oneMatch=false;
			for(Long num1:pre)
			{
				for(Long num2:pre)
				{
					if(num1.equals(num2)) continue;
					if (Long.parseLong(input[i]) == num1 + num2) {
						oneMatch = true;
						break;
					}
				}
			}
			if(!oneMatch) return Long.parseLong(input[i]);
		}

		return -1;
	}

	private static long Part2(String[] input) {
		Long result = Part1(input);
		for(int i=0; i<input.length; i++)
		{
			long smallest=Long.parseLong(input[i]);
			long largest=Long.parseLong(input[i]);

			Long addition = Long.parseLong(input[i]);
			for(int j=i+1;j<input.length;j++)
			{
				if(Long.parseLong(input[j])>largest) largest=Long.parseLong(input[j]);
				if(Long.parseLong(input[j])<smallest) smallest=Long.parseLong(input[j]);

				addition+=Long.parseLong(input[j]);
				if(addition.equals(result)) return smallest+largest;
			}
		}
		return-1;
	}
}