package week6.tasks_hashmap.task3;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void add(String key, String value) {
        dictionary.put(key, value);
    }

    public String translate(String word){
        if(dictionary.containsKey(word))
            return dictionary.get(word);
        return "Word " + word + " is not in your dictionary.";
    }

    public int amountOfWords(){
        return dictionary.size();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> list = new ArrayList<>();
        for(String key : dictionary.keySet()){
            list.add(key + " = " + dictionary.get(key));
        }
        return list;
    }
}
