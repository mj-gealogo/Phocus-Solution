package main;

import java.util.HashMap;

/**
 * The Class PrintSolutions. Prints the corresponding Phocus Solutions.
 */
public class PrintSolutions {
	
	/**
	 * Prints the average age of the data set.
	 *
	 * @param averageAge The average age in the data set.
	 */
	public static void printAverageAge(Integer averageAge) {
		System.out.println("Average age of people: "+averageAge+"\n");
	}
	
	/**
	 * Prints the oldest person's first and last name in the data set.
	 *
	 * @param oldestPerson The oldest person in the data set.
	 */
	public static void printOldest(String oldestPerson) {
		System.out.println("Oldest person: "+oldestPerson+"\n");
	}
	
	/**
	 * Prints the average ages of each country in the data set.
	 *
	 * @param countryAverages The country average ages in a map form.
	 */
	public static void printAverageAges(HashMap<String, Integer> countryAverages) {
		System.out.println("Average age per country");
		for (HashMap.Entry<String, Integer> entry : countryAverages.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println("\n");
	}
	
	/**
	 * Prints the youngest person's name for each country in the data set.
	 *
	 * @param youngestMap A map where the key is the country
	 * and the value is youngest person. 
	 */
	public static void printYoungest(HashMap<String, String> youngestMap) {
		System.out.println("Youngest Person per country");
		for (HashMap.Entry<String, String> entry : youngestMap.entrySet()) {
			String person = entry.getValue();
			String country = entry.getKey();
			System.out.println(country+" : "+person);
		}
		System.out.println("\n");
	}
	
	/**
	 * Prints the number in each range for the country of New Zealand.
	 *
	 * @param countArray The number of each age range in New Zealand.
	 */
	public static void printAgeRange(int[] countArray) {
		Integer i = 0;
		System.out.println("Number of people in the age range in New Zealand");
		for (Integer count : countArray) {
			System.out.println(i+" <= x < "+(i+10)+" : "+count);
			i = i + 10;
		}
		System.out.println("\n");
	}
	
}
