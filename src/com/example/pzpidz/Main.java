package com.example.pzpidz;

//У магазині формується список осіб, що записалися на покупку товару.
//Вигляд списку: номер, Ф.І.О., домашня адреса, дата обліку.
//Видалити із списку всі повторні записи, перевіряючи Ф.І.О. і адреса.
//Ключ: дата постановки на облік.

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        List<Person> people = personRepository.findAll();

        personRepository.deleteDuplicates();

        List<Person> uniquePeople = personRepository.findUnique();

        System.out.println("Given list:");
        people.forEach(System.out::println);
        System.out.println("New list:");
        uniquePeople.forEach(System.out::println);
    }
}
