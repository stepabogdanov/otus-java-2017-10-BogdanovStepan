public class Cash {

    private Cashbox cashbox;


    Cash (int amountOfNotes) {

        if (amountOfNotes % 100 == 0) {
            cashbox.acceptMoney(Notes.NOTE100, amountOfNotes/100);
        }

    }

}
