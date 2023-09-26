package exo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Spliterator {

    @Test
    void spliteratorOnList(){

        // Given
        List<Integer> integers = List.of(1,2,3,4,5,6,7);

        // L'objectif est de réaliser sur 2 sous ensembles de la liste la somme des données
        java.util.Spliterator<Integer> spliterator1 = integers.spliterator();
        java.util.Spliterator<Integer> spliterator2 = spliterator1.trySplit();
        java.util.Spliterator<Integer> spliterator3 = spliterator1.trySplit();

        final IntermediateSum intermediateSum = new IntermediateSum();
        spliterator3.forEachRemaining(i -> intermediateSum.setSum1(intermediateSum.getSum1() + i));
        spliterator2.forEachRemaining(i -> intermediateSum.setSum2(intermediateSum.getSum2() + i));
        spliterator1.forEachRemaining(i -> intermediateSum.setSum2(intermediateSum.getSum2() + i));

        Assertions.assertEquals(28, intermediateSum.getSum1() + intermediateSum.getSum2());
    }

    class IntermediateSum{
        Integer sum1 = 0;
        Integer sum2 = 0;

        public Integer getSum1() {
            return sum1;
        }

        public void setSum1(Integer sum1) {
            this.sum1 = sum1;
        }

        public Integer getSum2() {
            return sum2;
        }

        public void setSum2(Integer sum2) {
            this.sum2 = sum2;
        }
    }


}
