package com.impact.numberdelimiter.Junit;

import com.impact.numberdelimiter.NumberDelimiter;
/**
 *
 * @author EA Ravhuhali
 */
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class NumberSummarizerImplTest {

    @Test
    public void testCollectedNumbers() {
        NumberDelimiter test = new NumberDelimiter();
        String numbers = "60, 122, 5, 168, 112, 173, 190, 98";
        Collection<Integer> result = test.collect(numbers);
        assertEquals(Arrays.asList(5, 60, 98, 112, 122, 168, 173, 190), result);

    }

    @Test
    public void testSummarizedCollection() {

        NumberDelimiter test = new NumberDelimiter();
        Collection<Integer> listCollected = Arrays.asList(5, 60, 98, 112, 122, 168, 173, 190);
        String summarizedInput = test.summarizeCollection(listCollected);
        System.out.println(summarizedInput);
    }

}
