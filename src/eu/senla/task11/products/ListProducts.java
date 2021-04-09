package eu.senla.task11.products;

import eu.senla.task11.base.Base;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ListProducts extends Base<ItemProduct> {

    private int lastId = 0;
    public ListProducts(int maxLength) {
        super(maxLength);
    }
    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public String findProductForId(int idProduct){
        for (ItemProduct itemProduct : items) {
            if (idProduct == itemProduct.getId()) {
                return String.format("%s %s", itemProduct, itemProduct.getLocalDate());
            }
        }
        return  idProduct + " not found id";
    }

    public void manualProductInput(Scanner scanner){
        int id = 0;

        System.out.println("Введите название продукта");
        // чтение построчно
        String nameProduct = scanner.next();
//            while ((nameProduct = br.readLine()) != null) {
//            }
        add(new ItemProduct(++lastId, nameProduct));
    }

    public void deleteProduct(Scanner scanner){

        System.out.println("Введите название продукта");
        // чтение построчно
        String nameProduct = scanner.next();

        for (ItemProduct item : items) {
            if (nameProduct.equals(item.getNameProduct())) {
                remove(item);
                break;
            }
        }
    }

    public void loadProducts(String filePath){
        String s = "";
        while (countItems()>0){
            remove(getItem(0));
        }
        try (BufferedReader br = new BufferedReader( new FileReader(filePath) )){
            while((s=br.readLine())!=null){
                add(ItemProduct.of(s));
                if (countItems()>0) {
                    if (getItem(countItems() - 1).getId()>lastId){
                        lastId = getItem(countItems() - 1).getId();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл с таким названием не существует - " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения");
        } catch (NumberFormatException e){
            System.err.println("Неправильная запись ID " + s);
        } catch (DateTimeException e){
            System.err.println("Неправильная запись LocalDate " + s);
        }
    }

    public void saveProducts(String filePath){
        try (BufferedWriter bw = new BufferedWriter( new FileWriter(filePath) )){
            items.forEach(itemProduct -> {
                try {
                    bw.write(itemProduct.toString());
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int selectedProduct(Scanner scanner){
        int id = 0;
        System.out.println("Введите ID  продукта");
        id = scanner.nextInt();
        try {
            System.out.println( findProductForId( id ) );
            System.out.println("1 - Купить продукт");
            System.out.println("2 - Удалить продукт");
            int x = scanner.nextInt();
            if (x==1) {
                return id;
            }
            else
                if (x==2){
                    for (ItemProduct item : items) {
                        if (id==item.getId()) {
                            remove(item);
                            break;
                        }
                    }
                    return 0;
                }
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод");
        }
        return 0;
    }

    public int menuPrint(int number){
        System.out.printf("%s - Показать весь перечень продуктов;%n", number++);
        System.out.printf("%s - Выбрать из списка продукт;%n", number++);
        System.out.printf("%s - Ввести продукт вручную;%n", number++);
        System.out.printf("%s - Удалить продукт из списка;%n", number++);
        return number;
    }





}
