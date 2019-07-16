
/*
 * @Author: Gary J
 * @Date: 2019-07-16 16:45:50
 * @LastEditors: Gary J
 * @LastEditTime: 2019-07-16 17:24:09
 * @Description: Count all characters in Shakespeare's plays.
 */
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay() {
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }

    public void update(String name) {
        if (names.contains(name)) {
            int index = names.indexOf(name);
            counts.set(index, counts.get(index) + 1);
        } else {
            names.add(name);
            counts.add(1);
        }
    }

    public void findAllCharacters() {
        FileResource fr = new FileResource();
        String name;
        for (String line : fr.lines()) {
            line = line.strip();
            int indexOfPeriod = line.indexOf(".");
            if (indexOfPeriod != -1) {
                name = line.substring(0, indexOfPeriod);
                update(name);
            }
        }
    }

    public static void main(String[] args) {
        CharactersInPlay cip = new CharactersInPlay();
        cip.findAllCharacters();
        for (int i = 0; i < cip.names.size(); i++) {
            if(cip.counts.get(i)>1){
                System.out.println(cip.names.get(i));
                System.out.println(cip.counts.get(i));
            }
        }
    }
}