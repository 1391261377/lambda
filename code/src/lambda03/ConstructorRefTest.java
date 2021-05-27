package lambda03;

import lambda02.Employee;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-17 20:11
 **/

public class ConstructorRefTest {


    @Test
    public void test1(){

        Supplier<Employee> sup=new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        System.out.println(sup.get());


        Supplier<Employee> sup1=()->new Employee();
        System.out.println(sup1.get());

        Supplier<Employee> sup2=Employee::new;
        System.out.println(sup2.get());


    }
    @Test
    public void test2(){

        Function<Integer,Employee> function1=id-> new Employee(id);
        System.out.println(function1.apply(1001));


        Function<Integer,Employee> function2=Employee::new;
        System.out.println(function2.apply(1002));
    }
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> function1=(id,name)->new Employee(id,name);
        System.out.println(function1.apply(1001, "胡俊杰"));


        BiFunction<Integer,String,Employee> function2=Employee::new;
        System.out.println(function2.apply(1002, "蒲傻逼"));
        

    }
    
    //数组引用
    @Test
    public void test4(){
    
        Function<Integer,String[]> function1=l->new String[l];
        String[] apply = function1.apply(5);
        System.out.println(Arrays.toString(apply));

        Function<Integer,String[]> function2=String[]::new;
        String[] apply1 = function2.apply(10);
        System.out.println(Arrays.toString(apply1));


    }
    @Test
    public void test5(){

    }

}
