import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by step on 07.03.2018.
 */
public class Money implements Acceptable {
    List<Notes> listNotes = new ArrayList<>();
    private int amount;
    private Notes notes;
    private int sum;

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
        this.amount = amount;
        for (int i =0; i<amount; i++) {
            listNotes.add(notes);
        }
        return  this;
    }

    @Override
    public String toString() {
        return "Money: " + sum + listNotes;
    }

    public Notes getNotes() {
        return notes;
    }
}
