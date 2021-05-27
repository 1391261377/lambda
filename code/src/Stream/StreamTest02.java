package Stream;

import lambda02.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 13:29
 **/
public class StreamTest02 {

    @Test
    public void test01(){
        /**
         *  筛选与切片
         *   filter         接收lambda ，从流中排除某些元素
         *   limit          截断流，使其元不超过给定数量
         *   skip           跳过元素，返回一个扔掉了前n哥元素的 流，若流占中元素不足n个，则返回一个
         *   distinct       筛选(去重)，通过流所生成元素的hashCode() 和equals() 去除重复元素
         */
        List<Employee> list = EmployeeDate.getEmployees();
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);


        System.out.println("*****************************");

        //   limit          截断流，使其元不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println("*****************************");
        // skip           跳过元素，返回一个扔掉了前n哥元素的 流，若流占中元素不足n个，则返回一个
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("*****************************");
        // distinct       筛选，通过流所生成元素的hashCode() 和equals() 去除重复元素
        list.stream().distinct().forEach(System.out::println);




    }



    //映射
    @Test
    public void test02(){
        // map(Function f) ---接收一个函数作为参数，将元素转换成其他形式或提取信息，
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(f->f.toUpperCase()).forEach(System.out::println);


        //获取员工姓名长度大于等于3的员工姓名
        List<Employee> employees = EmployeeDate.getEmployees();
        Stream<String> stringStream = employees.stream().map(e -> e.getName());
        stringStream.filter(name->name.length()>= 3).forEach(System.out::println);

        System.out.println("");
        //将字符串中的字多个字符 拆开
        Stream<Stream<Character>> streams = list.stream().map(this::fromStringToStream);
        streams.forEach(s->{
            s.forEach(System.out::println);
        });

        System.out.println("");
        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个值
        Stream<Character> characterStream = list.stream().flatMap(this::fromStringToStream);
        characterStream.forEach(System.out::println);


    }

    public Stream<Character> fromStringToStream(String  str){
        //将字符串中的多个字符构成的集合转换为对应的Stream
        ArrayList<Character> list = new ArrayList<>();

        for (Character c: str.toCharArray()) {
            list.add(c);
        }
        return list.stream();


    }

    @Test
    public void test03(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list.add(list2);  //4个元素
        list.addAll(list2);  //6个元素
        System.out.println(list);



    }

}
