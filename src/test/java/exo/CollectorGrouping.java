package exo;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stream.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorGrouping {

    @Test
    void groupThemByCountry(){
        // Given
        Person jean = new Person(19, "jean", "FRANCE", Person.SEX.MALE);
        Person bon = new Person(19, "bon", "FRANCE", Person.SEX.MALE);
        Person steeve = new Person(8, "steeve", "ENGLAND", Person.SEX.MALE);
        Person mary = new Person(5, "mary", "ITALIA", Person.SEX.FEMALE);

        Stream<Person> personStream = Stream.of(jean, bon, steeve, mary);

        // L'objectif ici est de grouper les personnes par pays
        //Map<String, List<Person>> personsByCountry = null; //TODO
        Map<String, List<Person>> personsByCountry = personStream.collect(Collectors.groupingBy(Person::getCountry));

        Assertions.assertEquals(2, personsByCountry.get("FRANCE").size());
        Assertions.assertEquals(1, personsByCountry.get("ENGLAND").size());
        Assertions.assertEquals(1, personsByCountry.get("ITALIA").size());
    }

    @Test
    void groupThemByCountryThenBySex(){
        // Given
        Person jean = new Person(19, "jean", "FRANCE", Person.SEX.MALE);
        Person bon = new Person(19, "bon", "FRANCE", Person.SEX.MALE);
        Person jane = new Person(21, "jane", "FRANCE", Person.SEX.FEMALE);
        Person steeve = new Person(8, "steeve", "ENGLAND", Person.SEX.MALE);
        Person mary = new Person(5, "mary", "ITALIA", Person.SEX.FEMALE);

        Stream<Person> personStream = Stream.of(jean, bon, steeve, mary, jane);

        // L'objectif ici est de grouper les personnes par pays puis par sex
        Map<String, Map<Person.SEX, List<Person>>> personsByCountryThenBySex = null; //TODO

        Assertions.assertEquals(personsByCountryThenBySex.get("FRANCE").get(Person.SEX.MALE).size(), 2);
        Assertions.assertEquals(personsByCountryThenBySex.get("FRANCE").get(Person.SEX.FEMALE).size(), 1);
        Assertions.assertEquals(personsByCountryThenBySex.get("ENGLAND").get(Person.SEX.MALE).size(), 1);
        Assertions.assertEquals(personsByCountryThenBySex.get("ITALIA").get(Person.SEX.FEMALE).size(), 1);

    }

    @Test
    void groupThemByCountryAndBySex(){

        // Given
        Person jean = new Person(19, "jean", "FRANCE", Person.SEX.MALE);
        Person bon = new Person(19, "bon", "FRANCE", Person.SEX.MALE);
        Person jane = new Person(21, "jane", "FRANCE", Person.SEX.FEMALE);
        Person steeve = new Person(8, "steeve", "ENGLAND", Person.SEX.MALE);
        Person mary = new Person(5, "mary", "ITALIA", Person.SEX.FEMALE);

        Stream<Person> personStream = Stream.of(jean, bon, steeve, mary, jane);

        // L'objectif ici est de grouper les personnes à la fois sur le pays et sur le sex
        Map<Pair<String, Person.SEX>, List<Person>> personsByCountryAndSex = null; //TODO

        Assertions.assertEquals(personsByCountryAndSex.get(Pair.of("FRANCE", Person.SEX.MALE)).size(), 2);
        Assertions.assertEquals(personsByCountryAndSex.get(Pair.of("FRANCE", Person.SEX.FEMALE)).size(), 1);
        Assertions.assertEquals(personsByCountryAndSex.get(Pair.of("ENGLAND", Person.SEX.MALE)).size(), 1);
        Assertions.assertEquals(personsByCountryAndSex.get(Pair.of("ITALIA", Person.SEX.FEMALE)).size(), 1);
    }

}
