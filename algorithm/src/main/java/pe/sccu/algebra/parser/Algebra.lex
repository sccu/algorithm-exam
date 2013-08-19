
package pe.sccu.algebra.parser;

import java_cup.runtime.*;
import java.io.IOException;

import pe.sccu.algebra.Expr;
import static pe.sccu.algebra.parser.AlgebraSym.*;

%%

%class AlgebraLex

%unicode
%line
%column

// %public
%final
// %abstract

%cupsym pe.sccu.algebra.parser.AlgebraSym
%cup

%debug
%cupdebug

%init{
	// TODO: code that goes to constructor
%init}

%{
	private Symbol sym(int type)
	{
		return sym(type, yytext());
	}

	private Symbol sym(int type, Object value)
	{
		return new Symbol(type, yyline, yycolumn, value);
	}

	private void error()
	throws IOException
	{
		throw new IOException("illegal text at line = "+yyline+", column = "+yycolumn+", text = '"+yytext()+"'");
	}
%}

DIGIT       =   [:digit:]
NUM         =   {DIGIT}+([.]{DIGIT}+)?
PLUS        =   \+
MUL         =   \*
LPAREN      =   \(
RPAREN      =   \)
//VAR         =   [:alpha:][:alphanumeric:]*
VAR         =   [:jletter:][:jletterdigit:]*
WS          =   \r | \n | \r\n | [ \t\f]

%%

{NUM}       {   return sym(NUM, Expr.factor(Double.parseDouble(yytext()))); }
{VAR}       {   return sym(VAR, Expr.factor(yytext())); }
{PLUS}      {   return sym(PLUS); }
{MUL}       {   return sym(MUL); }
{LPAREN}    {   return sym(LPAREN); }
{RPAREN}    {   return sym(RPAREN); }
{WS}        {   /*IGNORE*/  }

