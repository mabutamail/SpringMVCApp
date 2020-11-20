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

        people.add(new Person(++PEOPLE_COUNT, "Egor", 23, "fdg"));
        people.add(new Person(++PEOPLE_COUNT, "Zalex",33, "fdg"));
        people.add(new Person(++PEOPLE_COUNT, "Tom",43, "fdg"));
        people.add(new Person(++PEOPLE_COUNT, "Jerry",53, "fdg"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}