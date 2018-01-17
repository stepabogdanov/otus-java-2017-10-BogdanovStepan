package base;

public class UserDataSet extends DataSet {
    private String name;
    private int age;
    private long id;

    public UserDataSet() {
        super();

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

    public long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "UserDataSet: [ id: " +  getId() + " name: " + getName() +  " age: " + getAge() + "]";
    }

}
