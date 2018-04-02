/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usernutzer
 */
public class WordsTest {
    
    public WordsTest() {
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

    /**
     * Test of asString method, of class Words.
     */
    @Test
    public void testAsString() throws Exception {
        System.out.println("asString");
        Words instance = new Words("babla\n dumdi\n dumbabla\n dumdidum");
        String expResult = "babla dumdi dumbabla dumdidum";
        String result = instance.asString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Didn't work.");
    }

    /**
     * Test of splitBySym method, of class Words.
     */
    @Test
    public void testSplitBySym() throws Exception {
        System.out.println("splitBySym");
        String T = "\n";
        Words instance = new Words("babla\n dumdi\n dumbabla\n dumdidum");
        String expResult = "[babla dumdi dumbabla dumdidum]";
        String result = instance.splitBySym(T);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Didn't work.");
    }

    /**
     * Test of splitByInd method, of class Words.
     */
    @Test
    public void testSplitByInd() throws Exception {
        System.out.println("splitByInd");
        int Ind = 2;
        Words instance = new Words("babla\n dumdi\n dumbabla\n dumdidum");
        String expResult = "[ba, null, bl, null, a , null, du, null, md, null, i , null, du, null]";
        String result = instance.splitByInd(Ind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Didn't work.");
    }

    /**
     * Test of mergeBySym method, of class Words.
     */
    @Test
    public void testMergeBySym() throws Exception {
        System.out.println("mergeBySym");
        char T = '#';
        Words instance = new Words("babla\n dumdi\n dumbabla\n dumdidum");
        String expResult = "babla#dumdi#dumbabla#dumdidum";
        String result = instance.mergeBySym(T);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Didn't work.");
    }

    /**
     * Test of mergeByInd method, of class Words.
     */
    @Test
    public void testMergeByInd() throws Exception {
        System.out.println("mergeByInd");
        int Ind = 3;
        char T = '#';
        Words instance = new Words("babla\n dumdi\n dumbabla\n dumdidum");
        String expResult = "bab#a #um#i #um#ab#a #um#id#m";
        String result = instance.mergeByInd(Ind, T);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Didn't work.");
    }
    
}
