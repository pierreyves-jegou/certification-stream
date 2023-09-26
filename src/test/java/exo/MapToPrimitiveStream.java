package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToPrimitiveStream {


    @Test
    void mapToPrimitiveStream(){
        // Given
        Stream<Integer> integerStream = Stream.of(5, 10, 5 , 10);

        IntStream intStream = integerStream.mapToInt(x -> x);

        OptionalDouble maybeAverage = intStream.average();
        Assertions.assertEquals(maybeAverage.getAsDouble(), 7.5d);


    }

}
