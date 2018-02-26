/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

/**
 *
 * @author musharafdoger
 */
public class WordsMain {
    public static void main (String args[]){
      //  String pass = "a*f-6@5+6*a\tj";
        String pass = "first line\nsecond line\nthird line";
        System.out.println("Before call: "+ pass);
        System.out.println("\nafter call: "+ new Words(pass).asString());
        
        
    }
    
}
