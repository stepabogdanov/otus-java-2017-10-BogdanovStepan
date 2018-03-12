import java.util.Collections;

public class Cashbox {

    private int amountMoney;
    private Money money = new Money();

    public void putToCashBox(Money money) {
        this.money = addMoney(money);
        money.getMapNotes().forEach((k, v) -> {
            amountMoney += k.getNominal() * v;
        });
    }

    public void takeFromCashBox (Money money) {
        this.money = subMoney(money);
        money.getMapNotes().forEach((k,v) -> {
            amountMoney -= k.getNominal() * v;
        });
    }

    public int show() {
        return amountMoney;
    }

    @Override
    public String toString() {
        return "Money: " + amountMoney +  '\n' + money;
    }

    private Money addMoney(Money moneyToAdd) {
        moneyToAdd.getMapNotes().forEach((k,v) -> {
                money.getMapNotes().merge(k, v, (v1, v2 ) -> v2 += v1);
        }) ;
        return money;
    }

    private Money subMoney (Money moneyToSub) {
        moneyToSub.getMapNotes().forEach((k,v) -> {
            money.getMapNotes().merge(k, v, (v1, v2) -> v2 -= v1);
        });
        return money;
    }
}
