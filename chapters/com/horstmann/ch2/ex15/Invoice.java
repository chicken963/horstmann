package com.horstmann.ch2.ex15;

import java.util.ArrayList;

/**
 * Реализуйте полностью класс Invoice, представленный в разделе 2.6.1. Предоставьте метод, выводящий счет-фактуру,
 * и демонстрационную версию программы, составляющей и выводящей образец счета-фактуры.
 */
public class Invoice {
    private static class Item { // Класс Item вложен в класс Invoice
        String description;
        int quantity;
        double unitPrice;

        double price() {
            return quantity * unitPrice;
        }
    }
    private ArrayList<Item> items = new ArrayList<>();

    public void addltem(String description, int quantity,
                        double unitPrice) {
        Item newltem = new Item();
        newltem.description = description;
        newltem.quantity = quantity;
        newltem.unitPrice = unitPrice;
        items.add(newltem);
    }

    public void print(){
        double totalPrice = 0;
        for(Invoice.Item item: this.items){
            System.out.printf("Description: %s,\nQuantity: %s,\nPrice per one: %s,\nPrice for the ordered number " +
                    "of units: %s\n", item.description, item.quantity, item.unitPrice, item.price());
            totalPrice += item.price();
        }
        System.out.print("TOTAL: ");
        System.out.printf("%.2f", totalPrice);
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addltem("Bicycle", 1, 16999.90);
        invoice.addltem("Motorcycle", 14, 107392.2);
        invoice.addltem("Oyster", 94, 12.06);
        invoice.print();
    }
}
