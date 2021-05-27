package optional;

/**
 * @program: lambda
 * @description
 * @author: 胡俊杰
 * @create: 2021-05-18 19:29
 **/
public class Girl {


    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
