package hbcu.stay.ready.algor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public Boolean harmlessRansomNote(String message , String magazineText){
        String[] magazineArray = magazineText.split(" ");
        Map<String, Integer> cutoutWords = new HashMap<>();
        for (String word : magazineArray) {
            if (cutoutWords.containsKey(word)) {
                Integer timesInHashmap = cutoutWords.get(word);
                timesInHashmap++;
                cutoutWords.put(word, timesInHashmap);
            } else {
                cutoutWords.put(word, 1);
            }
        }

        String[] messageArr = message.split(" ");
        for (String word : messageArr) {
            if (cutoutWords.containsKey(word)) {
                if (cutoutWords.get(word) < 1) {
                    return false;
                } else {
                    int timesInHashmap = cutoutWords.get(word);
                    timesInHashmap--;
                    cutoutWords.put(word, timesInHashmap);
                }
            } else {
                return false;
            }
        }


        return true;
    }
}
