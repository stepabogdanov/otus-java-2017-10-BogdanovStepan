public enum Notes {


    NOTE100(100),
    NOTE200(200),
    NOTE500(500),
    NOTE1000(1000),
    NOTE2000(2000),
    NOTE5000(5000);

    private int nominal;

    Notes (int nominal) {
        this.nominal = nominal;
    }

    public int getNominal () {
        return nominal;
    }



}
