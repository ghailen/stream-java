package com.ghailene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingNumbers = Arrays.asList("N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "g64", "I26", "I17", "I29", "O71");

        List<String> gNumbers = new ArrayList<>();

        /** Function interface Exemple **/
        String test = "gabc";
        Function<String, String> convert = (String x) -> {
            return x.toUpperCase();
        };
        String testMajuscule = convert.apply(test);
        System.out.println(testMajuscule);
        System.out.println("--------------------------------------------");
        /** Predicate interface exemple **/
        Predicate<String> validate = (String x) -> x.startsWith("G");
        Boolean val = validate.test(test);
        System.out.println(val);
        System.out.println("--------------------------------------------");
        /** Consumer interface exemple **/
        Consumer<String> consumer = (String x) -> System.out.println(x);

        /** Supplier interface exampel **/
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 5; i++) {
            System.out.println(randomSupplier.get());
        }


        System.out.println("--------------------------------------------");
        someBingNumbers.stream().map(convert).filter(validate).sorted().forEach(consumer);
        // or
        System.out.println("--------------------------------------------");
        someBingNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted().forEach(System.out::println);
        System.out.println("--------------------------------------------");
        // or
        someBingNumbers.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("G")).sorted().forEach(s -> System.out.println(s));

        Stream<String> idNumberStream = Stream.of("I26", "I17");
        Stream<String> inNumberStream = Stream.of("N26", "N17");
        Stream<String> concatStream = Stream.concat(idNumberStream, inNumberStream);

        // peek is supposed for debugging
        System.out.println("--------------------------------------------");
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        List<String> sortedGNumbers = someBingNumbers.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("G")).sorted().collect(Collectors.toList());
        //or
        //  List<String> sortedGNumbers2 = someBingNumbers.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("G")).sorted()
        //           .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

        System.out.println("--------------------------------------------");
        System.out.println(sortedGNumbers);
    }
}
