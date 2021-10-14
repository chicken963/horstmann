package com.horstmann.ch4.ex6;

import java.util.ArrayList;
import java.util.List;

/**
 * Допустим, что в методе Item, equals(), представленном в разделе 4.2.2, используется проверка с помощью операции
 * instanceof. Реализуйте метод DiscountedItem.equals() таким образом, чтобы выполнять в нем сравнение только с
 * суперклассом, если его параметр otherObject относится к типу Item, но с учетом скидки, если это тип DiscountedItem.
 * Продемонстрируйте, что этот метод сохраняет симметричность, но не транзитивность, т.е. способность обнаруживать
 * сочетание товаров по обычной цене и со скидкой, чтобы делать вызовы х.equals(у) и у.equals(z), но не х.equals(z).
 */
public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Item item1 = new DiscountedItem(42, "Socks", 100);
        Item item2 = new Item("Socks", 130);
        Item item3 = new DiscountedItem(20, "Socks", 100);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        System.out.println("symmetry: " + (item2.equals(item3) && item3.equals(item2)));
        System.out.println("item1 & discounted item2: " + item1.equals(item2));
        System.out.println("discounted item2 & item3: " + item2.equals(item3));
        System.out.println("item1 & item3: " + item1.equals(item3));
        StringBuilder builder = new StringBuilder("");
        for (Item item: items){
            builder.append(item.getDescription()).append(" ").append(item.getPrice()).append("\n");
        }
        System.out.println(builder.toString());
    }
}
