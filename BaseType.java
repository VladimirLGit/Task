package eu.senla.task1;

public class BaseType {
    private static final byte MINBYTE = -128;
    private static final byte MAXBYTE =  127;
    private static final short MINSHORT = -32768;
    private static final short MAXSHORT =  32767;
    private static final int MININT = -2147483648;
    private static final int MAXINT =  2147483647;
    private static final long MINLONG = -9223372036854775808L;
    private static final long MAXLONG =  9223372036854775807L;
    /*
    существует восемь примитивных типов
    а именно boolean , byte , short , char , int , float , long и double .
    */
    private boolean fBool;
    private byte fByte;
    private short fShort;
    // можно присвоить целочисленное значение от 0 до 65535
    private char fChar;
    private int fInt;
    private float fFloat;
    private long fLong;
    private double fDouble;
    private String fString;


    public BaseType() {
        fBool = false;
        fByte = 0;
        fShort = 0;
        fChar = '#';
        fInt = 0;
        fFloat = 0.0f;
        fLong = 0L;
        fDouble = 0.0d;
        fString = "";
    }

    public BaseType(String aString,
                    boolean aBoole,
                    byte aByte,
                    short aShort,
                    char aChar,
                    int aInt,
                    float aFloat,
                    long aLong,
                    double aDouble) {
        fBool = aBoole;
        fByte = aByte;
        fShort = aShort;
        fChar = aChar;
        fInt = aInt;
        fFloat = aFloat;
        fLong = aLong;
        fDouble = aDouble;
        fString = aString;
    }

    public void ShowParams(){
        System.out.println( "boolean = " + fBool );
        System.out.println( "byte = " + fByte );
        System.out.println( "short = " + fShort );
        System.out.println( "char = " + fChar );
        System.out.println( "int = " + fInt );
        System.out.println( "float = " + fFloat );
        System.out.println( "long = " + fLong );
        System.out.println( "double = " + fDouble );
        System.out.println( "String = '" + fString + "'");

    }

    /*
    Primitive type	Wrapper class
    boolean	Boolean
    byte	Byte
    char	Character
    float	Float
    int	Integer
    long	Long
    short	Short
    double	Double
     */

    public void TypeConvertion(){
        //возможна потеря данных
        System.out.println("(byte)fInt = " + (byte) fInt);
        //целая часть
        System.out.println("(int)fDouble = " + (int) fDouble);
        int a = 3;
        double b = 4.6;
        double c = a+b;
        System.out.println("""
                int a = 3;
                double b = 4.6;
                double c = a+b;""");
        System.out.println("c = " + c);
        fByte = 3;
        fShort = 4000;
        fByte = (byte)(a+b);
        System.out.println("(byte) (a+b)" + fByte);
        //cast to ...
        //автоматические преобразования с потерей точности.
        fFloat = (float) fInt;
        System.out.println("(float) fInt = " + fFloat);
        fFloat = (float) fLong;
        System.out.println("(float) fLong = " + fFloat);
        fDouble = (double) fLong;
        System.out.println("(double) fLong = " + fDouble);
        fFloat = (float) fDouble;
        System.out.println("(float) fDouble = " + fFloat);
        fInt = MAXINT + 1;
        System.out.println("MAXINT + 1 = " + (MAXINT+1));
        System.out.println("MININT - 1 = " + (MININT-1));
        Integer iValue = Integer.valueOf(fInt);
        fInt = iValue.intValue();

        Long lValue = Long.valueOf(fInt);
        fInt = (int) lValue.longValue();
        Byte bClass = new Byte((byte)12345);
        fByte = MAXBYTE;
    }

    public boolean isfBool() { return fBool; }
    public void setfBool(boolean fBool) { this.fBool = fBool; }
    public byte getfByte() { return fByte; }
    public void setfByte(byte fByte) { this.fByte = fByte; }
    public short getfShort() { return fShort; }
    public void setfShort(short fShort) { this.fShort = fShort; }
    public char getfChar() { return fChar; }
    public void setfChar(char fChar) { this.fChar = fChar; }
    public int getfInt() { return fInt; }
    public void setfInt(int fInt) { this.fInt = fInt; }
    public float getfFloat() { return fFloat; }
    public void setfFloat(float fFloat) { this.fFloat = fFloat; }
    public long getfLong() { return fLong; }
    public void setfLong(long fLong) { this.fLong = fLong; }
    public double getfDouble() { return fDouble; }
    public void setfDouble(double fDouble) { this.fDouble = fDouble; }
    public String getfString() { return fString; }
    public void setfString(String fString) { this.fString = fString; }
}
