package com.example.pzpidz;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    private FileController(){}

    public static void saveString(String fileName, String result){
        appendToFile(fileName, result);
    }

    public static void rewritePeople(String fileName, List<Person> people){
        StringBuilder peopleWritable = new StringBuilder();
        for (Person p: people){
            String personWritable = p.toWritable();
            peopleWritable.append(personWritable);
        }

        rewriteFile(fileName, peopleWritable.toString());
    }

    public static List<Person> loadPeople(String fileName){

        List<Person> people = new ArrayList<>();

        File file = new File(fileName);
        // read data
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            int n = 0;
            while ((text = reader.readLine()) != null) {
//                split "1.1; 0.1"
                String[] parts = text.split("; ");

                Person auxPerson = createPerson(parts);
                if (auxPerson != null) {
                    people.add(auxPerson);
                } else {
                    System.out.printf("error occurred while reading person [%d]\n", n+1);
                }
                n++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }

    private static Person createPerson(String[] data){
        if (data.length != 6) return null;
//(String phoneNumber, String firstName, String secondName, String lastName, String address, LocalDate registrationDate)

        try {
            Integer num = Integer.parseInt(data[0]);
            LocalDate date = LocalDate.parse(data[5]);
            return new Person(num, data[1], data[2], data[3], data[4], date);
        } catch (Exception e){
            return null;
        }
    }

    private static void rewriteFile(String fileName, String str){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to a file");
        }
    }

    private static void appendToFile(String fileName, String str){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to a file");
        }
    }


}
