package org.example;

import java.util.Arrays;
import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsBasics {

    public void performStreams(){
        List<Integer> numList = Arrays.asList(7,3,3,2,10,6,1,8,9,5);

         int result = numList.stream().filter(n ->  n%2==1).map(n ->  n * 2)
                 .sorted()
                 .reduce(0,(c,e)-> c+e);
        System.out.println(result);

        String str = "progpramming";

        str.chars().mapToObj(c->(char) c).collect(Collectors.
                groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(entry -> System.out.println(entry));


        

        /*Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Character firstNonRepeat = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        Map<Character,Long> resultMap= str.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));*/


    }
}
