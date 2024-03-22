# Práctica 07: Manejador de Cuentas Bancarias v2 

El equipo está `conformado` por: 
- Joshua Nathaniel Arrazola Elizondo (2230023)
- Hector Israel Cruz Resendez (2230021)
- Alex Emil Resendiz García (2130419)
- Ricardo Emmanuel Uriegas Ibarra (2230122)

## Archivos
A continuación una breve descripción de que hace cada archivo:
* `App`: Archivo principal del programa, es el archivo que se ejecuta y manda a llamar todos los demás archivos.
* `Cliente`: Clase que representa un cliente genérico, guarda datos como *RFC*, *fecha de nacimiento*, *nombre*, etc.
* `Debito`: Clase que representa una tarjeta de débito genérica, almacena datos como *saldo*, *RFC*, y el historial de *movimientos*.
* `File Management`: Clase que se encarga de todo lo correspondiente al manejo de archivos, desde crear los archivos, hasta serializar y deserializar objetos en formato *.json*.
* `ManejadorClientes`: Clase que se encarga de todas las tareas relacionadas a *verificar*, *modificar*, *listar*, *borrar* y *crear* clientes.
* `ManejadorDebito`: Clase que se encarga de todas las tareas relacionadas a *verificar*, *modificar*, *listar*, *borrar* y *crear* tarjetas de débito.
* `Menus`: Clase que contiene todos los menús que se imprimen por consola durante ejecución.
* `Movimiento`: Clase que representa un movimiento en una tarjeta, incluye datos como el *concepto*, el *monto*, *la fecha*, entre otros. 

## Funcionamiento general
Un `ArrayList` almacena los clientes en **`ManejadorClientes`**, un `HashMap` une cada **RFC** con el `ArrayList` de cuentas que le corresponden a cada cliente, esto debido a que el problema a solucionar específica que un cliente puede tener más de una cuenta.

### Consideraciones
- Los archivos se serializan con la biblioteca `gson` de Google, la dependencia se incluye en el `build.gradle`.
- Todas las clases que se serializan implementan la interfaz `Serializable`.