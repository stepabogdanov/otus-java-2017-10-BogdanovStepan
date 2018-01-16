package base;

public class UserDataSet extends DataSet {
    private String name;
    private int age;

    public UserDataSet() {
    }

    public UserDataSet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public long getId() {
        return id;
    }
}
