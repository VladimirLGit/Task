package eu.senla.task11.products;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class ItemProduct {
    private int id;
    private String nameProduct;
    private LocalDate localDate;

    public ItemProduct(int id, String nameProduct, LocalDate localDate) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.localDate = localDate;
    }

    public ItemProduct(int id, String nameProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.localDate = dateGenerator();
    }

    private static ItemProduct create(int id, String nameProduct, LocalDate localDate) {
        return new ItemProduct(id, nameProduct, localDate);
    }

    private LocalDate dateGenerator(){
        LocalDate start = LocalDate.of(2021, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
    }

    private static LocalDate parserLocDate(String strDate) throws NumberFormatException, DateTimeException {
        String[] split = strDate.split("-");
        return LocalDate.of(Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]));
    }
    public static ItemProduct of(String s) throws NumberFormatException {
        String[] sDate = s.split("/");
        return create(Integer.parseInt(sDate[0]), sDate[1], parserLocDate(sDate[2]));
    }


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  id +
                "/" + nameProduct +
                "/" + localDate;
    }
}
