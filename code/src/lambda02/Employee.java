package lambda02;

/**
 * @program: lambda
 * @description
 * @author: aoligei
 * @create: 2021-05-17 17:05
 **/
public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;

    public Employee(Integer id) {
        this.id = id;
        System.out.println(id);
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
        System.out.println("无参构造");
    }

    public Employee(Integer id, String name, Integer age, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
