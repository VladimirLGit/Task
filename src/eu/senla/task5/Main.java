package eu.senla.task5;



public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {
        /*for (int r = 0; r <= 255; r+=10) {
            for (int g = 0; g <= 255; g+=10) {
                for (int b = 0; b <= 255; b+=3) {
                    System.out.print("\u001B[48;2;"+r+";"+g+";"+b+"m"+" " + ANSI_RESET);
                    //System.out.print(String.format("\u001B[48;2;%d;%d;%dm%s",r,g,b,"|" ));
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }
                System.out.write( '\r');
                //System.out.println();
            }

        }
        System.out.print("\u001B[38;2;"+120+";"+223+";"+250+"m"+"Count: "); //+ ANSI_RESET

       for (int i = 200; i < 300; i++) {
            String num = Integer.toString(i);
            System.out.print(num);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            for (int j = 0, k = num.length(); j < k; j++) {
                //System.out.println(String.format("\u001B[38;5;%d;%d;%dm%s\u001B[38;2;%d;%d;%dm TTT"+ ANSI_RESET,12,12,25,"|",120,223,250 ));
                System.out.write( '\b');
            }
        }*/
        Port port = new Port(10);
        port.createContainers();
        port.createShips();
        port.loadContainer();
        System.out.println(port.calculateTheVolume());
    }
}