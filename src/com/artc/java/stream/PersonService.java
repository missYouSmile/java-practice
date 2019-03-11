package com.artc.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonService {

    public Person getTheHighestPerson() {
        return personList().stream().max(Comparator.comparingDouble(Person::getHeight))
                .orElseThrow(() -> new RuntimeException("can not find the highest person!"));
    }

    public Map<Double, List<Person>> getPersonThenGroupByHeight() {
        return personList().stream()
                .collect(Collectors.groupingBy(Person::getHeight));
    }

    /**
     * key = Person.id, value = Person
     */
    public Map<Long, Person> getPersonMap() {
        return personList().stream()
                .collect(Collectors.toMap(Person::getId, p -> p));
    }

    public List<Person> getByFirstName(String firstName) {
        return personList().stream()
                .filter(p -> Objects.equals(firstName, p.getFirstName()))
                .collect(Collectors.toList());
    }

    public List<Person> getAndSortedByWeightAsc() {
        return personList().stream()
                .sorted(Comparator.comparingDouble(Person::getHeight)) // default Ascending
                .collect(Collectors.toList());
    }

    public List<Person> getAndSortedByWeightDesc() {
        return personList().stream()
                .sorted(Comparator.comparingDouble(Person::getHeight).reversed())
                .collect(Collectors.toList());
    }

    public List<Person> getFemaleList() {
        return personList().stream()
                .filter(Person::isFemale) // or .filter(p -> p.isFemale())
                .collect(Collectors.toList());
    }

    /**
     * datasource
     */
    List<Person> personList() {
        ArrayList<Person> people = new ArrayList<>();
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("张");
        person.setLastName("三丰");
        person.setHeight(1.81);
        person.setGender(Person.Gender.MALE);
        people.add(person);

        person = new Person();
        person.setId(2L);
        person.setFirstName("王");
        person.setLastName("重阳");
        person.setHeight(1.78);
        person.setGender(Person.Gender.MALE);
        people.add(person);

        person = new Person();
        person.setId(3L);
        person.setFirstName("杨");
        person.setLastName("过");
        person.setHeight(1.85);
        person.setGender(Person.Gender.MALE);
        people.add(person);

        person = new Person();
        person.setId(4L);
        person.setFirstName("王");
        person.setLastName("英");
        person.setHeight(1.65);
        person.setGender(Person.Gender.MALE);
        people.add(person);

        person = new Person();
        person.setId(5L);
        person.setFirstName("黄");
        person.setLastName("蓉");
        person.setHeight(1.60);
        person.setGender(Person.Gender.FEMALE);
        people.add(person);

        person = new Person();
        person.setId(6L);
        person.setFirstName("李");
        person.setLastName("莫愁");
        person.setHeight(1.62);
        person.setGender(Person.Gender.FEMALE);
        people.add(person);
        return people;
    }
}
