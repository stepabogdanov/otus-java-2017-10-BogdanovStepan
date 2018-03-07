public class AMT {
    Cashbox cashbox;

    public AMT() {
        this.cashbox = new Cashbox();
    }

    public void putMoney(Notes notes, int amountOfNotes) {
        cashbox.putToCashbox(notes, amountOfNotes);
    }

    public int showMoney() {
        return cashbox.show();
    }

}
