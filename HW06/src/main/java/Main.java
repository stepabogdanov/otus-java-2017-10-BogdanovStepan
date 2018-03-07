public class Main {
    public static void main(String[] args) {
        AMT amt = new AMT();

        amt.putMoney(new Money().setNotes(Notes.NOTE200).setAmount(1).setNotes(Notes.NOTE5000).setAmount(2));

        System.out.println(amt.showMoney());

        //System.out.println(Notes.NOTE100);
    }
}
