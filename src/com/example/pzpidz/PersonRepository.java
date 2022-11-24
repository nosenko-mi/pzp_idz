package com.example.pzpidz;

import java.util.List;

public class PersonRepository {
//   imitate database connection
    private final String FILE_IN = "in.txt";
    private final String FILE_OUT = "out.txt";

    public void deleteDuplicates(){
//        instead of database
        List<Person> people = FileController.loadPeople(FILE_IN);
//        delete
        List<Person> uniquePeople = people
                .stream()
                .distinct()
                .toList();
//        rewrite
        for (int i = 0; i < uniquePeople.size(); i++){
            uniquePeople.get(i).setNumberInList(i+1);
        }
        FileController.rewritePeople(FILE_OUT, uniquePeople);
    }

    public List<Person> findAll(){
        return FileController.loadPeople(FILE_IN);
    }

    public List<Person> findUnique(){
        return FileController.loadPeople(FILE_OUT);
    }
}
