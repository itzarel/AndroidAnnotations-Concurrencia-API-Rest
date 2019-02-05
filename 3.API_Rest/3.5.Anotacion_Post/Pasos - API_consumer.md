# Post

Para poder realizar una llamada post deberemos añadir lo siguiente dentro del cliente API:

```
    @Post("/setAvenger")
    Avenger addAvenger(@Body Avenger avenger);
```

Como es un método post no habrá ningun subrecurso, sino que vendrá en el body de la petición. Para recuperar esta información habrá que poner la anotación `@Body` a la variable de entrada del método.
A continuación en la clase `MainActivity` deberemos añadir el siguiente método de background:

```
    @Background
    void addNewAvenger() {
        Avenger a = new Avenger(101L, "SP", "Iron Pikachu", "Pikachu", "Este es el mejor traje creado en la historia", "https://i.pinimg.com/originals/96/35/ee/9635eee41a5de65d88a6de5230694f1d.gif",
                                Long.parseLong("E9D327", 16), Long.parseLong("D9D8D3", 16), Long.parseLong("F0D12B", 16), Long.parseLong("D8AA20", 16), Long.parseLong("BF1311", 16) );
        Avenger aSaved = restClient.addAvenger(a);
        System.out.println(LINE + aSaved);
    }
```

Y deberá ser invocado en el método `AfterViews`:

```
    @AfterViews
    void afterInject() {
        getById();
------> addNewAvenger();
    }
```

