package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Boxed {


    @Test
    void boxed(){
        // Given
        IntStream intStream = IntStream.of(10, 11, 12, 13);

        Stream<Integer> integerStream = null; // TODO
        
        // L'objectif est de récupérer l'ensemble des éléments dans une liste
        Assertions.assertEquals((int) integerStream.count(), 4);
    }

}
