package week6.tasks_hashmap.task1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("matti", "mat");
        map.put("mikael", "mixu");
        map.put("arto", "arppa");
        System.out.println(map.get("mikael"));
    }
}
