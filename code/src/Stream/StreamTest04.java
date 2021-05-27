package Stream;

import lambda02.Employee;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 16:03
 **/
public class StreamTest04 {

    //匹配与查找

    @Test
    public void test01(){

        List<Employee> employees = EmployeeDate.getEmployees();

        //   boolean allMatch(Predicate<? super T> predicate);   检查是否匹配所有的元素
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch?"满足":"不满足");

        //    boolean anyMatch(Predicate<? super T> predicate);   检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);
        //    boolean noneMatch(Predicate<? super T> predicate);   检查是否没有匹配的元素，
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName() == "雷");
        System.out.println(noneMatch);
        //    Optional<T> findFirst();      返回第一个元素
        Optional<Employee> first = employees.stream().sorted((e1,e2)->Integer.compare(e1.getSalary(),e2.getSalary())).findFirst();
        System.out.println(first);
        //    Optional<T> findAny();        返回当前流中的任意元素   parallelStream并行流
        Optional<Employee> anyEmployee = employees.parallelStream().findAny();
        System.out.println(anyEmployee);
        //     long count();   返回流中的总个数
        long count = employees.stream().count();
        System.out.println(count);

        // 返回流中最大值
        Optional<Employee> max = employees.stream().max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);

        Stream<Integer> salary = employees.stream().map(e -> e.getSalary());
        Optional<Integer> max1 = salary.max(Integer::compare);
        System.out.println(max1);

        //返回流中最小值
        Optional<Employee> min = employees.stream().
                min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        System.out.println();
        // 内部迭代
        employees.stream().forEach(System.out::println);
        //使用的时集合的遍历操作
        employees.forEach(System.out::println);



    }

}
