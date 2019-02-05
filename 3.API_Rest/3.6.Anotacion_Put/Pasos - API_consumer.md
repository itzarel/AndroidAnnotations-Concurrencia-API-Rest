# Put

Para realizar una llamada a la API por put será una combinación de get y post:

```
    @Put("/change/{id}")
    Avenger replaceAvenger(@Path long id, @Body Avenger avenger);
```

Y deberá ser invocado en el método `AfterViews`:

```
    @AfterViews
    void afterInject() {
        getById();
        addNewAvenger();
------> changeAvenger();
    }

    @Background
    void changeAvenger() {
        Avenger a = new Avenger();
        a.setName("Iron Spider");
        a.setUrlimage("https://i.pinimg.com/564x/90/61/bf/9061bfd099ba90e7a130639dc96358f9.jpg");
        Avenger aSaved = restClient.replaceAvenger(1L, a);
        System.out.println(LINE + aSaved);
    }
```
