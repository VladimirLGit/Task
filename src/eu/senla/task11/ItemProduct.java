package eu.senla.task11;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ItemProduct {
    private int id;
    private String nameProduct;
    private LocalDate localDate;
    private static ItemProduct create(int id, String nameProduct, LocalDate localDate) {
        return new ItemProduct(id, nameProduct, localDate);
    }
    public ItemProduct(int id, String nameProduct, LocalDate localDate) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.localDate = localDate;
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
                '/' + nameProduct +
                '/' + localDate;
    }
}
