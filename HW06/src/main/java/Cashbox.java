public class Cashbox {

    private int cellCash50;
    private int cellCash100;
    private int cellCash200;
    private int cellCash500;
    private int cellCash1000;
    private int cellCash2000;
    private int cellCash5000;

    private int amountMoney;

    public Cashbox() {
    }

    public Cashbox(int amountMoney) {

        this.amountMoney = amountMoney;
    }

    public void putToCashbox (Money money) {
        this.amountMoney += money.getAmount();
    }

    public int show() {
        return amountMoney;
    }
}
