package Stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-27 12:09
 **/
public class StreamTest06 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.sorted().forEach(System.out::println);

        int[] arr={2,3,4,5,1};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(55);
        list.add(9);
        list.add(0);
        list.add(2);
        Collections.sort(list);
        list.forEach(System.out::println);
//        list.forEach(System.out::printlndadad);
        list.forEach(System.out::println);

    }

}
