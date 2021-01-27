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

    private String strChar = "FIDrwGgpAoEQsUgpIoWnpRnLnfEd";
    private String[][] strMatrix;

    public String randomDouble(){
       return new DecimalFormat("000.00").format( Math.random() * 1000);
    }

    public String randomString(){
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(strChar.charAt(rand.nextInt(strChar.length())));
        }
        return sb.toString();
    }

    public void createMatrix(){
        int index = 0;
        strMatrix = new String[10][10];
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
    public void printMatrix(){
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (index==0) {
                    System.out.print(ANSI_GREEN + strMatrix[i][j] + ANSI_RESET + " ");
                }
                else{
                    System.out.print(strMatrix[i][j] + " ");
                }
                index++;
                if (index>2){
                    index = 0;
                }
            }
            System.out.println();
        }
    }

}
