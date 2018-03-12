import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Map<Notes, Integer> map =  new HashMap<>();
        map.put(Notes.NOTE2000, 1);
        atm.putMoney(new Money().setNotes(Notes.NOTE200).setAmount(1).setNotes(Notes.NOTE5000).setAmount(3));
        atm.putMoney(new Money().setNotes(Notes.NOTE100).setAmount(5).setNotes(Notes.NOTE5000).setAmount(1));
        System.out.println(atm.cashbox);
        atm.takeMoney(new Money().setNotes(Notes.NOTE500).setAmount(1).setNotes(Notes.NOTE200).setAmount(1));
        System.out.println(atm.cashbox);

        //System.out.println(Notes.NOTE100);
    }
}
