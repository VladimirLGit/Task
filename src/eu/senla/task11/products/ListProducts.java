package eu.senla.task11.products;

import eu.senla.task11.base.Base;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ListProducts extends Base<ItemProduct> {

    private int lastId;
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
                String formatted = "%s %s".formatted(itemProduct, itemProduct.getLocalDate());
                return formatted;
            }
        }
        return "";
    }

    public void manualProductInput(){
        int id = 0;
        String nameProduct = "";
        try(BufferedReader br = new BufferedReader ( new InputStreamReader(System.in) ))
        {
            System.out.println("Введите название продукта");
            // чтение построчно
            while ((nameProduct = br.readLine()) != null) {
            }
            add(new ItemProduct(++lastId, nameProduct));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteProduct(){
        String nameProduct = "";
        try(BufferedReader br = new BufferedReader ( new InputStreamReader(System.in) ))
        {
            System.out.println("Введите название продукта");
            // чтение построчно
            while ((nameProduct = br.readLine()) != null) {
            }
            for (ItemProduct item : items) {
                if (nameProduct.equals(item.getNameProduct())) {
                    remove(item);
                    break;
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
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
                    bw.write(toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectedProduct(){
        int x = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID  продукта");
        String s = scanner.next();
        try {
            x = Integer.parseInt(s);
            if ( x < countItems()){
                System.out.println( findProductForId( x ) );
            }
            else
                System.out.println("Ввели неправильный ID");
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод");
        }
    }

    public int menuPrint(int number){
        System.out.printf("%s - Показать весь перечень продуктов;%n", number++);
        System.out.printf("%s - Выбрать из списка продукт;%n", number++);
        System.out.printf("%s - Ввести продукт вручную;%n", number++);
        System.out.printf("%s - Удалить продукт из списка;%n", number++);
        return number;
    }





}
