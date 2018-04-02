/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author usernutzer
 */
public class main {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Words wort = new Words("babla\n dumdi\n dumbabla\n dumdidum");
        
//        String s4 = wort.splitBySym("\n");
//        String s5 = wort.splitByInd(2);
//        String s6 = wort.mergeByInd(3,'#');
        String s7 = wort.mergeBySym('#');
        System.out.println(s7);
    }
}
