
/*
 * @Author: Gary J
 * @Date: 2019-07-16 15:31:24
 * @LastEditors: Gary J
 * @LastEditTime: 2019-07-16 16:28:16
 * @Description: Open a file and find most frequent word in it. 
 */
import java.util.ArrayList;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String word: fr.words()){
            word = word.toLowerCase();
            if(myWords.contains(word)){
                int i = myWords.indexOf(word);
                myFreqs.set(i, myFreqs.get(i)+1);
            }
            else{
                myWords.add(word);
                myFreqs.add(1);
            }
        }
    }
    public int findIndexOfMax(){
        int maxFreqs = 0;
        int maxIndex = -1;
        for(int i = 0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>maxFreqs){
                maxFreqs = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void main(String[] args) {
        WordFrequencies wf = new WordFrequencies();
        wf.findUnique();
        System.out.println("Number of Unique Words:" + wf.myWords.size());
        for(int i=0;i<wf.myWords.size();i++){
            System.out.println(wf.myFreqs.get(i));
            System.out.println(wf.myWords.get(i));
        }
        int max = wf.findIndexOfMax();
        System.out.println("The word that occurs most often and its count are:"+wf.myWords.get(max)+wf.myFreqs.get(max));
    }
}
