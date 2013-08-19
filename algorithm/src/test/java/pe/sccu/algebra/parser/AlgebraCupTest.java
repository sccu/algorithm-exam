package pe.sccu.algebra.parser;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;

import java_cup.runtime.Symbol;

import org.codehaus.plexus.util.StringInputStream;
import org.junit.Test;

import pe.sccu.algebra.Expr;

public class AlgebraCupTest {

    private static final double DELTA = 1e-14;
    private final AlgebraLex lex = new AlgebraLex((Reader) null);
    private final AlgebraCup parser = new AlgebraCup(lex);

    @Test
    public void testAdd() throws Exception {
        lex.yyreset(new StringReader("3.4 + 4.5"));
        Symbol parse = parser.parse();
        assertEquals("7.9", ((Expr) parse.value).toString());
    }

    @Test
    public void testCombined() throws Exception {
        AlgebraCup parser = new AlgebraCup(new AlgebraLex(new StringInputStream("3 * 2 + 4 * 5")));
        lex.yyreset(new StringReader("3 * 2 + 4 * 5"));
        Symbol parse = parser.parse();
        assertEquals(26, Double.parseDouble(((Expr) parse.value).toString()), DELTA);
    }

    @Test
    public void testExponential() throws Exception {
        lex.yyreset(new StringReader("2 * x ^ 3"));
        Symbol symbol = parser.debug_parse();
        assertEquals("2 * x^3", ((Expr) symbol.value).toString());
    }

    @Test
    public void testMultiply() throws Exception {
        lex.yyreset(new StringReader("3.4 * 4.5"));
        Symbol parse = parser.parse();
        assertEquals(15.3, Double.parseDouble(((Expr) parse.value).toString()), DELTA);
    }

    @Test
    public void testNumber() throws Exception {
        lex.yyreset(new StringReader("3.45"));
        Symbol parse = parser.parse();
        assertEquals("3.45", ((Expr) parse.value).toString());
    }

    @Test
    public void testParens() throws Exception {
        lex.yyreset(new StringReader("(3.45)"));
        Symbol symbol = parser.parse();
        assertEquals("3.45", ((Expr) symbol.value).toString());

        lex.yyreset(new StringReader("3 * (2 + 4) * 5"));
        symbol = parser.parse();
        assertEquals("90", ((Expr) symbol.value).toString());
    }

    @Test
    public void testVariable() throws Exception {
        lex.yyreset(new StringReader("2 * xx1"));
        Symbol symbol = parser.debug_parse();
        assertEquals("2 * xx1", ((Expr) symbol.value).toString());
    }

}
