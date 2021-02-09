// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task4;

/*
1. Создать матрицу из строк размером 10х10.
2. Заполнить матрицу 6-символьными элементами (вещественными числами(дабл) или буквами).
(границы числа и размерность буквенного ряда не указаны).
Порядок заполнения: за элементом содержащим число следуют 2 элемента содержащие буквы.
При создании значения заполняемого элемента использовать Math.random()
(сохранять ли последовательность при переходе на новую строку и с чего и как начинать заполнение матрицы не указан, т.е. на выбор )
3. Взять главную и побочную диагонали матрицы и сравнить их.(способ не указан)
4. Положить диагонали в массив. Определить символьные(строки) и числовые(дабл) элементы массива.
5. Если елемент строка - положить в SB со 2 по 4 символ и вывести на экран через запятую
(символы или элементы??? скорее всего элементы)
6. Если элемент число - округлить (граница 1.7, Н-р: 1.7->2; 1.69->1) и положить в массив.
Элементы массива вывести через "_"
7. Вывести на экран первоначальную матрицу.
*/

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\u001B[30m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_WHITE = "\u001B[37m";

    private ArrayList<Integer> arrayInteger;
    private StringBuilder sb;

    private String[][] strMatrix;
    private String[] strMainDiagonal;
    private String[] strReversDiagonal;

    public String randomDouble(){
       return new DecimalFormat("000.00").format( Math.random() * 1000);
    }

    public String randomString(){
        StringBuilder sb = new StringBuilder(6);
        Random rand = new Random();
        //String strChar = "FIDrwGgpAoEQsUgpIoWnpRnLnfEd";
        char c;
        for (int i = 0; i < 6; i++) {
            do {
                c = (char) ('A' + rand.nextInt('z'-'A'));
            } while (c<'a'+1 && c>'Z'-1);

            sb.append(c);
        }
            //sb.append(strChar.charAt(rand.nextInt(strChar.length())));
        return sb.toString();
    }

    public void createMatrix(){
        int index = 0;
        strMatrix = new String[10][10];
        strMainDiagonal = new String[strMatrix.length];
        strReversDiagonal = new String[strMatrix.length];
        //String[] strParsingMatrix = new String[strMatrix.length * 2];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                strMatrix[i][j] = index==0 ? randomDouble() : randomString();
                index++;
                if (index>2){
                    index = 0;
                }
            }
        }
    }

    public void showResultDiagonal(){
        System.out.println("strMainDiagonal:");
        for (String s : strMainDiagonal) {
            System.out.print(ANSI_PURPLE + s + ANSI_RESET + " ");
        }
        System.out.println();
        System.out.println("strReversDiagonal:");
        for (String s : strReversDiagonal) {
            System.out.print(ANSI_BLUE + s + ANSI_RESET + " ");
        }
        System.out.println();
        System.out.println("strMainDiagonal==strReversDiagonal: " + Arrays.equals(strMainDiagonal, strReversDiagonal));
    }

    public void parsingMatrix(){
        int indexRevers = 0;
        int indexMain = 0;
        int n = strMatrix.length-2;
        arrayInteger = new ArrayList<>();
        sb = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if (i + j == n + 1)  {strReversDiagonal[indexRevers] = strMatrix[i][j]; indexRevers++;}
                else if (i == j) {strMainDiagonal[indexMain] = strMatrix[i][j]; indexMain++;}
            }
        parserDiagonal(strMainDiagonal);
        parserDiagonal(strReversDiagonal);
        int index = sb.lastIndexOf(",");
        if (index != -1) sb.deleteCharAt(index);
    }


    private void parserDiagonal(String[] aDiagonal) {
        for (String s : aDiagonal) {
            try {
                double l = DecimalFormat.getNumberInstance().parse(s).doubleValue();
                int intPart = (int) l;
                arrayInteger.add(l - intPart > 0.7 ? intPart + 1 : intPart);
            } catch (ParseException e) {
                for (int j = 1; j < 4; j++) {
                    sb.append(s.charAt(j));
                }
                sb.append(",");
            }
        }
    }

    public void showResult(){
        StringBuilder sbArray = new StringBuilder();
        System.out.println("String array");
        System.out.println(sb.toString());
        sbArray.append("_");
        for (Integer integer : arrayInteger) {
            sbArray.append(integer).append("_");
        }
        System.out.println("String arrayInteger");
        System.out.println(sbArray.toString());
    }

    public void printMatrix(){
        int index = 0;
        int n = strMatrix.length-2;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i+j==n+1){
                    System.out.print(ANSI_BLUE + strMatrix[i][j] + ANSI_RESET + " ");
                }
                else {
                    if (index == 0) {
                        System.out.print((i == j ? ANSI_PURPLE : ANSI_GREEN) + strMatrix[i][j] + ANSI_RESET + " ");
                    } else {
                        System.out.print((i == j ? ANSI_PURPLE : ANSI_RESET) + strMatrix[i][j] + ANSI_RESET + " ");
                    }
                }
                index++;
                if (index>2) index = 0;
            }
            System.out.println();
        }
    }

}
