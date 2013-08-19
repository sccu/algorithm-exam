package pe.sccu.algebra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testAdd() {
        // add
        assertEquals("3", Expr.factor(3).toString());
        assertEquals("8", Expr.factor(3).add(Expr.factor(5)).toString());
    }

    @Test
    public void testDerive() {
        // derive
        assertEquals("3 + 2 * x + 2 * (x + 5)",
                Expr.factor(3).add(Expr.factor(2).mul(Expr.factor("x"))).mul(Expr.factor("x").add(Expr.factor(5)))
                        .derive("x").toString());
    }

    @Test
    public void testExp() {
        Expr x_3 = Expr.factor("x").exp(Expr.factor(3));
        assertEquals("3 * x^2", x_3.derive("x").toString());
        System.out.println(x_3.derive("x").derive("x"));

        System.out.println(Constant.E.exp(Expr.factor("x")).derive("x"));
        System.out.println(Constant.E.exp(Expr.ln(Expr.factor("x").exp(Expr.factor(2)))).derive("x"));
        System.out.println(Constant.E.exp(Expr.ln(Expr.factor("x"))).derive("x").derive("x"));

    }

    @Test
    public void testMultiply() {
        // multiply
        assertEquals("3 * x", Expr.factor(3).mul(Expr.factor("x")).toString());
        assertEquals("12", Expr.factor(3).mul(Expr.factor(4)).toString());
        assertEquals("0", Expr.factor(0).mul(Expr.factor(4)).toString());
        assertEquals("0", Expr.factor(3).mul(Expr.factor(0)).toString());
        assertEquals("0", Expr.factor(0).mul(Expr.factor("x")).toString());
        assertEquals("0", Expr.factor("y").mul(Expr.factor(0)).toString());
        assertEquals("x", Expr.factor(1).mul(Expr.factor("x")).toString());
        assertEquals("y", Expr.factor("y").mul(Expr.factor(1)).toString());

        // factor
        assertEquals("(3 + 2 * x) * (x + 5)",
                Expr.factor(3).add(Expr.factor(2).mul(Expr.factor("x"))).mul(Expr.factor("x").add(Expr.factor(5)))
                        .toString());

    }
}
