package eu.senla.task2;


import java.util.Scanner;

public class Rainbow {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\u001B[30m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_WHITE = "\u001B[37m";

    private final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private final String[] ANSI_COD = {ANSI_BLACK,ANSI_RED,ANSI_GREEN,ANSI_YELLOW,ANSI_BLUE,ANSI_PURPLE,ANSI_CYAN,ANSI_WHITE};
    private final String[] COLOR_RAINBOW = {"BLACK","RED","GREEN","YELLOW","BLUE","PURPLE","CYAN","WHITE"};

    private Scanner scanner;

    public Rainbow(){
        scanner = new Scanner(System.in);
    }

    public void  test(){
        System.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ANSI_RESET);
        System.out.println(ANSI_RED + "This text has red text but a default background!" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "This text has a green background and red text!" + ANSI_RESET);

        for (int fg = 40; fg < 47; fg++) {
            for (int bg = 30; bg < 37; bg++)
                System.out.print(String.format("\u001B[%d;%dm TEXT ", fg, bg) + ANSI_RESET);
            System.out.print("\n" + ANSI_RESET);
        }
    }
    public void chooseColor(){
        System.out.println("Enter the color number in the range from 1 to 7");
        int numberInput = scanner.nextInt();
        while (numberInput < 0 || numberInput > COLOR_RAINBOW.length){
            System.out.println("Enter the color number in the range from 1 to 7");
            numberInput = scanner.nextInt();
        }
        numberInput--;
        System.out.println(chooseColor(numberInput));
    }
    private String chooseColor(int aIndex){
        return ANSI_COD[aIndex] + ' ' +COLOR_RAINBOW[aIndex] + ' ' + ANSI_RESET;
    }

    public void mixColor(){
        int numberInput;
        do
        {
            System.out.println("Enter the first color number in the range from 1 to 7");
            numberInput = scanner.nextInt();
        } while(numberInput<0 || numberInput>COLOR_RAINBOW.length);
        int numberFirstColor, numberSecondColor;
        numberFirstColor = numberInput - 1;

        do
        {
            System.out.println("Enter the second color number in the range from 1 to 7");
            numberInput = scanner.nextInt();
        } while(numberInput<0 || numberInput>COLOR_RAINBOW.length);
        numberSecondColor = numberInput - 1;
        if (numberFirstColor == numberSecondColor) {
            mixColor();
        }
        else{
            System.out.println(chooseColor(numberFirstColor) + "-" + chooseColor(numberSecondColor));
        }

    }

    public void  showAllColor(){
        for(int i=0; i< COLOR_RAINBOW.length; i++)
           System.out.print(chooseColor(i));
        System.out.println("");
    }

}
