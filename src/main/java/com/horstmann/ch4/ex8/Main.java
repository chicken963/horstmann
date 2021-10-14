package com.horstmann.ch4.ex8;

import java.util.HashMap;
import java.util.Map;

/**
 * В классе Class имеются шесть методов, возвращающих строковое представление типа, описываемого объектом типа Class.
 * Чем отличается их применение к массивам, обобщенным типам, внутренним классам и примитивным типам?
 */
public class Main {
    public static void main(String[] args) {
        Bicycle[] bicycles = {new Bicycle(), new Bicycle()};
        Runnable r = new Thread();
        int i = 4;
        Bicycle.Steeringwheel steeringWheel = bicycles[0].new Steeringwheel();
        Map<String, Object> typeAndExample = new HashMap<>();
        typeAndExample.put("Array", bicycles);
        typeAndExample.put("Common type", r);
        typeAndExample.put("Primitive", i);
        typeAndExample.put("Inner class", steeringWheel);
        for(Map.Entry<String, Object> entry: typeAndExample.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getClass().getCanonicalName());
            System.out.println(entry.getValue().getClass().getSimpleName());
            System.out.println(entry.getValue().getClass().getTypeName());
            System.out.println(entry.getValue().getClass().getName());
            System.out.println(entry.getValue().getClass().toString());
            System.out.println(entry.getValue().getClass().toGenericString());
            System.out.println("\n");
        }
    }
}
