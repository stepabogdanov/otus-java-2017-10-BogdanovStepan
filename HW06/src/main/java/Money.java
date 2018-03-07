/**
 * Created by step on 07.03.2018.
 */
public class Money implements Acceptable {
//
//    private static final int note50 = 50;
//    private static final int note100 = 100;
//    private static final int note200 = 200;
//    private static final int note500 = 500;
//    private static final int note1000 = 1000;
//    private static final int note2000 = 2000;
//    private static final int note5000 = 5000;
    Notes notes;
    private int amount;

    public int getAmount () {
        return amount;
    }
    @Override
    public Money setNotes(Notes notes) {
        this.notes = notes;
        return this;
    }

    @Override
    public Money setAmount(int amount) {
        this.amount += amount * notes.getNominal();
        return  this;
    }

    @Override
    public String toString() {
        return "Money: " + this.getAmount();
    }
}
