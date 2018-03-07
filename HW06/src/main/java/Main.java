public class Main {
    public static void main(String[] args) {
        AMT amt = new AMT();
        Money money = new Money().setNotes(Notes.NOTE200).setAmount(3).setNotes(Notes.NOTE500).setAmount(5);
//        amt.putMoney(new Money().setNotes(Notes.NOTE200).setAmount(1).setNotes(Notes.NOTE5000).setAmount(2));

        System.out.println(money);

        //System.out.println(Notes.NOTE100);
    }
}
