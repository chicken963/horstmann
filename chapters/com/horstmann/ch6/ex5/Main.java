package com.horstmann.ch6.ex5;

public class Main {
    public static void main(String[] args) {
        /*
        Рассмотрите следующий вариант метода swap (), где массив может быть представлен с помощью ар1ументов переменной длины
         */
        //        Double[] result = CustomArrays.swap(0, 1, 1.5, 2, 3);

        //Какое сообщение об ошибке вы получите? Далее сделайте такой вызов:
        //        Double[] result = CustomArrays.<Double>swap(0, 1, 1.5, 2, 3);

        /*Изменилось ли к лучшему сообщение об ошибке? Что нужно сделать для устранения ошибки?
        * боксинг*/
        Double[] result = CustomArrays.<Double>swap(0, 1, new Double(1.5),
                new Double(1.5),
                new Double(1.5));
    }


}
