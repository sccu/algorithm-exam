package pe.sccu.algebra;

public abstract class Expr {
    public static Expr factor(double num) {
        return Constant.create(num);
    }

    public static Expr factor(String var) {
        return Variable.create(var);
    }

    public static Expr ln(Expr expr) {
        if (Constant.same(expr, 1)) {
            return Constant.create(0);
        } else if (Constant.same(expr, Constant.E.getValue())) {
            return Constant.create(1);
        } else {
            return NaturalLog.create(expr);
        }
    }

    public Expr add(Expr other) {
        if ((this instanceof Constant) && (other instanceof Constant)) {
            return Constant.create(((Constant) this).getValue() + ((Constant) other).getValue());
        } else if (Constant.same(this, 0)) {
            return other;
        } else if (Constant.same(other, 0)) {
            return this;
        } else {
            return new Sum(this, other);
        }
    }

    public abstract Expr derive(String var);

    public Expr exp(Expr exponent) {
        if (Constant.same(this, 0) || Constant.same(this, 1) || Constant.same(exponent, 1)) {
            return this;
        } else if (Constant.same(exponent, 0)) {
            return Expr.factor(1);
        } else if (this instanceof Constant && exponent instanceof NaturalLog) {
            return ((NaturalLog) exponent).getExpression().exp(Expr.ln(this));
        } else {
            return Exponentiation.create(this, exponent);
        }
    }

    public Expr exp(Expr exponent) {
        return new Exponentiation(this, exponent);
    }

    public Expr mul(Expr other) {
        if ((this instanceof Constant) && (other instanceof Constant)) {
            return Constant.create(((Constant) this).getValue() * ((Constant) other).getValue());
        } else if (Constant.same(this, 0) || Constant.same(other, 0)) {
            return Constant.create(0);
        } else if (Constant.same(this, 1)) {
            return other;
        } else if (Constant.same(other, 1)) {
            return this;
        } else {
            return new Product(this, other);
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

}
