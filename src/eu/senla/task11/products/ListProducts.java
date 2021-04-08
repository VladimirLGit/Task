package eu.senla.task11.products;

import eu.senla.task11.base.Base;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class ListProducts extends Base<ItemProduct> {

    private int lastId;
    public ListProducts(int maxLength) {
        super(maxLength);
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

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }



}
