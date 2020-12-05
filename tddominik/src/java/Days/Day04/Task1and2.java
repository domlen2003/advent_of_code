package tddominik.src.java.Days.Day04;

import tddominik.src.java.utils.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1and2 {

	private static final File inputFile = new File("tddominik/src/java/Days/Day04/input.txt");
	private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");
	public static void main(String[] args)
	{
		ArrayList<passportData> parsedData = parsePassportData(TxtReader.readfile(inputFile));
		System.out.println("Part 1: "+ Part1(parsedData));
		System.out.println("Part 2: "+ Part2(parsedData));
	}

	private static int Part1(ArrayList<passportData> parsedData) {
		int i=0;
		for(passportData data:parsedData)
		{
			if(data.byr!=null && data.iyr!=null && data.eyr!=null && data.hgt!=null && data.hcl!=null && data.ecl!=null && data.pid!=null) i++;
		}
		return i;
	}
	private static int Part2(ArrayList<passportData> parsedData) {
		int i=0;
		for(passportData data:parsedData)
		{
			if(!(data.byr!=null && data.iyr!=null && data.eyr!=null && data.hgt!=null && data.hcl!=null && data.ecl!=null && data.pid!=null)) continue;

			final int byr = Integer.parseInt(data.byr);
			final int iyr = Integer.parseInt(data.iyr);
			final int eyr = Integer.parseInt(data.eyr);

			if(!(byr >= 1920 && byr <= 2002))continue; //byr
			if(!(iyr >= 2010 && iyr <= 2020))continue; //iyr
			if(!(eyr >= 2020&& eyr <= 2030 ))continue; //eyr

			String unit= data.hgt.replaceAll("[^A-Za-z]", "");
			int height= Integer.parseInt(data.hgt.replaceAll("[^0-9]", ""));
			if(unit.length()<1)continue;

			if(!((unit.equalsIgnoreCase("cm")&&height>=150&&height<=193)||(unit.equalsIgnoreCase("in")&&height>=59&&height<=76))) continue; //hgt
			if(!(data.hcl.charAt(0)=='#'&&isHexadecimal(data.hcl.substring(1)))) continue; //hcl
			if(!(data.ecl.equals("amb") || data.ecl.equals("blu") || data.ecl.equals("brn") || data.ecl.equals("gry") || data.ecl.equals("grn") || data.ecl.equals("hzl") || data.ecl.equals("oth"))) continue; //ecl
			if(!(data.pid.length()==9)) continue; //pid
			i++;
		}
		return i;
	}

	private static ArrayList<passportData> parsePassportData(String[] input)
	{
		StringBuilder threshold= new StringBuilder();
		ArrayList<String> passportStrings = new ArrayList<>();
		for(int i=0; i<input.length; i++) {
			if(input[i].length()<1) {
				passportStrings.add(threshold.toString());
				threshold = new StringBuilder();
			}
			else if(i==input.length-1) {
				threshold.append(" ").append(input[i]);
				passportStrings.add(threshold.toString());
			}
			else threshold.append(" ").append(input[i]);
		}
		ArrayList<passportData>passports = new ArrayList<>();
		for(String passport:passportStrings) {
			String[] fields = passport.split("\\s+");
			String byr=null,iyr=null,eyr=null,hgt=null,hcl=null,ecl=null,pid=null;
			for(String field:fields) {
				String[] keyAndValue = field.split(":");
				switch (keyAndValue[0]) {
					case "byr" -> byr=keyAndValue[1];
					case "iyr" -> iyr=keyAndValue[1];
					case "eyr" -> eyr=keyAndValue[1];
					case "hgt" -> hgt=keyAndValue[1];
					case "hcl" -> hcl=keyAndValue[1];
					case "ecl" -> ecl=keyAndValue[1];
					case "pid" -> pid=keyAndValue[1];
				}
			}
			passports.add(new passportData(byr,iyr,eyr,hgt,hcl,ecl,pid));
		}
		return passports;
	}

	private static boolean isHexadecimal(String input) {
		final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
		return matcher.matches();
	}

	private static class passportData
	{
		public final String byr,iyr,eyr,hgt,hcl,ecl,pid;
		passportData(String byr,String iyr,String eyr,String hgt,String hcl,String ecl,String pid){
			this.byr=byr;
			this.iyr=iyr;
			this.eyr=eyr;
			this.hgt=hgt;
			this.hcl=hcl;
			this.ecl=ecl;
			this.pid=pid;
		}

		@Override
		public String toString() {
			return "passportData{" +
					"byr='" + byr + '\'' +
					", iyr='" + iyr + '\'' +
					", eyr='" + eyr + '\'' +
					", hgt='" + hgt + '\'' +
					", hcl='" + hcl + '\'' +
					", ecl='" + ecl + '\'' +
					", pid='" + pid + '\'' +
					'}';
		}
	}


}
