package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class OptionalBasic {

    @Test
    void ifPresent(){

        List<String> beautifulName = new ArrayList<>();

        // GIVEN
        Optional<String> mayBeName1 = Optional.empty();

        mayBeName1.ifPresent(name -> beautifulName.add(name.toUpperCase()));

        Assertions.assertEquals(0, beautifulName.size());

        // GIVEN
        Optional<String> mayBeName2 = Optional.of("John");
        mayBeName2.ifPresent(name -> beautifulName.add(name.toUpperCase()));

        Assertions.assertEquals(1, beautifulName.size());
    }


    @Test
    void orElse(){

        // GIVEN
        Optional<Integer> mayBeAConfigurationValueForMaxPoolSize= Optional.empty();

        Integer maxPoolSize = mayBeAConfigurationValueForMaxPoolSize.orElse(8);
        Assertions.assertEquals(8, maxPoolSize);
    }

    @Test
    void orElseGet(){

        // Given : 1 webservice "cacheable" qui permet de récupérer les informations rapidement car les données sont mise en cache
        // et 1 webservice "raw" qui contient l'ensemble des valeurs mais non mise en cache (plus lent)
        Function<String, Optional<Integer>> cachedWebServiceFnc = name -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(name.equals("john")){
                return Optional.of(18);
            }
            return Optional.empty();
        };

        Function<String, Integer> rawWebServiceFnc = name -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 25;
        };

        // L'objectif ici est de réaliser dans un premier temps un appel au service "cacheable" et si un Optional.empty() est renvoyé appeler le service "raw"
        Integer johnAge = cachedWebServiceFnc.apply("john").orElseGet(() -> rawWebServiceFnc.apply("john"));
        Integer cindyAge = cachedWebServiceFnc.apply("cindy").orElseGet(() -> rawWebServiceFnc.apply("cindy"));

        Assertions.assertEquals(18, johnAge);
        Assertions.assertEquals(25, cindyAge);


    }


}
