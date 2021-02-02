package eu.senla.task4;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.createMatrix();
        m.printMatrix();
        m.parsingMatrix();
        m.showResultDiagonal();
        m.showResult();
        System.out.println("Display characters: 'a'-'Z'");
        for (char c = 'A'; c <= 'z'; c++)
            System.out.print(c);
        System.out.println("");
    }
}
