package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class SumTopThreeValue {

    @Test
    void topThreeValues() {

        // Given
        Stream<Integer> inputStream = Stream.of(10, 18, 2, 29, 5, 9);

        // L'objectif est récupérer (si possible avec un seul enchainement de méthode "stream") les 3 valeurs les plus élevées et d'en faire la somme

        Integer sum = 0; // TODO
        Assertions.assertEquals(57, sum);
    }


    @Test
    void ignoreFirstThreeValues() {

        // Given
        Stream<Integer> inputStream = Stream.of(10, 18, 2, 29, 5, 9);

        // L'objectif ici est de faire la somme des éléments dans tenir compte des 3 premiers élements
        Integer sum = null; //TODO

        Assertions.assertEquals(sum, 43);
    }




}
