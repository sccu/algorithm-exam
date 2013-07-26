package pe.sccu.algebra;

public class Variable extends Expr {

    static Variable create(String var) {
        return new Variable(var);
    }

    private final String var;

    private Variable(String var) {
        this.var = var;
    }

    @Override
    public Expr derive(String aVar) {
        return var.equals(aVar) ? Constant.create(1) : Constant.create(0);
    }

    @Override
    public String toString() {
        return var;
    }

}
