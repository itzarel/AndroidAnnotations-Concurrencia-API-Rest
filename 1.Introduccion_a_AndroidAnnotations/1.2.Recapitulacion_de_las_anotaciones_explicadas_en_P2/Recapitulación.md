# Vistas y eventos

En el curso de introducción a AndroidAnnotations vimos como instanciar objetos de lógica y empezamos a ver como interacturar con la UI.

En este curso lo que hemos visto es como instanciar objetos de UI y como interactuar con sus eventos.
Para ello explicamos una representación de las anotaciones de UI más empleadas sobre una calculadora y luego fuimos practicando con laos ejercicios prácticos.

Con el primer ejercicio práctico trabajamos el evento LongClick, con el segundo evento probamos el evento de Click, en la tercera práctica trabajamos con las operaciones de la calculadora y finalmente (en la última práctica) añadimos un evento de SeekBarProgressChange para poder cambiar el color de la interfaz.

Finalmente en la práctica final, recuperamos la práctica del curso anterior y cambiamos la manera de instanciar y caputar los eventos a AndroidAnnotations.

# Anotaciones

En este tema vimos alguna de las anotaciones que nos permiten interactuar con la UI. Entre las que destacamos:

- `@ViewById` -> Nos permite instanciar los objetos de UI en la lógica Java.
- `@Click` -> Cuando se anota a un método con esta anotación, será la lógica que se ejecute cuando se haga un click sobre el objeto al que se ha referenciado. Se referenciará empleando una variable de entrada a la anotación o empleando el mismo nombre del método.
- `@Touch` -> Cuando se anota a un método con esta anotación, permite recuperar más acciones desencadenadas cuando el usuario hace un click. Por ejemplo ver cuando el usuario ha tocado la pantalla o cuando ha separado el dedo. Se referenciará empleando una variable de entrada a la anotación o empleando el mismo nombre del método.
- `@AfterTextChange` -> Permite controlar el evento desencadenado cuando el usuario (o lógica) introducen texto en un campo apto, por ejemplo el TextView.
- `@LongClick` -> Cuando se anota a un método con esta anotación, será la lógica que se ejecute cuando se haga un click largo sobre el objeto al que se ha referenciado. Se referenciará empleando una variable de entrada a la anotación o empleando el mismo nombre del método.
- `@SeekBarProgressChange` -> Cuando se anota a un método con esta anotación, será la lógica que se ejecute cuando se haga un evento de desplazamiento de SeekBar sobre el objeto al que se ha referenciado. Se referenciará empleando una variable de entrada a la anotación o empleando el mismo nombre del método.

