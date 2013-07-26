package pe.sccu.algebra;

public class Constant extends Expr {

    private static final Expr ZERO = new Constant(0);
    private static final Expr ONE = new Constant(1);

    static Expr create(double c) {
        if (same(ZERO, c)) {
            return ZERO;
        } else if (same(ONE, c)) {
            return ONE;
        } else {
            return new Constant(c);
        }
    }

    static boolean same(Expr expr, double num) {
        if (!(expr instanceof Constant)) {
            return false;
        }

        double val = ((Constant) expr).getValue();
        return Math.abs(val - num) < Double.MIN_VALUE * 10;
    }

    private double c;

    private Constant(double c) {
        this.c = c;
    }

    @Override
    public Expr derive(String var) {
        return ZERO;
    }

    double getValue() {
        return c;
    }

    @Override
    public String toString() {
        long l = Math.round(c);
        if (same(this, l)) {
            return String.valueOf(l);
        } else {
            return String.valueOf(c);
        }
    }

}
