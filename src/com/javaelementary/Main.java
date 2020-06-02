package com.javaelementary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        countNames("Ben Carl  Den   Mary Mary");
    }

    private static void countNames(String names) {
        names = names.trim();
        StringBuilder stringBuilder = new StringBuilder(names);
        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            if (stringBuilder.charAt(i) == ' ' && stringBuilder.charAt(i + 1) == ' ') {
                stringBuilder.deleteCharAt(i);
            }
        }
        Map<String, Integer> map = new HashMap<>();
        String[] strings = stringBuilder.toString().split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                int count = map.get(strings[i]);
                count++;
                map.put(strings[i], count);
            } else {
                map.put(strings[i], 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        System.out.println(list);
    }
}