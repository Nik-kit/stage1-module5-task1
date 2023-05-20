package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return t -> t.iterator().next().charAt(0) == t.iterator().next().toUpperCase().charAt(0) && !t.iterator().next().matches("[-+]?\\d+");
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                if (list.get(i) % 2 == 0) {
                    list.add(list.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            for (int i = 0; i < values.size(); i++) {
                String element = values.get(i);
                if (element.charAt(0) != element.toUpperCase().charAt(0)
                        || element.charAt(element.length() - 1) != '.'
                        || element.split(" ").length < 4) {
                    values.remove(i);
                    --i;
                }
            }
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s, s.length());
            }

            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
