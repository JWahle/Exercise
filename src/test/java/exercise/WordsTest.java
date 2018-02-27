package exercise;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class WordsTest {
//    @Test
//    public void thisIsJustAFailingExampleTest() {
//        assertTrue(
//                !new Words("test words").asString().isEmpty()
//        );
//    }    
    @Test //for string input
    public void testasString1(){
        String in="first line\nsecond line";
        Words testInst=new Words(in);        
        String out=testInst.asString();
        String expResult="first line second line";
        assertEquals(expResult,out);
    }
    @Test //for string input with special characters
    public void testasString12(){
        String in="first*&%($) line\nsecond@$%## line";
        Words testInst=new Words(in);        
        String out=testInst.asString();
        String expResult="first line second line";
        assertEquals(expResult,out);
    }
    @Test //for file input
    public void testasString2(){
        String in="myfile.txt";//input file
        Reader reader = null;
        try{
            reader = new FileReader(in);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        Words testInst=new Words(reader);
        String out=testInst.asString();
        String expResult="this is the content from file";
        assertEquals(expResult,out);
    }
    @Test //customize the character between words with space
    public void testasString31(){
        String in="one-two#three";
        Words testInst=new Words(in," ");        
        String out=testInst.asString();
        String expResult="one two three";
        assertEquals(expResult,out);
    }
    @Test //customize the character between words with "-"
    public void testasString32(){
        String in="one two three";
        Words testInst=new Words(in,"-");        
        String out=testInst.asString();
        String expResult="one-two-three";
        assertEquals(expResult,out);
    }
     @Test //customize the character between words with "*"
    public void testasString33(){
        String in="one$*#^*&#^ two )*)*(&three";
        Words testInst=new Words(in,"*");        
        String out=testInst.asString();
        String expResult="one*two*three";
        assertEquals(expResult,out);
    }
}