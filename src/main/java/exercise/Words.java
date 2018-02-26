package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Words {

    private final Reader input;
    String line,conLine="",testLine="";
   
    public Words(Reader input) {
        this.input = input;
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(this.input);
            while ((this.line = reader.readLine()) != null) {
                conLine+=this.line;
                conLine+="\n";
            }

        } catch (IOException e) {
        
        }//catch
    }

    public Words(String text) {
        this(new StringReader(text));
    }

    public String asString() {
       /* char sp= 32;
        for (int i=0; i< this.conLine.length(); i++ ){
           
            if (Character.isLetter(conLine.charAt(i))){
                testLine+=conLine.charAt(i);
                
            }
            else if (conLine.replace("\n", " ")){
                testLine+=sp;
            }
            else{
                testLine+=sp;
            }
         }   //for*/
       
       String a = conLine;
       System.out.println("check link " + conLine);
       
       String cleanString = this.conLine.replaceAll("\r", "").replaceAll("\n", "");
     
        
        
        return cleanString;
        
    }


}