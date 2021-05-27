package lambda02;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-17 16:56
 **/

public class testLambda {

    @Test
    public void test01() {

        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("成都");


        System.out.println("********************");

        Consumer<String> con2 = System.out::println;
        con2.accept("555");

    }

    @Test
    public void test02() {

        Employee emp = new Employee(1001, "tom", 23, 5600);

        Supplier<String> sup1 = () -> emp.getName();
        System.out.println("sup1.get() = " + sup1.get());
        System.out.println("********************");

        Supplier<String> sup2 = emp::getName;
        System.out.println("sup2.get() = " + sup2.get());

    }

    @Test
    public void test03() {

        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println("com1.compare(12,22) = " + com1.compare(12, 22));


        Comparator<Integer> com2 = Integer::compare;
        System.out.println("com2.compare(22,12) = " + com2.compare(22, 12));

    }


    @Test
    public void test04() {

        Function<Double, Long> function1 = d -> Math.round(d);
        System.out.println(function1.apply(2.45));


        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(2.55));


    }


    @Test
    public void test05() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("adc", "ade"));

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("adc", "abd"));
    }


    @Test
    public void test06() {
        BiPredicate<String,String> pre1=(s1,s2)->s1.equals(s2);
        System.out.println(pre1.test("a", "a"));


        BiPredicate<String,String> pre2=String::equals;
        System.out.println(pre2.test("a", "c"));


    }



    @Test
    public void test07() {

        Employee employee=new Employee(1001,"jerry",23,6000);
        Function<Employee,String> function1=e->e.getName();
        System.out.println(function1.apply(employee));


        Function<Employee,String> function2=Employee::getName;
        System.out.println(function2.apply(employee));
    }
}