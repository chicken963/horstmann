package com.horstmann.ch6.ex14;

import java.util.ArrayList;

/**
 * Реализуйте усовершенствованный вариант метода closeAll(), представленного в разделе 6.3. Закройте все элементы даже
 * в том случае, если некоторые из них генерируют исключение. В таком случае сгенерируйте исключение впоследствии.
 * Если исключение генерируется в результате двух или больше вызовов данного метода, свяжите их в цепочку.
 */
public class Main {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems, Exception... ex) {
        for (T elem : elems) {
            try {
                elem.close();
                elems.remove(elem);
            } catch (Exception e) {
                if (ex.length > 0) e.initCause(ex[0]);
                closeAll(elems, e);
            }
        }
    }
}
