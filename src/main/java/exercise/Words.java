package exercise;

import java.io.StringReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
public class Words {

    private final Reader input;
    private final String sep;
    
    public Words(Reader input) {
//        this.input = input;
        this(input," ");
    }
    public Words(FileReader input){
        this(input," ");
    }
    public Words(FileReader input, String sep){
        this.input=input;
        this.sep=sep;
    }
    public Words(Reader input, String sep){        
        this.input = input;
        this.sep = sep;
    }
    public Words(String text) {        
//        this(new StringReader(text));
        this(new StringReader(text)," ");
    }
    public Words(String text, String separate) {        
        this(new StringReader(text), separate);        
    }
    public String asString() {
        BufferedReader in  = new BufferedReader(input);
        String out="";
        try
        {
            String x=in.readLine();
            while (x!=null){                
                x=x.replaceAll("[^a-zA-Z0-9]", " ");
                x=x.replaceAll("\\s+", " ");
                out+=" "+x;
                x=in.readLine();
            }
        } catch (IOException e)
        {
            System.out.println("File I/O error!");
        }
        out=out.trim().replaceAll(" ", sep);
        return out;
    }

}