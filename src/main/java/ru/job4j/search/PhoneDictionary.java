package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> phoneContains = (x) -> x.getPhone().contains(key);
        Predicate<Person> surnameContains = (x) -> x.getSurname().contains(key);
        Predicate<Person> nameContains = (x) -> x.getName().contains(key);
        Predicate<Person> addressContains = (x) -> x.getAddress().contains(key);
        Predicate<Person> combine = phoneContains.or(surnameContains)
                .or(nameContains).or(addressContains);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
