public class Main {
    public static void main(String[] args) {
        AMT amt = new AMT();
        amt.putMoney(Notes.NOTE100, 2);
        amt.putMoney(Notes.NOTE200, 1);
        System.out.println(amt.showMoney());

        //System.out.println(Notes.NOTE100);
    }
}
