package pe.sccu.algebra.parser;

import java.io.IOException;

import java_cup.runtime.Symbol;

import org.codehaus.plexus.util.StringInputStream;
import org.junit.Test;

public class AlgebraLexTest {

	@Test
	public void test() throws IOException {
		AlgebraLex lex = new AlgebraLex(new StringInputStream("3+4"));
		Symbol token = lex.next_token();
		System.out.println("TOKEN:" + token.value);
		token = lex.next_token();
		System.out.println("TOKEN:" + token.value);
		token = lex.next_token();
		System.out.println("TOKEN:" + token.value);
		token = lex.next_token();
		System.out.println("TOKEN:" + token.value);
	}

}
