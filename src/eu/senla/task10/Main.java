// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task10;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\1077c\\IdeaProjects\\TestProject\\CPU";

        try {
            String[] sLine = Files.lines(Paths.get(path))
                    .flatMap((p) -> Arrays.stream(p.split(";"))).toArray(String[]::new);
            for (int i = 0; i < sLine.length; i++) {
                System.out.println(sLine[i]);
            }

            //System.out.println(Arrays.stream(Files.lines(Paths.get(path))
            //.map(line -> line.split(";")) // Stream<String[]>
             //       .map(s -> Arrays.stream(s).map(String::trim))
              //              .toArray().collect(Collectors.toList()));

                    //.flatMap(Arrays::stream)
                    //.distinct() // Stream<Stream<String>>
            //        .forEach(x -> System.out.println("ttt" + x));
            //Arrays.stream(Files.lines(Paths.get(path))
            //        .map(s -> s.split(";"))
            //        .map(s -> Arrays.stream(s).map(String::trim)).toArray(String[]::new)).peek(System.out::println);


            /*       .map( strArr -> parserCPU(strArr))
                    .collect(Collectors
                            .toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, Main::merge));
            stringList = map;

            stringList.forEach((key, value) -> System.out.println(key + ":" + value));
        */
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> merge(List<String> l1, List<String> l2) {
        return Stream.of(l1, l2).flatMap(List::stream).collect(Collectors.toList());
    }

    private static AbstractMap.SimpleEntry<Double, List<String>> parserCPU(String[] strArr) {
        String name = strArr[0];
        double freq = Double.parseDouble(strArr[1]);
        return new AbstractMap.SimpleEntry<>(freq, Collections.singletonList(name));
    }
}