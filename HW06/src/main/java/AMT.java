public class AMT {
    Cashbox cashbox;

    public AMT() {
        this.cashbox = new Cashbox();
    }

    public void putMoney(Money money) {
        cashbox.putToCashbox(money);
    }

    public int showMoney() {
        return cashbox.show();
    }

}
