package com.horstmann.ch2;

import java.util.Random;

/**
 * Проанализируйте метод nextInt() из класса Scanner. Является ли он методом
 * доступа или модифицирующим методом и почему? А что можно сказать о
 * методе nextInt() из класса Random ?
 */
public class ex2 {
    /**
     * В методе nextInt() класса Scanner не аффектятся поля объекта класса Scanner. Значит, данный метод является
     * методом доступа
     * В классе Random аналогичная ситуация
     */
    Random r = new Random(4);
}
