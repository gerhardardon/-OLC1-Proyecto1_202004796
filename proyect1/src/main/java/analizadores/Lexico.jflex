package analizadores;
import java_cup.runtime.*;
import proyect1.menu;
%%


%class Lexico
%cupsym sym
%cup 
%public
%unicode
%line 
%column
%ignorecase
%char
%full
%ignorecase



%init{ 
    yyline = 1; 
    yychar = 1; 
%init}

letra  = [a-zA-Z]
numero = [0-9]
blancos = [ \r\t\n\f]
simbolo = [\!\"\#\$\%\&\'\(\)\*\,\-\.\/\:\<\>\=\?\@\[\]\_\{\}\|\~\^\\]
simboloEspecial = (\\\"|\\n|\\\')


flecha = "->"
notacion = ({letra}{simbolo}{letra}|{numero}{simbolo}{numero})+
tld = {letra}({letra}|{numero}|\_)*
erComillas = ([\"]{simbolo}[\"]|[\"]{letra}[\"]|[\"]{numero}[\"]|[\"][\"])
erLlaves = \{[a-zA-Z0-9]+\}
lexemaEntrada = ([\"]{letra}([^\"])+[\"])

comentario = (\/\/.+\n)
comentarioMult = ("<""!" [^\|]* "!"">")


%%

"{" {
                    System.out.println("Token:<llaveAbrir> lexema:"+yytext());
                    return new Symbol(sym.llaveAbrir, yycolumn, yyline, yytext()); 
                    }
"}" {
                    System.out.println("Token:<llaveCerrar> lexema:"+yytext());
                    return new Symbol(sym.llaveCerrar, yycolumn, yyline, yytext()); 
                    }
":" {
                    System.out.println("Token:<dosPuntos> lexema:"+yytext());
                    return new Symbol(sym.dosPuntos, yycolumn, yyline, yytext()); 
                    }
"%" {
                    System.out.println("Token:<porcentaje> lexema:"+yytext());
                    return new Symbol(sym.porcentaje, yycolumn, yyline, yytext()); 
                    }
";" {
                    System.out.println("Token:<pComa> lexema:"+yytext());
                    return new Symbol(sym.pComa, yycolumn, yyline, yytext()); 
                    }
"." {
                    System.out.println("Token:<punto> lexema:"+yytext());
                    return new Symbol(sym.punto, yycolumn, yyline, yytext()); 
                    }
"|" {
                    System.out.println("Token:<or> lexema:"+yytext());
                    return new Symbol(sym.or, yycolumn, yyline, yytext()); 
                    }
"*" {
                    System.out.println("Token:<asterisco> lexema:"+yytext());
                    return new Symbol(sym.asterisco, yycolumn, yyline, yytext()); 
                    }
"+" {
                    System.out.println("Token:<suma> lexema:"+yytext());
                    return new Symbol(sym.suma, yycolumn, yyline, yytext()); 
                    }
"?" {
                    System.out.println("Token:<interrogacion> lexema:"+yytext());
                    return new Symbol(sym.interrogacion, yycolumn, yyline, yytext()); 
                    }
"CONJ" {
                    System.out.println("Token:<conj> lexema:"+yytext());
                    return new Symbol(sym.conj, yycolumn, yyline, yytext()); 
                    }

{flecha} {
                    System.out.println("Token:<flecha> lexema:"+yytext());
                    return new Symbol(sym.flecha, yycolumn, yyline, yytext()); 
                    }
{notacion} {
                    System.out.println("Token:<notacion> lexema:"+yytext());
                    return new Symbol(sym.notacion, yycolumn, yyline, yytext()); 
                    }
{tld} {
                    System.out.println("Token:<tld> lexema:"+yytext());
                    return new Symbol(sym.tld, yycolumn, yyline, yytext()); 
                    }
{erComillas} {
                    System.out.println("Token:<erComillas> lexema:"+yytext());
                    return new Symbol(sym.erComillas, yycolumn, yyline, yytext()); 
                    }
{erLlaves} {
                    System.out.println("Token:<erLlaves> lexema:"+yytext());
                    return new Symbol(sym.erLlaves, yycolumn, yyline, yytext()); 
                    }
{simboloEspecial} {
                    System.out.println("Token:<simboloEspecial> lexema:"+yytext());
                    return new Symbol(sym.simboloEspecial, yycolumn, yyline, yytext()); 
                    }
{lexemaEntrada} {
                    System.out.println("Token:<lexemaEntrada> lexema:"+yytext());
                    return new Symbol(sym.lexemaEntrada, yycolumn, yyline, yytext()); 
                    }
{comentario} {
                    System.out.println("Token:<comentario> lexema:"+yytext());
                    return new Symbol(sym.comentario, yycolumn, yyline, yytext()); 
                    }
{comentarioMult} {
                    System.out.println("Token:<comentarioMult> lexema:"+yytext());
                    return new Symbol(sym.comentarioMult, yycolumn, yyline, yytext()); 
                    }
{blancos} {}

.                   {System.out.println("ERROR LEXICO : "+yytext()+" Linea "+(yyline+1)+" Columna "+yycolumn);
                        listaErrores error = new listaErrores(yytext(),yyline+1,yycolumn,"lexico");
                        menu.err.add(error);}