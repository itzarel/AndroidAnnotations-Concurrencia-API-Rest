package com.example.openwebinar.myrestapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import com.example.openwebinar.myrestapplication.rest.ApiRestClient;
import com.example.openwebinar.myrestapplication.rest.Avenger;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;


@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    final String LINE  = "************************************************************> ";

    @RestService
    ApiRestClient restClient;

    @AfterViews
    void afterInject() {
        getById();
        addNewAvenger();
        changeAvenger();
        deleteAvenger();
    }

    @Background
    void gAll() {
        List<Avenger> all = restClient.getAll();
        System.out.println(all);
    }

    @Background
    void getById() {
        Avenger a = restClient.getById(0);
        System.out.println(LINE + a);
    }

    @Background(serial = "fakeAvenger")
    void addNewAvenger() {
        Avenger a = new Avenger(101L, "SP", "Iron Pikachu", "Pikachu", "Este es el mejor traje creado en la historia", "https://i.pinimg.com/originals/96/35/ee/9635eee41a5de65d88a6de5230694f1d.gif",
                                Long.parseLong("E9D327", 16), Long.parseLong("D9D8D3", 16), Long.parseLong("F0D12B", 16), Long.parseLong("D8AA20", 16), Long.parseLong("BF1311", 16) );
        Avenger aSaved = restClient.addAvenger(a);
        System.out.println(LINE + aSaved);
    }

    @Background
    void changeAvenger() {
        Avenger a = new Avenger();
        a.setName("Iron Spider");
        a.setUrlimage("https://i.pinimg.com/564x/90/61/bf/9061bfd099ba90e7a130639dc96358f9.jpg");
        Avenger aSaved = restClient.replaceAvenger(1L, a);
        System.out.println(LINE + aSaved);
    }

    @Background(serial = "fakeAvenger")
    void deleteAvenger() {
        restClient.deleteAvenger(101L);
        System.out.println(LINE + 101L);
    }


}
