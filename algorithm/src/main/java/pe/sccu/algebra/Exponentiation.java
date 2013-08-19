package pe.sccu.algebra;

public class Exponentiation extends Expr {

    static Expr create(Expr base, Expr exponent) {
        return new Exponentiation(base, exponent);
    }

    private final Expr base;
    private final Expr exponent;

    private Exponentiation(Expr base, Expr exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public Expr derive(String var) {
        return exponent.mul(base.exp(exponent.add(Expr.factor(-1)))).mul(base.derive(var))
                .add(mul(Expr.ln(base).exp(Expr.factor(-1)).mul(exponent.derive(var))));
    }

    @Override
    public String toString() {
        String baseString = null;
        if (base instanceof Sum || base instanceof Product) {
            baseString = "(" + base + ")";
        } else {
            baseString = base.toString();
        }
        String exponentString = null;
        if (exponent instanceof Sum || exponent instanceof Product) {
            exponentString = "(" + exponent + ")";
        } else {
            exponentString = exponent.toString();
        }

        return baseString + "^" + exponentString;
    }

}
