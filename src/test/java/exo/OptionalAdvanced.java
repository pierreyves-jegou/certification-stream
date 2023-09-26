package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalAdvanced {

    @Test
    void optional1(){

        // Given
        Function<String, String> upperCaseFnc = x -> x.toUpperCase();
        Optional<String> maybeAName1 = Optional.of("je");

        // L'objectif est de renvoyer dans "maybeAUpperCasedName1" un Optional.empty si "maybeAName1" est empty, sinon la valeur de l'optional en lettre majuscule (upperCaseFnc)
        Optional<String> maybeAUpperCasedName1 = null; //TODO

        // L'objectif est de renvoyer dans "maybeAUpperCaseWithLessThan3Letters" un Optional.empty si "maybeAUpperCasedName1" est empty ou que la valeur à plus de 3 lettre, sinon la valeur de l'optional
        Optional<String> maybeAUpperCaseWithLessThan3Letters = null; //TODO

        Assertions.assertEquals(maybeAUpperCasedName1.get(), "JE");

    }

    @Test
    void optional2_avdanced(){

        // Given
        Function<String, Optional<String>> upperCaseFnc = x -> Optional.ofNullable(x.toUpperCase());
        Optional<String> maybeAName = Optional.of("jean");

        // L'objectif ici est d'utilisé la function "upperCaseFnc" (qui renvoie déjà un "Optional")
        //Optional<String> maybeAUpperCase = null; //TODO
        Optional<String> maybeAUpperCase = maybeAName.flatMap(upperCaseFnc);

        Assertions.assertEquals(maybeAUpperCase.get(), "JEAN");
    }




}
