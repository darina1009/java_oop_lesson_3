package com.example;

import com.example.model.Person;
import com.example.tree.Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание дерева и добавление элементов
        Tree<Person> tree = new Tree<>();
        tree.add(new Person("Darina", "1995-08-20"));
        tree.add(new Person("Olga", "1985-12-30"));        
        tree.add(new Person("Elisey", "1994-01-01"));


        // Итерация по дереву
        System.out.println("Tree elements:");
        for (Person person : tree) {
            System.out.println(person);
        }

        // Создание списка людей
        List<Person> people = new ArrayList<>();
        people.add(new Person("Darina", "1995-08-20"));
        people.add(new Person("Elisey", "1994-01-01"));
        people.add(new Person("Olga", "1985-12-30"));

        // Сортировка по имени
        Collections.sort(people, Comparator.comparing(Person::getName));
        System.out.println("Sorted by name:");
        people.forEach(System.out::println);

        // Сортировка по дате рождения
        Collections.sort(people, Comparator.comparing(Person::getBirthDate));
        System.out.println("Sorted by birth date:");
        people.forEach(System.out::println);
    }
}