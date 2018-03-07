public class Cashbox {

    private final static int CASH10 = 10;
    private final static int CASH50 = 50;
    private final static int CASH100 = 100;

    private int amountMoney;

    public Cashbox() {
    }

    public Cashbox(int amountMoney) {

        this.amountMoney = amountMoney;
    }

    public void putToCashbox (Notes notes,  int amountOfNotes) {
        this.amountMoney += notes.getNominal() * amountOfNotes;
    }

    public int show() {
        return amountMoney;
    }
}
