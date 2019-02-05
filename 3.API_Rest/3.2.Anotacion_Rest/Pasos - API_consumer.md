# Rest

En el lado de Java crearemos un nuevo paquete llamado "rest". Ahí pondremos tanto la API como tanto el POJO donde recuperaremos los datos que nos devolverá la API:

&nbsp;&nbsp;&nbsp;1. El cliente de la API:

```
		@Rest(rootUrl = "http://192.168.0.184:8080/avengers", converters = { MappingJackson2HttpMessageConverter.class })
		public interface ApiRestClient {

		}
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Como ves "192.168.0.184" coincide con el primer subdominio que hemos definido en `network_security_config.xml`.

&nbsp;&nbsp;&nbsp;2. El POJO podremos copiar y pegar literalmente el DTO de la API. Lo único es que renombraremos de `AvengerDTO` a `Avenger`.