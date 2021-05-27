package optional;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 19:16
 **/

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 *
 */
public class OptionalTest {

    /**         public static<T> Optional<T> empty() {}    创建一个Optional实列，t必须非空
     *          public static <T> Optional<T> of(T value){}  创建一个空的Optional 实列
     *           public static <T> Optional<T> ofNullable(T value) {}   t可以为null
     */

    @Test
    public void test01(){
        Girl girl = new Girl();

        Optional<Girl> optional = Optional.of(girl);

    }

    @Test
    public void test02(){
        Girl girl = new Girl();
//        girl=null;
        Optional<Girl> optional = Optional.ofNullable(girl);
        //orElse 如果当前optional 内部封装的T时非空的则返回内部的这个T ，如果内部这个T是空的 ，则返回orElse() 方法中的参数t1.
        Girl girl1 = optional.orElse(new Girl("美女"));

        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test03(){
        Boy boy=new Boy();

        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化

    public String getGirlName1(Boy boy){
        if (boy!=null){
            Girl girl=boy.getGirl();
            if (girl!=null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test04(){
        Boy boy=new Boy();

        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional
    public String getGirlName2(Boy boy){
        Optional<Boy> optional = Optional.ofNullable(boy);
        Boy boy1 = optional.orElse(new Boy(new Girl("美女1")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("美女2"));

        return girl1.getName();

    }

    @Test
    public void test05(){
        Boy  boy=null;
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);


    }

}
