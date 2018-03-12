public class ATM {
    Cashbox cashbox;

    public ATM() {
        this.cashbox = new Cashbox();
    }

    public void putMoney(Money money) {
        cashbox.putToCashBox(money);
    }

    public void takeMoney (Money money) {
        cashbox.takeFromCashBox(money);
    }

    public int showMoney() {
        return cashbox.show();
    }

}
