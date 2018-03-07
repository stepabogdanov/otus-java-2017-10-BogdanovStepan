public class Cashbox {
    Money money;

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


    public void putToCashbox (Money money) {

        cellCash50 = money.getNotes().getNominal();
        this.amountMoney += money.getAmount();
    }

    public int show() {
        return amountMoney;
    }

    private void fillCells  (Money money) {
//        if
    }

}
