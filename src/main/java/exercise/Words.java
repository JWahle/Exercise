package exercise;

import java.io.Reader;
import java.io.StringReader;

public class Words {

    private final Reader input;
   
    public Words(Reader input) {
       
        this.input = input;
    }

    public Words(String text) {
        this(new StringReader(text));
    }

    public String asString() {
        return this.input.toString();
        
    }

}