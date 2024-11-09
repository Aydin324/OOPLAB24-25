package week6.tasks_hashmap.task2;

import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> notes;

    //useless constructor
    public PromissoryNote() {
        notes = new HashMap<>();
    }

    public void setLoan(String toWhom, double amount){
        notes.put(toWhom, amount);
    }

    public double howMuchIsTheDebt(String whose){
        if(notes.containsKey(whose)){
            return notes.get(whose);
        }
        return 0.0;
    }
}
