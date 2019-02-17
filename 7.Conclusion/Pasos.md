# Clusión

- **@Background**: Permite lanzar una lógica en un hilo aparte del hilo de UI. Esto no implica que vaya a crear un nuevo hilo sino que puede generar un nuevo proceso dentro de un hilo ya usado por otros procesos (con esta técnica se hace una mejor gestión de los recursos). Ante los ojos del desarrollador veremos que los procesos se ejecutan en paralelo.
- **@UiThread**: La anotación "@Background" no permite la modificación de la UI (por diseño arquitectural de Android), esta anotación nos permite crear un método capaz de correr en el hilo de la UI.
- **@Put**: El prototipo de la interfaz que esté anotado con esta anotación acabará generando de forma automática el código del método PUT al path que se le especifica como variable de entrada de la anotación.
- **@Delete**: El prototipo de la interfaz que esté anotado con esta anotación acabará generando de forma automática el código del método DELETE al path que se le especifica como variable de entrada de la anotación.
- **@Path**: Permite relacionar una variable que viene por URL con la variable de entrada del método.
- **@Body**: Permite recuperar el body de la petición.
- **@Rest**: Anotación anexa a una interfaz que nos permitirá generar de forma automática todo el código del cliente de la API.
- **@RestService**: Instancia la interfaz que haya sido anotada con "@Rest".
- **@Get**: El prototipo de la interfaz que esté anotado con esta anotación acabará generando de forma automática el código del método GET al path que se le especifica como variable de entrada de la anotación.
- **@Post**: El prototipo de la interfaz que esté anotado con esta anotación acabará generando de forma automática el código del método POST al path que se le especifica como variable de entrada de la anotación.