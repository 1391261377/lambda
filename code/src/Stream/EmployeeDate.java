package Stream;

import lambda02.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 12:48
 **/
public class EmployeeDate {

    public static List<Employee> getEmployees(){
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(1001,"胡俊杰",21,20000));
        list.add(new Employee(1002,"周",22,5000));
        list.add(new Employee(1003,"李",18,3000));
        list.add(new Employee(1004,"王",19,2000));
        list.add(new Employee(1005,"杨",25,1000));
        list.add(new Employee(1006,"薛",26,4000));


        return list;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
