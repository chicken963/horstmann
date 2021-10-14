package com.horstmann.ch4.ex9;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * Напишите "универсальный" метод toString(), в котором применяется рефлексия для получения символьной строки со
 * всеми переменными экземпляра объекта. В качестве дополнительного задания можете организовать обработку
 * циклических ссылок.
 */
public class Main {
    /**
     * Перегоняет любой объект в стрингу из значений полей. Рекурсивно проваливается в поля-объекты, выводит результаты
     * дефолтного toString() при зацикливании.
     * @param o - объект
     * @param registeredObjects - массив, где будут накапливаться поля-объекты
     * @return стринговое представление
     */
    public static String toString(Object o, List<Object> registeredObjects) {
        StringBuilder result = new StringBuilder();
        //добавляем сам объект в список объектов, которые надо мониторить на предмет зацикливания
        registeredObjects.add(o);
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(o);
                //проверяем, что поле не примитив и ещё не выводилось в данном методе на других уровнях
                boolean isObjectToBeAdded = !(value instanceof Integer)
                        && !(value instanceof String)
                        && !registeredObjects.contains(value);
                //если перед нами действительно новый объект
                if (isObjectToBeAdded) {
                    //укажем имя класса
                    result.append(value.getClass().getSimpleName())
                            .append(":{")
                            //и его стринговое представление
                            .append(toString(value, registeredObjects))
                            .append("}, ");
                } else {
                    //если примитив или зацикленный объект, то неявно вызываем обычный toString()
                    result.append(value).append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //косметические штучки - удаляем на конце запятую с пробелом
        return result.substring(0, result.toString().length() - 2);
        //и ещё вопрос - надо ли было делать рекурсивный прогон по суперклассам? как в задании 10

    }

    public static void main(String[] args) {
        SteeringWheel steeringWheel = new SteeringWheel("Mozo", "Black");
        Bicycle bicycle = new Bicycle(19900, "Stels", steeringWheel);
        steeringWheel.setBicycle(bicycle);
        System.out.println(toString(bicycle, new LinkedList<>()));
    }
}
