package tddominik.src.java.utils;

import java.io.*;
import java.util.ArrayList;

public class TxtReader {
	public static String[] readfile(File input)
	{
		ArrayList<String> list = new ArrayList<>();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] args = new String[list.size()];
		args = list.toArray(args);
		return args;
	}
}
