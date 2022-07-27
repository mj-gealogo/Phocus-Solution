package test;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import main.PhocusSolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class PhocusSolutionTest. Tests the methods in the PhocusSolution class.
 */
class PhocusSolutionTest {

	
	/**
	 * Sets up each test. Two file created. Normal input file and an empty test file.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		File normalTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\normalTest.txt");
		File emptyTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\emptyTest.txt");
		try {
			normalTestFile.createNewFile();
			FileWriter normalTestWriter = new FileWriter("normalTest.txt");
			normalTestWriter.write("{firstName:Minne,lastName:Barrow,country:New Zealand,age:0}"+"\n");
			normalTestWriter.write("{firstName:Bob,lastName:Kay,country:New Zealand,age:15}"+"\n");
			normalTestWriter.write("{firstName:John,lastName:Smith,country:New Zealand,age:128}"+"\n");
			normalTestWriter.write("{firstName:Caleb,lastName:Jerry,country:United States,age:76}"+"\n");
			normalTestWriter.write("{firstName:Henry,lastName:Sky,country:Sweden,age:30}");
			normalTestWriter.close();
			
			emptyTestFile.createNewFile();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the findAverageAge method.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	@Test
	void averageAgeTest() throws FileNotFoundException {
		PhocusSolution solution = new PhocusSolution();
		File normalTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\normalTest.txt");
		assertEquals(49, solution.findAverageAge(normalTestFile));
		
		File emptyTestFile = new File ("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\emptyTest.txt");
		assertEquals(0, solution.findAverageAge(emptyTestFile));
	}
	
	/**
	 * Tests the findOldest method.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	@Test
	void findOldestTest() throws FileNotFoundException {
		PhocusSolution solution = new PhocusSolution();
		File normalTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\normalTest.txt");
		assertEquals("John Smith", solution.findOldest(normalTestFile));
		
		File emptyTestFile = new File ("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\emptyTest.txt");
		assertEquals("",solution.findOldest(emptyTestFile));
	}
	
	/**
	 * Tests the findYoungest method.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	@Test
	void findYoungestTest() throws FileNotFoundException {
		PhocusSolution solution = new PhocusSolution();
		File normalTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\normalTest.txt");
		HashMap<String, String> normalTestMap = solution.findYoungest(normalTestFile);
		assertEquals("Minne Barrow", normalTestMap.get("New Zealand"));
		assertEquals("Caleb Jerry", normalTestMap.get("United States"));
		assertEquals("Henry Sky", normalTestMap.get("Sweden"));
		
		File emptyTestFile = new File ("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\emptyTest.txt");
		HashMap<String, String> emptyTestMap = new HashMap<String, String>();
		assertEquals(emptyTestMap,solution.findYoungest(emptyTestFile));
	}
	
	/**
	 * Tests the findAverages method.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	@Test
	void findAveragesTest() throws FileNotFoundException {
		PhocusSolution solution = new PhocusSolution();
		File normalTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\normalTest.txt");
		HashMap<String, Integer> normalTestMap = solution.findAverages(normalTestFile);
		assertEquals(47, normalTestMap.get("New Zealand"));
		assertEquals(76, normalTestMap.get("United States"));
		assertEquals(30, normalTestMap.get("Sweden"));
		
		File emptyTestFile = new File ("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\emptyTest.txt");
		HashMap<String, Integer> emptyTestMap = new HashMap<String, Integer>();
		assertEquals(emptyTestMap, solution.findAverages(emptyTestFile));
	}
	
	/**
	 * Tests the findAgeRangemethod.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	@Test
	void findRangeTest() throws FileNotFoundException {
		PhocusSolution solution = new PhocusSolution();
		File normalTestFile = new File("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\normalTest.txt");
		int[] normalTestArray = solution.findAgeRange(normalTestFile);
		int [] normalExpectedArray = {1,1,0,0,0,0,0,0,0,0,0,0,1};
		assertArrayEquals(normalExpectedArray, normalTestArray);
		
		File emptyTestFile = new File ("C:\\Users\\mjgea\\OneDrive\\Desktop\\Phocus\\emptyTest.txt");
		int [] emptyExpectedArray = new int[13];
		assertArrayEquals(emptyExpectedArray ,solution.findAgeRange(emptyTestFile));
	}
	

}
