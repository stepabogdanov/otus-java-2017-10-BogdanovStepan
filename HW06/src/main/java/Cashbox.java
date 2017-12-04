import java.util.Map;
import java.util.stream.Stream;

public class Cashbox {
    Notes notes;
    private int size;
    private Map<Notes, Integer> sum;
    private int sum200;
    private int sum500;
    private int sum1000;
    private int sum2000;
    private int sum5000;

    public int getInfoMoneyCell(){
        System.out.println("Cell100: " + sum100 + );

    }

    public int getInfoMoneyCell(Notes note) {

        Stream.of(sum).

        if (note.getNominal() == 100) {
            return sum100;
        }
        if (note.getNominal() == 200) {
            return sum200;

        }if (note.getNominal() == 500) {
            return sum500;

        }if (note.getNominal() == 1000) {
            return sum1000;

        }if (note.getNominal() == 2000) {
            return sum2000;
        }

        if (note.getNominal() == 5000) {
            return sum5000;
        }
        return 0;
    }

    public void setMaxCellSize (int size) {

    }

    public void acceptMoney (Notes notesComing, int i) {

        if (notesComing.getNominal() == 100) {
            for ( int j = 0 ; j < i; j++ ) {
                sum100 ++;
            }
        }

    }
}
