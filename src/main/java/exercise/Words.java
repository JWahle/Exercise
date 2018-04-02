package exercise;

// Ali Eftekhari

import java.io.Reader;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Words {

    private final Reader input;
    public File file;

    public Words(Reader input) {
        this.input = input;
    }

    public Words(String text) {
        this(new StringReader(text));
    }
    
    public Words(File file) throws FileNotFoundException {
        this.file = file;    
        
    }

    public String asString() throws IOException {
        BufferedReader b1 = new BufferedReader(this.input);
        String line = "";
        String out = "";
        while((line = b1.readLine() ) != null){
            out = out + line;
        }
        return out;
    }
    
    public String splitBySym(String T) throws IOException {        
        String s1 = this.asString();
        String[] s2 = s1.split(T);
        return Arrays.toString(s2);
    }
    
    public String splitByInd(int Ind) throws IOException {
        
        String s1 = this.asString();
        int L = (int) Math.ceil(s1.length()/Ind);
        String[] s2 = new String[L];
        
        for (int i = 0; i < s2.length; i+= Ind) {
            // nicht perfekt, aber "gut genug"
            s2[i] = s1.substring(i, Math.min(i+Ind, s1.length()));
        }
        return Arrays.toString(s2);
        
    }

    public String mergeBySym(char T) throws IOException{
        
        StringBuilder s1 = new StringBuilder(this.asString());
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ') {
                s1.setCharAt(i, T);
            }
        }
        return s1.toString();
    }
    
    public String mergeByInd(int Ind, char T) throws IOException{
        
        StringBuilder s1 = new StringBuilder(this.asString());
        
        for (int i = 0; i < s1.length(); i+= Ind) {
            if (i == 0) {
                continue;
            }
            s1.setCharAt(i, T);
        }
        return s1.toString();
    }
}