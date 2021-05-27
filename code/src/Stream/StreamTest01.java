package Stream;

/**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-18 12:34
 **/

import lambda02.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *   Stream关注的是对数据的计算，与cpu打交道
 *   集合关注的是数据的存储，与内存打交道
 *
 *
 *   Stream   自己不会存储元素
 *   Stream   不会改变源对象。相反，他们会返回一个持有结果的新Stream
 *   Stream   操作时延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 *
 */
public class StreamTest01 {

    @Test
    public void test01(){

        List<Employee> employees = EmployeeDate.getEmployees();

        //串行流
        Stream<Employee> stream = employees.stream();


        //并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }


    @Test
    public void test02(){

        int[] arr={1,2,3,4,5,6};

        IntStream stream = Arrays.stream(arr);


        Employee employee1 = new Employee(1001,"Tom");
        Employee employee2 = new Employee(1002,"Jerry");

        Employee[] arr1=new Employee[]{employee1,employee2};
        Stream<Employee> stream1 = Arrays.stream(arr1);


    }


    /**
     *  通过Stream的of
     */
    @Test
    public void test04(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);
    }

    /**
     * 创建无限流
     */
    @Test
    public void test05(){
        //迭代
        //    public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {}
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        //生成
        //  public static<T> Stream<T> generate(Supplier<T> s) {}
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }




    }
