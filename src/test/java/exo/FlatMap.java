package exo;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stream.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMap {


    @Test
    void doAFlatMap() {

        List<Integer> list1 = getRandomNumbers(5);
        List<Integer> list2 = getRandomNumbers(5);
        List<Integer> list3 = getRandomNumbers(5);

        //Given
        Stream<List<Integer>> listOnTheGrill = Stream.of(list1, list2, list3);

        // L'objectif est de mettre à plat les listes du stream pour n'avoir plus que des "Integer" sur le Stream et ensuite en faire la somme
        int sum = listOnTheGrill.flatMap(x -> x.stream())
                .mapToInt(x -> x)
                .sum();

        Assertions.assertEquals(
                list1.stream().mapToInt(Integer::valueOf).sum() +
                        list2.stream().mapToInt(Integer::valueOf).sum() +
                        list3.stream().mapToInt(Integer::valueOf).sum()
                , sum);

    }

    @Test
    void advancedFlatMap(){

        //Given
        List<Person> persons = List.of(
                new Person(18, "jean", "FRANCE", Person.SEX.MALE, List.of("jean@gmail.fr", "jean@yahoo.fr", "jaimelespub@yahoo.fr")),
                new Person(22, "bon", "FRANCE", Person.SEX.MALE, List.of("bon@gmail.fr", "bon@yahoo.fr")),
                new Person(22, "clara", "FRANCE", Person.SEX.FEMALE, List.of("clara@gmail.fr"))
        );

        // L'objectif ici est de lister le prénom et l'email des personnes ayant un email qui finit par "@yahoo.fr"
        List<Pair<String, String>> nameAndEmailList = persons
                .stream()
                .flatMap(p -> p.getEmails().stream().map(e -> Pair.of(p.getName(), e)))
                .filter(p -> p.getRight().endsWith("@yahoo.fr"))
                .collect(Collectors.toList());

        Assertions.assertEquals(3, nameAndEmailList.size());
        Assertions.assertEquals(Pair.of("jean", "jean@yahoo.fr"), nameAndEmailList.get(0));
        Assertions.assertEquals(Pair.of("jean", "jaimelespub@yahoo.fr"), nameAndEmailList.get(1));
        Assertions.assertEquals(Pair.of("bon", "bon@yahoo.fr"), nameAndEmailList.get(2));


    }


    private List<Integer> getRandomNumbers(int numbers) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt())
                .limit(numbers)
                .collect(Collectors.toList());
    }





}
