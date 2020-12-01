package java.src.Day01;

import java.util.ArrayList;

public class Task1and2 {

	ArrayList<Integer> intNumbers = new ArrayList<>();

	public static void main(String[] args) {
		new Task1and2 ().start(args);
	}

	public void start(String[] args)
	{
		for (String numbers : args) {
			intNumbers.add(Integer.parseInt(numbers));
		}
		System.out.println("Part 1: " + part1());
		System.out.println("Part 2: " + part2());
	}

	public int part1()
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

	public int part2()
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
