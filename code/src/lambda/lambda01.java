package lambda;

import java.lang.invoke.SerializedLambda;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-14 14:34
 **/
public class lambda01 {
    public static void main(String[] args) {

        //lambda 表达式的写法
        /**
         *  (o1, o2) -> Integer.compare(o1,o2)
         *      -> :lambda操作符或箭头操作符
         *      ->的左边: lambda形参的列表 (就是接口中得抽象方法得形参列表)
         *      ->的右边：lambda体(就是重写的抽象方法的方法体)
         */
        Comparator<Integer> com1=((o1, o2) -> Integer.compare(o1,o2));
        int compare1 = com1.compare(12, 11);

        System.out.println( compare1>0?"真":"假");




        //方法引用
        Comparator<Integer> com2=(Integer::compare);

        int compare2 = com2.compare(24, 30);


        System.out.println( compare2>0?"真":"假");

    }
}
