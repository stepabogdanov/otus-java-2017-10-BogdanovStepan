package base;

public class UserDataSet extends DataSet {
    private String name;
    private Integer age;
    private Long id;

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

    public Integer getAge() {
        return age;
    }

    public long getId() {
        if (id != null) {
            return id;
        }
        else return -1l;
    }

    @Override
    public String toString(){
        return "UserDataSet: [ id: " +  getId() + " name: " + getName() +  " age: " + getAge() + "]";
    }

}
