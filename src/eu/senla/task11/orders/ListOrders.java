package eu.senla.task11.orders;

import eu.senla.task11.base.Base;

import java.io.*;

public class ListOrders extends Base<Order> {

    public ListOrders(int maxLength) {
        super(maxLength);
    }

    public void loadOrders(String filePath){
        String s = "";
        while (countItems()>0){
            remove(getItem(0));
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while((s=br.readLine())!=null){
                add(Order.of(s));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл с таким названием не существует - " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения");
        } catch (NumberFormatException e){
            System.err.println("Неправильная запись ID " + s);
        }
    }
    public void saveOrders(String filePath){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            items.forEach(orderProduct -> {
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

    public int menuPrint(int number){
        System.out.printf("%s - Вывести список покупок;%n", number++);
        System.out.printf("%s - Удалить из списка покупок продукт;%n", number++);
        return number;
    }

}
