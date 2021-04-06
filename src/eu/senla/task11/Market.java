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
                arrayItems.add(ItemProduct.of(s))
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
    public void menuPrint(){
        System.out.println("1 - Показать весь перечень продуктов;");
        System.out.println("2 - Выбрать из списка продукт;");
        System.out.println("3 - Привезти новые продукты;");
        System.out.println("4 - телефон;");
    }
}
