package com.example.openwebinar.avengersinfo.recoverinfo;

import android.annotation.SuppressLint;
import android.app.Application;

import com.example.openwebinar.avengersinfo.recoverinfo.dto.HeroInfo;
import com.example.openwebinar.avengersinfo.rest.ApiRestClient;
import com.example.openwebinar.avengersinfo.rest.Avenger;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.ES;

@SuppressLint("Registered")
@EApplication
public class RequestInfoActivity extends Application {

    @RestService
    ApiRestClient apiRestClient;

    private List<Avenger> avengers = null;


    public HeroInfo getHero(int heroId) {
        HeroInfo heroInfo = null;

        initAvenger();
        if (avengers!= null && !avengers.isEmpty()) {
            Avenger anAvenger = avengers.get(heroId);
            heroInfo = avenger2HeroInfo(anAvenger);

        }

        return heroInfo;
    }

    public  void deleteAvenger(long id, String lang) {
        if (avengers != null) {
            int index = getIndexFromAvengers(id);
            apiRestClient.deleteAvenger(id);
            avengers.remove(index);
            if (ES.equals(lang)) {
                apiRestClient.deleteAvenger(id - 1);
                avengers.remove(index - 1);
            } else {
                apiRestClient.deleteAvenger(id + 1);
                avengers.remove(index);
            }
        }
    }

    public void replaceAvenger(long id, Avenger changeAvenger) {
        apiRestClient.replaceAvenger(id, changeAvenger);
        avengers = apiRestClient.getAll();
    }

    public void addAvenger(Avenger newAvenger) {
        apiRestClient.addAvenger(newAvenger);
        avengers = apiRestClient.getAll();
    }

    public int totalAvengers() {
        initAvenger();
        return avengers.size();
    }

    public long getLastId() {
        long lastId = -1;

        if (avengers != null) {
            Avenger lastAvenger = avengers.get(avengers.size() - 1);
            lastId = lastAvenger.getId();
        }

        return lastId;
    }


    private int getIndexFromAvengers(long id) {
        for (int c=0; c<avengers.size(); c++) {
            Avenger anAvenger = avengers.get(c);
            if ( anAvenger.getId() == id ) {
                return c;
            }
        }

        return -1;
    }

    private void initAvenger() {
        if (avengers == null) {
            avengers = apiRestClient.getAll();
        }
    }

    private HeroInfo avenger2HeroInfo(Avenger anAvenger) {
        int[] colors = new int[]{anAvenger.getColor_1().intValue(), anAvenger.getColor_2().intValue(), anAvenger.getColor_3().intValue(), anAvenger.getColor_4().intValue(), anAvenger.getColor_5().intValue()};
        return new HeroInfo(
                anAvenger.getId().intValue(),
                anAvenger.getLang(),
                anAvenger.getUrlimage(),
                anAvenger.getName(),
                anAvenger.getActor(),
                anAvenger.getDescription(),
                colors);
    }
}
