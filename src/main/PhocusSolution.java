package main;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class PhocusSolution. Finds the answers for the corresponding phocus questions.
 */
public class PhocusSolution {
	
	/**
	 * Strips raw file line into an array containing useful attributes.
	 *
	 * @param fileLine The raw file line.
	 * @return currentLine The array containing useful attributes.
	 */
	public static String[] stripToArray(String fileLine) {
		String[] currentLine;
		fileLine = fileLine.replace("{","");
		fileLine = fileLine.replace("}", "");
		fileLine = fileLine.replaceAll("\"", "");
		currentLine = fileLine.split("[:,]");
		return currentLine;
	}

	/**
	 * Find oldest.
	 *
	 * @param file Data set file.
	 * @return oldestPerson Oldest person in data set.
	 * @throws FileNotFoundException the file not found exception.
	 */
	public static String findOldest(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		Integer oldestAge = -1; 
		String oldestPerson = ""; 
		String[] currentLine;
		while (scan.hasNextLine()) {
			currentLine = stripToArray(scan.nextLine());
			if (Integer.valueOf(currentLine[7]) > oldestAge) {
				oldestAge = Integer.valueOf(currentLine[7]);
				oldestPerson = currentLine[1]+" "+currentLine[3];
			}
		}
		return oldestPerson;
	}
	
	/**
	 * Finds the average age of the data set.
	 *
	 * @param file Data set file
	 * @return averageAge Average age of data set.
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Integer findAverageAge(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		Integer averageAge = 0;
		Integer sumOfAges = 0;
		Integer numPeople = 0;
		String[] currentLine;
		while (scan.hasNextLine()) {
			numPeople++;
			currentLine = stripToArray(scan.nextLine());
			sumOfAges = sumOfAges + Integer.valueOf(currentLine[7]);
		}
		if (numPeople > 0) {
			averageAge = sumOfAges / numPeople;
		}
		return averageAge;
	}

	/**
	 * Finds the youngest person from each country in each data set.
	 *
	 * @param file Data set file
	 * @return countryPersonMap Map of country to youngest person in country
	 * @throws FileNotFoundException the file not found exception
	 */
	public static HashMap<String, String> findYoungest(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		String[] currentLine;
		HashMap<String, Integer> countryAgeMap = new HashMap<String, Integer>();
		HashMap<String, String> countryPersonMap = new HashMap<String, String>();
		while (scan.hasNextLine()) {
			currentLine = stripToArray(scan.nextLine());
			
			if (countryAgeMap.containsKey(currentLine[5])) {
				if (Integer.valueOf(currentLine[7]) < countryAgeMap.get(currentLine[5])) {
					countryAgeMap.put(currentLine[5],Integer.valueOf(currentLine[7]));
					countryPersonMap .put(currentLine[5], currentLine[1]+" "+currentLine[3]);
				}
			} else {
				countryAgeMap.put(currentLine[5], Integer.valueOf(currentLine[7]));
				countryPersonMap.put(currentLine[5], currentLine[1]+" "+currentLine[3]);
			}
		}
		return countryPersonMap;
	}
	
	/**
	 * Find average age of each country in the data set.
	 *
	 * @param file Data set file.
	 * @return countryAveMap Map of country to its average age.
	 * @throws FileNotFoundException the file not found exception.
	 */
	public static HashMap<String, Integer> findAverages(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		String[] currentLine;
		HashMap<String, Integer> countryAgeMap = new HashMap<String, Integer>();
		HashMap<String, Integer> countryNumMap = new HashMap<String, Integer>();
		HashMap<String, Integer> countryAveMap = new HashMap<String, Integer>();
 		while (scan.hasNextLine()) {
			currentLine = stripToArray(scan.nextLine());
			
			if (countryAgeMap.containsKey(currentLine[5])) {
				countryAgeMap.put(currentLine[5], Integer.valueOf(currentLine[7])+countryAgeMap.get(currentLine[5]));
				countryNumMap.put(currentLine[5], countryNumMap.get(currentLine[5]) + 1);
			} else {
				countryAgeMap.put(currentLine[5], Integer.valueOf(currentLine[7]));
				countryNumMap.put(currentLine[5], 1);
			}
		}
		
		for (HashMap.Entry<String, Integer> entry : countryAgeMap.entrySet()) {
			Integer totalAge = entry.getValue();
			String country = entry.getKey();
			Integer average = totalAge / countryNumMap.get(country);
			countryAveMap.put(country, average);
		}
		return countryAveMap;
	}
	
	/**
	 * Finds age range of New Zealand in the data set.
	 *
	 * @param file Data set file.
	 * @return countArray Array of number of people in each age range.
	 * @throws FileNotFoundException the file not found exception.
	 */
	public static int[] findAgeRange(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		String[] currentLine;
		int[] countArray = new int[13];
		while (scan.hasNextLine()) {
			currentLine = stripToArray(scan.nextLine());
			
			if (currentLine[5].equals("New Zealand") && Integer.valueOf(currentLine[7]) >= 0) {
				Integer ageRange = Integer.valueOf(currentLine[7]) / 10; 
				countArray[ageRange] = countArray[ageRange] + 1;
			}
		}
		return countArray;
	}
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\data.ndjson");
		PrintSolutions printSolutions = new PrintSolutions();
		

		printSolutions.printAverageAge(findAverageAge(file));
		printSolutions.printOldest(findOldest(file));
		printSolutions.printYoungest(findYoungest(file));
		printSolutions.printAverageAges(findAverages(file));
		printSolutions.printAgeRange(findAgeRange(file));
	}
}
