package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Range {


    @Test
    void range(){
        // L'objectif est de faire la somme des nombres entre (inclus) 1 => 100 (exclu)
        IntStream intStream = IntStream.range(1, 100);
        int sum = intStream.sum();
        Assertions.assertEquals(4950, sum);
    }


    @Test
    void rangeClosed(){
        // L'objectif est de faire la somme des nombres entre (inclus) 1 => 100 (inclus)
        IntStream intStream = IntStream.rangeClosed(1, 100);
        int sum = intStream.sum();
        Assertions.assertEquals(5050, sum);
    }



}
