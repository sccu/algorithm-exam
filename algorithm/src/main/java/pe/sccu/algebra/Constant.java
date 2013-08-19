package pe.sccu.algebra;

public class Constant extends Expr {

    static final Constant ZERO = new Constant(0);
    static final Constant ONE = new Constant(1);
    static final Constant PI = new Constant(Math.PI);
    static final Constant E = new Constant(Math.E);

    static Expr create(double c) {
        if (same(ZERO, c)) {
            return ZERO;
        } else if (same(ONE, c)) {
            return ONE;
        } else if (same(PI, c)) {
            return PI;
        } else if (same(E, c)) {
            return E;
        } else {
            return new Constant(c);
        }
    }

    static boolean same(Expr expr, Constant c) {
        return (expr == c)  || same(expr, c.getValue());
    }

    static boolean same(Expr expr, double num) {
        if (!(expr instanceof Constant)) {
            return false;
        }

        double val = ((Constant) expr).getValue();
        return Math.abs(val - num) < Double.MIN_VALUE * 10;
    }

    private final double c;

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
        } else if (same(this, Math.PI)) {
            return "PI";
        } else if (same(this, Math.E)) {
            return "e";
        } else {
            return String.valueOf(c);
        }
    }
}
