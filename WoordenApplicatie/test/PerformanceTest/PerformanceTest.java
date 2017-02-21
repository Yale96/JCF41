/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceTest;

import java.security.Timestamp;
import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.HandleWords;

/**
 *
 * @author Yannick
 */
public class PerformanceTest {
    
    private long startTime;
    private long endTime;
    private long duration;
    
    public PerformanceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public String generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }

        return Arrays.toString(randomStrings);
    }

    HandleWords word = new HandleWords();

    @Test
    public void performanceTestGenerateWords() {
        System.out.print("HAAL WOORDEN OP");
        startTime = System.nanoTime();
        System.out.print("Haal 1000000 woorden op");
        word.haalWoordenOp(generateRandomWords(10));
        endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;  // milliseconds.
            System.out.println("Method 'amount' with 1000000 words: " + duration + " milliseconds");
    }

    @Test
    public void performceTestSorteerWoorden() {
        System.out.print("SORTEER DE WOORDEN");
        System.out.print("Sorteer 10 woorden");
        word.sorteerWoorden(generateRandomWords(10));
    }
    
    @Test
    public void performanceTestTelWoorden(){
        System.out.print("TEL DE WOORDEN");
        System.out.print("Tellen 10 woorden");
        word.telWoorden(generateRandomWords(10));
        System.out.print("Tellen 10000 woorden");
        word.telWoorden(generateRandomWords(10000));
        System.out.print("Tellen 1000000 woorden");
        word.telWoorden(generateRandomWords(1000000));
    }
    @Test
    public void performanceTestFreqWoorden() {
        System.out.print("FREQUENTIE VAN DE WOORDEN");
        System.out.print("Frequentie van 1000000 woorden");
         word.frequentieVanWoorden(generateRandomWords(1000000));
    }

    @Test
    public void performanceTestConc() {
        System.out.print("COONCERDANTIE VAN DE WOORDEN");
        System.out.print("Conc 1000000 woorden: ");
        startTime = System.nanoTime();
        word.cooncerdantie(generateRandomWords(1000000));
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // milliseconds.
        System.out.println("Method 'Conc' with 1000000 words: " + duration + " milliseconds");
    }
}
