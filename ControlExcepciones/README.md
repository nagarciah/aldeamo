Control de Excepciones y Logging
===========================

Ejercicio 1: La necesidad del log
-------------
Tomando como base el archivo ``/log/Ejercicio1.log``, determine que pasó con la aplicación: inició correctamente o no? Si falló, 
identifique la causa.


Ejercicio 2: System.out y System.err no son loggers
-------------
Revise el código de la clase ``Ejercicio2`` y estime los cambios y el tiempo necesarios para hacer que el mensaje que se envía al 
log con ``System.out.println``` y ``System.err.println``, pueda ser enviado también a un archivo, a una base de datos y a 
una cola JMS. Imagine que tiene que hacer lo mismo en 200 clases y estime nuevamente.

El registro de eventos o logging es una característica no funcional indispensable en toda aplicación, sin importar su tamaño, lenguaje, 
sexo, color de piel... y como es una necesidad común, existen soluciones comunes: librerías de logging altamente configurables que 
ofrecen gran flexibilidad para cambiar la forma en que se hace el registro de eventos o logging, sin necesidad de tener que recompilar 
la aplicación. De esta forma, por ejemplo, se puede cambiar el tipo de almacenamiento con le que se guarda el log, de un archivo a una 
base de datos, una cola JMS o cualquier que imaginemos, con sólo ajustar la configuración del logger. Algunas de las soluciones más 
conocidas y utilizadas son Log4J, Apache Commons Logging, Java Logging API, Simple Log For Java (SL4J) y Logback.

Ejercicio 3 (Buena Práctica): Utilizando un logger: Java Logging API
-------------
Desde la versión 1.4 de Java SE, existe el paquete `java.util.logging` que ofrece las funcionalidades de registro de eventos a través 
de la clase `java.util.logging.Logger`. La mejor forma de obtener un logger utilizando este API, es la que se muestra en la 
clase `Ejercicio 3`. Porque esta es la mejor forma? 

- Logger log: Es una variable declarada a nivel de clase, por lo que es accesible desde cualquier método. 
- private: Ninguna otra clase debería tener acceso al logger de esta clase o se podría mezclar la información de cada clase y seria más 
dificil saber cual es la clase que produjo el mensaje (o error). Un error común es declarar un logger global usado por todas las clases. 
En ese escenario, todos los mensajes aparecerían como provenientes de una única clase (la que posee el logger) e impide que se puedan 
configurar niveles de log independientes por cada clase o paquete, por ejemplo, para depurar sólo una clase o paquete. 
- final: El logger no debe ser modificado por ningún método de la clase. Su construcción es costosa y por eso debe crearse una sóla vez
- static: La construcción del logger es costosa en términos de procesamiento y por eso debe crearse una sóla vez. Sin embargo hay una 
excepción a esta regla cuando se usan loggers en entornos con classloader compartidos como en contenedores de servlets o JavaEE en cuyo 
caso el log podría cruzarse entre diferentes hilos. En ese escenario, el log no debe ser "static". 
- getLogger(...class.getName()): El logger escribe el paquete y nombre de la clase (incluso la línea de código) para que sepamos con 
exactitud en donde se produjo el mensaje



Ejercicio 4 (Buena Práctica): Utilizar un wrapper: Apache Commons Logging (ACL)
-------------
A medida que crece la aplicación, las referencias a los paquetes y clases de un logger (por ejemplo `java.util.logging`) aparecen en 
cada vez más clases de nuestra aplicación. Que pasa si un día encontramos que ese logger tiene un problema o no nos ofrece una cacterística 
y tenemos que cambiarlo? Ene se caso, se deben cambiar todas las referencias a ese logger en todas las clases de nuestra aplicación. Para
evitar esto, existen librerías que actúan como puentes entre nuestra aplicación y el logger especifíco. De esta manera nuestra aplicación 
hace referencia a la librería puente y mediante configuración de dicha librería, cambiamos el logger específico. De esta forma podríamos 
cambiar por ejemplo, Java Logging API por Log4J sin cambiar nuestro código fuente. Las librerías puente o "wrappers" más conocidas son 
Apache Commons Logging y SL4J. Estas librerías funcionan en combinación con las librerías de logging más populares y también proveen sus 
propias implementaciones de loggers.

* Para hacer: Descargue y agregue la librería Apache Commons Logging al build path y ejecute la aplicación en la clase `Ejercicio4`. 
Se verán los mensajes de log casi idénticos a los del Ejercicio 3; por qué?

Apache Commons Logging busca en el classplath cualquier implementación de Logger que pueda utilizar y dado que no encuentra alguna como 
Log4J, utiliza su propia implementación que no es más que un wrapper sobre Java Logging API.
 

Ejercicio 5 (Buena Práctica): Niveles de Logging
-------------
De los mensajes que se quieren registrar en un log, no todos tienen el mismo propósito, importancia o detalle. Por ejemplo, una excepción 
debería ser mostrada siempre, mientras que los valores de una variable, quizá solamente deberían mostrarse en caso de que deseemos depurar 
un bug en algún fragmento de código. Los nombres de los niveles pueden variar entre diferentes librerías de logging pero en general el 
concepto es el mismo. Los niveles (o prioridades) en ACL son:

* fatal: Para mensajes de error en los cuales la aplicación no puede continuar
* error: Para mensajes de error en los cuales la aplicación puede continuar normalmente
* warn: Para situaciones en la cual ocurrió algo que no es un error pero podría tener repercusiones más adelante
* info: Reemplaza al tradicional "entró/salió". Pueden usarse para indicar que está haciendo la aplicación a un alto nivel
* debug: Para describir que hace la aplicación, con más detalle, por ejemplo para incluir valores de variables
* trace: Igual que debug, sólo que con mayor detalle. En algunos frameworks de logging, es lo mismo que debug

En ACL y en general en los frameworks de log, cada nivel de menor prioridad incluye a los niveles de prioridad superior también.

Cree la clase `Ejercicio5` en la cual se escribe un mensaje con cada una de las prioridades. Extra: configure ACL para cambiar la 
prioridad del log y pruebe con diferentes niveles.


Ejercicio 6 (Buena Práctica): Registrando excepciones (conservando stacktrace)
-------------

* Analice el contenido del archivo `Ejercicio6.log` y determine la causa del fallo.
* Analice el contenido del archivo `Ejercicio6Corregido.log` y determine la causa del fallo.

Cual de los dos archivos le permitó identificar la causa del error?


Típico (pero quien no lo ha hecho?):

``
try{
   ...
}catch(Exception e){
	log.info("Error ejecutando X: " + e.getMessage());
}
``

* Corrija el registro de excepciones en la clase `Ejercicio6`.


Ejercicio 7 (Buena Práctica): Fronteras de control de errores (o Registrando excepciones donde se requiere)
-------------
Entre las diferentes capas o cadenas de llamados de una aplicación, se pueden distinguir dos tipos de fronteras entre el código:
* Las fronteras entre componentes internos, por ejemplo cuando un método de una clase invca a un método en otra clase dentro de 
la misma aplicación
* Las fronteras entre nuestra aplicación y componentes o sistemas externos o clientes de nuestra aplicación, por ejemplo, 
nuestra interfaz de servicio web o la interfaz gráfica de usuario para una aplicación web

Esta diferencia es importante en el momento de elegir como se controlarán las excepciones y cuales serán los mensajes que se 
propagarán hacia el cliente o componenete que invoco al código en donde se controla la excepción. Esto significa que:

En las fronteras internas, el código que produce la excepción no sabe como reaccionar ante un problema: debe reintentar la 
transacción? debe cancelarlar? debe tomar una acción correctiva? Eso sólo lo sabe el cliente de dicho código y por lo tanto, 
el código que produce la excepción no debería tratar de controlarla (a lo sumo, registrarla o enmascararla y relanzarla) 
sino dejar que se propague hacia el cliente quien seguramente sabrá como reaccionar ante ella o dejará que se propague hacia 
su propio cliente.

En cambio, en las fronteras externas (GUI, interfaz de servicio web), el cliente que recibe la excepción, sabrá como tratarla y 
cual decisión tomar con base en la excepción. Dado que este es el último punto en el que tenemos acceso a la excepción, es el 
mejor punto para registrarla en el log pues aquí tendremos acceso al stacktrace completo. Una buena práctica de seguridad en 
estas fronteras es registrar la excepción en el log con el mayor nivel de detalle posible, que permita su diagnóstico y cambiar 
el mensaje que se entrega al cliente, por uno que no revele los detalles internos del sistema (passwords, rutas, tecnologías, etc) 
pero que le brinde información suficiente sobre el resultado de la transacción paraque pueda tomar las acciones correctivas 
necesarias.

En resumen: atrape las excepciones únicamente en las capas en las que puede hacer algo al respecto, como en los controladores 
en estilos MVC o en las interfaces externas de un servicio, en la scuales además puede enmascararlas en una excepción del API y 
relanzarla al cliente. 

* Modifique el ejercicio 6 para que cumpla estas características. Compare contra la clase `Ejercicio7` e identifique como se 
cumple esta buena práctica


Ejercicio 8 Unchecked exceptions y código más limpio
-------------
Las recomendaciones del ejercicio 7 orientan una buena forma de tratar excepciones pero se puede mejorar aún más. Los clientes del 
método `Ejercicio7.dividir(long a, long b) throws Exception`, están obligados a controlar la excepción que declara el método 
dividir. Esto los obliga a escribir bloques try/catch o a declarar que sus métodos lanzan la misma excepción, lo cual los acopla 
más a nuestro método `dividir`. Como solucionarlo?

Existen dos tipos de excepciones: controladas y no controladas (checked y unchecked). Las primeras heredan de `java.lang.Exception` 
y las segundas, de `java.lang.RuntimeException`. La diferencia entre las dos es que el compilador exige que las excepciones 
`java.lang.Exception` y sus subclases sean controladas dentro del código, bien sea por un bloque try/catch o declarando el método 
para que las lance (... throws Exception), mientras que las excepciones `java.lang.RuntimeException` no exigen ningún tipo de 
control en el código lo cual evita escribir bloques try/catch y throws, haciendo el código más limpio y mejorando el control de excepciones.

* Modifique el código del Ejercicio 7 para eliminar la declaración throws del método `dividir`. Porque es posible eliminarla esa 
declaración en este caso
* Verifique el árbol de herencia de `java.lang.ArithmeticException` 


Extra. Ejercicio 9: Configurar ACL con Log4J
-------------
Que sucede si deseamos explotar técnicas avanzadas de registro de eventos (logging)? Java Logging API es suficiente para las tareas 
básicas de registro de eventos pero se queda corta cuando requerimos de características avanzadas, por ejemplo, enviar los mensajes de 
log a una base de datos o a una cola JMS para el registro centralizado de eventos. En esos casos debemos recurrir a otro framework de 
logging como Log4J. 

Log4J es uno de los frameworks de logging más versátiles y de más amplio uso en el mundo. En este ejericio se cambiará la implementación 
de logging por defecto (java.util.logging) por Log4J, aprovechando que estamos usando ACL para hacer el cambio sin modificar el código de 
la aplicación

* Agruege la librería de Log4J al classpath y listo! ACL encontrará a Log4J en el classpath y lo utilizará como el proveedor o framework
de logging por defecto. Si se desea cambiar el framework por defevto que utiliza ACL, debe crear un archivo `commons-logging.properties` 
con una línea como la siguiente: `org.apache.commons.logging.Log=<clase factory>` en donde `<clase factory>` corresponde al 
nombre de una clase que implemente el puente con la implementación que desea utilizar

* Agregue el archivo lib/commons-logging.properties al classpath y ejecute el ejercicio 8. Pruebe comentando y descomentando cada 
línea y observe como cambia la salida en pantalla, según el logger activo.


Extra. Ejercicio 10: Configurar Chainsaw (Appender)
------------
* Copie el archivo lib/log4j.properties al classpath, inicie chainsaw e inicie la aplicación. Observe la salida en la consola de chainsaw.
* Analice el contenido del archivo. Determine que es un Logger, un Appender y un Layout
 


