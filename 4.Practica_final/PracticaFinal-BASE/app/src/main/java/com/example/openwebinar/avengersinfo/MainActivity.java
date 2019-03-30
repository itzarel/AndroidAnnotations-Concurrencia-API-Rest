package com.example.openwebinar.avengersinfo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.openwebinar.avengersinfo.beans.English;
import com.example.openwebinar.avengersinfo.beans.Spanish;
import com.example.openwebinar.avengersinfo.recoverinfo.RequestInfoActivity;
import com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants;
import com.example.openwebinar.avengersinfo.recoverinfo.dto.HeroInfo;
import com.example.openwebinar.avengersinfo.views.CustomView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.res.BooleanRes;

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

    private int counterAvenger = 0;
    private HeroInfo hero;

    @AfterViews
    void initAfterViews() {
        hero = receiverAction.callHero(0, Constants.EN);
        customView.setInfo(hero);
    }

    @Click(R.id.b_english_change)
    void changeToEnglish() {
        changeTextFromToolbar(english.getAppName(), english.getBSelectEn(), english.getBSelectSp());
        changeCustomView(Constants.EN);
    }

    @Click(R.id.b_spanish_change)
    void changeToSpanish() {
        changeTextFromToolbar(spanish.getAppName(), spanish.getBSelectEn(), spanish.getBSelectSp());
        changeCustomView(Constants.ES);

    }

    @Click(R.id.ib_next)
    void nextAvenger() {
        String language = hero.getLanguage();
        counterAvenger = (counterAvenger+1)%6;
        hero = receiverAction.callHero(counterAvenger, language);
        customView.setInfo(hero);
    }

    @Click(R.id.ib_back)
    void backAvenger() {
        String language = hero.getLanguage();
        counterAvenger = (counterAvenger-1)%6;
        if (counterAvenger == -1) {
            counterAvenger = 5;
        }
        hero = receiverAction.callHero(counterAvenger, language);
        customView.setInfo(hero);
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

    private void changeCustomView(String language) {
        if (is_fade_in) {
            customView.startAnimation(fade_in);
            ib_next.startAnimation(fade_in);
            ib_back.startAnimation(fade_in);
        } else {
            customView.startAnimation(appear);
            ib_next.startAnimation(appear);
            ib_back.startAnimation(appear);
        }

        hero = receiverAction.callHero(hero.getId(), language);
        customView.setInfo(hero);
    }
}
