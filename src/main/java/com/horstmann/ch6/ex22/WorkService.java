package com.horstmann.ch6.ex22;

import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Усовершенствуйте метод public static <V, Т> V doWork(Callable<V> с, T ex) throws T, представленный в разделе 6.6.7,
 * таким образом, чтобы передавать ему объект исключения, который вряд ли будет вообще использован.
 * Вместо этого данный метод должен принимать ссылку на класс исключения.
 */
public class WorkService {
//    public static <V, T extends Throwable> V doWork(Callable<V> c, T ex) throws T {
//        try {
//            return c.call ();
//        } catch (Throwable realEx) {
//            ex.initCause(realEx);
//            throw ex;
//        }
//    }

    public static <V, T extends Throwable> V doWork(Callable<V> c, Class<T> exceptionClass) throws T {
        try {
            return c.call ();
        } catch (Throwable realEx) {
            T ex = null;
            try {
                ex = exceptionClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            Objects.requireNonNull(ex).initCause(realEx);
            throw ex;
        }
    }
}
