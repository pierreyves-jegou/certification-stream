package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generate {

    @Test
    void generate(){
        // L'objectif est de générer 100 Double "random" dans une liste
        Stream<Double> doubleStream = Stream.generate(Math::random)
                .limit(100);

        List<Double> collect = doubleStream.collect(Collectors.toList());
        Assertions.assertEquals(collect.size(), 100);

    }

}
