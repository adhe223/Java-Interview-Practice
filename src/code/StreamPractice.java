package code;

import exceptions.ArraysConsumedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by ahenry on 11/17/16.
 * Sccobeedoobeebop
 */
public class StreamPractice {
    public static void main(String[] args)
    {
        List<Integer> initial = new ArrayList<Integer>();
        initial.add(-1);
        initial.add(1);
        initial.add(1);
        initial.add(-1);
        initial.add(-1);
        initial.add(2);

        System.out.println("initial = " + initial);

        List<List<Integer>> after = initial.stream()
                .filter(integer -> integer < 0)
                .map(negInteger -> asList(negInteger, 0))
                .collect(Collectors.toList());

        System.out.println("after = " + after);
    }
}

