package Stream;


import lambda02.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 16:55
 **/

//归约
public class StreamTest05 {

    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);   可以将流中能源所反复结合起来，得到一个值
     *
     * Optional<T> reduce(BinaryOperator<T> accumulator);       可以将流中元素反复集合起来，得到一个值
     */
    @Test
    public void test01(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

    }

    @Test
    public void test02(){
        List<Employee> employees = EmployeeDate.getEmployees();
        Stream<Integer> salary = employees.stream().map(Employee::getSalary);
        Optional<Integer> reduce = salary.reduce(Integer::sum);
        System.out.println(reduce);

        System.out.println();
        Stream<Integer> salary1 = employees.stream().map(Employee::getSalary);
        Optional<Integer> reduce1 = salary1.reduce((s1, s2) -> s1 + s2);
        System.out.println(reduce1);
    }



    @Test
    public void test03(){
        /**
         *  收集
         *          <R> R collect(Supplier<R> supplier,
         *                   BiConsumer<R, ? super T> accumulator,
         *                   BiConsumer<R, R> combiner);
         *
         *
         *          <R, A> R collect(Collector<? super T, A, R> collector);
         */

        List<Employee> list = EmployeeDate.getEmployees();
        //将流中元素收集到List  有序
        List<Employee> collect1 = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println();
        //将流中元素收集到Set   无序
        Set<Employee>  collect2 = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect2.forEach(System.out::println);

    }
}
