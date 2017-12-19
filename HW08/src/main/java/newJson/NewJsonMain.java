package newJson;

public class NewJsonMain {
    public static void main(String[] args) {
        MyJson myJson = new MyJson();
        OnePerson onePerson = new OnePerson();

        System.out.println(myJson.toJson(onePerson));
    }
}
