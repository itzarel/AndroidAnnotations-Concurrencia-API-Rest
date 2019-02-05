# Get

Actualmente no tenemos ningún método dentro del cliente. Vamos a definir el siguiente:

```
    @Get("/get/{id}")
    Avenger getById(@Path long id);
```

El parámetro de entrada al método llamado "id" deberá estar anotado con `@Path` y deberá coincidir con la variable del subrecurso, en este caso `{id}`.

Este método es el que nos permite recuperar un elemento de la API por id. Éste lo llamaremos desde el método anotado con `@AfterViews`:

```
    @AfterViews
    void afterInject() {
        restClient.getById(1);
    }
```

Esto genera un error:

```
	E/AndroidRuntime: FATAL EXCEPTION: main
	    Process: com.example.openwebinar.myrestapplication, PID: 14324
	    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.openwebinar.myrestapplication/com.example.openwebinar.myrestapplication.MainActivity_}: android.os.NetworkOnMainThreadException
```

Ya que estamos bloqueando el hilo principal, por lo que Android no lo va a permitir. Para ello deberemos crear un método en background:

```
    @AfterViews
    void afterInject() {
        getById();
    }

    @Background
    void getById() {
        Avenger a = restClient.getById(1);
        System.out.println("************************************************************> " + a);
    }
```

Y como resultado obtendremos:

```
	I/System.out: ************************************************************> Avenger{id=1, lang='EN', name='Spider-Man', actor='Tom Holland', description='Spider-Man is a fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko. He first appeared in the anthology comic book Amazing Fantasy #15 (August 1962) in the Silver Age of Comic Books...', urlimage='https://d29fhpw069ctt2.cloudfront.net/icon/image/59595/preview.svg'}
```

