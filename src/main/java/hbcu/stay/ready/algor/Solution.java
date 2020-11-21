package hbcu.stay.ready.algor;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Boolean harmlessRansomNote(String message, String magazineText) {
        Map<String, Integer> numTimesWordsExist = getNumTimesWordsAppear(magazineText);

        String[] messageArr = message.split(" ");
        for (String word : messageArr) {
            if (!numTimesWordsExist.containsKey(word) || numTimesWordsExist.get(word) < 1)
                return false;       // if word isn't in hashmap, or times it has appeared is less than 1, there aren't enough words to create message. Return false.

            int numTimesWordExists = numTimesWordsExist.get(word);
            numTimesWordExists--;
            numTimesWordsExist.put(word, numTimesWordExists);
        }

        // If code reaches this point, there were enough words in magazineText to create message.
        return true;
    }

    // String for every word. Integer for times it appears in array.
    private Map<String, Integer> getNumTimesWordsAppear(String magazineText) {
        Map<String, Integer> numTimesWordsAppear = new HashMap<>();

        String[] magazineArray = magazineText.split(" ");
        for (String word : magazineArray) {
            if (numTimesWordsAppear.containsKey(word)) {
                Integer numTimesWordAppears = numTimesWordsAppear.get(word);
                numTimesWordAppears++;
                numTimesWordsAppear.put(word, numTimesWordAppears);
            } else {
                numTimesWordsAppear.put(word, 1);
            }
        }

        return numTimesWordsAppear;
    }
}
