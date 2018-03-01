package exercise;

import static org.junit.Assert.*;
import org.junit.Test;
import exercise.Words;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Assert;

public class WordsTest {
    @Test
    public void taskOneTest (){
    String pass = "first line\rsecond line\tthird line";
    String returnString = new Words(pass).asString();
        assertEquals("first line second line third line", returnString);
   
    }
    
    @Test
    public void taskTwoTest() {
        String fileName = "./input.txt";
        String fileValue = "";
                        try {
                                File file = new File (fileName);

                                BufferedReader br = new BufferedReader(new FileReader(file));
                                StringBuffer fileContents = new StringBuffer();
                                String line = br.readLine();
                                while (line != null) {
                                        fileContents.append(line);
                                        fileContents.append(' ');
                                        line = br.readLine();
                                }
                                fileValue = fileContents.toString();
                               // System.out.println("Before call: " + fileContents.toString());
                               // System.out.println("\noutput: " + new Words(fileContents.toString()).asString());
                                br.close();
                        }//try 
                        catch (IOException ioe) {
                                ioe.printStackTrace();
                        }//catch
        
        String returnString = new Words(fileValue).asString();
        assertEquals("first line second line third line", returnString);
    }
    @Test
    public void taskThreeTest (){
    String newPass = "&one#two-three@four*";
    // System.out.println("\nOutput:" + new Words(newPass).asStringModify());
    
    String returnString = new Words(newPass).asStringModify();
        assertEquals("one-two-three-four", returnString);
    }

}