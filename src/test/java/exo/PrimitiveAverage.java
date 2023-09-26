package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveAverage {

    @Test
    void averageOnIntegerStream(){
        Stream<Integer> integerStream = Stream.of(10, 20);

        double average = integerStream.mapToDouble(x -> x)
                        .average()
                                .orElse(0.0);
        Assertions.assertEquals(15, average);
    }

    @Test
    void averageOnIntStream(){
        IntStream intStream = IntStream.of(10, 20);
        double average = intStream.average()
                        .orElse(0.0);

        Assertions.assertEquals(15, average);
    }


}
