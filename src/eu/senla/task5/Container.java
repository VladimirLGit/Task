// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

    enum Shape {CYLINDER, SQUARE, CONE;
    private static final Shape[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Shape getRandomShape()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
public class Container {
    private static final double PI = 3.1415;
    private double densityWater = 0.0;
    private int height = 0;
    private int diagonal = 0;
    public Shape shape;
    //public Shape shape = Shape.getRandomShape();

    Container(int height, int diagonal, Shape shape){
        this.height = height;
        this.diagonal = diagonal;
        this.shape = shape;
    };

    public double volumeShape(){
        double volume = 0;
        switch (shape){
            case CONE:
                volume = PI*Math.pow(diagonal/2,2)*height/3;
                //V = 1/3 πR^2H
                break;
            case SQUARE:
                volume = 2*Math.pow(diagonal/2,2)*height;
                //V= 2R^2 * H
                break;
            case CYLINDER:
                volume = PI*Math.pow(diagonal/2,2)*height;
                //V = πr^2h
                break;
        };
        return volume;

    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public double weightContainer(){
        return densityWater*volumeShape()/1000;
    };

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        //return  String.format("10.6f",weightContainer());

        double x = weightContainer();
        System.out.print(String.format("weight = %.3f\t", x));
        return String.format("%.3f", x);
        //return new DecimalFormat( "###.##" ).format(x);
        //return Double.toString( (long)(x > 0 ? x * 1000 + 0.5 : x * 1000 - 0.5)/1e3 );
    }

    public void setDensityWater(double densityWater) {
        this.densityWater = densityWater;
    }
}

