public class AMT {
     private int publicAccount;
     Cashbox cashbox = new Cashbox();


    public int getInfoAmountMoneyInAMT () {

        System.out.println(publicAccount);
        return publicAccount;
    }

    public void putMoney (Notes notes) {

        publicAccount +=notes.getNominal();
        cashbox.acceptMoney(notes,1);

    }

    public void GetInFoCashbox () {

        cashbox.getInfoMoneyCell()
    }






}
