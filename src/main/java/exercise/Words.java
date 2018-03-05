package exercise;

import java.io.StringReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Words {

    private final Reader input;
    private final String sep;
    private final int numCharsSplit;
    private final int numWordsSplit;
    
    //constructors: default values (sep=" ") (numCharsSplit=0) (numWordsSplit=1)
    public Words(Reader input) {
        this(input,0,1," ");
    }
    public Words(Reader input, String separate) {
        this(input,0,1,separate);
    }
    public Words(Reader input, int numCharsSplit, int numWordsSplit, String separate){        
        this.input = input;
        this.sep = separate;
        this.numCharsSplit=numCharsSplit;
        this.numWordsSplit=numWordsSplit;
    }
    
    public Words(String text) {        
        this(new StringReader(text),0,1," ");
    }
    public Words(String text, String separate) {        
        this(new StringReader(text),0,1,separate);
    }
    public Words(String text, int numCharsSlpit, int numWordsSplit, String separate) {        
        this(new StringReader(text), numCharsSlpit, numWordsSplit, separate);        
    }
    
    public Words(File input){
        this(input,0,1," ");
    }
    public Words(File input,String sep){
        this(input,0,1,sep);
    }
    public Words(File input, int numCharsSplit, int numWordsSplit,String sep){        
        Reader fileReader = null;
        try {
            fileReader=new FileReader(input);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Words.class.getName()).log(Level.SEVERE, null, ex);
        }   
        this.input=fileReader;
        this.sep=sep;
        this.numCharsSplit=numCharsSplit;
        this.numWordsSplit=numWordsSplit;
    }
    //end of constructors
    
    public String asStringAlternative() {
        Stream<String> stream = new BufferedReader(input).lines(); 
        return stream.map((n)->String.join(" ",n.split("(?<=\\G.{"+this.numCharsSplit+"})")))
                .collect(Collectors.joining(sep));
    }
    
    public String asString() {
        String out="";
        Stream<String> stream = new BufferedReader(input).lines();         
        if (this.numCharsSplit>0){
            String[] splits= stream.map(n->String.join("&&", n.split("(?<=\\G.{"+this.numCharsSplit+"})")))
                .collect(Collectors.joining("&&")).split("&&");            
            for (int i=0; i<splits.length; i++)
                if ((i+1)%this.numWordsSplit==0&&(i+1)!=splits.length)
                    out+=splits[i]+this.sep;
                else
                    out+=splits[i]+" ";
        }else{//no input of number of characters to split + no input of number of words to split
            out=stream.map(n->n.replaceAll("[^a-zA-Z0-9]"," ").replaceAll("\\s+", this.sep)).collect(Collectors.joining(this.sep));
        }        
        return out.trim();
    }
}