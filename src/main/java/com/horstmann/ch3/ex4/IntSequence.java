package com.horstmann.ch3.ex4;

/**
 * Реализуйте статический метод of() из интерфейса IntSequence, возвращающий последовательность из передаваемых ему
 * аргументов. Например, в результате вызова метода IntSequence.of(3, 1, 4, 1, 5, 9) возвращается последовательность из
 * шести значений. В качестве дополнительного задания организуйте возврат экземпляра анонимного внутреннего класса.
 */
public interface IntSequence {

    static IntSequence of(int... args) {
        return new ex4(args) {};
    }

    default boolean hasNext() {
        return true;
    }

    default int next(){
        return 0;
    };

}
