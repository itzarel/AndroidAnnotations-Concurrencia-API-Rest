# Configuración

Crear una empty activity

Abrir `<project>/build.gradle` y añade dentro de `allprojects >> repositories` [para más información ver este enlace](http://projects.spring.io/spring-android/):

```
		maven {
		    url 'https://repo.spring.io/libs-milestone'
		}
```

Abrir `<project>/app/build.gradle`  y añade dentro de `dependencies`:

```
	    annotationProcessor "org.androidannotations:androidannotations:$AAVersion"
	    implementation "org.androidannotations:androidannotations-api:$AAVersion"

	    annotationProcessor "org.androidannotations:rest-spring:$AAVersion"
	    implementation "org.androidannotations:rest-spring-api:$AAVersion"

	    implementation "org.springframework.android:spring-android-rest-template:$SAVersion"

	    implementation "com.fasterxml.jackson.core:jackson-databind:$JVersion"
```

Donde `$AAVersion`, `$SAVersion` y `$JVersion` son las variables que contienen las versiones de cada dependencia. Se deberá poner como variables globales al archivo:

```
	def AAVersion = '4.5.2'
	def SAVersion = '2.0.0.M3'
	def JVersion = '2.9.8'
```

Las dependencias de AA podremos ver las diferentes versiones en [este enlace](https://mvnrepository.com/artifact/org.androidannotations). Para las versiones de Spring Android [las podremos ver en este enlace (visto ya anteriormente)](http://projects.spring.io/spring-android/). Finalmente para Jackson [podremos verlo en este enlace](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.9.8).

Ahora deberemos conceder permisos a la aplicación para que pueda acceder a nuestra API. Para ello hay dos maneras:

```
	1. Modificando el manifest añadiendo '<uses-permission android:name="android.permission.INTERNET" />'.
	2. Modificando el manifest con "android:usesCleartextTraffic="true"" (dentro de la sección "application")
		- Esto permite todo el tráfico de nuestra aplicación. Nosotros no emplearemos esta opción, ya que sólo queremos acceder a nuestra API y a "pinterest"
	3. Creando un nuevo recurso en la aplicación. Habrá que crear una carpeta "xml" dentro de "res", dentro de la carpeta "xml" habrá que crear "network_security_config.xml" y añadir lo siguiente:
		<?xml version="1.0" encoding="utf-8"?>
		<network-security-config>
		    <domain-config cleartextTrafficPermitted="true">
			<domain includeSubdomains="true">192.168.0.184</domain>
			<domain includeSubdomains="true">https://www.pinterest.es</domain>
			<domain includeSubdomains="true">https://i.pinimg.com</domain>
		    </domain-config>
		</network-security-config>

	Posteriormente habrá que dar de alta este archivo en el manifes, dentro de la sección "application":
		android:networkSecurityConfig="@xml/network_security_config"
	4. 'app/build.gradle', dentro de la sección 'android':
       packagingOptions {
           exclude 'META-INF/notice.txt'
           exclude 'META-INF/license.txt'
       }
```
