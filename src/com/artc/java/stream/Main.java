package com.artc.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static PersonService personService = new PersonService();

    public static void main(String[] args) {
        System.out.println("----------------------");
        List<Person> list = personService.getAndSortedByWeightAsc();
        // 获取所有人的身高
        List<Double> heightList = list.stream().map(Person::getHeight).collect(Collectors.toList());
        System.out.println("升序身高结果: " + heightList);

        System.out.println("----------------------");
        list = personService.getAndSortedByWeightDesc();
        heightList = list.stream().map(Person::getHeight).collect(Collectors.toList());
        System.out.println("降序序身高结果: " + heightList);

        System.out.println("----------------------");
        Person theHighestPerson = personService.getTheHighestPerson();
        System.out.println("最高的人:" + theHighestPerson);

        System.out.println("----------------------");
        Map<Double, List<Person>> map = personService.getPersonThenGroupByHeight();
        List<Person> p180 = map.getOrDefault(1.80, new ArrayList<>()); // jdk since 1.8
        System.out.println("身高为180的人:" + p180);
        map.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("----------------------");
        Map<Long, Person> map1 = personService.getPersonMap();
        map1.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("----------------------");
        List<Person> zl = personService.getByFirstName("张");
        System.out.println("姓张的人: " + zl);

        System.out.println("----------------------");
        List<Person> femaleList = personService.getFemaleList();
        System.out.println("女性: " + femaleList);
    }

}
