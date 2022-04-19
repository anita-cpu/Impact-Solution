package com.impact.numberdelimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import numberrangersummarizer.NumberRangeSummarizer;

/**
 *
 * @author EARavhuhali
 */
public class NumberDelimiter implements NumberRangeSummarizer {

    public static void main(String[] args) {
        NumberDelimiter number = new NumberDelimiter();
        //  random generated string 
        String userInput = "37,148,73,176,193,127,153,24";

        try {
            Collection<Integer> input = (List<Integer>) number.collect(userInput);
            String inSummarizedRange = number.summarizeCollection(input);
            System.out.println(inSummarizedRange);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Unexpected input , please revise to acceptable format");
        }

    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> userInputList;
        userInputList = new ArrayList<>(input);
        int length = userInputList.size();
        int start;
        int next;
        for (int a = 0; a < length; a++) {

            if (a == length - 1) {
                if (Objects.equals(userInputList.get(2 - length), userInputList.get(length - 1))) {
                } else {
                    sb.append(userInputList.get(a)).append(",");
                }
                break;
            }
            start = userInputList.get(a);

            next = userInputList.get(a + 1);
            if (next == start + 1) {
                count++;
                int lowestBound = start;
                for (int i = a + 1;; i++) {
                    start = userInputList.get(i);
                    next = userInputList.get(i + 1);

                    if (next == start + 1) {
                        count++;
                    } else {
                        a = i;
                        if (count != 0) {
                            sb.append(lowestBound).append(" - ").append(userInputList.get(i)).append(", ");
                        }
                        break;
                    }
                }
                count = 0;
            } else {
                sb.append(start).append(", ");
            }
        }

        String ranges = sb.toString();
        return ranges.substring(0, ranges.length() - 1);

    }

    @Override
    public Collection<Integer> collect(String input) {
        //Separating collected numbers from userinput with  a comma
        String[] arrayOfString = input.split(",");
        int[] integers = new int[arrayOfString.length];
        for (int i = 0; i < arrayOfString.length; i++) {
            integers[i] = Integer.parseInt(arrayOfString[i]);
        }

        // sorting the numbers
        Arrays.sort(integers);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            list.add(integers[i]);

        }

        return list;

    }

}
