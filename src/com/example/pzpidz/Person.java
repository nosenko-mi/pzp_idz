package com.example.pzpidz;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private Integer numberInList;
    private String firstName = "";
    private String secondName = "";
    private String lastName = "";
    private String address = "";
    private LocalDate registrationDate = LocalDate.now();

    @Override
    public String toString() {
        return "Person{" +
                "number='" + numberInList + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public Person(Integer numberInList, String firstName, String secondName, String lastName, String address, LocalDate registrationDate) {
        this.numberInList = numberInList;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public Person(Integer numberInList, String firstName) {
        this.numberInList = numberInList;
        this.firstName = firstName;
    }

    public String toWritable(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(numberInList)
                .append("; ")
                .append(firstName)
                .append("; ")
                .append(secondName)
                .append("; ")
                .append(lastName)
                .append("; ")
                .append(address)
                .append("; ")
                .append(registrationDate)
                .append("\n");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, address);
    }

    public Integer getNumberInList() {
        return numberInList;
    }

    public void setNumberInList(Integer numberInList) {
        this.numberInList = numberInList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
