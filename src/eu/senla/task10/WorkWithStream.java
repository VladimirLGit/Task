package eu.senla.task10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkWithStream {
    private String path = "C:\\Users\\1077c\\IdeaProjects\\TestProject\\CPU";
    Map<Double, List<String>> collect = null;
    Stream<AbstractMap.SimpleEntry<Double, List<String>>> simpleEntry = null;
    public void workSplit(){
        String[] sLine = new String[0];
        try {
            sLine = Files.lines(Paths.get(path))
                    .flatMap((p) -> Arrays.stream(p.split(";"))).toArray(String[]::new);
            for (int i = 0; i < sLine.length; i++) {
                System.out.println(sLine[i]);
            }
            String[][] sLine2 = Files.lines(Paths.get(path))
                    .map(line -> line.split(";"))
                    .toArray(String[][]::new);
            for (int i = 0; i < sLine2.length; i++) {
                for (int j = 0; j < sLine2[i].length; j++) {
                    System.out.print(sLine2[i][j]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createAbstractMap(){
        try {
            simpleEntry = Files.lines(Paths.get(path))
                    .map(line -> line.split(";"))
                    .map(s -> Arrays.stream(s).map(String::trim).toArray(String[]::new))
                    .map(strings -> {
                        String nameCPU = strings[0];
                        double freq = Double.parseDouble(strings[1]);
                        return new AbstractMap.SimpleEntry<>(freq,
                                Collections.singletonList(nameCPU));

                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createCollect(){

        createAbstractMap();
        collect = simpleEntry.collect(Collectors
                            .toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, WorkWithStream::merge));
        System.out.println("Show all elements");
        collect.forEach((aDouble, strings) -> System.out.println("freq=" + aDouble +" Name=" + strings));
    }

    public void filterKey(){
        createAbstractMap();
        collect = simpleEntry.filter(doubleListSimpleEntry -> doubleListSimpleEntry.getKey()>2)
                .collect(Collectors
                        .toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, WorkWithStream::merge));
        System.out.println("filter for key(freq) > 2");
        collect.forEach((aDouble, strings) -> System.out.println("freq=" + aDouble +" Name=" + strings));
    }
    public void findForKey(){
        System.out.println("Find element for key(freq)=3.0");
        createAbstractMap();
        collect = simpleEntry.filter(doubleListSimpleEntry -> doubleListSimpleEntry.getKey()==3.0)
                .collect(Collectors
                        .toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, WorkWithStream::merge));
        collect.forEach((aDouble, strings) -> System.out.println("freq=" + aDouble +" Name=" + strings));
    }

    public void showCountCPU(){
        System.out.println("Show count CPU Intel");
        createAbstractMap();
        System.out.println(simpleEntry.filter("Intel_Core_i7-7820X"::equals).count());
    }

    public void findFirstElement(){
        AbstractMap.SimpleEntry<Double, List<String>> entry = null;
        System.out.println("findFirstElement");
        createAbstractMap();
        entry = simpleEntry.findFirst().orElse(new AbstractMap.SimpleEntry<Double, List<String>>(1.0,
                Collections.singletonList("nameCPU")));
        System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());

    }

    private static List<String> merge(List<String> l1, List<String> l2) {
        return Stream.of(l1, l2).flatMap(List::stream).collect(Collectors.toList());
    }
}
