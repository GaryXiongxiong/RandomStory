import edu.duke.*;
import java.util.*;

import javax.annotation.processing.FilerException;

public class CodonCount{
    HashMap<String,Integer> codonCount;
    public CodonCount(){
        codonCount = new HashMap<String,Integer>();
    }
    public void count(FileResource fr,int readingFrame){
        codonCount.clear();
        String dna = fr.asString().strip();
        int i = readingFrame;
        while (i+2<dna.length()) {
            String currCodon = dna.substring(i, i+3);
            if (codonCount.containsKey(currCodon)) {
                codonCount.put(currCodon, codonCount.get(currCodon)+1);
            }
            else{
                codonCount.put(currCodon, 1);
            }
            i+=3;
        }
        for (String codon : codonCount.keySet()) {
            System.out.println(codon+"\t"+codonCount.get(codon));
        }

    }
    public static void main(String[] args) {
        FileResource fr = new FileResource("smalldna.txt");
        CodonCount cc = new CodonCount();
        // cc.count(fr, 0);
        // cc.count(fr, 1);
        cc.count(fr, 2);
    }
}