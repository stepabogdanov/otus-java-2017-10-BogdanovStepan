public class Main {
    public static void main(String[] args) {
        AMT amt = new AMT();
        amt.putMoney(20);
        amt.putMoney(40);
        System.out.println(amt.showMoney());
    }
}
