package eu.senla.task5;

import java.util.Random;

    enum Shape {CYLINDER, SQUARE, CONE;
    private static final Shape[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Shape getRandomShape()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
};
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

    };

    public double weightContainer(){
        return densityWater*volumeShape();
    };

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return Double.toString(weightContainer()/1_000_000);
    }

    public void setDensityWater(double densityWater) {
        this.densityWater = densityWater;
    }
}

