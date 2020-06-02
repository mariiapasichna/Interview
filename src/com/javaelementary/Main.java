package com.javaelementary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(countNames("Ben  Carl   Mariia Ben Alex"));
    }

    private static Map<String, Long> countNames(String names) {
        if (names == null || names.trim().equals("")) {
            return null;
        }
        return Arrays.stream(names.split("\\s+"))
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}