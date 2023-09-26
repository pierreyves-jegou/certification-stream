package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CollectorJoining {

    @Test
    void joingThemAll(){
        //Given
        Stream<String> inputStream = Stream.of("jean", "bon", "tony");

        // L'objectif ici est d'utiliser un collector permettant de valider l'assertion
        String result = null; // TODO

        Assertions.assertEquals("jean-bon-tony", result);

    }

}
