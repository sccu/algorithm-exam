package pe.sccu.algebra;

public class Product extends Expr {

    private final Expr multiplier;
    private final Expr multiplicand;

    Product(Expr multiplier, Expr multiplicand) {
        this.multiplier = multiplier;
        this.multiplicand = multiplicand;
    }

    @Override
    public Expr derive(String var) {
        return multiplier.mul(multiplicand.derive(var)).add(multiplier.derive(var).mul(multiplicand));
    }

    @Override
    public String toString() {
        String multiplierString = null;
        if (multiplier instanceof Sum) {
            multiplierString = "(" + multiplier.toString() + ")";
        } else {
            multiplierString = multiplier.toString();
        }

        String multiplicandString = null;
        if (multiplicand instanceof Sum) {
            multiplicandString = "(" + multiplicand.toString() + ")";
        } else {
            multiplicandString = multiplicand.toString();
        }
        return multiplierString + " * " + multiplicandString;
    }

}
