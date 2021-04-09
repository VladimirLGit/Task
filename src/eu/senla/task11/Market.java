package eu.senla.task11;




import eu.senla.task11.foods.Fruits;
import eu.senla.task11.foods.Meats;
import eu.senla.task11.orders.ListOrders;
import eu.senla.task11.orders.Order;
import eu.senla.task11.products.ItemProduct;
import eu.senla.task11.products.ListProducts;
import java.util.Random;
import java.util.Scanner;

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
                itemsProduct.add( new ItemProduct( ++lastId, fruits.name() ));
            }
            else {
                Meats meats = Meats.getRandomMeats();
                itemsProduct.add( new ItemProduct( ++lastId, meats.name() ));
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

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int indexMenu = 1;
        int x = 0;

        while (x!=indexMenu){
            indexMenu = 1;
            indexMenu = itemsProduct.menuPrint(indexMenu);
            indexMenu = itemsOrder.menuPrint(indexMenu);
            indexMenu = menuPrint(indexMenu);
            System.out.printf("%s - Для выхода из приложения введите;%n", indexMenu);
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                switch (x) {
                    case 1:
                        printListProducts();
                        break;
                    case 2:
                        int id = itemsProduct.selectedProduct(scanner);
                        if (id>0){
                            itemsOrder.add(new Order(id));
                        };
                        break;
                    case 3:
                        itemsProduct.manualProductInput(scanner);
                        break;
                    case 4:
                        itemsProduct.deleteProduct(scanner);
                        break;
                    case 5:
                        printListOrders();
                        break;
                    case 6:
                        //.deleteProduct();
                        break;
                    case 7:
                        createFoods();
                        break;
                    case 8:
                        itemsProduct.saveProducts(FILEPATH_PRODUCTS);
                        break;
                    case 9:
                        itemsProduct.loadProducts(FILEPATH_PRODUCTS);
                        break;
                    case 10:
                        itemsOrder.saveOrders(FILEPATH_ORDERS);
                        break;
                    case 11:
                        itemsOrder.loadOrders(FILEPATH_ORDERS);
                        break;
                }
            }
            System.out.println();
        }
    }

    private int menuPrint(int number){
        System.out.printf("%s - Привезти новые продукты;%n", number++);
        System.out.printf("%s - Сохранить список продуктов;%n", number++);
        System.out.printf("%s - Загрузить список покупок;%n", number++);
        System.out.printf("%s - Сохранить список покупок;%n", number++);
        return number;
    }
}
