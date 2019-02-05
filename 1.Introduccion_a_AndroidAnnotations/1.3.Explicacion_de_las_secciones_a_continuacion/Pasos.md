# Anotaciones

En esta sección veremos anotaciones orientadas a la **concurrencia** que nos permitirá ver y hacer las siguientes anotaciones, las cuales son orientadas a consumir un **API REST**. Serán:

- **Background**: Esta anotación nos permite lanzar un método en segundo plano.
- **UiThread**: Esta anotación nos permite modificar la UI desde un método de *Background* (aunque puede ser también un método normal).

- **Rest**: La interfaz que esté anotada con esta anotación será el cliente del API REST en si.
- **RestService**: Permite instanciar el cliente del API REST anotado con la anotación *Rest*.
- **Get**: Permite crear el método GET del API REST.
- **Post**: Permite crear el método POST del API REST.
- **Put**: Permite crear el método PUT del API REST.
- **Delete**: Permite crear el método DELETE del API REST.
