package exo;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stream.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorMapping {

    @Test
    void mapping(){

        // Given
        Person jean = new Person(19, "jean", "FRANCE", Person.SEX.MALE);
        Person bon = new Person(19, "bon", "FRANCE", Person.SEX.MALE);
        Person jane = new Person(21, "jane", "FRANCE", Person.SEX.FEMALE);
        Person steeve = new Person(8, "steeve", "ENGLAND", Person.SEX.MALE);
        Person mary = new Person(5, "mary", "ITALIA", Person.SEX.FEMALE);

        Stream<Person> personStream = Stream.of(jean, bon, steeve, mary, jane);

        // L'objectif ici est d'utiliser le collector "Collectors.mapping()" qui sera souvent utilisé en "downstream" d'un autre collector.
        // Grouper les personnes par pays puis utiliser le collector  "Collectors.mapping()" pour récupérer le 1ier nom (par tri alphabétique)
        Map<String, Optional<String>> firstOrderedNameByCountry = personStream.collect(
                Collectors.groupingBy(x -> x.getCountry(), Collectors.mapping(x -> x.getName(), Collectors.minBy(String::compareTo))));

        Assertions.assertEquals(firstOrderedNameByCountry.get("FRANCE").get(), "bon");
        Assertions.assertEquals(firstOrderedNameByCountry.get("ENGLAND").get(), "steeve");
        Assertions.assertEquals(firstOrderedNameByCountry.get("ITALIA").get(), "mary");
    }

}
