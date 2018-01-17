package base;

public class NewUser extends UserDataSet {
    private String Phone;

    public NewUser() {
        super();
    }


    public NewUser(String name, int age, String phone) {
        super(name, age);
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    @Override
    public String toString() {

        return super.toString() + "Phone: " + getPhone();
    }
}
