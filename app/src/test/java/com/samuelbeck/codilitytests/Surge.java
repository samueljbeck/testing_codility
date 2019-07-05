package com.samuelbeck.codilitytests;

/*
 * Created by samueljbeck on 2019-05-28.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;

class Surge {

    public static class Person {
        String name;
        Person mother;
        Person father;
        String iceCream;

        public Person(String name, Person mother, Person father, String iceCream) {
            this.name = name;
            this.mother = mother;
            this.father = father;
            this.iceCream = iceCream;
        }
    }

    @Test
    public static void main(String[] args) {
        Person fred = new Person("Fred",
                new Person("Edna", null, null, "chocolate"),
                new Person("Ed", null, null, "vanilla"),
                "strawberry");

        Person wilma = new Person("Wilma",
                new Person("Pearl", null, null, "chocolate"),
                null, "chocolate");
        Person pebbles = new Person("Pebbles", wilma, fred, "vanilla");

        List flavors = getFlavorsOfAncestorsRecursive(pebbles);
        // [pebbles, fred, wilma, ed, edna, pearl]
        System.out.println(flavors);
        System.out.println(getFavoriteFlavor(flavors));
    }

    static String getFavoriteFlavor(List<String> flavors) {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for(String s : flavors) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }
        String flavor = "";
        Integer favoriteCount = 0;
        for(String entry: counts.keySet()) {
            // entry.getKey() -> "chocolate" entry.getValue() -> 3
            if (!counts.containsKey(flavor)) {
                flavor = entry;
            } else if (counts.get(entry) > counts.get(flavor)) {
                    flavor = entry;
                }
            }

        return flavor;
    }

    //Get names of this person and all their ancestors in the system.
    static List<String> getFlavorsOfAncestors(Person p) {
        ArrayList<String> flavors = new ArrayList<>();
        Stack<Person> peopleToCheck = new Stack<>();

        peopleToCheck.push(p);
        //implement me.
        do {
            Person currentPerson = peopleToCheck.pop();
            if (currentPerson.mother != null)
                peopleToCheck.push(currentPerson.mother);
            if (currentPerson.father != null)
                peopleToCheck.push(currentPerson.father);
            flavors.add(currentPerson.iceCream);

        } while(!peopleToCheck.empty());

        return flavors;
    }

    //Get names of this person and all their ancestors in the system.
    static List<String> getFlavorsOfAncestorsRecursive(Person p) {
        ArrayList<String> flavors = new ArrayList<>();
        if (p.father != null) {
            flavors.addAll(getFlavorsOfAncestorsRecursive(p.father));
        }
        if (p.mother != null) {
            flavors.addAll(getFlavorsOfAncestorsRecursive(p.mother));
        }
        flavors.add(p.iceCream);

        return flavors;
    }
}