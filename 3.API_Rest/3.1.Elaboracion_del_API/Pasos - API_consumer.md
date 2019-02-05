# Configuración

Crear una empty activity

Abrir `<project>/build.gradle` y añade dentro de `allprojects >> repositories`:

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

Ahora deberemos conceder permisos a la aplicación para que pueda acceder a nuestra API. Para ello hay dos maneras:

```
	1. Modificando el manifest con "android:usesCleartextTraffic="true"" (dentro de la sección "application")
		- Esto permite todo el tráfico de nuestra aplicación. Nosotros no emplearemos esta opción, ya que sólo queremos acceder a nuestra API y a "pinterest"
	2. Creando un nuevo recurso en la aplicación. Habrá que crear una carpeta "xml" dentro de "res", dentro de la carpeta "xml" habrá que crear "network_security_config.xml" y añadir lo siguiente:
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
```
