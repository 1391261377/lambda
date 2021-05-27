package lambda; /**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-16 15:24
 **/


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/***
 *  java 内置4大核心函数式接口
 *      消费型接口 Consumer<T>   void    accept(T t)
 *      供给型接口 Supplier<T>   T       get()
 *      函数型接口 Function<T,R> R       apply(T t)
 *      断定型接口 Predicate<T>  boolean  test(T t)
 *
 **/
public class lambda03 {


    @Test
    public  void test01(){

        happyTime(400,money-> System.out.println("学习太累了"+money));

        List<String> list= Arrays.asList("北京","胡俊杰","周渠岸","郭宝林","南京");
        System.out.println(filterString(list, s -> s.contains("京")));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s:list) {
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
