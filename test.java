package CodinAdvent;

import java.util.ArrayList;

public class CodingAdvent1 {

	ArrayList<Integer> intNumbers = new ArrayList<>();

	public static void main(String[] args) {
		new CodingAdvent1().start(args);
	}

	public void start(String[] args)
	{
  
		for (String numbers : args) {
			intNumbers.add(Integer.parseInt(numbers));
		}
		findMatch();
	}

	public void findMatch()
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
		System.out.println(match1+"|"+match2);
		System.out.print(match1*match2);
	}
}
