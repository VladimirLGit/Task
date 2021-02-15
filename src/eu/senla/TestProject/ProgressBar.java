package eu.senla.TestProject;

public class ProgressBar {
    private int done = 0;
    private int length;
    private String nameBar;
    private String line;
    private String pattern;

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }



    public ProgressBar(String name, int length) throws IllegalArgumentException {
        this.nameBar = name;
        this.length = length;
        prepare();
    }

    public int getLength() {
        return length;
    }

    private void prepare() throws IllegalArgumentException {
        System.out.println(nameBar);
        if (length < 0 || length > 100)
            throw new IllegalArgumentException("Length of line is not in range of 0 and 100");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++)
            s.append("*");
        line = s.toString();
        pattern = String.format("[%%-%ds%%3d%%%%]\r", length);
    }

    private void print(int step) {
        System.out.format(pattern, line.substring(0, step * line.length() / 100), step);
    }
    public void showStateBar() { print(done); System.out.println(); }
    public void nextPercent() {
        if (done <= 100) {
            //print(done);
            done++;
        }
    }

    public static void main(String[] args) throws Throwable {
        ProgressBar pb = new ProgressBar("",20);
        for (int i = 0; i < 105; i++) {
            Thread.sleep(10);
            pb.nextPercent();
        }

        System.out.println("Test string 1");
        System.out.println("Test string 2");
        System.out.println("Test string 3");
        System.out.println("Test string 4");
        char escCode = 0x1B;
        int row = 1; int column = 10;
        System.out.print(String.format("%c[%d;%df",escCode,row,column));
        System.out.println("\u001b[1A"+"Test string 5");
    }
}