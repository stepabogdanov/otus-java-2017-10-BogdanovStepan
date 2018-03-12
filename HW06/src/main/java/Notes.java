public enum Notes {

    NOTE50(50),
    NOTE100(100),
    NOTE200(200),
    NOTE500(500),
    NOTE1000(1000),
    NOTE2000(2000),
    NOTE5000(5000);

    private int nominal;

    Notes (int p) {
        nominal = p;
    }

    public int getNominal () {
        return nominal;
    }



}
