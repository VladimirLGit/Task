package eu.senla.task11;




import eu.senla.task11.foods.Fruits;
import eu.senla.task11.foods.Meats;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

public class Market {
    private int lastId = 0;
    private String FILEPATH_PRODUCTS = "C:\\Users\\1077c\\IdeaProjects\\TestProject\\Products";
    private String FILEPATH_ORDERS = "C:\\Users\\1077c\\IdeaProjects\\TestProject\\Orders";
    public ArrayList<ItemProduct> arrayItems;
    public ArrayList<OrderProduct> arrayOrders;

    public Market() {
        arrayItems = new ArrayList<>();
        arrayOrders = new ArrayList<>();
    }
    private String findProductForId(int idProduct){
        for (ItemProduct itemProduct : arrayItems) {
            if (idProduct == itemProduct.getId()) {
                String formatted = "%s %s".formatted(itemProduct, itemProduct.getLocalDate());
                return formatted;
            }
        }
        return "";
    }
    private LocalDate dateGenerator(){
        LocalDate start = LocalDate.of(2021, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
    }
    private void loadProducts(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH_PRODUCTS))){
            String s;
            while((s=br.readLine())!=null){
                arrayItems.add(ItemProduct.of(s));
                if (arrayItems.size()>0) {
                    if (arrayItems.get(arrayItems.size() - 1).getId()>lastId){
                        lastId = arrayItems.get(arrayItems.size() - 1).getId();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл с таким названием не существует - " + FILEPATH_PRODUCTS);
        } catch (IOException e) {
            System.err.println("Ошибка чтения");
        } catch (NumberFormatException e){
            System.err.println("Неправильная запись ID");
        } catch (DateTimeException e){
            System.err.println("Неправильная запись LocalDate");
        }
    }
    private void saveProducts(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH_PRODUCTS))){
            arrayItems.forEach(itemProduct -> {
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

    private void loadOrders(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH_ORDERS))){
            String s;
            while((s=br.readLine())!=null){
                arrayOrders.add(OrderProduct.of(s));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл с таким названием не существует - " + FILEPATH_ORDERS);
        } catch (IOException e) {
            System.err.println("Ошибка чтения");
        } catch (NumberFormatException e){
            System.err.println("Неправильная запись ID");
        }
    }
    private void saveOrders(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH_ORDERS))){
            arrayOrders.forEach(orderProduct -> {
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

    public void createFoods(){
        Random RANDOM = new Random();
        arrayItems = new ArrayList<>();

        for (int i = 0; i < RANDOM.nextInt(5) + 1; i++) {
            if (i%2==0) {
                Fruits fruits = Fruits.getRandomFruits();
                arrayItems.add(new ItemProduct( lastId++, fruits.name(), dateGenerator() ));
            }
            else {
                Meats meats = Meats.getRandomMeats();
                arrayItems.add(new ItemProduct( lastId++, meats.name(), dateGenerator() ));
            }
        }
    }
    public void manualProductInput(){
        int id = 0;
        String nameProduct = "";
        LocalDate date;
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
        {
            System.out.println("Введите название продукта");
            // чтение построчно
            while ((nameProduct = br.readLine()) != null) {
            }
            date = dateGenerator();
            arrayItems.add(new ItemProduct(++lastId, nameProduct, date));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void printListOrders(){
        for (OrderProduct idProduct: arrayOrders) {
            System.out.println(findProductForId(idProduct.getId()));
        }
    }
    public void deleteProduct(){
        String nameProduct = "";
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
        {
            System.out.println("Введите название продукта");
            // чтение построчно
            while ((nameProduct = br.readLine()) != null) {
            }
            for (ItemProduct itemProduct : arrayItems) {
                if (nameProduct.equals(itemProduct.getNameProduct())) {
                    arrayItems.remove(itemProduct);
                    break;
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void menuPrint(){
        System.out.println("1 - Показать весь перечень продуктов;");
        System.out.println("2 - Выбрать из списка продукт;");
        System.out.println("3 - Привезти новые продукты;");
        System.out.println("4 - Ввести продукт вручную;");
        System.out.println("5 - Сохранить список продуктов;");
        System.out.println("6 - Загрузить список покупок;");
        System.out.println("7 - Сохранить список покупок;");
        System.out.println("8 - Вывести список покупок;");
        System.out.println("9 - Удалить из списка покупок продукт;");
    }
}
