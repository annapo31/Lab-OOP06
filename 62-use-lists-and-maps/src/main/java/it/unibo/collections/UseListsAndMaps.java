package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MIN = 1000;
    private static final int MAX = 2000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = MIN; i < MAX; i++) {
            arraylist.add(i);
        }


        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> list = new LinkedList<>(arraylist);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmp = arraylist.getFirst();
        arraylist.set(0, arraylist.getLast());
        arraylist.set(arraylist.size() - 1 , tmp);


        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer i : arraylist){
            System.out.println(i);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timearray = System.nanoTime();
        for(int i = 0; i <= 100_000 ; i++) {
            arraylist.addFirst(i);
        }
        timearray = System.nanoTime() - timearray;
        System.out.println("Adding 100.000 elements to ArrayList requires " + timearray + " ns");

        long timelist = System.nanoTime();
        for(int i = 0; i <= 100_000 ; i++) {
            list.addFirst(i);
        }
        timelist = System.nanoTime() - timelist;
        System.out.println("Adding 100.000 elements to LinkedList requires " + timelist + " ns");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        for(int i = 0; i <= 1000 ; i++) {
            arraylist.get(arraylist.size() / 2);
        }
        timearray = System.nanoTime() - timearray;
        System.out.println("Reading 1000 elements to ArrayList requires " + timearray + " ns");


        for(int i = 0; i <= 1000 ; i++) {
            list.get(list.size() / 2);
        }
        timelist = System.nanoTime() - timelist;
        System.out.println("Reading 1000 elements to LinkedList requires " + timelist + " ns");


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000 aggiungi una L dopo aver inserito i numeri
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> map = new HashMap<String,Long>();
        map.put ("Africa", 1110635000L);
        map.put ("Americas", 972005000L);
        map.put ("Antarctica", 0L);
        map.put ("Asia", 4298723000L);
        map.put ("Europe", 742452000L);
        map.put ("Oceania", 38304000L);

        /*
         * 8) Compute the population of the world
         */
        long populationworld = 0L;
        for ( final long i : map.values() ) {
            populationworld += i;
        }
        System.out.println("World population: " + populationworld );
    }
}