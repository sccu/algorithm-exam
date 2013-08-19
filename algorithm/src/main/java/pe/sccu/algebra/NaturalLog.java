package pe.sccu.algebra;

public class NaturalLog extends Expr {

    static Expr create(Expr expr) {
        return new NaturalLog(expr);
    }

    private final Expr expr;

    private NaturalLog(Expr expr) {
        this.expr = expr;
    }

    @Override
    public Expr derive(String var) {
        return expr.exp(Expr.factor(-1));
    }

    Expr getExpression() {
        return expr;
    }

    @Override
    public String toString() {
        return "ln(" + expr + ")";
    }

}
