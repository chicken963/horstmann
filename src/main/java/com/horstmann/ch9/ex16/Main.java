package com.horstmann.ch9.ex16;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Какие классы из стандартной библиотеки Java реализуют интерфейс Externalizable и в каких из них применяются методы
 * writeReplace() и readResolve()? - по ходу никакие, здесь своя кухня
 */
public class Main implements Externalizable {

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
