package com.example.openwebinar.avengersinfo.rest;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Delete;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Put;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Rest(rootUrl = "http://192.168.1.98:8080/avengers", converters = { MappingJackson2HttpMessageConverter.class })
public interface ApiRestClient {

    @Get("/getAll")
    List<Avenger> getAll();

    @Post("/setAvenger")
    Avenger addAvenger(@Body Avenger avenger);

    @Put("/change/{id}")
    Avenger replaceAvenger(@Path long id, @Body Avenger avenger);

    @Delete("/delete/{id}")
    void deleteAvenger(@Path long id);
}
