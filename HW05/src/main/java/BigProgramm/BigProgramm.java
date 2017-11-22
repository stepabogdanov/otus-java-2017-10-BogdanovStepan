package BigProgramm;

// класс для тестирования
public class BigProgramm {
    int a, b;

    BigProgramm(int a, int b){

        this.a = a;
        this.b = b;
    }

    public  int sum() {
        return a + b ;
    }

    public int dev() {
        return a / b;
    }

    public int sub() {
        return a - b;
    }

    public int multy() {
        return a * b;
    }
}
