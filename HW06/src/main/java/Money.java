import java.util.HashMap;
import java.util.Map;

/**
 * Created by step on 07.03.2018.
 */
public class Money implements Acceptable {

    private Notes notes;
    private Map<Notes, Integer> mapNotes = new HashMap<>();


    public Money() {
    }

    public Money(Map<Notes, Integer> mapNotes) {
        this.mapNotes = mapNotes;
    }

    public Map<Notes, Integer> getMapNotes () {
        return mapNotes;
    }

    @Override
    public Money setNotes(Notes notes) {
        mapNotes.put(notes, 0);
        this.notes = notes;
        return this;
    }

    @Override
    public Money setAmount(int amount) {
        mapNotes.put(notes, amount);
        return  this;
    }

    @Override
    public String toString() {
        return "Money: " + mapNotes;
    }
}
