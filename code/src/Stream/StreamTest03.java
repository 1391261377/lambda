package Stream;

import lambda02.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 15:34
 **/

public class StreamTest03 {

    //排序
    @Test
    public void test01(){
        /**
         *     Comparable
         *     Comparator
         *
         *
         *     Stream<T> sorted();  自然排序
         *
         *     Stream<T> sorted(Comparator<? super T> comparator);  定制排序
         */

        List<Integer> list = Arrays.asList(12, 43, 65, 343, 84, 0, -98, 7);

        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(System.out::print);

        System.out.println();
        /**
         * java.lang.ClassCastException: lambda02.Employee cannot be cast to java.lang.Comparable
         *
         * 这个类没有实现 Comparable 接口
         */
//        List<Employee> employees = EmployeeDate.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);


        List<Employee> employees = EmployeeDate.getEmployees();
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
                .forEach(System.out::println);


        System.out.println("");
        //当年龄 一样 比较 薪资
        List<Employee> employeeList = EmployeeDate.getEmployees();
        employeeList.stream().sorted((e1,e2)->{
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare!=0){
                return compare;
            }else {
                /**
                 *  默认从小到
                 *      -Double.compare(e1.getSalary(),e2.getSalary()); 表示从大到小
                 */
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);



    }

}
