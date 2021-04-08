package eu.senla.task11;




import eu.senla.task11.foods.Fruits;
import eu.senla.task11.foods.Meats;
import eu.senla.task11.orders.ListOrders;
import eu.senla.task11.orders.Order;
import eu.senla.task11.products.ItemProduct;
import eu.senla.task11.products.ListProducts;
import java.util.Random;

public class Market {
    private String FILEPATH_PRODUCTS = "C:\\Users\\1077c\\IdeaProjects\\TestProject\\Products";
    private String FILEPATH_ORDERS = "C:\\Users\\1077c\\IdeaProjects\\TestProject\\Orders";
    public ListProducts itemsProduct;
    public ListOrders itemsOrder;

    public Market() {
        itemsProduct = new ListProducts(20);
        itemsOrder = new ListOrders(20);
    }

    public void saveList(){
        itemsProduct.saveProducts( FILEPATH_PRODUCTS );
        itemsOrder.saveOrders( FILEPATH_ORDERS );
    }

    public void loadList(){
        itemsProduct.loadProducts( FILEPATH_PRODUCTS) ;
        itemsOrder.loadOrders( FILEPATH_ORDERS );
    }


    public void createFoods(){
        int lastId = itemsProduct.getLastId();
        Random RANDOM = new Random();
        for (int i = 0; i < RANDOM.nextInt(5) + 1; i++) {
            if (i%2==0) {
                Fruits fruits = Fruits.getRandomFruits();
                itemsProduct.add( new ItemProduct( lastId++, fruits.name() ));
            }
            else {
                Meats meats = Meats.getRandomMeats();
                itemsProduct.add( new ItemProduct( lastId++, meats.name() ));
            }
        }
        itemsProduct.setLastId( lastId );
    }
    public void printListProducts(){
        for (ItemProduct product: itemsProduct.items){
            System.out.println( product );
        }
    }

    public void printListOrders(){
        for (Order order: itemsOrder.items) {
            System.out.println( itemsProduct.findProductForId(order.getId()) );
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
