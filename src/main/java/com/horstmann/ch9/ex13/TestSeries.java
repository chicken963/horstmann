package com.horstmann.ch9.ex13;

import java.io.Serializable;

public class TestSeries implements Serializable {
    private String name;
    private int id;

    public TestSeries(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString(){
        return "My name is " + name + ", id = " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TestSeries)) {
            return false;
        } else {
            TestSeries another = (TestSeries) obj;
            return this.id == another.id && this.name.equals(another.name);
        }
    }
}
