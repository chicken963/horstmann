package com.horstmann.ch6.ex4;

public class Main {
    public static void main(String[] args) {
        Table<String, String> sounds = new Table<>();
        sounds.set("Cow", "Mooo");
        sounds.set("Dog", "Bark");
        sounds.set("Cat", "Meow");
        sounds.set("Fox", "Ding-ding-ding ya-pa-paw");
        System.out.println(sounds.get("Dog"));
        sounds.print();
        sounds.set("Frog", "croak");
        sounds.print();
        sounds.set("Frog", "quak");
        sounds.print();
        sounds.pop("Cat");
        sounds.print();
    }
}
