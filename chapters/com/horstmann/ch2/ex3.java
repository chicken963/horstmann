package com.horstmann.ch2;

public class ex3 {
    private String propertyA;
    private int propertyB;

    public ex3(){
        this.propertyA = "A";
        this.propertyB = 1;
    }
    /*Может ли модифицирующий метод вообще возвращать что-нибудь, кроме типа void ?*/
    private int modifyingNotVoid(){
        this.propertyB = 2;
        return this.propertyB;
    }

    /*Можно ли создать метод доступа с возвращаемым типом v o id , т.е. ничего фактически не возвращающий?*/
    private void accesibleVoid(){
        System.out.println(this.propertyA);
    }
}
