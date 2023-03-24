# Gamatica utilizada para el proyecto 📚
```
INI::=CONTENIDO;

CONTENIDO::= llaveAbrir SENTENCIAS llaveCerrar;

SENTENCIAS::=   SENTENCIAS CONJUNTOS 
                |SENTENCIAS comentario
                |SENTENCIAS comentarioMult
                |SENTENCIAS ER
                |SENTENCIAS DELIMITADORES
                |SENTENCIAS ENTRADA
                |SENTENCIAS error
                |CONJUNTOS
                |COMENTARIOS
                |DELIMITADORES
                |ENTRADA
                |comentario
                |comentarioMult;

CONJUNTOS::=    conj dosPuntos tld flecha notacion pComa;

ER::=           tld flecha NOTACIONER pComa

NOTACIONER::=   punto NOTACIONER:a NOTACIONER
                |or NOTACIONER NOTACIONER
                |asterisco NOTACIONER
                |suma NOTACIONER
                |interrogacion NOTACIONER
                |erComillas
                |erLlaves
                |simboloEspecial;

DELIMITADORES::= porcentaje porcentaje;

ENTRADA::=      tld dosPuntos lexemaEntrada pComa;
```
