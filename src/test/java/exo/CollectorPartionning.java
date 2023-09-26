package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stream.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CollectorPartionning {

    @Test
    void partitionThem(){
        // Given
        Person jean = new Person(19, "jean", "FRANCE");
        Person bon = new Person(19, "bon", "FRANCE");
        Person steeve = new Person(8, "steeve", "ENGLAND");
        Person mary = new Person(5, "mary", "ITALIA");

        Stream<Person> personStream = Stream.of(jean, bon, steeve, mary);

        // L'objectif ici est de distinguer les personnes majeures des personnes mineures
        Map<Boolean, List<Person>> personsByMajority = null; //TODO

        Assertions.assertTrue(personsByMajority.get(Boolean.TRUE).contains(jean));
        Assertions.assertTrue(personsByMajority.get(Boolean.TRUE).contains(bon));
        Assertions.assertEquals(personsByMajority.get(Boolean.TRUE).size(), 2);

    }
}
