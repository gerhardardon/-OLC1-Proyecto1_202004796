# Manual Tecnico EXREGAN📚

## Descripcion del proyecto 📱
El curso de Organización de Lenguajes y Compiladores 1, perteneciente a la Facultad de Ingeniería de la Universidad de San Carlos de Guatemala, requiere que usted, como conocedor en la construcción de analizadores Léxico y Sintáctico, cree un
sistema que sea capaz de realizar el Método del Árbol y el Método de Thompson, para que los estudiantes puedan verificar que las respuestas de las tareas y exámenes del curso son correctas. Este aplicativo, requiere de las funciones que se abordan en la Sección 4, y requiere que las expresiones regulares sean ingresadas en notación
polaca o prefija.

## Requisitos 🖥

### Requisitos de hardware 📱
- Sistema operativo: Windows 7 o superior, MacOS 10.12 o superior, o una distribución de Linux actualizada.
- Procesador: Intel Core i3 o superior, o un procesador AMD equivalente.
- RAM: 4 GB o más.
- Espacio en disco duro: 500 MB o más de espacio libre en el disco duro.
- Resolución de pantalla: 1024 x 768 píxeles o superior.

### Requisitos generales 🙍‍♂️
- Conocimiento de Metodo del Arbol
- Conocimiento de Metodo de Thompson
- Conocimiento general de Java
- Uso y manejo de estructuras de datos

### Estructuras utilizadas 🔀
- Arraylist 
- Hash maps
- Stacks
- Lista Simple Doblemente Enlazada (propia)
- Lista Circular Doblemente Enlazada (propia)
- Arbol (propio)

### Herramientas utilizadas para el desarrollo 🛠
- jFlex full 1.7.0
- Java cup -11b

En estas herramientas se describio el alfabeto que se utilizaria en el programa, para el *analisis sintactico* se utilizó la herramienta flex, en donde se definio el alfabeto, ademas
de recuperarse de errores lexicos.
Para el *analisis lexico* se utilizo la herramienta de cup, en donde con el uso de la gramatica encontrada en este repositorio como *Gramatica.md* se pudo validar el flujo de 
la gramatica del programa por medio de los terminales y los no terminales, junto con sus producciones, ademas con el apartado de parser code se pudo implementar el Metodo Del Arbol 
a las partes de declaracion de gramatica dentro del archivo, en donde se analizaban las expresiones presentes para asi poder generar su tabla de siguientes, tabla de transiciones y 
tambien su AFD

## Nodo Utilizado para el arbol
Este nodo se utilizó para guardar el arbol sintactico del programa y poder realizar las tablas 
```java
public class Nodo {

    public Nodo hijoIzq;
    public Nodo hijoDer;
    public String valor;
    public int idNodo;
    public int idHoja;
    public boolean anulable;
    public String primero;
    public String ultimo;

    public Nodo(Nodo hijoIzq, Nodo hijoDer, String valor, int idNodo, int idHoja, boolean anulable, String primero, String ultimo) {
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.valor = valor;
        this.idNodo = idNodo;
        this.idHoja = idHoja;
        this.anulable = anulable;
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public int getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(int idHoja) {
        this.idHoja = idHoja;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public String getPrimero() {
        return primero;
    }

    public void setPrimero(String primero) {
        this.primero = primero;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }

    public String getCodigoInterno() {
        String etiqueta;
        if (hijoIzq == null && hijoDer == null) {
            etiqueta = "nodo" + idNodo + " [ label =\"" + valor + "\n\nfirst: " + primero + "\nlast: " + ultimo + "\nan: " + anulable + "\nhoja: " + idHoja + "\"]; \n";
        } else {
            etiqueta = "nodo" + idNodo + " [ label =\"" + valor + "\n\nfirst: " + primero + "\nlast: " + ultimo + "\nan: " + anulable + "\"]; \n";
        }
        if (hijoIzq != null) {
            etiqueta = etiqueta + hijoIzq.getCodigoInterno()
                    + "nodo" + idNodo + "->nodo" + hijoIzq.idNodo + "\n";
        }
        if (hijoDer != null) {
            etiqueta = etiqueta + hijoDer.getCodigoInterno()
                    + "nodo" + idNodo + "->nodo" + hijoDer.idNodo + "\n";
        }
        return etiqueta;
    }
}
```
En este nodo se iran guardando la informacion mas importante de cada una de las hojas, tales como:
- primeros y ultimos
- anulabilidad
- numero de nodo
- numero de hoja

Con esta informacion se proceden a aplicar las reglas para la crecaion de primeros y ultimos, ademas de la anulabilidad.

### Reglas para primeros y ultimos 0️⃣-9️⃣
Las reglas de primeros y últimos son una parte fundamental del algoritmo de construcción de árboles de decisión. Estas reglas determinan cómo se dividen los nodos del árbol y qué características se utilizan para tomar esas decisiones.

Las reglas de primeros y últimos se definen como sigue:

🟩Regla de primeros: esta regla indica que la primera característica utilizada para dividir un nodo debe ser aquella que maximice la ganancia de información o reduzca la entropía de las clases. La entropía mide la impureza de las clases en un conjunto de datos, y la ganancia de información se refiere a la cantidad de información que se gana al dividir un nodo en subconjuntos.

🟥Regla de últimos: esta regla indica que una vez que se ha elegido la primera característica para dividir un nodo, se deben considerar las demás características para determinar la siguiente mejor división. Esto se hace de manera iterativa, evaluando cada característica en orden hasta encontrar la que produzca la mayor ganancia de información o reducción de la entropía.

### Reglas de anulabilidad
Las reglas de anulabilidad, también conocidas como reglas de nulabilidad, son un conjunto de reglas que se utilizan en el modelado de datos para determinar si un atributo o campo puede tener un valor nulo o vacío en una tabla de base de datos.

### Tabla de siguientes 
Para esta tabla se utilizó una Hashmap nativa de java 
```java
//HASH TABLE SIGIENTES------------------------------------------------------
    public static HashMap<String, String> tablaSiguientes = new HashMap<String, String>();
```
En donde en cada concatenacion, * y + se iban creando las siguientes posiciones "sigPos" segun las reglas de la tabla de siguientes, esta Hashmap genera un archivo .dot
en el cual se crea una tabla de siguientes por medio de la herramienta graphviz

### Tabla de Transiciones 
Para esta tabla se utilizaron mas estructuras devido a su complejidad, un resumen de ellas son:
```java
//EDD UTILES PARA TRANSICIONES-------------------------------------------
    public static ArrayList<String> arrayId = new ArrayList<String>(); //sym
    public static ArrayList<String> sigposEvaluar = new ArrayList<String>(); //sigpos a evaluar
    public static HashMap<String, String> hashEstados = new HashMap<String, String>();// sigpos -> S
    public static HashMap<String, String> hashAux = new HashMap<String, String>();// numHoja -> sigpos
    public static int numEstado = 0;
    public static ListaSimple ls =new ListaSimple();
```
En las cuales se hace todo el calculo de las tablas de transicion para poder generar un archivo .dot para ser visalizado por medio de graphviz.
La informacion de esta tabla esta almacennada en una Lista Simple Doblemente Enlazada

### Lista Enlazada Transiciones 
En ella se guarda la tabla de trancisiones y tiene atributos como:
- estado inicial
- simbolo de transicion
- siguientes posiciones
- estado de transicion

Ademas de los metodos:
- constructor
- insertar
- imprimir
- transicionesDot
```java
public class ListaSimple {

    public nodoS primero = null;
    public nodoS ultimo = null;

    public void insertar(String sInicial, String sym, String sigpos, String sFinal) {
        nodoS nuevo = new nodoS(sInicial, sym, sigpos, sFinal);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            nuevo.anterior = this.ultimo;
            nuevo.siguiente = this.primero;
            this.ultimo.siguiente = nuevo;
            this.primero.anterior = nuevo;
        }
        this.ultimo = nuevo;
    }

    public String imprimir() {
        String txt="";
        nodoS aux = this.primero;
        while (aux != null) {
            txt += "<tr><td>" + aux.sInicial + "</td><td>" + aux.sym + "</td><td>" + aux.sigpos + "</td><td>" + aux.sFinal + "</td></tr>";
                
            while (aux.siguiente == this.primero) {
                return txt;
            }
            aux = aux.siguiente;
        }
        return txt;
    }

    public void transicionesDot(String nombre) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombre + "_transiciones.dot");
            pw = new PrintWriter(fichero);
            String texto = """
                         digraph tabla {
                             node [shape=plaintext]
                             tabla [label=<<table border="1" cellspacing="0">
                                 <tr><td bgcolor="#c1e1c1"><b> Estado </b></td><td bgcolor="#c1e1c1"><b> Sym </b></td><td bgcolor="#c1e1c1"><b> Sigpos </b></td><td bgcolor="#c1e1c1"><b> Estado </b></td></tr>
                                 
                         """;
            
            texto += this.imprimir();
            
            texto += "</table>>];}";
            System.out.println(texto);
            pw.println(texto);

        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo" + e);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            //dirección del archivo dot
            String fileInputPath = nombre + "_transiciones.dot";
            //dirección donde se creara la magen
            String fileOutputPath = "TRANSICIONES_202004796\\"+nombre + "_transiciones.jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
            System.out.println("######listo, transiciones hecho###############");

        } catch (Exception e) {

        }

    }
    
    public void eliminar(){
        this.primero=null;
        this.ultimo=null;
    }

}
```

