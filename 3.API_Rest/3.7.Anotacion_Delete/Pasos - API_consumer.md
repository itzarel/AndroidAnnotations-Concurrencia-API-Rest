# Delete

Finalmente para eliminar una entrada empleando el cliente del API deberemos definir:

```
    @Delete("/delete/{id}")
    void deleteAvenger(@Path long id);
```

Y en las clase `MainActivity` borraremos el falso vengador que creamos en el paso de post. Como la aplicación simepre va a ejecutarse de cero debemos asegurar que primero se ejecute el post y luego el delete, para ello emplearemos la opción de "serial" de la anotación `@Background` tanto en el método `addNewAvenger` como en el nuevo método `deleteAvenger`:

```
    @AfterViews
    void afterInject() {
        getById();
        addNewAvenger(); <------
        changeAvenger();
------> deleteAvenger();
    }

    @Background(serial = "fakeAvenger")
    void addNewAvenger() {
	...
    }

    @Background(serial = "fakeAvenger")
    void deleteAvenger() {
        restClient.deleteAvenger(101L);
        System.out.println(LINE + 101L);
    }
```

