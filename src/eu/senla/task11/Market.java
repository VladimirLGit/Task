package eu.senla.task11;




import eu.senla.task11.foods.Fruits;
import eu.senla.task11.foods.Meats;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

public class Market {
    private int lastId = 0;
    public ArrayList<ItemProduct> arrayItems;
    private LocalDate dateGenerator(){
        LocalDate start = LocalDate.of(2021, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
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
