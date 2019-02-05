package com.example.openwebinar.avengersinfo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.openwebinar.avengersinfo.beans.English;
import com.example.openwebinar.avengersinfo.beans.Spanish;
import com.example.openwebinar.avengersinfo.recoverinfo.RequestInfoActivity;
import com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants;
import com.example.openwebinar.avengersinfo.recoverinfo.dto.HeroInfo;
import com.example.openwebinar.avengersinfo.rest.Avenger;
import com.example.openwebinar.avengersinfo.views.CustomView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.res.BooleanRes;

import java.util.Random;


@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.b_english_change)
    Button bEnglishChange;
    @ViewById(R.id.b_spanish_change)
    Button bSpanishChange;

    @ViewById
    ImageButton ib_next, ib_back;

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.container)
    CustomView customView;

    @Bean
    Spanish spanish;
    @Bean
    English english;

    @App
    RequestInfoActivity receiverAction;

    @AnimationRes
    Animation fade_in, appear;

    @BooleanRes
    boolean is_fade_in;

    private int counterAvenger = 0, allAvengers = 0;
    private HeroInfo hero;


    @AfterViews
    void initAfterViews() {
        countAllAvengersBackground();
        recoverAvengerBackground(0);
    }



    @Click(R.id.b_english_change)
    void changeToEnglish() {
        if ( (counterAvenger%2) == 1 ) {
            counterAvenger = counterAvenger - 1;
            changeTextFromToolbar(english.getAppName(), english.getBSelectEn(), english.getBSelectSp());
            changeCustomView();
        }
    }

    @Click(R.id.b_spanish_change)
    void changeToSpanish() {
        if ( (counterAvenger%2) == 0 ) {
            counterAvenger = counterAvenger + 1;
            changeTextFromToolbar(spanish.getAppName(), spanish.getBSelectEn(), spanish.getBSelectSp());
            changeCustomView();
        }
    }

    @Click(R.id.ib_next)
    void nextAvenger() {
        if (hero != null) {
            counterAvenger = (counterAvenger + 2) % allAvengers;
            recoverAvengerBackground(counterAvenger);
        }
    }

    @Click(R.id.ib_back)
    void backAvenger() {
        if (hero != null) {
            counterAvenger = (counterAvenger - 2) % allAvengers;
            if (counterAvenger < 0) {
                counterAvenger = allAvengers + counterAvenger; // ¡¡Negative number!!
            }
            recoverAvengerBackground(counterAvenger);
        }
    }

    @Click(R.id.fab_menu_delete)
    void deleteAvenger() {
        deleteAvengerBackground();
    }

    @Click(R.id.fab_menu_add)
    void fabMenuAdd() {
        addBackground();
    }

    @Click(R.id.fab_menu_update)
    void fabMenuUpdate() {
        updateBackground();
    }



    @Background(serial = "mainProcessAvengers")
    void countAllAvengersBackground() {
        allAvengers = receiverAction.totalAvengers();
        Log.i("MainActivity", "Recovered number of avengers: " + allAvengers);
    }

    @Background(serial = "mainProcessAvengers")
    void recoverAvengerBackground(int id) {
        hero = receiverAction.getHero(id);
        updateAvenger(hero);
    }

    @Background(serial = "mainProcessAvengers")
    void deleteAvengerBackground() {
        if (hero != null) {
            counterAvenger = 0;
            receiverAction.deleteAvenger(hero.getId(), hero.getLanguage());

            countAllAvengersBackground();
            recoverAvengerBackground(counterAvenger);
        }
    }

    @Background(serial = "mainProcessAvengers")
    void addBackground() {
        counterAvenger = 0;

        long newId = receiverAction.getLastId() + 1;
        Avenger newAvengerEN = createFakeAvenger(newId, "Encoded name is <", "Actor code <", "Encripted information <");
        Avenger newAvengerES = createFakeAvenger(newId+1, "Nombre codificado es <", "Código de actor <", "Información encriptada <");

        receiverAction.addAvenger(newAvengerEN);
        receiverAction.addAvenger(newAvengerES);

        initAfterViews();
    }

    @Background(serial = "mainProcessAvengers")
    void updateBackground() {
        counterAvenger = 0;

        Avenger newAvenger = updateFakeInfo();

        receiverAction.replaceAvenger(newAvenger.getId(), newAvenger);

        initAfterViews();
    }

    @UiThread
    void updateAvenger(HeroInfo update) {
        customView.setInfo(update);
    }



    private void changeTextFromToolbar(String app_name, String b_select_en, String b_select_sp) {
        if (is_fade_in) {
            toolbar.startAnimation(fade_in);
        } else {
            toolbar.startAnimation(appear);
        }
        toolbar.setTitle(app_name);
        bEnglishChange.setText(b_select_en);
        bSpanishChange.setText(b_select_sp);
    }

    private void changeCustomView() {
        if (is_fade_in) {
            customView.startAnimation(fade_in);
            ib_next.startAnimation(fade_in);
            ib_back.startAnimation(fade_in);
        } else {
            customView.startAnimation(appear);
            ib_next.startAnimation(appear);
            ib_back.startAnimation(appear);
        }

        recoverAvengerBackground(counterAvenger);
    }

    private Avenger createFakeAvenger(long newId, String name, String actor, String desc) {
        final String CLOSE_TAG = ">";
        Random rand = new Random();

        return new Avenger(newId,
                Constants.EN,
                name + rand.nextInt(5000000) + CLOSE_TAG,
                actor + rand.nextInt(5000000) + " "  + rand.nextInt(5000000) + rand.nextInt(5000000) + CLOSE_TAG,
                desc + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) +
                        rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) +
                        rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) +
                        rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + rand.nextInt(5000000) + CLOSE_TAG,
                "https://i.pinimg.com/564x/d4/0a/6f/d40a6f7a51c081639f89e4c16c503eed.jpg",
                4293117806L, 4279138767L, 4292416129L, 4294709510L, 4278241567L);
    }

    private Avenger updateFakeInfo() {
        final String CLOSE_TAG = ">";
        Random rand = new Random();
        String newName;
        if (hero.getHero().contains(CLOSE_TAG)) {
            newName = hero.getHero().replace(CLOSE_TAG, " " + rand.nextInt(5000000) + CLOSE_TAG);
        } else {
            newName = "<" + hero.getHero() + " " + rand.nextInt(5000000) + CLOSE_TAG;
        }

        return new Avenger(
                (long) hero.getId(),
                hero.getLanguage(),
                newName,
                hero.getActor(),
                hero.getDescription(),
                hero.getImage(),
                (long) hero.getColors()[0],
                (long) hero.getColors()[1],
                (long) hero.getColors()[2],
                (long) hero.getColors()[3],
                (long) hero.getColors()[4]);
    }
}
