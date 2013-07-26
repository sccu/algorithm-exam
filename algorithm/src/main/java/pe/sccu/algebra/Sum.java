package pe.sccu.algebra;

public class Sum extends Expr {

    private final Expr augend;
    private final Expr addend;

    Sum(Expr augend, Expr addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Expr derive(String var) {
        return augend.derive(var).add(addend.derive(var));
    }

    @Override
    public String toString() {
        return augend.toString() + " + " + addend.toString();
    }
}
