public class Main {
    public static void main(String[] args) {
        AMT a = new AMT();
        a.getInfoAmountMoneyInAMT();


        a.putMoney(Notes.NOTE500);
        a.putMoney(Notes.NOTE500);
        a.putMoney(Notes.NOTE500);
        a.putMoney(Notes.NOTE500);

        a.getInfoAmountMoneyInAMT();
    }
}
