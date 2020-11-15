package ru.zalex.spring.dao;

import org.springframework.stereotype.Component;
import ru.zalex.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Egor"));
        people.add(new Person(++PEOPLE_COUNT, "Zalex"));
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Jerry"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

}