public class AMT {
    Cashbox cashbox;

    public AMT() {
        this.cashbox = new Cashbox();
    }

    public void putMoney(int amountMoney) {
        cashbox.putToCashbox(amountMoney);
    }

    public int showMoney() {
        return cashbox.show();
    }
}
