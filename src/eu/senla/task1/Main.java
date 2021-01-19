package eu.senla.task1;

public class Main {
    private static final byte MINBYTE = -128;
    private static final byte MAXBYTE =  127;
    private static final short MINSHORT = -32768;
    private static final short MAXSHORT =  32767;
    private static final int MININT = -2147483648;
    private static final int MAXINT =  2147483647;
    private static final long MINLONG = -9223372036854775808L;
    private static final long MAXLONG =  9223372036854775807L;



    public static void main(String[] args) {
        /*
        Из большего в меньший(Long>Int>Short>Byte)
        */
        BaseType baseType = new BaseType();
        System.out.println("##############");
        baseType.ShowParams();
        System.out.println("##############");
        BaseType baseType2 =
                new BaseType("Text1",
                             true,
                              (byte) 127,
                              (short) 34_000,
                             '%',
                             10000,
                             1000,
                             123_456_789,
                             0.12345d);
        baseType2.ShowParams();
        System.out.println("##############");
        BaseType baseType3 =
                new BaseType("Text1",
                        false,
                        MAXBYTE,
                        MAXSHORT,
                        (char) 23000,
                        MAXINT,
                        1000,
                        MINLONG,
                        0.12345d);
        baseType3.ShowParams();
        baseType3.TypeConvertion();
        System.out.println("byte = " + baseType3.getfByte());
        System.out.println(String.format("byte = %c",baseType3.getfByte()));
        System.out.println(String.format("byte = %b",baseType3.getfByte()));
        System.out.println(String.format("byte = %d",baseType3.getfByte()));
        //System.out.println(String.format("byte = %t",baseType3.getfByte())); error
        //System.out.println(String.format("byte = %f",baseType3.getfByte())); error
        System.out.println(String.format("byte = %c short = %d",baseType3.getfByte(),baseType3.getfInt()));
    }

}
