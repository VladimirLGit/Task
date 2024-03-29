// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static class StringComparator implements Comparator,Cloneable  {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1.getClass() == String.class && o2.getClass() == String.class)
                return ((String) o1).compareTo((String) o2);
            else if (o1.getClass() == Integer.class && o2.getClass() == Integer.class)
                return Integer.compare((Integer) o1, (Integer) o2);
            return 0;
        }
    }
    public static StringBuilder sb = new StringBuilder("10");
    public static void chv(int v){
        v += 5;
    }
    public static void main(String[] args) {
        int initv = 5;
        chv(initv);
        sb.append(initv);
        int i = initv + Integer.parseInt(sb.toString());
        System.out.println(i);
        ArrayList<String> currentList = new ArrayList<>();
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1111");
        myArrayList.add("2222");
        myArrayList.add("3333");
        myArrayList.add("4444");
        myArrayList.add("5555");
        System.out.println(myArrayList);

        myArrayList.add(4,"8888");
        System.out.println(myArrayList);
        myArrayList.addAll(3, myArrayList);
        //myArrayList.addAll(new myArrayList<String>() { List.of("sdfsf","sdfsfds","dgfdfgd") });
        System.out.println(myArrayList);
        StringBuilder sb = new StringBuilder();
        for (String str: myArrayList) {
            sb.append(str+", ");
        }
        sb = sb.delete(sb.length()-2,sb.length());
        System.out.println("[" + sb + "]");
        myArrayList.remove("4444");
        System.out.println(myArrayList);
        myArrayList.remove(2);
        System.out.println(myArrayList);

        System.out.println("indexOf - 8888 -" + myArrayList.indexOf("8888"));
        System.out.println("lastIndexOf - 8888 -" + myArrayList.lastIndexOf("8888"));
        StringComparator stringComparator = new StringComparator();
        myArrayList.sort(stringComparator);
        System.out.println(myArrayList);
        System.out.println(new MyArrayList<String>().ofList("1111","3333","5555"));

        System.out.println(myArrayList.subList(3,6));

        currentList.add("1111");
        currentList.add("2222");
        currentList.add("3333");
        currentList.add("4444");
        currentList.add("5555");
        System.out.println(currentList);

        //currentList.addAll(new ArrayList<String>() { {add("sdfsf");add("sdfsfds");add("dgfdfgd");} });

        currentList.add(4,"8888");
        System.out.println(currentList);

        currentList.addAll(3, currentList);
        System.out.println(currentList);
        StringBuilder sb1 = new StringBuilder();
        for (String str: currentList) {
            sb1.append(str+", ");
        }
        sb1 = sb1.delete(sb1.length()-2,sb1.length());
        System.out.println("[" + sb1 + "]");
        currentList.remove("4444");
        System.out.println(currentList);
        currentList.remove(2);
        System.out.println(currentList);
        System.out.println("indexOf - 8888 -" + currentList.indexOf("8888"));
        System.out.println("lastIndexOf - 8888 -" + currentList.lastIndexOf("8888"));

        //System.out.println(List.of("1111","3333","5555"));
    }
}