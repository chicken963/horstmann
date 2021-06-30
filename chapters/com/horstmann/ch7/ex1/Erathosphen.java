package com.horstmann.ch7.ex1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Реализуйте алгоритм под названием "Решето Эратосфена" для выявления всех простых чисел меньше или равных п.
 * Сначала введите все числа от 2 до п в множество. Затем организуйте повторяющийся поиск наименьшего элемента s
 * в этом множестве, постепенно удаляя из него элементы s2, s • (s + 1), s • (s + 2) и т.д.
 * Этот поиск завершается при условии, когда s2 > п. Реализуйте данный алгоритм как для множества типа HashSet<Integer>,
 * так и для множества типа BitSet.
 */
public class Erathosphen {
    public static Set<Integer> findAllPrimesLessThan(Integer n) {
        Set<Integer> primes = new HashSet<>();
        int i = 2;
        while (i <= n) {
            primes.add(i);
            i++;
        }
        int elem = 2;
        while (Math.pow(elem, 2) <= n) {
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

    public static BitSet findAllPrimesLessThanAsBitSet(Integer n) {
        BitSet primes = new BitSet(n);
        primes.set(2, n);
        int elem = 2;
        while (Math.pow(elem, 2) <= n) {
            int secondMultiplier = elem;
            while (elem * secondMultiplier <= n) {
                if (primes.get(elem * secondMultiplier)) {
                    primes.clear(elem * secondMultiplier);
                }
                secondMultiplier++;
            }
            elem++;
        }

        return primes;
    }
}
