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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        if (age != null) {
            this.age = age;
        }
        else this.age = null;
    }

    @Override
    public String toString(){
        return "UserDataSet: [ id: " +  getId() + " name: " + getName() +  " age: " + getAge() + "]";
    }

}
