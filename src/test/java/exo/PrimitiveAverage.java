package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveAverage {

    @Test
    void averageOnIntegerStream(){
        Stream<Integer> integerStream = Stream.of(10, 20);

        // L'objectif ici est d'effectuer la somme des "Integer". Lorsque pas de valeur on renverra "0.0"
        double average = 0d; //TODO
        Assertions.assertEquals(15, average);
    }

    @Test
    void averageOnIntStream(){
        IntStream intStream = IntStream.of(10, 20);

        // L'objectif ici est d'effectuer la somme des "int". Lorsque pas de valeur on renverra "0.0"
        double average = 0d; //TODO
        Assertions.assertEquals(15, average);
    }


}
