package tddominik.src.java.Days.Day05;

import tddominik.src.java.utils.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day05/input.txt");

	public static void main(String[] args) {
		ArrayList<Integer>IDList = makeIDList(TxtReader.readfile(inputFile));
		System.out.println("Part 1: maxID = "+ Part1(IDList));
		System.out.println("Part 2: ID = "+ Part2(IDList));

	}

	private static int Part1(ArrayList<Integer> IDs)
	{
		return Collections.max(IDs);
	}

	private static int Part2(ArrayList<Integer> IDs)
	{
		Collections.sort(IDs);
		for(int i = 0; i<IDs.size()-1;i++)
		{
			if(IDs.get(i+1)-IDs.get(i)==2) return IDs.get(i)+1;
		}
		return -1;
	}

	private static ArrayList<Integer> makeIDList(String[] input) {
		ArrayList<Integer> IDs = new ArrayList<>();

		for(String boardingPass: input)
		{
			String frontBack = boardingPass.substring(0,7);
			String leftRight  = boardingPass.substring(7,10);

			boolean[] lowFB = new boolean[7];
			for(int i=0; i<frontBack.toCharArray().length; i++) {
				if (frontBack.toCharArray()[i] == 'F') lowFB[i]=true;
				if (frontBack.toCharArray()[i] == 'B') lowFB[i]=false;
			}

			boolean[] lowLR = new boolean[3];
			for(int i=0; i<leftRight.toCharArray().length; i++) {
				if (leftRight.toCharArray()[i] == 'L') lowLR[i]=true;
				if (leftRight.toCharArray()[i] == 'R') lowLR[i]=false;
			}

			int row = searchSeat(0,127, lowFB,0);
			int column = searchSeat(0,7, lowLR,0);
			IDs.add(row*8+column);
		}
		return IDs;
	}

	private static int searchSeat(int lowBorder, int highBorder, boolean[] low, int i)
	{
		if(i<low.length)
		{
			if(low[i]) return searchSeat(lowBorder, (highBorder-lowBorder)/2+lowBorder, low,i+1);
			if(!low[i]) return searchSeat((highBorder-lowBorder)/2+lowBorder+1, highBorder, low,i+1);
		}
		return lowBorder;
	}

}
