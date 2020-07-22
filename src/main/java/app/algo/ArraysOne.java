package app.algo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysOne {

    public static void main(String[] args) {
        int[] data = {2,7,7,11,15};

        AtomicInteger ai = new AtomicInteger(0);
        Map<Integer,Integer> result=  Arrays.stream(data).boxed().collect(Collectors.toMap(i->ai.getAndIncrement(), i->i));
        System.out.println(result);

        Map<Integer,Integer> result2 = IntStream.range(0, data.length)
                .boxed()
                .collect(Collectors.toMap(i->i, i -> data[i]));

        System.out.println(result2);

        int[] pData = {1,2,3,4,5,6,7,8,9,10};

        Map<Boolean, List<Integer>> datp =   Arrays.stream(pData).boxed().collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println(datp.get(Boolean.FALSE.booleanValue()));

    }
}
