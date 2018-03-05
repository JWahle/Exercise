package exercise;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class WordsTest {  
    @Test
    public void testString3Lines_Default(){
        assertEquals("first line second line third line",new Words("first line\nsecond line\nthird line").asString());
    }
    @Test
    public void testString3Lines_Default_WithSep(){
        assertEquals("first#line#second#line#third#line",new Words("first@$@line\nsecond line\nthird@line","#").asString());
    }
    @Test
    public void testString3Lines_WithSepNumCharsNumWords_split(){
        assertEquals("12345 6789#22345 6789",
                new Words("123456789\n223456789",5,2,"#").asString());
    }
     @Test
    public void testString3Lines_WithSepNumCharsNumWords_split2(){
        assertEquals("12345 6789 22345*6789",
                new Words("123456789\n223456789",5,3,"*").asString());
    }
    @Test
    public void testString3Lines_fullInput_3(){
        assertEquals("1234 5678 9@2234 5678 9",
                new Words("123456789\n223456789",4,3,"@").asString());
    }
    @Test
    public void testFile_Default(){
        File in = new File("myfile.txt");
        assertEquals("one two three four five this is a new line",
                new Words(in).asString());
    }
    @Test
    public void testFile(){
        assertEquals("one#two#three#four#five#this#is#a#new#line",
                new Words(new File("myfile.txt"),"#").asString());
    }
    @Test
    public void testFile_fullInput(){
        assertEquals("one two th ree four f@ive this is a @new line",
                new Words(new File("myfile.txt"),10,2,"@").asString());
    }
}