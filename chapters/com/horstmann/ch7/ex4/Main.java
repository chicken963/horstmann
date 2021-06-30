package com.horstmann.ch7.ex4;

import java.util.HashSet;
import java.util.Set;

/**
 * Воспроизведите ситуацию, когда возникает исключение типа ConcurrentModificationException.
 * Что можно предпринять, чтобы избежать этого?
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findAllPrimesLessThan(99));
    }
    public static Set<Integer> findAllPrimesLessThan(Integer n) {
        Set<Integer> primes = new HashSet<>();
        int i = 2;
        while (i <= n) {
            primes.add(i);
            i++;
        }
        //простейший пример под рукой - обращаться к коллекции снаружи цикла и менять её изнутри.
        //избежать этого - не менять коллекцию изнутри, если она упоминается в условии цикла
        for (int elem: primes) {
            int secondMultiplier = elem;
            while (elem * secondMultiplier <= n) {
                if (primes.contains(elem * secondMultiplier)) {
                    primes.remove(elem * secondMultiplier);
                }
                secondMultiplier++;
            }
            elem++;
        }

        return primes;
    }
}
