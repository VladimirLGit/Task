package eu.senla.task11;

import java.time.LocalDate;

public class ItemProduct {
    private int id;
    private String nameProduct;
    private LocalDate localDate;

    public ItemProduct(int id, String nameProduct, LocalDate localDate) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.localDate = localDate;
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
}
