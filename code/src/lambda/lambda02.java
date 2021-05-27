package lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-14 14:34
 **/
public class lambda02 {
    public static void main(String[] args) {

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("胡俊杰");
            }
        };
        r1.run();


        //无参，无返回值
        Runnable r2=()-> System.out.println("胡俊杰96666");
        r2.run();


        //需要一个参数 但是没有返回值
        Consumer<String> con=(String str)-> System.out.println(str);

        con.accept("1");

        // lambda 若只需要一个参数时，参数的小括号可以省略

        Consumer<String> con2=str-> System.out.println(str);

        con2.accept("2");

        //lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值

        Comparator<Integer> com1=(o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com1.compare(10,20));

        Comparator<Integer> com2=(o1, o2) ->  o1.compareTo(o2);

        System.out.println(com2 .compare(10,20));


    }
}
