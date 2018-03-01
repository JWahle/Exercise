package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import static javafx.application.Platform.exit;

public class Words {

	private final Reader input;
	String line, conLine = "";
        
	public Words(Reader input) {
		this.input = input;
		BufferedReader reader;
		try {
			reader = new BufferedReader(this.input);
                         System.out.println("reader"+reader);
			while ((this.line = reader.readLine()) != null) {
                               // System.out.println(""+this.line);
				conLine += this.line + " ";
			}
		} // try
		catch (IOException e) {

		} // catch*/
	}

	public Words(String text) {
		this(new StringReader(text));
	}
        
	public String asString() {
                // check and cleaning new lines and tabs replace them with whitespace
		String cleanString = this.conLine.replace('\r', ' ').replace('\n', ' ').replace('\t', ' ');
                cleanString = cleanString.trim();
		return cleanString;
        }
        // new method to normalize the data
        public String asStringModify() {
            String concatTemp="";
            for(char ch : this.conLine.toCharArray()){
                   if (Character.isLetter(ch)){ // if the char is letter
                       concatTemp+=ch;
                   }
                   else {
                       ch = ' '; //replacing char with white space
                       concatTemp+=ch;
                   }
                }
                //trim white spaces from start and end
                concatTemp = concatTemp.trim();
                String concatLine="";
                for(char ch : concatTemp.toCharArray()){
                    if (Character.isSpaceChar(ch)){
                       ch = '-';
                       concatLine+=ch;
                    }
                    else{
                        concatLine+=ch;
                    }
                }
              
		return concatLine;
        }
}