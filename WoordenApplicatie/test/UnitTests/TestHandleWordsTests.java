/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.HandleWords;

/**
 *
 * @author yanni
 */
public class TestHandleWordsTests {

    public TestHandleWordsTests() {
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
    //Test het sorteren met 4 strings
    private HandleWords words = new HandleWords();

    String names = "Yannick \n"
            + "Dennis, Yannick, \n"
            + "Dennis, \n"
            + "Dennis, \n"
            + "Max, \n"
            + "Rene";

    @Test
    public void haalOpTest() {
        LinkedList<String> expected = new LinkedList<>();
        expected.add("yannick");
        expected.add("dennis");
        expected.add("yannick");
        expected.add("dennis");
        expected.add("dennis");
        expected.add("max");
        expected.add("rene");

        assertEquals(expected, words.haalWoordenOp(names));
    }

    @Test
    public void sorteerTest() {
        String expected = "[yannick, rene, max, dennis]";
        assertEquals(expected, words.sorteerWoorden(names));
    }

    @Test
    public void telWoordenTest() {
        assertEquals("Aantal uit input: " + 7
                + "\nAantal uniek: " + 4, words.telWoorden(names));
    }

    @Test
    public void frequentieTest() {
        String expected = "[max=1, rene=1, yannick=2, dennis=3]";
        assertEquals(expected, words.frequentieVanWoorden(names));
    }

    @Test
    public void concTest() {
        String expected = "{yannick=[1, 2]\n"
                + "max=[5]\n"
                + "dennis=[2, 3, 4]\n"
                + "rene=[6]}";
        assertEquals(expected, words.cooncerdantie(names));
    }
}
